package com.hi.kotlinmvp.user

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Vishal Patel on 05/12/19.
 */
interface UserUsecase {

    fun userList(compositeDisposable: CompositeDisposable)

    fun onDestroy()
}
