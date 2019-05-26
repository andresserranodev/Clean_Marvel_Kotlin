package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.MarvelCard
import com.puzzlebench.cmk.domain.service.ComicsServices
import io.reactivex.Single

class GetComicsServiceUseCase constructor(private val comicsServices: ComicsServices) :BaseServiceUseCase {

     override fun invoke(): Single<List<MarvelCard>> = comicsServices.getComics()

}