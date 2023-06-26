package com.hugo.videoFlix.mapper

import com.hugo.videoFlix.dto.`in`.VideoForm
import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.service.CategoriasService
import org.springframework.stereotype.Component

@Component
class VideoFormMapper(
        private val categoriasService: CategoriasService
):MapperInterface<VideoForm, Video> {
    override fun map(t: VideoForm): Video {
        return Video(
                titulo = t.titulo,
                descricao = t.descricao,
                url = t.url,
                categoria = categoriasService.getById(t.categoriaId)
        )
    }
}