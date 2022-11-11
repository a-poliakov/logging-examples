package org.example;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

import java.util.logging.Logger;

@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
	Logger logger = LoggerFactory

	public static void main(String[] args) {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}

}
