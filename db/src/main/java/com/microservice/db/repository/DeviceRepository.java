package com.microservice.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.microservice.db.modle.entity.Device;

/**
 * @author Alex Liu
 * @date 2021/03/24
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
