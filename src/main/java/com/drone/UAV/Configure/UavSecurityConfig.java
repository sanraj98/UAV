package com.drone.UAV.Configure;

import com.drone.UAV.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

@Configuration
public class UavSecurityConfig {

    @Autowired
    private UserService userservice;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userservice).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/uav/map");
        handler.setUseReferer(false);
        return handler;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/admin/**").hasAuthority("ADMIN") // Require authentication for /admin/feedback_data
                                .requestMatchers("/api/**").permitAll()
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/static/**").permitAll() // Add this line to permit access to CSS files
                                .anyRequest().authenticated()

                )

                .formLogin(form ->
                        form
                                .loginPage("/uav/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .successHandler(successHandler())
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/log/access-denied")

                );

        return http.build();
    }
}
