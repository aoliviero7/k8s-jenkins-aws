package com.jhooq.Jhooqk8s.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
public class DataDockerDemoController {

    @GetMapping("/data")
    public String hello() {
        return "Hello data manager- Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/data/{tableName}")
    public String getAllEntriesAsJson(@PathVariable String tableName) {
        List<Map<String, Object>> entries = new ArrayList<>();

        String jdbcUrl = "jdbc:mysql://mysql-testtesi.ccl6bjosmzgx.eu-west-1.rds.amazonaws.com:3306/dbTesi";
        String username = "userDB";
        String password = "userDB";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            String sql = "SELECT * FROM " + tableName + ";";
            System.out.println(sql);

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                
                System.out.println("ColumnCount " + columnCount);

                while (rs.next()) {
                    Map<String, Object> entry = new HashMap<>();
                    for (int i = 1; i <= columnCount; i++) {
                        String columnName = metaData.getColumnName(i);
                        Object value = rs.getObject(i);
                        entry.put(columnName, value);
                    }
                    entries.add(entry);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String jsonResult = "";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonResult = objectMapper.writeValueAsString(entries);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
    
    @GetMapping("/")
    public String root() {
        return "ROOT";
    }
}
