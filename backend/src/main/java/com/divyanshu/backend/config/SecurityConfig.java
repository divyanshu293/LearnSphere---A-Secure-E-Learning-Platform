package com.divyanshu.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCrryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth


                        .requestMatchers("/api/v1/auth/**").permitAll()


                        .requestMatchers("/api/v1/user/**").hasRole("ADMIN")


                        .requestMatchers(
                                "/api/v1/course/add",
                                "/api/v1/course/edit/**",
                                "/api/v1/course/delete/**",
                                "/api/v1/course/assign/**"
                        ).hasAnyRole("ADMIN", "INSTRUCTOR")


                        .requestMatchers(
                                "/api/v1/course/list",
                                "/api/v1/course/{courseId}"
                        ).authenticated()


                        .requestMatchers(
                                "/api/v1/document/add",
                                "/api/v1/document/edit/**",
                                "/api/v1/document/delete/**"
                        ).hasAnyRole("ADMIN", "INSTRUCTOR")


                        .requestMatchers(
                                "/api/v1/document/list",
                                "/api/v1/document/{documentId}",
                                "/api/v1/document/download/**"
                        ).authenticated()


                        .requestMatchers("/api/v1/log/**").hasRole("ADMIN")


                        .requestMatchers("/api/v1/rate-limit/check/**").authenticated()


                        .requestMatchers(


                                "/swagger-ui.html",


                                "/swagger-ui/**",


                                "/v3/api-docs/**",


                                "/swagger-resources/**",


                                "/webjars/**"


                        ).permitAll()


                        .anyRequest().authenticated()


                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws  Exception {
        return config.getAuthenticationManager();
    }


}

