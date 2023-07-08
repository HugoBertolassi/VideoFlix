package com.hugo.videoFlix.Autenticacao

import com.hugo.videoFlix.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
        private val usuarioRepository: UsuarioRepository
):UserDetailsService {
    override fun loadUserByUsername(email: String?): UserDetails {
        val usuario= usuarioRepository.findByEmail(email) ?: throw RuntimeException()
        println(usuario.email)
        println(usuario.role)
        return UserDetailService(usuario)
    }
}