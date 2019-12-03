package fr.dta.ovg.security.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fr.dta.ovg.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
            .antMatcher("/*").anonymous()
            .and()
            .antMatcher("/api/**").authorizeRequests()
            .and()
            .antMatcher("/api/v1/*").authorizeRequests()
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.GET).anonymous()
            .and()
            .httpBasic();
        super.configure(http);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("admin").password("admin")
//            .and()
//            .withUser("standard").password("standard");

        auth.userDetailsService(userDetailsServiceImpl);

        super.configure(auth);
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
      return authenticationManager();
    }

}
