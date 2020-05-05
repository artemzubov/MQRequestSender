package com.trgr.dockets.RequestSender;

import com.trgr.dockets.RequestSender.util.DateTimeParser;
import com.trgr.dockets.RequestSender.util.ServerHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class RequestSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestSenderApplication.class, args);
	}

	@Bean
	public ServerHelper getServerHelper() {
		return new ServerHelper();
	}

	@Bean
	public DateTimeParser getDateTimeParser() {
		return new DateTimeParser();
	}
}
