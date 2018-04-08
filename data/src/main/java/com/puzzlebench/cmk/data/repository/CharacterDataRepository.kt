package com.puzzlebench.cmk.data.repository

import com.puzzlebench.cmk.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.repository.source.CharacterDataSource
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.repository.CharacterRepository


class CharacterDataRepository(dataSource: CharacterDataSource, mapper: CharacterMapperRepository) : BaseDataRepository<Character, CharacterRealm>(dataSource, mapper), CharacterRepository
