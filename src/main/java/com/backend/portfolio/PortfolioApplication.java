package com.backend.portfolio;

import com.backend.portfolio.security.JWTAuthorizationFilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
        
        

        @EnableWebSecurity
        public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

                @Override
                protected void configure(HttpSecurity http) throws Exception {
                        http
                                // by default uses a Bean by the name of corsConfigurationSource
                                .cors().and()
                                ...
                }

                @Bean
                CorsConfigurationSource corsConfigurationSource() {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(Arrays.asList("https://front-portfolio-angular.web.app""));
                        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
                        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
                        source.registerCorsConfiguration("/**", configuration);
                        return source;
                }
        }

        
        @EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/acceso").permitAll()
				.anyRequest().authenticated();
		}
	}

}
