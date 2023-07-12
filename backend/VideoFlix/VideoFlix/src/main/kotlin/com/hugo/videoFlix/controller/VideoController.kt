package com.hugo.videoFlix.controller

import com.hugo.videoFlix.dto.`in`.VideoForm
import com.hugo.videoFlix.dto.`in`.VideoFormUpdate
import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.service.VideoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/videos")
class VideoController(
        private val videoService:VideoService
) {
    @GetMapping
    fun listar(
            @RequestParam(required = false) titulo:String?,
            //@PageableDefault(size = 5, sort = ["dataCriacao"], direction = Sort.Direction.DESC ) paginacao: Pageable
            @PageableDefault(size = 5 ) paginacao: Pageable
    ): Page<Video> {
        return videoService.listar(titulo,paginacao)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id:Long):Video{
        return videoService.getById(id)
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    fun createVideo(
            @RequestBody @Valid videoForm: VideoForm,
            uriBuilder: UriComponentsBuilder
    ):ResponseEntity<Video>{
        val video =videoService.add(videoForm)
        val uri=uriBuilder.path("/topicos/${video.id}").build().toUri()
        return ResponseEntity.created(uri).body(video)
    }

    @PutMapping
    @Transactional
    fun updateVideo(
            @RequestBody @Valid videoFormUpdate: VideoFormUpdate,
            uriBuilder: UriComponentsBuilder
    ):ResponseEntity<Video>{
        val video =videoService.update(videoFormUpdate)
        val uri=uriBuilder.path("/topicos/${video.id}").build().toUri()
        return ResponseEntity.created(uri).body(video)
    }

    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deleteVideo(
            @PathVariable id:Long
    ):ResponseEntity<Unit>{
        return if(videoService.excluirPorId(id)){
            ResponseEntity.noContent().build()
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
}