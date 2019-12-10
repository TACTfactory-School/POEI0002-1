package fr.dta.ovg.security.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fr.dta.ovg.security.services.UserDetailsServiceImpl;


//@EnableWebSecurity
//@EnableAutoConfiguration
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
     */

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.csrf().disable()
            .antMatcher("/*").anonymous() // anonymous
            .and()
            .antMatcher("/api/**").authorizeRequests() // authorizeRequests
            .and()
            .antMatcher("/api/v1/*").authorizeRequests() // authorizeRequests
                .antMatchers(HttpMethod.GET, "/api/v1/user").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/event").permitAll()
                .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll()
            .and()
            .httpBasic();

        super.configure(http);
    }

    /* (non-Javadoc)
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsServiceImpl)
            .and()
            .inMemoryAuthentication().withUser("admin").password("admin")
            .and()
            .withUser("standard").password("standard");

//        auth.userDetailsService(userDetailsServiceImpl);

        super.configure(auth);
    }

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
      return authenticationManager();
    }

}
