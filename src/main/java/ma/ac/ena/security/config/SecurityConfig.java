package ma.ac.ena.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;

	// ******************************** methode0 ********************
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {

		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("a")).roles("ADMIN", "PROF",
				"ETUDIANT", "SCOLARITE");
		auth.inMemoryAuthentication().withUser("sco").password("{bcrypt}scolar").roles("ETUDIANT", "SCOLARITE");
		auth.inMemoryAuthentication().withUser("prof").password("{bcrypt}prof").roles("PROF", "ETUDIANT");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("etd").password("etd")
				.roles("ETUDIANT");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// ******************************** fin methode0 ********************

	// ******************************** methode1 ********************
	// @Autowired
	// public void globalConfig(AuthenticationManagerBuilder auth, DataSource
	// dataSource) throws Exception {
	// auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select
	// username as principal, password as credentials, true from users where
	// username = ?")
	// .authoritiesByUsernameQuery("select user_username as principal, roles_role as
	// role from users_roles where user_username = ?") .rolePrefix("ROLE_");
	// }
	// ******************************** fin methode1 ********************

	// ******************************** methode2 ********************
	// @Autowired
	// public void globalConfig(AuthenticationManagerBuilder auth, DataSource
	// dataSource) throws Exception {
	// // ******cas 2********
	// // final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	// // CharSequence password = null; // passwordEncoder.encode(password);
	// System.out.println("--------------");
	// User user = userRepository.findByUsernameAndPassword("admin",
	// passwordEncoder().encode("a"));
	// System.out.println("-----------");
	// if (user != null) {
	// System.out.println(user.toString());
	// } else {
	// System.out.println("rien");
	// }

	// ******cas 2********
	// .passwordEncoder(new BCryptPasswordEncoder());
	// }
	//
	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	// }

	// ******************************** fin methode2 ********************

	// ******************************* methode3 ************************

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return new BCryptPasswordEncoder();
	// }
	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	// }
	//
	// @Autowired
	// private DataSource dataSource;
	//
	// @Value("${spring.queries.users-query}")
	// private String usersQuery;
	//
	// @Value("${spring.queries.roles-query}")
	// private String rolesQuery;
	//
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// //
	// auth.inMemoryAuthentication().withUser("user").password("{noop}pass").authorities("ADMIN");
	//
	// auth.jdbcAuthentication().passwordEncoder(passwordEncoder()).usersByUsernameQuery(usersQuery)
	// .authoritiesByUsernameQuery(rolesQuery).dataSource(dataSource);
	// }

	// ************************** fin method3 *********************************

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/img/**").permitAll()
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/index.html");

	}

	// @Bean
	// public ViewResolver jspViewResolver() {
	// InternalResourceViewResolver bean = new InternalResourceViewResolver();
	// bean.setPrefix("/WEB-INF/classes/templates/");
	// bean.setSuffix(".jsp");
	// return bean;
	// }

	// @Override
	// public void configureViewResolvers(ViewResolverRegistry registry) {
	// registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");
	// }

}
