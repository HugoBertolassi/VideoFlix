package com.hugo.videoFlix.Autenticacao

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Component
import java.util.*


@Component
class JWTUtil(){
    private val expiration=60000 //1min
    @Value("\${jwt.secret}")//pega o valor do yml  que define o valor do segredo da chave do yml
    private lateinit var  secret:String//lateInitapenas carrega a variavel quando gerar

//    fun gerarToken(username: String, authorities: MutableCollection<out GrantedAuthority>){
//        return return Jwts.builder()
//                .setSubject(username)
//                .claim("role", authorities)//pega as roles do usuario
//                .setExpiration(Date(System.currentTimeMillis()+ expiration))
//                .signWith(SignatureAlgorithm.HS512,secret.toByteArray())
//                .compact()//junta as infs do token
//    }

    fun gerarToken(username: String, authorities: MutableCollection<out GrantedAuthority>):String {
        val auth=Jwts.builder()
                .setSubject(username)
                .claim("role", authorities)
                //.setExpiration(LocalDateTime.now().plusMinutes(10).toInstant("-03:00"))
                .setExpiration(Date(System.currentTimeMillis()+ expiration))
                .signWith(SignatureAlgorithm.HS512,secret.toByteArray())
                .compact()
        println("autoridade: ${auth}")
        return auth
    }
}