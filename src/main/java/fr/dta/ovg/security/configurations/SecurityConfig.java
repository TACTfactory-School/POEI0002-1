package fr.dta.ovg.security.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import fr.dta.ovg.security.services.UserDetailsServiceImpl;

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



}
