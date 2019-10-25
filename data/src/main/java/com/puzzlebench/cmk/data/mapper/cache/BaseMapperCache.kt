package com.puzzlebench.cmk.data.mapper.cache

import io.realm.RealmObject

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <C> the cached model input type
 * @param <D> the domain model input type
 * */
interface BaseMapperCache<D, C : RealmObject> {

    fun transform(input: D): C

    fun transform(input: C): D
}