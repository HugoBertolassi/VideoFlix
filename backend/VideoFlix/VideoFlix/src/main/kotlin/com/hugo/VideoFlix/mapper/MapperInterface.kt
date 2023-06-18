package com.hugo.VideoFlix.mapper

interface MapperInterface<T,U> {
    fun map(t:T):U
}