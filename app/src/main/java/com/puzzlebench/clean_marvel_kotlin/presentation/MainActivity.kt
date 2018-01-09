package com.puzzlebench.clean_marvel_kotlin.presentation

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.adapter.CharacterAdapter
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseRxActivity(), CharacterView {

    val presenter = CharacterPresenter(this, GetCharacterServiceUseCase(CharacterServicesImpl()), subscriptions)
    var adapter = CharacterAdapter { character -> showToast(character.name) }
    private val SPAN_COUNT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.int()
        recycleView.layoutManager = GridLayoutManager(this, SPAN_COUNT)
        recycleView.adapter = adapter

    }

    override fun showToastNetworkError(error: String) {
        showToast(error)
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun showCharacters(characters: List<Character>) {
        adapter.data = characters
    }

    override fun showLoading() {
        progressBar.visibility = View.GONE

    }
}
