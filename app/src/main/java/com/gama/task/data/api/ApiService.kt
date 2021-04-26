package com.gama.task.data.api

import androidx.lifecycle.LiveData

import com.gama.task.models.Accounts
import com.gama.task.models.Budgets
import com.gama.task.models.GeneralResponse
import com.gama.task.models.InsertAccounts
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * All end points for the app.
 */
interface ApiService {


    @GET("budgets/2166dd29-d00c-46b5-a272-89ddaf999dee/accounts")
    fun getAllaccounts(): LiveData<ApiResponse<GeneralResponse<Accounts>>>

    @GET("budgets?include_accounts=true")
    fun getAllbudgets(): LiveData<ApiResponse<GeneralResponse<Budgets>>>

    @POST("budgets/31594a4c-a709-4467-b83b-1dad94faf7fe/accounts")
    fun insertaccount(@Body account: InsertAccounts): LiveData<ApiResponse<GeneralResponse<Any>>>


}