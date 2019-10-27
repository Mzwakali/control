package ac.za.cput.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE = "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(encoder().encode("adminpass"))
                .roles(ADMIN_ROLE)
                .and()
                .withUser("user")
                .password(encoder().encode("userpass"))
                .roles(USER_ROLE);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/control/**/create").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.PUT, "/control/**/update").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.DELETE, "/control/**delete").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET, "/control/**/all").hasAnyRole(ADMIN_ROLE, USER_ROLE)
                .antMatchers(HttpMethod.GET, "/control/**/read").hasAnyRole(ADMIN_ROLE, USER_ROLE)
                .antMatchers("/").permitAll()
                .and()
                .csrf().disable()
                .formLogin();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
