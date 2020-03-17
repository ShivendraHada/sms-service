package com.kisannetwork.smsservice.smsservice.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String contactNo;
    private String otp;
    private String dateTime;
    private String body;

    public Record() {
    }

    public Record(Long id, String name, String contactNo, String otp, String dateTime, String body) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.otp = otp;
        this.dateTime = dateTime;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
