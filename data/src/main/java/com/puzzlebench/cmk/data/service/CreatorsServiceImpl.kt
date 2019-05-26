package com.puzzlebench.cmk.data.service

import com.puzzlebench.cmk.data.mapper.service.CreatorMapperService
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.service.CreatorsService
import io.reactivex.Single

class CreatorsServiceImpl constructor(private val api: MarvelResquestGenerator = MarvelResquestGenerator(),
                                      private val mapper: CreatorMapperService = CreatorMapperService())
    : CreatorsService {
    override fun getCreators(): Single<List<MarvelCard>> {
        return api.makeMarvelService().getCreators().map { response ->
            response.data!!.result.map { comicsResponse -> mapper.transform(comicsResponse) }
        }
    }
}