package com.puzzlebench.cmk.data.cache

import com.puzzlebench.cmk.data.model.CharacterRealm

interface CharacterDataSource {
    fun getAllCharacters(): List<CharacterRealm>
    fun saveCharacters(charactersRealm: List<CharacterRealm>)
}