package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.cmk.domain.model.Character
import io.reactivex.Single

interface CharacterContract {

    interface Presenter {
        fun initPresenter()
        fun fetchData()
        fun onPause()

    }

    interface Model {
        fun fetchData(): Single<List<Character>>
    }

    interface View {
        fun initView()
        fun showLoading()
        fun hideLoading()
        fun showMessageNoItemToShow()
        fun showNetworkError(error: String)
        fun showCharacters(characters: List<Character>)
    }
}