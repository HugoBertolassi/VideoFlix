package com.hugo.videoFlix.service

import com.hugo.videoFlix.dto.`in`.CategoriaForm
import com.hugo.videoFlix.dto.`in`.CategoriaFormUpdate
import com.hugo.videoFlix.dto.`in`.VideoForm
import com.hugo.videoFlix.dto.`in`.VideoFormUpdate
import com.hugo.videoFlix.exception.NotFoundException
import com.hugo.videoFlix.mapper.CategoriaFormMapper
import com.hugo.videoFlix.model.Categoria
import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.repository.CategoriaRepository
import org.springframework.stereotype.Service

@Service
class CategoriasService(
       private val categoriaRepository: CategoriaRepository,
       private val categoriaFormMapper: CategoriaFormMapper

) {
    fun listar(): List<Categoria> {
        return categoriaRepository.findAll()
    }

    fun getById(id: Long): Categoria {
        return categoriaRepository.findById(id).orElseThrow {
            val notFoundMessage: String = "Categoria não encontrada"
            NotFoundException(notFoundMessage)
        }
    }

    fun add(categoriaForm: CategoriaForm): Categoria {
        val categoria = categoriaFormMapper.map(categoriaForm)
        categoriaRepository.save(categoria)
        return categoria
    }

    fun update(categoriaFormUpdate: CategoriaFormUpdate): Categoria {
        val notFoundMessage:String = "Video não encontrado"
        val categoria=categoriaRepository.findById(categoriaFormUpdate.id)
                .orElseThrow{NotFoundException(notFoundMessage)}
        categoria.titulo=categoriaFormUpdate.titulo
        categoria.cor=categoriaFormUpdate.cor

        return categoria

    }

    fun excluirPorId(id: Long):Boolean {
        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id)
            return true
        }
        return false
    }
}