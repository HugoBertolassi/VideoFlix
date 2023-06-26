package com.hugo.videoFlix.repository

import com.hugo.videoFlix.model.Categoria
import org.springframework.data.jpa.repository.JpaRepository

interface CategoriaRepository: JpaRepository<Categoria, Long> {
}