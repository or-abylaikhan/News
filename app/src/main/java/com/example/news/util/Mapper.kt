package com.example.news.util

interface Mapper<N, M> {

    fun from(model: N): M

    fun to(model: M): N

    fun from(model: List<N>): List<M>

    fun to(model: List<M>): List<N>
}