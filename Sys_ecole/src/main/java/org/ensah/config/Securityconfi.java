package org.ensah.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
@Configuration
@EnableWebSecurity
public class Securityconfi extends WebSecurityConfigurerAdapter{
	@Autowired
    @Qualifier("daoAuthenticationProvider")
	private AuthenticationProvider authenticationProvider;
	@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService) {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication()
////        .dataSource(dataSource)
////        .usersByUsernameQuery("Select username,password,enabled,iduser from compte where username=?")
////        .authoritiesByUsernameQuery("SELECT c.username AS username,r.role_name as role from compte c,role r where r.id=(Select role_id from compte where username=?)")
////        .rolePrefix("ROLE_");
//		
//}
	 @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	       httpSecurity.formLogin().loginPage("/signin").defaultSuccessUrl("/home", true).permitAll()
           .usernameParameter("username").passwordParameter("password")
           .and()
           .logout().logoutSuccessUrl("/signin?signout").permitAll();; 
		 httpSecurity.authorizeRequests()
	                .antMatchers("/professeur/*").hasAuthority("ADMIN")
	                .antMatchers("/professeur/*").hasAuthority("PROFESSEUR")
	                .antMatchers("/etudiant/*").hasAuthority("ETUDIANT");
	        //for H2 Database [Security hole | avoid in production]
	        httpSecurity.csrf().disable();
	        httpSecurity.headers().frameOptions().disable();
	}
}
