package com.hugo.videoFlix.controller

import com.hugo.videoFlix.dto.`in`.CategoriaForm
import com.hugo.videoFlix.dto.`in`.CategoriaFormUpdate
import com.hugo.videoFlix.dto.`in`.VideoForm
import com.hugo.videoFlix.dto.`in`.VideoFormUpdate
import com.hugo.videoFlix.model.Categoria
import com.hugo.videoFlix.model.Video
import com.hugo.videoFlix.service.CategoriasService
import com.hugo.videoFlix.service.VideoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/categorias")
class CategoriaController(
        private val categoriasService: CategoriasService
) {

    @GetMapping
    fun list():List<Categoria>{
        return categoriasService.listar()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id:Long):Categoria{
        return categoriasService.getById(id)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    fun createVideo(
            @RequestBody @Valid categoriaForm: CategoriaForm,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Categoria> {
        val categoria =categoriasService.add(categoriaForm)
        val uri=uriBuilder.path("/categorias/${categoria.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoria)
    }

    @PutMapping
    @Transactional
    fun updateVideo(
            @RequestBody @Valid categoriaFormUpdate: CategoriaFormUpdate,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Categoria> {
        val categoria =categoriasService.update(categoriaFormUpdate)
        val uri=uriBuilder.path("/categorias/${categoria.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoria)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun deleteVideo(
            @PathVariable id:Long
    ): ResponseEntity<Unit> {
        return if(categoriasService.excluirPorId(id)){
            ResponseEntity.noContent().build()
        }
        else{
            ResponseEntity.notFound().build()
        }
    }
}