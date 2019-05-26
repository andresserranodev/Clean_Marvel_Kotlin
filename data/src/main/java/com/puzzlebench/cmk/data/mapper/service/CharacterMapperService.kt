package com.puzzlebench.cmk.data.mapper.service

import com.puzzlebench.cmk.data.service.response.CharacterResponse
import com.puzzlebench.cmk.data.service.response.ThumbnailResponse
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.model.Thumbnail


class CharacterMapperService : BaseMapperService<CharacterResponse, MarvelCard> {

    override fun transform(characterResponse: CharacterResponse): MarvelCard
            = MarvelCard(
            characterResponse.name,
            characterResponse.description,
            transformToThumbnail(characterResponse.thumbnail)
    )

    override fun transformToResponse(type: MarvelCard): CharacterResponse
            = CharacterResponse(
            type.header,
            type.description,
            transformToThumbnailResponse(type.thumbnail)
    )

    fun transformToThumbnail(thumbnailResponse: ThumbnailResponse): Thumbnail
            = Thumbnail(
            thumbnailResponse.path,
            thumbnailResponse.extension
    )

    fun transformToThumbnailResponse(thumbnail: Thumbnail): ThumbnailResponse
            = ThumbnailResponse(
            thumbnail.path,
            thumbnail.extension
    )

    fun transform(charactersResponse: List<CharacterResponse>): List<MarvelCard>
            = charactersResponse.map { transform(it) }

}