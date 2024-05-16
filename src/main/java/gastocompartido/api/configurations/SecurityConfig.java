package gastocompartido.api.configurations;

import gastocompartido.api.utils.JwtAuthenticationFilter;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final ApplicationConfig applicationConfig;

    @Value("${auto-open-browser}")
    private String openBrowser;

    /**
     * A SecurityFilterChain function that configures security for the HTTP requests.
     *
     * @param  http  the HttpSecurity object for configuring security
     * @return      the configured SecurityFilterChain object
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authRequest ->
                        authRequest.requestMatchers("/auth/**", "users/login",
                                        "/api/v1/auth/**", "/v3/api-docs/**","/v3/api-docs.yaml", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                        sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(applicationConfig.authenticationProvider())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @PostConstruct
    public void init() {
        openBrowser("http://localhost:8080/swagger-ui/index.html");
    }

    private void openBrowser(String url) {
        if (openBrowser.equals("true")) {
            String os = System.getProperty("os.name").toLowerCase();
            Runtime rt = Runtime.getRuntime();

            try {
                if (os.contains("win")) {
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (os.contains("mac")) {
                    rt.exec("open " + url);
                } else if (os.contains("nix") || os.contains("nux")) {
                    rt.exec("xdg-open " + url);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
