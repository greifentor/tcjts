package de.ollie.utils.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

/**
 * A configuration for the version information.
 *
 * @author mamue
 *
 */
@Configuration
@PropertySource("classpath:project.properties")
@ConfigurationProperties(prefix = "project")
@Getter
@Setter
public class ProjectConfiguration {

	private String version;

}