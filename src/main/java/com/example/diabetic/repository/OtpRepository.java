package com.example.diabetic.repository;

import com.example.diabetic.model.OtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<OtpVerification,Long> {

}
