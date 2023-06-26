package com.hugo.videoFlix.model

import jakarta.persistence.*

@Entity
data class Video (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long? = null,
        var titulo : String,
        var descricao :String,
        var url:String,
        val ativo:Long = 1,
        @ManyToOne
        var categoria:Categoria
)
