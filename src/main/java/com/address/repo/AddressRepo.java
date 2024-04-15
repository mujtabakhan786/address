package com.address.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.address.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

	@Query(value = "SELECT ad.id,ad.lane1,ad.lane2,ad.state,ad.zip FROM spring2024.address ad join spring2024.employee em on em.id=ad.employee_id where ad.employee_id=:employeeId", nativeQuery = true)
	Address findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
