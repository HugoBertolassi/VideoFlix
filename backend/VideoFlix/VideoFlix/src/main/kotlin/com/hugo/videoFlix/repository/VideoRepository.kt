package com.hugo.videoFlix.repository

import com.hugo.videoFlix.model.Video
import org.springframework.data.jpa.repository.JpaRepository


interface VideoRepository: JpaRepository<Video, Long> {

    fun findByTitulo(titulo:String):List<Video>
}