package com.puzzlebench.clean_marvel_kotlin.data.repository

import com.puzzlebench.clean_marvel_kotlin.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.clean_marvel_kotlin.data.model.CharacterRealm
import com.puzzlebench.clean_marvel_kotlin.data.repository.source.CharacterDataSource
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character


class CharacterRepository(dataSource: CharacterDataSource, mapper: CharacterMapperRepository) : BaseRepository<Character, CharacterRealm>(dataSource, mapper)
