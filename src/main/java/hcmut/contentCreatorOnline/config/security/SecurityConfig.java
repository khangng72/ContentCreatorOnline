package hcmut.contentCreatorOnline.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disable CSRF and permit all requests
        http
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable()) // Updated way to disable CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()); // Allow all requests without
                                                        // authentication

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Use a secure encoder to store passwords
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder().encode("password")) // Encode the password
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for password encoding
        return new BCryptPasswordEncoder();
    }
}
