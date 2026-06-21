package com.example.springlearning.service;


import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommonService extends AbstractCommonService {

    @Autowired
    DataSource dataSource;

    @Transactional
    public void transactionMethod() {
        System.out.println("Executing transaction method in CommonService");
    }

    public ResponseEntity<Map<String, Object>> getDataSourceInfo(){
        Map<String, Object> poolInfo = new HashMap<>();
         if(dataSource instanceof HikariDataSource) {

             HikariDataSource hikariDS = (HikariDataSource) dataSource;
             HikariPoolMXBean poolMXBean = hikariDS.getHikariPoolMXBean();

             poolInfo.put("activeConnections", poolMXBean.getActiveConnections());
             poolInfo.put("idleConnections", poolMXBean.getIdleConnections());
             poolInfo.put("totalConnections", poolMXBean.getTotalConnections());
             poolInfo.put("threadsAwaitingConnection", poolMXBean.getThreadsAwaitingConnection());
             poolInfo.put("maxPoolSize", hikariDS.getMaximumPoolSize());
             poolInfo.put("minIdle", hikariDS.getMinimumIdle());
         }
        return ResponseEntity.ok(poolInfo);
    }
}
