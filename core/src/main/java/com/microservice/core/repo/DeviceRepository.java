package com.microservice.core.repo;

import com.microservice.core.modle.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Alex Liu
 * @date 2021/03/24
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
