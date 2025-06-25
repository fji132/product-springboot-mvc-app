package ma.youhad.productspringmcv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
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
                //.formLogin(Customizer.withDefaults())

                // Customizable login formula
                .formLogin(fl->fl.loginPage("/login").permitAll())
                //  all request with /user need USER authentication
                .csrf(Customizer.withDefaults())
                //.authorizeHttpRequests(authr ->authr.requestMatchers("/user/**").hasRole("USER"))
                //  all request with /admin need ADMIN authentication
                //.authorizeHttpRequests(authr ->authr.requestMatchers("/admin/**").hasRole("ADMIN"))
                // public authentication
                .authorizeHttpRequests(authr ->authr.requestMatchers("/public/**","/webjars/**").permitAll())
                // all request need authentication
                .authorizeHttpRequests(authr ->authr.anyRequest().authenticated())
                // if a user tried to access a place he is not authorized to enter, he will be  redirected to the page specified
                .exceptionHandling(eh -> eh.accessDeniedPage("/notAuthorized"))
                .build();
    }
}
