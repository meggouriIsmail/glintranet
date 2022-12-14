package com.giantlink.glintranet.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.giantlink.glintranet.services.EmployeeService;

@EnableWebSecurity
public class WebSecurity  extends WebSecurityConfigurerAdapter{
	
	private final EmployeeService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public WebSecurity(EmployeeService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    
		http.cors();
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, SecurityConstants.SING_UP_URL)
				.permitAll()
				.antMatchers("/api/v1/docs.html")
				.permitAll()
//				.anyRequest()
//				.authenticated()
				.and()
				.addFilter(getAuthenticationFilter())
				.addFilter(new AuthorizationFilter(authenticationManager()))
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	protected AuthenticationFilter getAuthenticationFilter() throws Exception{
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/api/login");
		return filter;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		
	}


}
