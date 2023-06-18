package com.hugo.VideoFlix.controller

import com.hugo.VideoFlix.model.Video
import com.hugo.VideoFlix.service.VideoService
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/videos")
class VideoController(
        private val videoService:VideoService
) {
    @GetMapping
    fun listar():List<Video>{
        return videoService.listar()
    }


}