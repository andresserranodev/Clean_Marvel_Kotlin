package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.domain.model.Character
import com.puzzlebench.clean_marvel_kotlin.presentation.MainActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.adapter.CharacterAdapter
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class CharecterView(activity: MainActivity) {
    private val activityRef = WeakReference(activity)
    private val SPAN_COUNT = 1
    var adapter = CharacterAdapter { character -> activity.applicationContext.showToast(character.name) }

    fun init() {
        val activity = activityRef.get()
        if (activity != null) {
            activity.recycleView.layoutManager = GridLayoutManager(activity, SPAN_COUNT)
            activity.recycleView.adapter = adapter
            showLoading()
        }

    }

    fun showToastNoItemToShow() {
        val activity = activityRef.get()
        if (activity != null) {
            val message = activity.baseContext.resources.getString(R.string.message_no_items_to_show)
            activity.applicationContext.showToast(message)

        }
    }

    fun showToastNetworkError(error: String) {
        activityRef.get()!!.applicationContext.showToast(error)
    }

    fun hideLoading() {
        activityRef.get()!!.progressBar.visibility = View.GONE
    }

    fun showCharacters(characters: List<Character>) {
        adapter.data = characters
    }

    fun showLoading() {
        activityRef.get()!!.progressBar.visibility = View.VISIBLE

    }
}
