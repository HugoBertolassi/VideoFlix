package com.hugo.videoFlix.mapper

import com.hugo.videoFlix.dto.`in`.CategoriaForm
import com.hugo.videoFlix.model.Categoria
import org.springframework.stereotype.Component

@Component
class CategoriaFormMapper :MapperInterface<CategoriaForm, Categoria>{
    override fun map(t: CategoriaForm): Categoria {
        return Categoria(
                titulo=t.titulo,
                cor = t.cor
        )
    }
}