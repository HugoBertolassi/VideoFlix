package com.hugo.videoFlix.Autenticacao

import com.hugo.videoFlix.dto.`in`.LoginForm
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
@RestController
class AuthController(
    private val authenticationManager: AuthenticationManager,
    private val jwtUtil:JWTUtil

) {

    @PostMapping("/login")
    fun login(@RequestBody login:LoginForm): String {
      val token=UsernamePasswordAuthenticationToken(login.login,login.password)
       var auth:Authentication= this.authenticationManager.authenticate(token)
        println(login.password)
//        var user =auth.getPrincipal() as UserDetails
        var user =auth.principal as UserDetails
        println("userdeail :$user")
        return jwtUtil.gerarToken(user.username,user.authorities)
    }

}