package com.puzzlebench.cmk.data.mapper.cache

import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.model.ThumbnailRealm
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.model.Thumbnail
import javax.inject.Inject

class CharacterMapperCache @Inject constructor() : BaseMapperCache<Character, CharacterRealm> {

    override fun transform(input: CharacterRealm): Character = Character(input.name!!, input.description!!, transformToThumbnail(input.thumbnail!!))

    override fun transform(input: Character): CharacterRealm = CharacterRealm(input.name, input.description, transformToThumbnailRealm(input.thumbnail))

    private fun transformToThumbnail(thumbnailRealm: ThumbnailRealm): Thumbnail = Thumbnail(thumbnailRealm.path!!, thumbnailRealm.extension!!)

    private fun transformToThumbnailRealm(thumbnail: Thumbnail): ThumbnailRealm = ThumbnailRealm(thumbnail.path, thumbnail.extension)
}
