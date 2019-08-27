package com.puzzlebench.cmk.data.cache.realm

import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmObject

abstract class DataSource<T : RealmObject>(private val clazz: Class<T>) {

    fun save(item: T, realm: Realm? = null) {
        if (realm == null) {
            Realm.getDefaultInstance().use { realmInstance ->
                realmInstance.executeTransaction {
                    realmInstance.insertOrUpdate(item)
                }
            }
        } else {
            realm.insertOrUpdate(item)
        }
    }

    fun save(items: List<T>, realm: Realm = Realm.getDefaultInstance()) {
        realm.use { realmInstance ->
            realmInstance.executeTransaction {
                items.map { save(it, realm) }
            }
        }
    }

    fun getAll(realm: Realm = Realm.getDefaultInstance()): MutableList<T>? {
        return realm.copyFromRealm(realm.where(clazz).findAll())
    }

    fun Realm.executeAsync(transaction: (Realm) -> Unit): Single<Boolean> {
        return Single.create<Boolean> { emitter ->
            executeTransactionAsync(transaction, {
                emitter.onSuccess(true)
            }, {
                emitter.onError(it)
            })
        }
    }
}