package com.puzzlebench.cmk.domain.service

import com.puzzlebench.cmk.domain.model.Character
import io.reactivex.Observable

interface CharacterServices {
    fun getCharacters(): Observable<List<Character>>
}