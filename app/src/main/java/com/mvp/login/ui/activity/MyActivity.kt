package com.mvp.login.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mvp.login.R
import entity.User
import mvp.presenter.LoginPresenter
import mvp.view.LoginView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * 登录程序示例的Activity
 * 这里需要创建presenter对象，presenter对象中是有view对象和model对象的！
 */
class MyActivity : AppCompatActivity(), LoginView, OnClickListener {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    /**
     * 初始化数据
     */
    private fun initView() {
        btn_login.setOnClickListener(this)
        loginPresenter = LoginPresenter()
        //绑定View和Presenter，因为这个Activity已经实现了接口，已经包含了View对象
        loginPresenter.bind(this)
    }

    /**
     * 登录按钮的监听方法
     * 这里要做后台数据的处理，需要用到Presenter
     */
    override fun onClick(v: View) {
        if (v.id == R.id.btn_login) {
            loginPresenter.login()
        }
    }

    /**
     * 下面五个方法都是实现LoginView后要是实现的方法
     */
    override fun getAccount(): String {
        return et_name.text.toString()
    }

    override fun getPassword(): String {
        return et_password.text.toString()
    }

    override fun loginSuccess(user: User) {
        //登录成功后，一般是实现页面的跳转
        Toast.makeText(this@MyActivity, user.name + "登录成功", Toast.LENGTH_SHORT).show();
        //页面跳转
        val intent = Intent(this@MyActivity, UserInfoActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    override fun showNetworkError() {
        Toast.makeText(this, "当前网络不可用", Toast.LENGTH_SHORT).show()
    }

    override fun showVerifyFailed() {
        Toast.makeText(this, "输入的用户名或密码有误", Toast.LENGTH_SHORT).show()
    }
}