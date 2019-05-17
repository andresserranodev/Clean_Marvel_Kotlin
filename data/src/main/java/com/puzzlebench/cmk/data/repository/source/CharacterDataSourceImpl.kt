package com.puzzlebench.cmk.data.repository.source

import com.puzzlebench.cmk.data.model.CharacterRealm
import io.realm.Realm


class CharacterDataSourceImpl : DataSource<CharacterRealm>(CharacterRealm::class.java), CharacterDataSource {

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