package com.kisannetwork.smsservice.smsservice.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsService {

    public void sendOtp(String to, String body) {
        String AUTH_TOKEN = "0725d0778ddc1e00511e3257cdd379ea";
        String ACCOUNT_SID = "AC3fa92f95eb12dcdaa3b636ede7efa659";
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new PhoneNumber(to), new PhoneNumber("+14132415665"), body).create();
        message.getSid();
    }
}
