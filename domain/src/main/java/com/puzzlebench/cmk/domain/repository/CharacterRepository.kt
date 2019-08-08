package com.puzzlebench.cmk.domain.repository

import com.puzzlebench.cmk.domain.model.Character
import io.reactivex.Completable

interface CharacterRepository {
    fun getAll(): List<Character>
    fun save(c: List<Character>): Completable
}