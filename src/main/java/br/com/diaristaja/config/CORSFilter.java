package br.com.diaristaja.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class CORSFilter extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowedMethods("PUT", "DELETE", "POST", "GET", "OPTIONS", "PATCH")
			.allowedHeaders("*")
//			.allowedHeaders("Content-Type, Access-Control-Allow-Origin, Access-Control-Allow-Headers, Authorization, X-Requested-With, requestId, Correlation-Id")
			.allowCredentials(true);
	}
}
