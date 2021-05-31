package com.gama.task.data.repository


import com.gama.saudi2go.data.db.UserAuthDao
import com.gama.saudi2go.data.db.insertOrUpdate

import com.gama.task.data.api.ApiService
import com.gama.task.data.db.FavouriteDao
import com.gama.task.di.IdentityRequest
import com.gama.task.models.*
import dagger.hilt.android.scopes.ActivityScoped
import io.realm.Realm
import javax.inject.Inject

/**
 * A repository class that works as data provider for auth
 *
 * @property apiService [ApiService] the interface contains API end points
 * @property userAuthDao [UserAuthDao] the db dao that manage the [UserAuth] entity
 * @constructor create instance using dagger constructor injection
 */
@ActivityScoped
class AuthRepository @Inject constructor(
    @IdentityRequest private val apiService: ApiService,
     private val favouritedao: FavouriteDao,
    private val userAuthDao: UserAuthDao
) {

    /**
     * perform login request and store response in db when success and return db data
     *
     * @param email String the email that user entered
     * @param password String the password that user entered
     * @return LiveData<Resource<UserAuth>> the stored user in db wrapped in [Resource] to handle status
     */
    fun login(email: String, password: String) =
        object : NetworkOnlyResource<UserAuth1, UserAuth1>() {
            override fun createCall() = apiService.login(
                mapOf(


                    "email" to email,
                    "password" to password,
                    "type" to "admin"
//                    "latitude" to 34534534,
//                    "longitude" to 5645,
//                    "deviceId" to "abc"
                )
            )
        }.asLiveData()

    /**
     * insert an instance of user response into database.
     */
    fun insertUserAuth(userAuth: UserAuth) = userAuthDao.insertOrUpdateUserAuth(userAuth)
    fun insertOrUpdatefAVOURITE(content: Content) = favouritedao.insertFavourite(content)
    fun deletefavourite(content: Content) = favouritedao.deleteHotel(content)
    fun getAllFavourites() = favouritedao.getHotels()
    /**
     * Get stored user in db
     */
    fun getRegisteredUser() = userAuthDao.getUserAuth()


    /**
     * perform register api request.
     *
     * @param registerRequest [RegisterRequest]
     * @return LiveData<Resource<IdentifyGeneralResponse>> response of api wrapped in liveData of Resource
     */
//    fun register(registerRequest: RegisterRequest) =
//        object : NetworkOnlyResource<IdentityGeneralResponse, IdentityGeneralResponse>() {
//            override fun createCall() = apiService.register(registerRequest)
//        }.asLiveData()

    /**
     * perform send forget pass api request.
     *
     * @param email String email entered by user
     * @return LiveData<Resource<IdentifyGeneralResponse>> response of api wrapped in liveData of Resource
     */
//    fun sendForgetPassCode(email: String) =
//        object : NetworkOnlyResource<IdentityGeneralResponse, IdentityGeneralResponse>() {
//            override fun createCall() = apiService.forgetPassword(mapOf("Email" to email))
//        }.asLiveData()

    /**
     * perform reset password api request.
     *
     * @param email String the email entered by user
     * @param newPass String the new password entered by user
     * @param code String the code that's send to user's email and user entered it
     * @return LiveData<Resource<IdentifyGeneralResponse>>
     */
//    fun resetPass(email: String, newPass: String, code: String) =
//        object : NetworkOnlyResource<IdentityGeneralResponse, IdentityGeneralResponse>() {
//            override fun createCall() =
//                apiService.resetPassword(
//                    mapOf(
//                        "Email" to email,
//                        "Password" to newPass,
//                        "Token" to code
//                    )
//                )
//        }.asLiveData()

    /**
     * logout user and delete all db.
     */
    fun logout() {
        Realm.getDefaultInstance().use { it.executeTransaction { it.deleteAll() } }
    }

    /**
     * Get the user token stored in db
     */
    fun getUserToken() = userAuthDao.getUserToken()

    fun getAllCategoriesdata () =
        object : NetworkOnlyResource<Categories, Categories>() {
            override fun createCall() = apiService.get_categories("en")
        }.asLiveData()
}