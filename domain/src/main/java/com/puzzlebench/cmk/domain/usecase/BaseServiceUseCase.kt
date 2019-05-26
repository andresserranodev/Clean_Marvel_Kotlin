package com.puzzlebench.cmk.domain.usecase

import com.puzzlebench.cmk.domain.model.MarvelCard
import io.reactivex.Single

interface BaseServiceUseCase {

    fun invoke(): Single<List<MarvelCard>>
}