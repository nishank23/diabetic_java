package com.example.diabetic.repository;

import com.example.diabetic.model.DeviceInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceInfoRepository extends JpaRepository<DeviceInfo,Long> {

}
