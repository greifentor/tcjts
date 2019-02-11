package de.ollie.tcjts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("de.ollie")
public class TCJTSApplication {

	public static final Logger LOG = LogManager.getLogger(TCJTSApplication.class);

	public static void main(String[] args) {
		LOG.info("Starting TCJTS Application");
		SpringApplication.run(TCJTSApplication.class, args);
	}

}