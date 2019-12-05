package com.hi.kotlinmvp.network

/**
 * Created by Vishal Patel on 05/12/19.
 */
interface RestApiCallback<T, U> {

    fun onSuccess(aApiCode: Int, aSuccessResponse: T)

    fun onApiError(aApiCode: Int, aFailureResponse: T)

}