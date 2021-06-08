package com.gama.saudi2go.data.db


import com.gama.task.models.UserAuth
import javax.inject.Inject

/**
 * Manage the [UserAuth] entity (table).
 */
class UserAuthDao @Inject constructor() {


    /**
     * insert an instance of user response into database.
     */
    fun insertOrUpdateUserAuth(userAuth: UserAuth) = insertOrUpdate(userAuth)


    /**
     * get the stored user from the db .
     * @return UserAuth the stored user
     */
    fun getUserAuth() = queryFirst<UserAuth>()


    /**
     * delete the user.
     */

    fun deleteUserAuth() = delete<UserAuth>()


    /**
     * get the user token
     */
    fun getUserToken() = getUserAuth()?.token

    //fun getUserId() = getUserId()?.id


    /**
     * get the user token type
     */
//    fun getUserTokenType() = getUserAuth()?.tokenType
    fun getUserTokenType() = "Bearer "
}