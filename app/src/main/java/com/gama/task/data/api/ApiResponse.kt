package com.gama.task.data.api

import com.gama.task.models.GeneralResponse

import retrofit2.Callback
import retrofit2.Response

/**
 * Common class used by API responses.
 * @param <T> the type of the response object
</T> */
@Suppress("unused") // T is used in extending classes
sealed class ApiResponse<T> {
    companion object {

        private val TAG = "okhttp"

        /**
         * create a failure class with a [Throwable]'s msg.
         * called from retrofit's [Callback.onFailure]
         *
         * @param error Throwable the exception
         * @return ApiFailureResponse<T> a class that handle that represent a networking failure
         */
        fun <T> create(error: Throwable): ApiFailureResponse<T> {
            return ApiFailureResponse(error.message)
        }

        /**
         * create and return one of:
         *  - [ApiEmptyResponse] if the response is 204 or the response body is null.
         *  - [ApiErrorResponse] if [response.isSuccessful] is false
         *   or if [response.isSuccessful] is true and body is [IdentityGeneralResponse] with success == false
         *   or if [response.isSuccessful] is true and body is [GeneralResponse] with isSuccess == false.
         *  - [ApiSuccessResponse] otherwise
         *
         * called from retrofit's [Callback.onResponse]
         *
         * @param response Response<T> the response to be handled
         * @return ApiResponse<T> the created [ApiResponse]
         */
        fun <T> create(response: Response<T>): ApiResponse<T> {
            return if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    ApiEmptyResponse()
                }
//                else if (body is IdentityGeneralResponse && body.success == false) {
//                    val errorMsg = when {
//                        body.errorMessage != null -> body.errorMessage
//                        body.errors != null && body.errors.isNotEmpty() -> body.errors[0]
//                        else -> null
//                    }
//
//                    ApiErrorResponse(errorMsg, response.code())
//                }
                else {
                    ApiSuccessResponse(
                        body = body,
//                        headers = response.headers()
                    )
                }
            } else {
                ApiErrorResponse(null, response.code())
            }
        }
    }
}

/**
 * separate class for HTTP 204 responses.
 *
 *  @param T the type of response body in case of success
 */
class ApiEmptyResponse<T> : ApiResponse<T>()

/**
 * class for successful api request
 *
 * @param T the type of response body in case of success
 *
 * @property body T? the response body
 * @property headers Headers the response headers
 *
 */
data class ApiSuccessResponse<T>(
    val body: T?,
//    val headers: Headers

) : ApiResponse<T>()

/**
 * class for error api request
 *
 * @param T the type of response body in case of success
 *
 * @property errorMessage String? the error msg to displayed or null if unknown error
 * @property responseCode Int the response code of the error
 *
 */
data class ApiErrorResponse<T>(val errorMessage: String?, val responseCode: Int) : ApiResponse<T>()

/**
 * class for error api failure
 *
 * @param T the type of response body in case of success
 *
 * @property errorMessage String? the error msg to displayed or null if unknown error
 */
data class ApiFailureResponse<T>(val errorMessage: String?) : ApiResponse<T>()

