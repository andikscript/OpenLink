package com.andikscript.igate;

import com.andikscript.igate.socket.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class IgateApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgateApplication.class, args);
	}
}