package com.puzzlebench.cmk.domain.repository

import com.puzzlebench.cmk.domain.model.MarvelCard

interface CharacterRepository {
    fun getAll() : List<MarvelCard>
    fun save(c: List<MarvelCard>)
}