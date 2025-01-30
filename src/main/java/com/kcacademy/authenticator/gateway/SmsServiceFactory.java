package com.kcacademy.authenticator.gateway;

import com.kcacademy.authenticator.SmsConstants;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmsServiceFactory {

	private static final Logger logger = LoggerFactory.getLogger(SmsServiceFactory.class);

	public static SmsService get(Map<String, String> config) {
		if (Boolean.parseBoolean(config.getOrDefault(SmsConstants.SIMULATION_MODE, "false"))) {
			return (phoneNumber, message) ->
					logger.warn(String.format("***** SIMULATION MODE ***** Would send SMS to %s with text: %s", phoneNumber, message));
		} else {
			return new AwsSmsService(config);
		}
	}
}
