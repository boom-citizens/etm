package uz.boom.citizens.configs.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true
)
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Value(value = "${remember.me.token.key}")
    private String rememberMeTokenKey;

    @Value(value = "${remember.me.token.expiry}")
    private int rememberMeTokenExpiry;

    private int rememberMeTokenExpiryInSeconds;

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserDetailsService applicationUserDetailsService;

    public SecurityConfigurer(
            PasswordEncoder passwordEncoder,
            ApplicationUserDetailsService applicationUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.applicationUserDetailsService = applicationUserDetailsService;
    }

    @PostConstruct
    public void init() {
        this.rememberMeTokenExpiryInSeconds = (int) TimeUnit.DAYS.toSeconds(rememberMeTokenExpiry);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/webjars/**", "/css/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer
                                .maximumSessions(1)
                                .maxSessionsPreventsLogin(false)
                )
                .authorizeRequests((authorizeRequests) ->
                        authorizeRequests
                                .antMatchers("/")
                                .permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin((httpSecurityFormLoginConfigurer) ->
                        httpSecurityFormLoginConfigurer
                                .permitAll()
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/auth/login")
                                .usernameParameter("username")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/index", true)
                )
                .rememberMe((httpSecurityRememberMeConfigurer) ->
                        httpSecurityRememberMeConfigurer
                                .tokenValiditySeconds(rememberMeTokenExpiryInSeconds)
                                .alwaysRemember(false)
                                .key(rememberMeTokenKey)
                                .userDetailsService(applicationUserDetailsService)
                                .rememberMeParameter("remember-me"))
                .userDetailsService(applicationUserDetailsService)

                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer
                                .logoutUrl("/auth/logout")
                                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
                                .clearAuthentication(true)
                                .invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID", "remember-me")
                                .logoutSuccessUrl("/auth/login"));
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        daoAuthenticationProvider.setUserDetailsService(applicationUserDetailsService);
        return daoAuthenticationProvider;
    }

}
