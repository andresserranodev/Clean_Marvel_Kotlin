package com.puzzlebench.clean_marvel_kotlin.presentation

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.presentation.adapter.CharacterAdapter
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel.CharactersViewModel
import com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel.CharactersViewState
import com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel.CharactersViewModelFactory
import com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel.ScreenState
import com.puzzlebench.cmk.data.service.CharacterServicesImpl
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.usecase.GetCharacterServiceUseCase
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recycleView

class MainActivityMVVM : AppCompatActivity() {

    private val getCharacterServiceUseCase = GetCharacterServiceUseCase(CharacterServicesImpl())

    private lateinit var viewModel: CharactersViewModel
    private val count = 1

    var adapter = CharacterAdapter { character -> this.showToast(character.name) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(
                this,
                CharactersViewModelFactory(getCharacterServiceUseCase)
        )[CharactersViewModel::class.java]
        viewModel.mainState.observe(::getLifecycle, ::updateUI)
        recycleView.layoutManager = GridLayoutManager(this, count)
        recycleView.adapter = adapter

    }

    private fun updateUI(screenState: ScreenState<CharactersViewState>?) {
        when (screenState) {
            ScreenState.Loading -> showProgress()
            is ScreenState.Render -> processRenderState(screenState.renderState)
        }
    }

    private fun processRenderState(renderState: CharactersViewState) {
        hideProgress()
        when (renderState) {
            is CharactersViewState.ShowItems -> showCharacters(renderState.items)
            is CharactersViewState.ShowMessage -> this.showToast(renderState.message)

        }
    }

    private fun showCharacters(characters: List<Character>) {
        adapter.data = characters
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
        recycleView.visibility = View.GONE
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
        recycleView.visibility = View.VISIBLE
    }


}
