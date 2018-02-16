package com.puzzlebench.clean_marvel_kotlin.data.model

import io.realm.RealmObject


open class ThumbnailRealm(var path: String? = null, var extension: String? = null) : RealmObject()