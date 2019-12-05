package com.hi.kotlinmvp.network

import com.hi.kotlinmvp.user.model.UserResponse
import com.hi.kotlinmvp.utils.USER_API
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Vishal Patel on 05/12/19.
 */
class RestApisImpl {

    private var mRestApis: RestApis = RetrofitClientFactory.get()

    /**
     * Repository List
     *
     * @param aApiCallback
     */
    fun doUserList(aApiCallback: RestApiCallback<Any, Any>, compositeDisposable: CompositeDisposable) {

        compositeDisposable.add(mRestApis.requestUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    aApiCallback.onSuccess(USER_API, it as List<UserResponse>)
                }, {
                    aApiCallback.onApiError(USER_API, it.message.toString())
                }))
    }
}