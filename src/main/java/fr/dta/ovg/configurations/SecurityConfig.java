/* Security Configuration Class
 * @author Samy Moussaoui.
 * License : ©2019 All rights reserved.
 */

package fr.dta.ovg.configurations;

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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.dta.ovg.contracts.ConfigurationContract;
import fr.dta.ovg.services.user.UserDetailsServiceImpl;

/** Security Configuration Class (Web Security Configurer Adapter)*/
@EnableWebSecurity
@EnableAutoConfiguration
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /** Link to User Details Service Implementation */
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * Security configure function.
     * Override HttpSecurity configure to open route & put httpBasic security.
     * @see #configure (org.springframework.security.config.annotation.web.builders.HttpSecurity).
     * @throws Exception : Handle HTTP Security exception.
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable()
            .cors().disable()
            .authorizeRequests()
                .antMatchers(ConfigurationContract.REQUEST_URI_USER_ME).permitAll()
                .antMatchers(HttpMethod.POST, ConfigurationContract.REQUEST_URI_EVENT).authenticated()
                .antMatchers(HttpMethod.POST, ConfigurationContract.REQUEST_URI_MESSAGE).authenticated()
                .antMatchers(HttpMethod.POST, ConfigurationContract.REQUEST_URI_HOBBY).authenticated()
                .antMatchers(HttpMethod.POST, ConfigurationContract.REQUEST_URI_LANGUAGE).authenticated()
                .antMatchers(HttpMethod.POST, ConfigurationContract.REQUEST_URI_USER).anonymous()
                .anyRequest().permitAll()
            .and()
            .httpBasic()
            .and()
                .formLogin().disable();
    }

    /**
     * Authentication Manager Builder class.<br>
     * Call super HttpSecurity configure().
     * @see org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder.
     * @throws Exception : Handle AuthenticationManagerBuilder exception.
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);

        super.configure(auth);
    }

    /**
     * Authenticate Manager Function.
     * @return authenticationManager : customAuthenticationManager.
     * @throws Exception : Handle AUTH exception.
     */
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
      return authenticationManager();
    }

    /**
     * Password Encoder Function.
     * Bean of system.
     * @return BCryptPasswordEncoder : BCrypt Encoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
