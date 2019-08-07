package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.cmk.domain.model.Character
import javax.inject.Inject

class CharacterPresenterV2 @Inject constructor(private val view: CharacterContract.View,
                                               private val model: CharacterContract.Model) : CharacterContract.Presenter {

    override fun initPresenter() {
        view.initView()
        fetchData()
    }

    override fun fetchData() {
        val characters: List<Character> = model.fetchData()
        if (characters.isEmpty()) {
            view.showMessageNoItemToShow()
        } else {
            view.hideLoading()
            view.showCharacters(characters)
        }
    }
}