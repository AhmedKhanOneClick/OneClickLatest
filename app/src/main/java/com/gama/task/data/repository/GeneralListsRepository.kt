package com.gama.task.data.repository

import com.gama.task.data.api.ApiService
import com.gama.task.di.NormalRequest
import com.gama.task.models.*
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * Get Lookups data and manage its data sources.
 *
 * @property apiService [ApiService] the interface contains API end points.
 * @constructor create instance using dagger constructor injection.
 */
@ActivityScoped
class GeneralListsRepository @Inject constructor(@NormalRequest private val apiService: ApiService) {


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

    fun getAllCategoriesdata () =
        object : NetworkOnlyResource<Categories, Categories>() {
            override fun createCall() = apiService.get_categories()
        }.asLiveData()
}