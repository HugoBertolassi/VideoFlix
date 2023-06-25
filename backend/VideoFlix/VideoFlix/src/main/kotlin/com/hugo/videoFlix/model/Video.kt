package com.hugo.videoFlix.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Video (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long? = null,
        var titulo : String,
        var descricao :String,
        var url:String,
        val ativo:Long = 1
)
