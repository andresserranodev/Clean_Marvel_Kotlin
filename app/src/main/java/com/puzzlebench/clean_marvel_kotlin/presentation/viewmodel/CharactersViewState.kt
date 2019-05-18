package com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel

import com.puzzlebench.cmk.domain.model.Character

sealed class CharactersViewState {
    class ShowItems(val items: List<Character>) : CharactersViewState()
    class ShowMessage(val message: String) : CharactersViewState()

}