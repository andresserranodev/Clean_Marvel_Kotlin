package com.puzzlebench.cmk.data.mapper.repository

import io.realm.RealmObject

interface BaseMapperRepository<I, O : RealmObject> {

    fun transform(input: I): O

    fun transform(input: O): I
}