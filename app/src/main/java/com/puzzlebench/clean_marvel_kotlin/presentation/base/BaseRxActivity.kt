package com.puzzlebench.clean_marvel_kotlin.presentation.base

import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

open class BaseRxActivity : AppCompatActivity() {

    protected var subscriptions = CompositeDisposable()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeDisposable()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
}