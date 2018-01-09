package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import com.puzzlebench.clean_marvel_kotlin.domain.model.Character

interface CharacterView {
    fun hideLoading()
    fun showCharacters(characters: List<Character>)
    fun showLoading()
    fun showToastNetworkError(error: String)

}