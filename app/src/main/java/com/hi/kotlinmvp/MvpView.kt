package com.hi.kotlinmvp

/**
 * Created by Vishal Patel on 05/12/19.
 */
interface MvpView {
    /**
     * Override to show loader for long running task
     */

    fun showLoader()

    /**
     * Override to hide loader of long running task
     */
    fun hideLoader()

    /**
     * override to show error message when internet connection is not available
     */
    fun noInternetConnection()

    /**
     * To show api error messages. This will be called mostly from onApiError of Presenter class
     *
     * @param aError error message to show user
     */
    fun apiError(aApiCode: Int, aError: String)

}
