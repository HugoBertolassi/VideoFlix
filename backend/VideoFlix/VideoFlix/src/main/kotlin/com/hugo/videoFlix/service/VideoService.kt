package com.hugo.videoFlix.service

import com.hugo.videoFlix.exception.NotFoundException
import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.repository.VideoRepository
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
