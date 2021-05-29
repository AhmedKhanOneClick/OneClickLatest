package com.gama.task.data.db

import com.gama.saudi2go.data.db.delete
import com.gama.saudi2go.data.db.insertOrUpdate
import com.gama.saudi2go.data.db.queryAll
import com.gama.task.models.Content

import io.realm.Realm
import io.realm.kotlin.deleteFromRealm
import javax.inject.Inject

/**
 * Manage the [HotelCart] and [RoomCart] entities (tables).
 */
class FavouriteDao @Inject constructor() {

    /**
     *  insert hotel
     *
     * @param hotel HotelCart hotel to insert
     */
    fun insertFavourite(content: Content) = insertOrUpdate(content)


    /**
     * get the list of hotels stored in db.
     *
     * @return List<HotelCartWithRooms> the list of hotels
     */
    fun getHotels() = queryAll<Content>()


    /**
     * delete a hotel from db
     * @param hotel HotelCart the hotel to delete
     */
    fun deleteHotel(content: Content) = content.deleteFromRealm()


    /**
     * delete all hotels from db
     */
    fun deleteAllHotels() = delete<Content>()


    /**
     * get the hotel by its gdsResponse and code then select room by its id and  delete it,
     * also delete hotel if it was the only room in this hotel
     * @param gdsResponse String hotel gdsResponse.
     * @param hotelCode String hotel code.
     * @param roomId String id of room to delete.
     * */


}