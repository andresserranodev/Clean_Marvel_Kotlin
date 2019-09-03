package com.puzzlebench.clean_marvel_kotlin.presentation.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.presentation.mvp.CharacterContract
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    @Inject
    lateinit var presenter: CharacterContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.initPresenter()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }
}
