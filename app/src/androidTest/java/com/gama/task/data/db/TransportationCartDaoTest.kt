package com.gama.saudi2go.data.db


import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.gama.saudi2go.TestUtil.createTransportationCompanyCart
import com.gama.saudi2go.TestUtil.createVehicle
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
class TransportationCartDaoTest : DbTest() {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun insertCompanyAndRead() = runBlocking {

        val transportationCompanyCart = createTransportationCompanyCart()

        val id = db.transportationCartDao().insertCompany(transportationCompanyCart)

        val loaded = db.transportationCartDao().getCompanyWithVehicles().getOrAwaitValue()

        assertThat(loaded, notNullValue())
        assertThat(loaded, hasSize(1))
        assertThat(loaded[0].transportationItem.id, `is`(id))
        assertThat(loaded[0].vehicles, nullValue())
    }


    @Test
    fun insertHotelWithRoomsAndRead() = runBlocking {

        val companyCart = createTransportationCompanyCart()
        val vehicles = listOf(createVehicle(), createVehicle(), createVehicle())

        db.transportationCartDao().addCompanyAndVehicles(companyCart, vehicles)

        val loaded = db.transportationCartDao().getCompanyWithVehicles().getOrAwaitValue()

        Log.d("companyCart", Gson().toJson(loaded))

        assertThat(loaded, notNullValue())
        assertThat(loaded, hasSize(1))
        assertThat(loaded[0], notNullValue())
        assertThat(loaded[0].vehicles, hasSize(3))
    }


}
