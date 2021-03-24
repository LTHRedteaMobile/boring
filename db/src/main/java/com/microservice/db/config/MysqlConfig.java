package com.microservice.db.config;

import org.hibernate.dialect.MySQL5Dialect;
import org.springframework.stereotype.Component;

/**
 * @author Alex Liu
 * @date 2021/03/24
 */
@Component
@SuppressWarnings("deprecation")
public class MysqlConfig extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8mb4";
    }
}
