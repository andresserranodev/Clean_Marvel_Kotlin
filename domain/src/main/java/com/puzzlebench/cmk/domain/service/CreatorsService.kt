package com.puzzlebench.cmk.domain.service

import com.puzzlebench.cmk.domain.model.MarvelCard
import io.reactivex.Single

interface CreatorsService {
    fun getCreators(): Single<List<MarvelCard>>
}