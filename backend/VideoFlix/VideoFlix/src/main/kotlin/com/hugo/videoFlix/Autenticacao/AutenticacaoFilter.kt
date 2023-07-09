package com.hugo.videoFlix.Autenticacao

import com.hugo.videoFlix.repository.UsuarioRepository
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.tomcat.util.http.parser.Authorization
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class AutenticacaoFilter(
        private val jwtUtil:JWTUtil,
        private val authenticationService: AuthenticationService
):OncePerRequestFilter() {
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        val token:String
        val authorizationHeader:String?=request.getHeader("Authorization")
        if(authorizationHeader !=null){
            token=authorizationHeader.replace("Bearer ","")
            var subject=this.jwtUtil.getSubject(token)

            var usuario =authenticationService.loadUserByUsername(subject)

            var auth = UsernamePasswordAuthenticationToken(usuario,null,usuario.authorities)

            SecurityContextHolder.getContext().authentication = auth
        }

        filterChain.doFilter(request,response)
    }

}
