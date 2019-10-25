package com.puzzlebench.cmk.data.mapper.service

/**
 * Interface for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer data source layers
 *
 * @param <S> the service model input type
 * @param <D> the domain model input type
 * */
interface BaseMapperService<S, D> {

    fun transform(type: S): D

    fun transformToResponse(type: D): S
}