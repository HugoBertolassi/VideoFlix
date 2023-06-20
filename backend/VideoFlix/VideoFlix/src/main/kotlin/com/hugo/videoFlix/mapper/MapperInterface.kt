package com.hugo.videoFlix.mapper

interface MapperInterface<T,U> {
    fun map(t:T):U
}