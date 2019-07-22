package com.vk.rest.SpringBootRestFulService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBootRestFulServiceApplication {

	private  static Logger log = LogManager.getLogger(SpringBootRestFulServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestFulServiceApplication.class, args);
		log.info("info logger");
		log.debug("debug logger");
		log.error("error log");

	}

	@Bean
	public  LocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@Bean
	public  ResourceBundleMessageSource bundleMessageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return  messageSource;
	}
}
