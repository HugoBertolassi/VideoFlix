package com.hugo.videoFlix.dto.`in`

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

data class LoginForm(
    @field:NotEmpty
    val login:String,
    @field:NotEmpty
    val password: String
    )
