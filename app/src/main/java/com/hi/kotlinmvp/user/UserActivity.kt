package com.hi.kotlinmvp.user

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

import com.hi.kotlinmvp.R
import com.hi.kotlinmvp.user.model.UserResponse
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_user_list.*

/**
 * Created by Vishal Patel on 05/12/19.
 */
class UserActivity : AppCompatActivity(), UserView {

    private lateinit var compositeDisposable: CompositeDisposable
    private var mLoginPresenter: UserPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        compositeDisposable = CompositeDisposable()
        mLoginPresenter = UserPresenter(this)
        mLoginPresenter!!.userList(compositeDisposable)
    }

    override fun onUserListSuccess(aUserResponse: ArrayList<UserResponse>) {
        if (aUserResponse.isNotEmpty()) {
            rvUserList.adapter = UserAdapter(this, aUserResponse)
        } else {
            Toast.makeText(this, "No data found...!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showLoader() {
        skLoaderView.visibility = VISIBLE
    }

    override fun hideLoader() {
        skLoaderView.visibility = GONE
    }

    override fun noInternetConnection() {
        Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show()
    }

    override fun apiError(aApiCode: Int, aError: String) {
        Toast.makeText(this, aError, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
