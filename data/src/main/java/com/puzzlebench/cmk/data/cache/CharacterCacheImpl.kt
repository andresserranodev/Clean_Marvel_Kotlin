package com.puzzlebench.cmk.data.cache

import com.puzzlebench.cmk.data.mapper.cache.CharacterMapperCache
import com.puzzlebench.cmk.domain.model.Character
import com.puzzlebench.cmk.domain.cache.CharacterCache
import io.reactivex.Completable
import javax.inject.Inject


class CharacterCacheImpl @Inject constructor(private val dataSource: CharacterDataSource,
                                             private val mapper: CharacterMapperCache)
    : CharacterCache {

    override fun save(c: List<Character>): Completable {
        return Completable.fromAction {
            dataSource.saveCharacters(c.map { mapper.transform(it) })
        }
    }

    override fun getAll(): List<Character> {
        return dataSource.getAllCharacters().map { mapper.transform(it) }
    }

}
