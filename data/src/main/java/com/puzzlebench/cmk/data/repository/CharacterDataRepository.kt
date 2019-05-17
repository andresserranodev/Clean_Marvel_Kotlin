package com.puzzlebench.cmk.data.repository

import com.puzzlebench.cmk.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.cmk.data.repository.source.CharacterDataSource
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository


class CharacterDataRepository constructor(private val dataSource: CharacterDataSource,
                                          private val mapper: CharacterMapperRepository) : CharacterRepository {

    override fun save(c: List<Character>) {
        dataSource.saveCharacters(c.map { mapper.transform(it) })
    }

    override fun getAll(): List<Character> {
        return dataSource.getAllCharacters().map { mapper.transform(it) }
    }

}
