// package com.senai.escola.Models;
//
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
//
// import
// org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
//
//
// @Configuration
// @EnableMethodSecurity // Habilita uso do @PreAuthorize nos controllers
// public class SecurityConfig {
//
// @Bean
// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// http.csrf(csrf -> csrf.disable())
// .authorizeHttpRequests(auth -> auth
// // Rotas públicas (exemplo: login, cadastro)
// .requestMatchers("/auth/**").permitAll()
//
// // Permissões específicas
// .requestMatchers("/alunos/**").hasAnyRole("ADMIN", "PROFESSOR")
// .requestMatchers("/professor/**").hasRole("ADMIN")
//
// // Qualquer outra rota precisa de autenticação
// .anyRequest().authenticated()
// );
//
// return http.build();
// }
//
// @Bean
// public PasswordEncoder passwordEncoder() {
// return new BCryptPasswordEncoder();
// }
// }
