package com.backend.portfolio;

import com.backend.portfolio.security.JWTAuthorizationFilter;
import java.time.Duration;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

        
        @EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
            
                @Bean
                CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
                configuration.setAllowedHeaders(Arrays.asList("Origin, Accept", "X-Requested-Width", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
		configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Acces-Control-Allows-Credentials"));
                configuration.setAllowedOrigins(Arrays.asList("https://front-portfolio-angular.web.app"));
		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                configuration.addAllowedOrigin("*");
                configuration.setMaxAge(Duration.ZERO);
                configuration.setAllowCredentials(Boolean.TRUE);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
                }

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
                            .cors(withDefaults())
                            .csrf().disable()
                            .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
			    .authorizeRequests()
                            .antMatchers(HttpMethod.POST, "/acceso").permitAll()
                            .anyRequest().authenticated();
		}      
        
        }

}
