package com.kcacademy.authenticator.gateway;

public interface SmsService {

	void send(String phoneNumber, String message);

}
