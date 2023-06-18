package com.hugo.VideoFlix.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Video (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long? = null,
        val titulo : String,
        val descricao :String,
        val url:String,
        val ativo:Long = 1
)
