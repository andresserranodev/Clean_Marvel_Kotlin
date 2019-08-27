package com.puzzlebench.cmk.data.cache.realm

import com.puzzlebench.cmk.data.model.CharacterRealm
import com.puzzlebench.cmk.data.cache.CharacterDataSource
import io.realm.Realm
import javax.inject.Inject


class CharacterDataSourceImpl @Inject constructor() : DataSource<CharacterRealm>(CharacterRealm::class.java), CharacterDataSource {

    override fun saveCharacters(c: List<CharacterRealm>) {
        this.save(c)
    }

    override fun getAllCharacters(): List<CharacterRealm> {
        var allCharacters: List<CharacterRealm> = arrayListOf()
        Realm.getDefaultInstance().use { realm ->
            val result = realm.where(CharacterRealm::class.java).findAll()
            result.let {
                allCharacters = realm.copyFromRealm(it)
            }
        }
        return allCharacters

    }

}