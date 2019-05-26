package com.puzzlebench.cmk.data.service

import com.puzzlebench.cmk.data.mapper.service.ComicMapperService
import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.service.ComicsServices
import io.reactivex.Single

class ComicSerivicesImpl constructor(private val api: MarvelResquestGenerator = MarvelResquestGenerator(),
                                     private val mapper: ComicMapperService = ComicMapperService())
    : ComicsServices {
    override fun getComics(): Single<List<MarvelCard>> {
        return api.makeMarvelService().getComics().map { response ->
            response.data!!.result.map { comicsResponse -> mapper.transform(comicsResponse) }
        }
    }
}