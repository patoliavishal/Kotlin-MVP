package com.hi.kotlinmvp.user

import com.hi.kotlinmvp.TheGithubUser
import com.hi.kotlinmvp.user.model.UserResponse
import com.hi.kotlinmvp.network.RestApiCallback
import com.hi.kotlinmvp.utils.NetworkUtils
import com.hi.kotlinmvp.utils.USER_API
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Vishal Patel on 05/12/19.
 */
class UserPresenter constructor(var mUserView: UserView?) : UserUsecase, RestApiCallback<Any, Any> {

    /**
     * Github User List
     */
    override fun userList(compositeDisposable: CompositeDisposable) {
        if (NetworkUtils.isNetworkAvailable(TheGithubUser.app)) {
            mUserView?.showLoader()
            TheGithubUser.getRestApis().doUserList(this, compositeDisposable)
        } else {
            mUserView?.hideLoader()
            mUserView?.noInternetConnection()
        }
    }

    override fun onDestroy() {
        mUserView = null
    }

    override fun onSuccess(aApiCode: Int, aSuccessResponse: Any) {
        mUserView?.hideLoader()
        when (aApiCode) {
            USER_API -> mUserView?.onUserListSuccess(aSuccessResponse as ArrayList<UserResponse>)
        }
    }

    override fun onApiError(aApiCode: Int, aFailureResponse: Any) {
        mUserView?.hideLoader()
        when (aApiCode) {
            USER_API -> mUserView?.apiError(aApiCode, aFailureResponse.toString())
        }
    }
}
