package com.example.diabetic.repository;

import com.example.diabetic.model.Insulin_Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsulinLogRepository extends JpaRepository<Insulin_Logs,Long> {
}
