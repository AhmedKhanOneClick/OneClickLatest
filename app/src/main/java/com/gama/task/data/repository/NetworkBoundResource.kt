/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gama.task.data.repository

import androidx.annotation.MainThread
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.gama.task.data.api.*
import com.gama.task.models.GeneralResponse
import com.gama.task.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


/**
 * A generic class that can provide a resource from the network.
 *
 *
 * @param <ResultType>
 * @param <RequestType>
</RequestType></ResultType> */
abstract class NetworkOnlyResource<ResultType, RequestType> {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.loading(null)
        fetchFromNetwork()
    }

    @MainThread
    private fun setValue(newValue: Resource<ResultType>) {
        if (result.value != newValue) {
            result.value = newValue
        }
    }

    private fun fetchFromNetwork() {
        val apiResponse = createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            when (response) {
                is ApiSuccessResponse -> {
                    GlobalScope.launch(Dispatchers.Main) {
                        setValue(Resource.success(processResponse(response)))
                    }
                }
                is ApiEmptyResponse -> {
                    GlobalScope.launch(Dispatchers.Main) {
                        setValue(Resource.error("empty body"))
                    }
                }
                is ApiErrorResponse -> {
                    GlobalScope.launch(Dispatchers.Main) {
                        setValue(Resource.error(response.errorMessage, response.responseCode))
                    }
                }
                is ApiFailureResponse -> {
                    GlobalScope.launch(Dispatchers.Main) {
                        setValue(Resource.error(null))
                    }
                }
            }
        }
    }


    fun asLiveData() = result as LiveData<Resource<ResultType>>

    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>

    @WorkerThread
    protected open fun processResponse(response: ApiSuccessResponse<RequestType>): ResultType? {
        return if (response.body is GeneralResponse<*>)
            (response.body.data as ResultType?)
        else
            response.body as ResultType
    }
}

