package com.hugo.videoFlix.dto.`in`


import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class VideoForm  (
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val titulo:String,
    @field:NotEmpty
    val descricao: String,
    @field:NotEmpty
    @field:Pattern(regexp ="^(([-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*))|(https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\\\=]*)))\$")
    val url: String,
    @field:NotNull
    val categoriaId:Long
)

data class VideoFormUpdate  (
        @field:NotNull
        val id:Long,
        @field:NotEmpty
        @field:Size(min = 5, max = 100)
        val titulo:String,
        @field:NotEmpty
        val descricao: String,
        @field:NotEmpty
        @field:Pattern(regexp ="^(([-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*))|(https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_\\+.~#?&\\\\=]*)))\$")
        val url: String
)