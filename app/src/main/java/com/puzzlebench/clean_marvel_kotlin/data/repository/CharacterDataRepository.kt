package com.puzzlebench.clean_marvel_kotlin.data.repository

import com.puzzlebench.clean_marvel_kotlin.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.clean_marvel_kotlin.data.model.CharacterRealm
import com.puzzlebench.clean_marvel_kotlin.data.repository.source.CharacterDataSource
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository


class CharacterDataRepository(dataSource: CharacterDataSource, mapper: CharacterMapperRepository) : BaseDataRepository<Character, CharacterRealm>(dataSource, mapper), CharacterRepository
