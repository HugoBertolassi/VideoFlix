package com.hugo.videoFlix.Autenticacao

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
class SecurityConfiguration (
        private val configuration: AuthenticationConfiguration,
        private val jwtUtil: JWTUtil
){
    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration):AuthenticationManager{
        return authenticationConfiguration.authenticationManager
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
                .csrf { csrf -> csrf.disable() }   ///remoção do controle de csrf, Verificar como adicionar essa etapa, sem ela bloqueava o post
                .authorizeHttpRequests(Customizer {auth->
                    auth
                            .requestMatchers("/login").permitAll()
                            .requestMatchers("/videos","/videos/**")
                                .hasAuthority("LEITURA_ESCRITA")
                            .anyRequest().authenticated()
                })
                .sessionManagement(Customizer{session->
                    session.
                    sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                })

        return http.build()
    }

}