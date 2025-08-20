package co.edu.uniminuto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import co.edu.uniminuto.security.JwtFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                // Solo admin puede ver usuarios
                .requestMatchers(HttpMethod.GET, "/usuarios/**")
                    .hasRole("ADMINISTRADOR")
                // Lectura para usuarios y admin en los demás
                .requestMatchers(HttpMethod.GET, "/empleados/**", "/cargos/**", "/grupos/**", "/vacantes/**", "/postulaciones/**")
                    .hasAnyRole("ADMINISTRADOR", "USUARIO")
                // Solo admin puede modificar
                .requestMatchers(HttpMethod.POST, "/usuarios/**", "/empleados/**", "/cargos/**", "/grupos/**", "/vacantes/**", "/postulaciones/**")
                    .hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PUT, "/usuarios/**", "/empleados/**", "/cargos/**", "/grupos/**", "/vacantes/**", "/postulaciones/**")
                    .hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.DELETE, "/usuarios/**", "/empleados/**", "/cargos/**", "/grupos/**", "/vacantes/**", "/postulaciones/**")
                    .hasRole("ADMINISTRADOR")
                .requestMatchers(HttpMethod.PATCH, "/usuarios/**", "/empleados/**", "/cargos/**", "/grupos/**", "/vacantes/**", "/postulaciones/**")
                    .hasRole("ADMINISTRADOR")
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}