package com.puzzlebench.cmk.data.mapper.repository

import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.model.ThumbnailRealm
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.model.Thumbnail

class CharacterMapperRepository : BaseMapperRepository<MarvelCard, CharacterRealm> {

    override fun transform(input: CharacterRealm): MarvelCard = MarvelCard(input.name!!, input.description!!, transformToThumbnail(input.thumbnail!!))

    override fun transform(input: MarvelCard): CharacterRealm = CharacterRealm(input.header, input.description, transformToThumbnailRealm(input.thumbnail))

    private fun transformToThumbnail(thumbnailRealm: ThumbnailRealm): Thumbnail = Thumbnail(thumbnailRealm.path!!, thumbnailRealm.extension!!)

    private fun transformToThumbnailRealm(thumbnail: Thumbnail): ThumbnailRealm = ThumbnailRealm(thumbnail.path, thumbnail.extension)
}
