package com.hugo.videoFlix.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Categoria(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id :Long? = null,
        var titulo : String,
        var cor:String
)