package com.mvp.login.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import entity.User

/**
 * 用户信息页面
 */
class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val user = intent.getSerializableExtra("user") as User
        val textView = TextView(this@UserInfoActivity)

        textView.append("账号:${user.name}")
        textView.append("\n")
        textView.append("密码:${user.password}")

        setContentView(textView)
    }
}