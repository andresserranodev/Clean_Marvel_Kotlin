package com.puzzlebench.clean_marvel_kotlin.presentation

import android.os.Bundle
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.cmk.data.mapper.repository.CharacterMapperRepository
import com.puzzlebench.cmk.data.repository.CharacterDataRepository
import com.puzzlebench.cmk.data.repository.source.CharacterDataSource
import com.puzzlebench.cmk.data.service.CharacterServicesImpl
import com.puzzlebench.cmk.domain.usecase.GetCharacterRepositoryUseCase
import com.puzzlebench.cmk.domain.usecase.GetCharacterServiceUseCase
import com.puzzlebench.clean_marvel_kotlin.presentation.base.BaseRxActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterView

open class MainActivity : BaseRxActivity() {

    val getCharacterServiceUseCase = GetCharacterServiceUseCase(CharacterServicesImpl())
    val getCharacterRepositoryUseCase = GetCharacterRepositoryUseCase(CharacterDataRepository(CharacterDataSource(), CharacterMapperRepository()))

    val presenter = CharacterPresenter(CharacterView(this), getCharacterServiceUseCase, getCharacterRepositoryUseCase, subscriptions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.init()
    }
}
