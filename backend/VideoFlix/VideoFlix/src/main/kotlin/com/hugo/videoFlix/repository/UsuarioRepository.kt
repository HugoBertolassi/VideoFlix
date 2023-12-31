package com.hugo.videoFlix.repository


import com.hugo.videoFlix.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findByEmail(username: String?): Usuario? //por estar no formato o spring já vai intepretar e criar o metodo, não necessitando criar a query

}