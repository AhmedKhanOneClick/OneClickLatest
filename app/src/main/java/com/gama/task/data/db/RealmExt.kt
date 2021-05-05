package com.gama.saudi2go.data.db

import io.realm.*
import io.realm.kotlin.delete
import io.realm.kotlin.where

/**
 * make un-manged copy of managed realm object.
 */
fun <T : RealmModel> T?.copyFromRealm(realm: Realm) =
    if (this != null) realm.copyFromRealm(this) else null

/**
 * convert  realmResults to list
 */
fun <T : RealmModel> RealmResults<T>.copyFromRealm(realm: Realm) =
    realm.copyFromRealm(this)

/**
 * get the first item in the table of the entity [T] that match the [query] or null if no items found.
 *
 * @param query [@kotlin.ExtensionFunctionType] Function1<RealmQuery<T>, RealmQuery<T>>
 *     the query to be used to select item, default is no special query.
 * @return T? the first item that match the query or null if no  matching.
 */
inline fun <reified T : RealmModel> queryFirst(query: RealmQuery<T>.() -> RealmQuery<T> = { this }) =
    Realm.getDefaultInstance().use {
        query(it.where()).findFirst().copyFromRealm(it)
    }

/**
 * get all items in the table of the entity [T] that match the [query] .
 *
 * @param query [@kotlin.ExtensionFunctionType] Function1<RealmQuery<T>, RealmQuery<T>>
 *     the query to be used to select item, default is no special query.
 * @return List<(T..T?)> the list of items that match the query .
 */
inline fun <reified T : RealmModel> queryAll(query: RealmQuery<T>.() -> RealmQuery<T> = { this }) =
    Realm.getDefaultInstance().use {
        query(it.where()).findAll().copyFromRealm(it).toList()
    }


/**
 * delete the item from the db.
 */
inline fun <reified T : RealmModel> delete() =
    Realm.getDefaultInstance().use { it.executeTransaction { it.delete<T>() } }

/**
 * insert item into db.
 * @param `object` T the item to be inserted.
 */
inline fun <reified T : RealmModel> insertOrUpdate(`object`: T) = Realm.getDefaultInstance().use {
    it.executeTransaction { realm ->
        realm.insertOrUpdate(`object`)
    }
}



/**
 * convert collection to realm list
 *
 * @receiver Collection<T>
 * @return RealmList<(T..T?)>
 */
inline fun <reified T : RealmModel> Collection<T>.toRealmList() = RealmList(*toTypedArray())

