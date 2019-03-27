package com.puzzlebench.cmk.data.service.response

import com.google.gson.annotations.SerializedName

class DataBaseResponse<T>(
        val offset: Int,
        val limit: Int,
        val total: Int,
        @SerializedName("results") val result: List<T>
)