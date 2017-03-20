package pl.shelterwebapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("1111").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("admin1").password("1313").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/list").permitAll()
		.antMatchers("/add**", "/deleteDog", "/editDog").access("hasRole('ADMIN')")
		.and().formLogin().loginPage("/").usernameParameter("name").passwordParameter("password").defaultSuccessUrl("/").failureUrl("/?errorLogin")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/?logout");
	}

}
