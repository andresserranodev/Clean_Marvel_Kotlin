package com.puzzlebench.cmk.data.mapper.service

import com.puzzlebench.cmk.data.service.response.CreatorsResponse
import com.puzzlebench.cmk.domain.model.MarvelCard

class CreatorMapperService : BaseMapperService<CreatorsResponse, MarvelCard> {

    override fun transform(type: CreatorsResponse): MarvelCard = MarvelCard(
            type.fullName,
            "FirstName :" + type.firstName + "Modified:" + type.modified,
            transformToThumbnail(type.thumbnail))

    override fun transformToResponse(type: MarvelCard): CreatorsResponse = CreatorsResponse(
            type.header,
            type.description,
            type.description,
            transformToThumbnailResponse(type.thumbnail))
}