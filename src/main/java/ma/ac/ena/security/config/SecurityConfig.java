package ma.ac.ena.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ma.ac.ena.dao.UserRepository;
import ma.ac.ena.pogo.FileStorageProperties;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;

	// ******************************** methode0 ********************

	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("a")).roles("ADMIN", "PROF",
				"ETUDIANT", "SCOLARITE");
		auth.inMemoryAuthentication().withUser("employee").password("{bcrypt}a").roles("ETUDIANT", "SCOLARITE");
		auth.inMemoryAuthentication().withUser("toto").password("{bcrypt}a").roles("PROF", "ETUDIANT");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("etd").password("etd")
				.roles("ETUDIANT");
	}
	


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}



	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/img/**").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/index.html");

	}




	
	
	
	
	
	

}






















