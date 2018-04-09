package com.puzzlebench.cmk.data.mapper.service

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <T> the cached model input type
 * @param <T> the remote model input type
 * @param <V> the model return type
 */
interface BaseMapperService<E, D> {

    fun transform(type: E): D

    fun transformToResponse(type: D): E

}