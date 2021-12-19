package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
