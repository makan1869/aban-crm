package ir.serenade.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().loginPage("/login").permitAll()
                .and().httpBasic().and()
                .requestMatchers()
                //specify urls handled
                .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
                .antMatchers("/fonts/**", "/js/**", "/css/**")
                .and()
                .authorizeRequests()
                .antMatchers("/fonts/**", "/js/**", "/css/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("reader")
                .password("reader")
                .authorities("ROLE_READER")
                .and()
                .withUser("guest")
                .password("guest")
                .authorities("ROLE_GUEST");
    }
}
