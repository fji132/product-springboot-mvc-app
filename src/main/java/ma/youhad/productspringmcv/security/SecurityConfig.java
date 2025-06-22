package ma.youhad.productspringmcv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // to apply a hash algorithm to the password
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // InMemoryUserDetailsManager is a strategy that tells Spring
    // the users who have access to the application are stored in memory.
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        PasswordEncoder encoder = passwordEncoder();
        return new InMemoryUserDetailsManager(
                User.withUsername("user1").password(passwordEncoder().encode("1234")).roles("USER").build(),
                User.withUsername("user2").password(passwordEncoder().encode("1234")).roles("USER").build(),
                User.withUsername("user3").password(passwordEncoder().encode("1234")).roles("USER", "ADMIN").build()
        );
    }
    // Security Strategy: Resources that need to be protected;  require authentication.
    // Access to those resources should be authorized based on user roles, such as USER or ADMIN ...
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // default login formula
                .formLogin(Customizer.withDefaults())
                //  all request with /index need USER authentication
                .authorizeHttpRequests(authr ->authr.requestMatchers("/index/**").hasRole("USER"))
                //  all request with /save or /delete need USER ADMIN
                .authorizeHttpRequests(authr ->authr.requestMatchers("/save**/**", "/delete/**").hasRole("ADMIN"))
                // all request need authentication
                .authorizeHttpRequests(authr ->authr.anyRequest().authenticated())
                .build();
    }
}
