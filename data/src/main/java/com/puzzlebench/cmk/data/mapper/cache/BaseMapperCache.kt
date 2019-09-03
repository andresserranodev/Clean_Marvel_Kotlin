package com.puzzlebench.cmk.data.mapper.cache

import io.realm.RealmObject

interface BaseMapperCache<I, O : RealmObject> {

    fun transform(input: I): O

    fun transform(input: O): I
}