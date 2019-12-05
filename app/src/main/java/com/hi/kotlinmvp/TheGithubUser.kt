package com.hi.kotlinmvp

import android.app.Application

import com.hi.kotlinmvp.network.RestApisImpl

/**
 * Created by Vishal Patel on 05/12/19.
 */
class TheGithubUser : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
        restApi = RestApisImpl()
    }

    companion object {
        lateinit var app: TheGithubUser
        lateinit var restApi: RestApisImpl

        /**
         * To get singleton instance of [TheGithubUser]
         *
         * @return ModelApp instance
         */
        fun getAppInstance(): TheGithubUser {
            return app
        }

        fun getRestApis(): RestApisImpl {
            return restApi
        }
    }
}