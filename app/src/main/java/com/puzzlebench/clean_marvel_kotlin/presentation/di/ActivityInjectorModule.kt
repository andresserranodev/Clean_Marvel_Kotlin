package com.puzzlebench.clean_marvel_kotlin.presentation.di

import com.puzzlebench.clean_marvel_kotlin.presentation.android.MainActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.di.android.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjectorModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [CharacterModule::class])
    abstract fun mainActivity(): MainActivity

}