package com.hugo.videoFlix.service

import com.hugo.videoFlix.dto.`in`.VideoForm
import com.hugo.videoFlix.dto.`in`.VideoFormUpdate
import com.hugo.videoFlix.exception.NotFoundException
import com.hugo.videoFlix.mapper.VideoFormMapper
import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.repository.VideoRepository
import org.springframework.stereotype.Service


@Service
class VideoService(
        private val videoRepository: VideoRepository,
        private val videoFormMapper: VideoFormMapper
){
    fun listar():List<Video> {
        return videoRepository.findAll()
    }

    fun getById(id:Long):Video{
        println(id)
        return videoRepository.findById(id).orElseThrow{
            val notFoundMessage:String = "Video não encontrado"
            NotFoundException(notFoundMessage)
        }
    }

    fun add(videoForm: VideoForm):Video {
        val video = videoFormMapper.map(videoForm)
        videoRepository.save(video)
        return video
    }

    fun update(videoFormUpdate: VideoFormUpdate): Video {
        val notFoundMessage:String = "Video não encontrado"
        val video=videoRepository.findById(videoFormUpdate.id)
                .orElseThrow{NotFoundException(notFoundMessage)}
        video.titulo=videoFormUpdate.titulo
        video.descricao=videoFormUpdate.descricao
        video.url=videoFormUpdate.url

        return video

    }

    fun excluirPorId(id: Long):Boolean {
       if(videoRepository.existsById(id)){
           videoRepository.deleteById(id)
           return true
       }
        return false
    }


}
