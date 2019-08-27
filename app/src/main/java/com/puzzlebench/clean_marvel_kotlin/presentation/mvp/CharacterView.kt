package com.puzzlebench.clean_marvel_kotlin.presentation.mvp

import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.puzzlebench.clean_marvel_kotlin.R
import com.puzzlebench.clean_marvel_kotlin.presentation.android.MainActivity
import com.puzzlebench.clean_marvel_kotlin.presentation.adapter.CharacterAdapter
import com.puzzlebench.clean_marvel_kotlin.presentation.extension.showToast
import com.puzzlebench.cmk.domain.model.Character
import kotlinx.android.synthetic.main.activity_main.progressBar
import kotlinx.android.synthetic.main.activity_main.recycleView
import java.lang.ref.WeakReference
import javax.inject.Inject

class CharacterView @Inject constructor(private val activity: MainActivity) : CharacterContract.View {


    private val activityRef = WeakReference(activity)
    private val SPAN_COUNT = 1
    private var adapter = CharacterAdapter { character -> activity.applicationContext.showToast(character.name) }

    override fun initView() {
        val activity = activityRef.get()
        activity?.let {
            it.recycleView.layoutManager = GridLayoutManager(it, SPAN_COUNT)
            it.recycleView.adapter = adapter
            showLoading()
        }
    }

    override fun showLoading() {
        activityRef.get()!!.progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        activityRef.get()!!.progressBar.visibility = View.GONE
    }

    override fun showMessageNoItemToShow() {
        activityRef.get()?.let {
            val message = it.baseContext.resources.getString(R.string.message_no_items_to_show)
            it.applicationContext.showToast(message)
        }
    }

    override fun showNetworkError(error: String) {
        activityRef.get()!!.applicationContext.showToast(error)
    }

    override fun showCharacters(characters: List<Character>) {
        adapter.data = characters
    }
}