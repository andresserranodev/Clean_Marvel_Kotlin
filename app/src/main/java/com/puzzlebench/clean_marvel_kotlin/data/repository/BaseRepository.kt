package com.puzzlebench.clean_marvel_kotlin.data.repository

import com.puzzlebench.clean_marvel_kotlin.data.mapper.repository.BaseMapperRepository
import com.puzzlebench.clean_marvel_kotlin.data.repository.source.DataSource
import io.realm.RealmObject

abstract class BaseRepository<T, D : RealmObject>(private val dataSource: DataSource<D>, private val mapper: BaseMapperRepository<T, D>) {

    fun save(item: T) {
        dataSource.save(mapper.transform(item))
    }

    fun save(items: List<T>) {
        dataSource.save(items.map { mapper.transform(it) })
    }

    fun getAll(): List<T> = dataSource.getAll()?.map { mapper.transform(it) } ?: listOf()
}