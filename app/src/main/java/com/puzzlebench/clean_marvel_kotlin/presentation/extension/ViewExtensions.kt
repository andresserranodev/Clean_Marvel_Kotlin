package com.puzzlebench.clean_marvel_kotlin.presentation.extension

import android.support.annotation.IdRes
import android.support.v7.widget.RecyclerView
import android.view.View

//TODO this only to show a  reified function extencion.
inline fun <reified T : View> View.findTypeById(@IdRes idRes: Int): T {
    return findViewById(idRes) as T
}

inline fun <reified T : View> RecyclerView.ViewHolder.findTypeById(@IdRes idRes: Int): T = itemView.findTypeById(idRes)


