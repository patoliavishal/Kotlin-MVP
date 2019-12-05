package com.hi.kotlinmvp.network

import com.hi.kotlinmvp.user.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by Vishal Patel on 05/12/19.
 */
interface RestApis {

    /**
     * User List
     *
     * @return Github User List
     */
    @GET("users")
    fun requestUser(): Observable<List<UserResponse>>

}
