package com.gama.task.data.repository

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.task.data.api.ApiService
import com.gama.task.data.db.FavouriteDao
import com.gama.task.di.NormalRequest
import com.gama.task.models.*
import com.google.gson.Gson
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


/**
 * Get Lookups data and manage its data sources.
 *
 * @property apiService [ApiService] the interface contains API end points.
 * @constructor create instance using dagger constructor injection.
 */
@ActivityScoped
class GeneralListsRepository @Inject constructor(
    @NormalRequest private val apiService: ApiService, private val favouritedao: FavouriteDao,
    private val userAuthDao: UserAuthDao
) {


    fun getAllAccounts() =
        object : NetworkOnlyResource<Accounts, GeneralResponse<Accounts>>() {
            override fun createCall() = apiService.getAllaccounts()
        }.asLiveData()

    fun getAllBudgets() =
        object : NetworkOnlyResource<Budgets, GeneralResponse<Budgets>>() {
            override fun createCall() = apiService.getAllbudgets()
        }.asLiveData()

    fun inserAccount(account: InsertAccounts) =
        object : NetworkOnlyResource<Any, GeneralResponse<Any>>() {
            override fun createCall() = apiService.insertaccount(account)
        }.asLiveData()

    fun getAllCategoriesdata (lng: String) =
        object : NetworkOnlyResource<Categories, Categories>() {
            override fun createCall() = apiService.get_categories(lng)
        }.asLiveData()
    fun getAllSubCategoriesdata(id: String,lng:String) =
        object : NetworkOnlyResource<Subcategories, Subcategories>() {
            override fun createCall() = apiService.get_subcategories(id,lng)
        }.asLiveData()
    fun getAllProducts(id: String,lng:String) =
        object : NetworkOnlyResource<Products, Products>() {
            override fun createCall() = apiService.getAllproducts(id,lng)
        }.asLiveData()
    fun getAllOrdersdata (lng: String) =
        object : NetworkOnlyResource<Orders, Orders>() {
            override fun createCall() = apiService.get_orders()
        }.asLiveData()
    fun insertOrUpdatefAVOURITE(content: Content) {
//        var mPrefs: SharedPreferences = getPreferences(MODE_PRIVATE)
        favouritedao.insertFavourite(content)
//        val appSharedPrefs = PreferenceManager
//            .getDefaultSharedPreferences(this.applicationContext)
//        val prefsEditor = appSharedPrefs.edit()
//        val gson = Gson()
//        val json = gson.toJson(obj)
//        prefsEditor.putString("MyObject", json)
//        prefsEditor.commit()
    }

    fun deletefavourite(content: Content) = favouritedao.deleteHotel(content)
    fun getAllFavourites() = favouritedao.getHotels()
    fun createOrder(changepass: Order) =
        object : NetworkOnlyResource<Any, GeneralResponse<Any>>() {
            override fun createCall() = apiService.createorder(changepass)
        }.asLiveData()
    fun getAllDetails(orderId: String) =
        object : NetworkOnlyResource<OrdersDetails, OrdersDetails>() {
            override fun createCall() = apiService.getAllDetails(orderId)
        }.asLiveData()
}