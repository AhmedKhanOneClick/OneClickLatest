package com.gama.saudi2go.data.db


import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gama.saudi2go.TestUtil.createHotelCart
import com.gama.saudi2go.TestUtil.createRoom
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.hasSize
import org.hamcrest.Matchers.nullValue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HotelCartDaoTest : DbTest() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun insertHotelAndRead() = runBlocking {

        val hotelCart = createHotelCart()

        val id = db.hotelCartDao().insertHotel(hotelCart)

        val loaded = db.hotelCartDao().getHotelsWithRooms().getOrAwaitValue()

        assertThat(loaded, notNullValue())
        assertThat(loaded, hasSize(1))
        assertThat(loaded[0].hotelCart.id, `is`(id))
        assertThat(loaded[0].rooms, nullValue())
    }


    @Test
    fun insertHotelWithRoomsAndRead() = runBlocking {

        val hotelCart = createHotelCart()
        val rooms = listOf(createRoom(), createRoom(), createRoom())

        db.hotelCartDao().addHotelAndRooms(hotelCart, rooms)

        val loaded = db.hotelCartDao().getHotelsWithRooms().getOrAwaitValue()

        Log.d("hotelCart", Gson().toJson(loaded))

        assertThat(loaded, notNullValue())
        assertThat(loaded, hasSize(1))
        assertThat(loaded[0], notNullValue())
        assertThat(loaded[0].rooms, hasSize(3))
    }


}
