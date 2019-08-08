package com.puzzlebench.clean_marvel_kotlin.presentation.extension

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.widget.Toast

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()
