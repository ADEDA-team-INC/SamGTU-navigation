package org.adeda.samgtunavigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SamGtuNavigationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamGtuNavigationApplication.class, args);
	}

}
