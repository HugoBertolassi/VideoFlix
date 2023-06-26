package com.hugo.videoFlix.dto.`in`

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class CategoriaForm(
        @field:NotEmpty
        @field:Size(min = 2, max = 100)
        val titulo:String,
        @field:NotEmpty
        val cor: String
)

data class CategoriaFormUpdate(
        @field:NotNull
        val id:Long,
        @field:NotEmpty
        @field:Size(min = 2, max = 100)
        val titulo:String,
        @field:NotEmpty
        val cor: String
)
