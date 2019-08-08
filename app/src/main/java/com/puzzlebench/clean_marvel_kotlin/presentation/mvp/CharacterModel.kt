package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.model.Thumbnail
import com.puzzlebench.cmk.domain.usecase.FetchCharacterUseCase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterModel @Inject constructor(private val fetchCharacterUseCase: FetchCharacterUseCase) : CharacterContract.Model {

    override fun fetchData(): Single<List<Character>> = fetchCharacterUseCase
            .invoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}