package com.puzzlebench.cmk.data.model

import io.realm.RealmObject


open class ThumbnailRealm(var path: String? = null, var extension: String? = null) : RealmObject()