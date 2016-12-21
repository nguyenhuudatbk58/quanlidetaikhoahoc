package quanlidetaikhoahoc.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages={"quanlidetaikhoahoc.dao"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	@Qualifier("authenticationProviderImpl")
	private AuthenticationProvider authenticationProviderImpl;
	
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
	    .antMatchers("/dang-ki-de-tai").hasRole("USER")
	    .antMatchers("/cap-nhat-thong-tin").hasRole("USER")
	    .antMatchers("/thong-tin-ca-nhan").hasRole("USER")
	    .antMatchers("/chinh-sua-thong-tin").hasRole("USER")
	    .antMatchers("/thay-doi-mat-khau").hasRole("USER")
		.and().formLogin().loginPage("/dang-nhap").permitAll().defaultSuccessUrl("/trang-chu")
		.loginProcessingUrl("/dang-nhap").passwordParameter("password").usernameParameter("username")
		.and().logout().logoutUrl("/dang-xuat").logoutSuccessUrl("/trang-chu")
		.and().csrf().disable();
		
	}

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProviderImpl);
	}
}
