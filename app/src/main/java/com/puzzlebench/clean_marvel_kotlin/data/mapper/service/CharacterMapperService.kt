package com.puzzlebench.clean_marvel_kotlin.data.mapper.service

import com.puzzlebench.clean_marvel_kotlin.data.service.response.CharacterResponse
import com.puzzlebench.clean_marvel_kotlin.data.service.response.ThumbnailResponse
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.model.Thumbnail


class CharacterMapperService : BaseMapperService<CharacterResponse, Character> {

    override fun transform(characterResponse: CharacterResponse): Character
            = Character(
            characterResponse.name,
            characterResponse.description,
            transformToThumbnail(characterResponse.thumbnail)
    )

    override fun transformToResponse(type: Character): CharacterResponse
            = CharacterResponse(
            type.name,
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

    fun transform(charactersResponse: List<CharacterResponse>): List<Character>
            = charactersResponse.map { transform(it) }

}