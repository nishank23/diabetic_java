package com.example.diabetic.repository;


import com.example.diabetic.model.BgReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BgRepository extends JpaRepository<BgReading,Long> {



}
