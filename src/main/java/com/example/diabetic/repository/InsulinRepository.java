package com.example.diabetic.repository;

import com.example.diabetic.model.Insulin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsulinRepository extends JpaRepository<Insulin,Long> {
}
