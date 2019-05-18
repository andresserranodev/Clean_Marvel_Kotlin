package com.puzzlebench.clean_marvel_kotlin.presentation.viewmodel

sealed class ScreenState<out T> {
    object Loading : ScreenState<Nothing>()
    class Render<T>(val renderState: T) : ScreenState<T>()
}