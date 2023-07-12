package com.hugo.videoFlix.repository

import com.hugo.videoFlix.model.Video
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface VideoRepository: JpaRepository<Video, Long> {
    // https://www.baeldung.com/spring-data-derived-queries
    // https://www.baeldung.com/spring-data-jpa-query

    fun findByTitulo(titulo:String):List<Video>

     //fun findAllTitulo(@Param("titulo")titulo:String):List<Video>

    //@Query("SELECT new com.hugo.videoFlix.model.Video(id,titulo,descricao,url) FROM video WHERE titulo LIKE CONCAT('%', :titulo, '%')")
    //fun findByTextContaining(@Param("titulo") titulo:String):List<Video>

    //@Query("SELECT new com.hugo.videoFlix.model.Video FROM video WHERE titulo LIKE CONCAT('%', 'video', '%')")
    //fun findByTextContaining(@Param("titulo") titulo:String):List<Video>

    fun findByTituloContaining(titulo:String):List<Video>
    fun findByCategoriaId(id: Long): List<Video>
    fun findByTituloContaining(titulo: String, paginacao: Pageable): Page<Video>

}