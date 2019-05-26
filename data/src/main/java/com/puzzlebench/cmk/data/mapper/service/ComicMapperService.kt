package com.puzzlebench.cmk.data.mapper.service

import com.puzzlebench.cmk.data.service.response.ComicsResponse
import com.puzzlebench.cmk.data.service.response.ThumbnailResponse
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.model.Thumbnail

class ComicMapperService : BaseMapperService<ComicsResponse, MarvelCard> {

    override fun transform(response: ComicsResponse): MarvelCard = MarvelCard(
            response.title,
            response.variantDescription,
            transformToThumbnail(response.thumbnail))

    override fun transformToResponse(type: MarvelCard): ComicsResponse = ComicsResponse(
            type.header,
            type.description,
            transformToThumbnailResponse(type.thumbnail))

}