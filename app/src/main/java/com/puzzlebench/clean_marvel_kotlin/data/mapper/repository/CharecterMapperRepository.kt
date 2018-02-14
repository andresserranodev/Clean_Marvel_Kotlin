package com.puzzlebench.clean_marvel_kotlin.data.mapper.repository

import com.puzzlebench.clean_marvel_kotlin.data.model.CharacterRealm
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.model.Thumbnail

class CharecterMapperRepository : BaseMapperRepository<Character, CharacterRealm> {
    override fun transform(input: CharacterRealm): Character = Character(input.name!!, input.description!!, Thumbnail(input.name!!, input.description!!))

    override fun transform(input: Character): CharacterRealm = CharacterRealm(input.name, input.description)


}
