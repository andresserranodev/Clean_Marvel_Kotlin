package com.puzzlebench.cmk.data.mapper.service

import com.puzzlebench.cmk.data.service.response.ComicResponse
import com.puzzlebench.cmk.domain.model.MarvelCard

class ComicMapperService : BaseMapperService<ComicResponse, MarvelCard> {

    override fun transform(response: ComicResponse): MarvelCard = MarvelCard(
            response.title,
            response.variantDescription,
            transformToThumbnail(response.thumbnail))

    override fun transformToResponse(type: MarvelCard): ComicResponse = ComicResponse(
            type.header,
            type.description,
            transformToThumbnailResponse(type.thumbnail))

}