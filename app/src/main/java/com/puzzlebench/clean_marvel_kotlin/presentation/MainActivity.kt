package com.puzzlebench.clean_marvel_kotlin.presentation

import android.os.Bundle
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.clean_marvel_kotlin.data.repository.CharacterRepository
import com.puzzlebench.clean_marvel_kotlin.data.repository.source.CharacterDataSource
import com.puzzlebench.clean_marvel_kotlin.data.service.CharacterServicesImpl
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterRepositoryUseCase
import com.puzzlebench.clean_marvel_kotlin.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.BaseRxActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharecterView

open class MainActivity : BaseRxActivity() {

    val getCharacterServiceUseCase = GetCharacterServiceUseCase(CharacterServicesImpl())
    val getCharacterRepositoryUseCase = GetCharacterRepositoryUseCase(CharacterRepository(CharacterDataSource(), CharacterMapperRepository()))

    val presenter = CharacterPresenter(CharecterView(this), getCharacterServiceUseCase, getCharacterRepositoryUseCase, subscriptions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.init()
    }
}
