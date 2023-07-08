package com.hugo.videoFlix.Autenticacao

import com.hugo.videoFlix.model.Usuario
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailService (
        private val usuario: Usuario
): UserDetails {
    override fun getAuthorities()=usuario.role
//    : MutableCollection<out GrantedAuthority> {
//        return mutableListOf(SimpleGrantedAuthority("LEITURA_ESCRITA"))
//    }
    override fun getPassword()=usuario.password

    override fun getUsername() =usuario.email

    override fun isAccountNonExpired(): Boolean =true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean =true

    override fun isEnabled(): Boolean =true
}