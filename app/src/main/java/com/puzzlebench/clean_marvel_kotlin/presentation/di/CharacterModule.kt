package com.puzzlebench.clean_marvel_kotlin.presentation.di

import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterContract
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterModel
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterPresenter
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterView
import com.puzzlebench.cmk.data.di.repository.RepositoryModule
import com.puzzlebench.cmk.data.di.service.ServiceModule
import dagger.Binds
import dagger.Module

@Module(includes = [ServiceModule::class, RepositoryModule::class])
abstract class CharacterModule {
    @Binds
    abstract fun provideCharacterModel(characterModel: CharacterModel): CharacterContract.Model

    @Binds
    abstract fun provideCharacterView2(characterView2: CharacterView): CharacterContract.View

    @Binds
    abstract fun provideCharacterPresenterV2(characterPresenter: CharacterPresenter): CharacterContract.Presenter
}