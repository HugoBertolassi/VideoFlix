package com.hugo.videoFlix.controller

import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.service.VideoService
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