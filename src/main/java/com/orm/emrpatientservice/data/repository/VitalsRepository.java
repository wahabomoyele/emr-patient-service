package com.orm.emrpatientservice.data.repository;

import com.orm.emrpatientservice.data.entity.entry.Vitals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VitalsRepository extends JpaRepository<Vitals, Long> {
}
