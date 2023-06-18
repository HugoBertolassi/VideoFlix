package com.hugo.VideoFlix.repository

import com.hugo.VideoFlix.model.Video
import org.springframework.data.jpa.repository.JpaRepository


interface VideoRepository: JpaRepository<Video, Long> {
}