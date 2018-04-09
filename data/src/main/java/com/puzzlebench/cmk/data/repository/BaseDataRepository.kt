package com.puzzlebench.cmk.data.repository

import com.puzzlebench.cmk.data.mapper.repository.BaseMapperRepository
import com.puzzlebench.cmk.data.repository.source.DataSource
import io.realm.RealmObject

abstract class BaseDataRepository<T, D : RealmObject>(private val dataSource: DataSource<D>, private val mapper: BaseMapperRepository<T, D>) {

    fun save(item: T) {
        dataSource.save(mapper.transform(item))
    }

    fun save(items: List<T>) {
        dataSource.save(items.map { mapper.transform(it) })
    }

    fun getAll(): List<T> = dataSource.getAll()?.map { mapper.transform(it) } ?: listOf()
}