package com.gama.task.data.api

import androidx.lifecycle.LiveData
import com.gama.saudi2go.data.api.requests.LoginRequest
import com.gama.task.models.*
import com.gama.task.models.menumodel.profile.ProfileModel
import retrofit2.Call
import retrofit2.http.*

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
//    @POST("auth/login")
//    fun login(@Body hotelsSearchRequest: LoginRequest): LiveData<ApiResponse<GeneralResponse<UserAuth>>>
@FormUrlEncoded
@POST("auth/login")
fun login(@FieldMap body: Map<String, String>): LiveData<ApiResponse<UserAuth1>>
    @GET("productCategories?page=1&size=10")
    fun get_categories(@Query("lng") lng: String): LiveData<ApiResponse<Categories>>

    @GET("productCategories/{id}")
    fun get_subcategories(@Path("id") id: String): LiveData<ApiResponse<Subcategories>>
    @GET("products?page=1&size=10&sort=updatedAt,desc")
    fun getAllproducts(@Query("categoryId") id: String,@Query("lng") lng: String): LiveData<ApiResponse<Products>>


    @GET("users/me")
    fun getUserLoggedInProfile(@Header("Authorization")authHeader:String): Call<ProfileModel>

}