package com.hugo.VideoFlix.service

import com.hugo.VideoFlix.exception.NotFoundException
import com.hugo.VideoFlix.model.Video
import com.hugo.VideoFlix.repository.VideoRepository
import org.springframework.stereotype.Service


@Service
class VideoService(
        private val videoRepository: VideoRepository
){
    fun listar():List<Video> {
        return videoRepository.findAll()
    }

    fun getById(id:Long):Video{
        return videoRepository.findById(id).orElseThrow{
            val notFoundMessage:String = "Video não encontrado"
            NotFoundException(notFoundMessage)
        }
    }


}
