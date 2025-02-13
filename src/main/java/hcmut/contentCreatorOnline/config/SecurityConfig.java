package hcmut.contentCreatorOnline.config;

import hcmut.contentCreatorOnline.filter.JwtFilter;
import hcmut.contentCreatorOnline.handler.CustomAccessDeniedHandler;
import hcmut.contentCreatorOnline.handler.CustomAuthenticationEntryPoint;
import hcmut.contentCreatorOnline.service.impl.CustomUserDetailsService;
import hcmut.contentCreatorOnline.utils.PasswordUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    final CustomUserDetailsService userDetailsService;

    final JwtFilter jwtFilter;

    final PasswordUtil passwordUtil;

    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtFilter jwtFilter, PasswordUtil passwordUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtFilter = jwtFilter;
        this.passwordUtil = passwordUtil;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/auth/**", "/user/register")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .httpBasic(AbstractHttpConfigurer::disable)
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(new CustomAuthenticationEntryPoint())
                        .accessDeniedHandler(new CustomAccessDeniedHandler()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordUtil);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
