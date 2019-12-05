package com.hi.kotlinmvp.user

import com.hi.kotlinmvp.MvpView
import com.hi.kotlinmvp.user.model.UserResponse

/**
 * Created by Vishal Patel on 05/12/19.
 */
interface UserView : MvpView {

    fun onUserListSuccess(aUserResponse: ArrayList<UserResponse>)
}
