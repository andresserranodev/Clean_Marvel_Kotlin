package com.puzzlebench.cmk.domain.service

import com.puzzlebench.cmk.domain.model.MarvelCard
import io.reactivex.Single

interface ComicsServices {
    fun getComics(): Single<List<MarvelCard>>
}