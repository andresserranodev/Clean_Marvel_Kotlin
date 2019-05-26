package com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel

import com.puzzlebench.cmk.domain.model.MarvelCard

sealed class CharactersViewState {
    class ShowItems(val items: List<MarvelCard>) : CharactersViewState()
    class ShowMessage(val message: String) : CharactersViewState()

}