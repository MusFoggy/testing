package ua.com.testing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.testing.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final UserService userService;

    @Autowired
    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authenticationManager(
                http.getSharedObject(AuthenticationManagerBuilder.class)
                        .userDetailsService(userService)
                        .passwordEncoder(passwordEncoder())
                        .and()
                        .build());
        http
                .csrf()
                .disable()
                .authorizeRequests((authorize) -> authorize
                        .requestMatchers("/static/**").permitAll()
                        .requestMatchers("/login", "/registration").permitAll()
                        .requestMatchers("/category").authenticated()
                        .requestMatchers("/admin").hasRole("Admin")
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error=true")
                )
                .logout((logout) -> logout
                        .permitAll()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                )
                .exceptionHandling()
                .accessDeniedPage("/");
        return http.build();
    }
}

