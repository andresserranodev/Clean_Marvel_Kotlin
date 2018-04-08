package com.puzzlebench.clean_marvel_kotlin.data.mapper.repository

import com.puzzlebench.clean_marvel_kotlin.data.model.CharacterRealm
import com.puzzlebench.clean_marvel_kotlin.data.model.ThumbnailRealm
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.model.Thumbnail

class CharacterMapperRepository : BaseMapperRepository<Character, CharacterRealm> {

    override fun transform(input: CharacterRealm): Character = Character(input.name!!, input.description!!, transformToThumbnail(input.thumbnail!!))

    override fun transform(input: Character): CharacterRealm = CharacterRealm(input.name, input.description, transformToThumbnaiRealm(input.thumbnail))

    fun transformToThumbnail(thumbnailRealm: ThumbnailRealm): Thumbnail = Thumbnail(thumbnailRealm.path!!, thumbnailRealm.extension!!)

    fun transformToThumbnaiRealm(thumbnail: Thumbnail): ThumbnailRealm = ThumbnailRealm(thumbnail.path!!, thumbnail.extension!!)
}
