package com.puzzlebench.cmk.domain.cache

import com.puzzlebench.cmk.domain.model.Character
import io.reactivex.Completable

interface CharacterCache {
    fun getAll(): List<Character>
    fun save(c: List<Character>): Completable
}