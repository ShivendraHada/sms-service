package com.kisannetwork.smsservice.smsservice.service;

import com.kisannetwork.smsservice.smsservice.domain.Record;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class DbService {

    public SimpleDriverDataSource h2DataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriver(new org.h2.Driver());
        dataSource.setUrl("jdbc:h2:mem:testdb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }

    public void pushJsonToDB(String json){
        String name = "";
        String contactNo = "";
        JSONParser parser = new JSONParser();
        try {
            JSONArray completeJSON = (JSONArray) parser.parse(json);
            for (Object o : completeJSON) {
                JSONObject oneData = (JSONObject) o;
                name = oneData.get("name").toString();
                contactNo = oneData.get("contactNo").toString();
                JdbcTemplate jdbcTemplate = new JdbcTemplate(h2DataSource());
                jdbcTemplate.update("INSERT INTO USER_DETAILS(name,contact_no) VALUES (?,?)",name,contactNo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pushMessageToDB(Record record){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(h2DataSource());
        jdbcTemplate.update("INSERT INTO RECORD(name,contact_no,otp,date_time,body) VALUES (?,?,?,?,?);",record.getName(),record.getContactNo(),record.getOtp(),record.getDateTime(),record.getBody());
    }
}
