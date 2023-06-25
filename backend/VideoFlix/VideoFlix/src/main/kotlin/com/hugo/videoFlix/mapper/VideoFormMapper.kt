package com.hugo.videoFlix.mapper

import com.hugo.videoFlix.dto.`in`.VideoForm
import com.hugo.videoFlix.model.Video
import org.springframework.stereotype.Component

@Component
class VideoFormMapper:MapperInterface<VideoForm, Video> {
    override fun map(t: VideoForm): Video {
        return Video(
                titulo = t.titulo,
                descricao = t.descricao,
                url = t.url
        )
    }
}