package com.puzzlebench.clean_marvel_kotlin.data.mapper.repository

import io.realm.RealmObject

interface BaseMapperRepository<I, O : RealmObject> {

    fun transform(input: I): O

    fun transform(input: O): I
}