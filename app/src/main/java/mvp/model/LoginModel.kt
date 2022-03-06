package mvp.model

import entity.User

/**
 * MVP中的model数据处理类
 * 这里处理登录时的数据
 */
class LoginModel {
    /**
     * 处理登录业务并返回结果
     */
    fun login(name: String, password: String, onLoginResultListener: OnLoginResultListener) {
        //一般登录都是请求服务器，验证
        //这里就简单一点，大家别介意
        if ("liwen" == name && "123456" == password) {
            onLoginResultListener.loginSuccess(User(name, password)) //登录成功,给他返回用户对象
        } else {
            onLoginResultListener.loginFailure() //登录失败
        }
    }

    //回调接口
    interface OnLoginResultListener {
        fun loginSuccess(user: User) //登录成功后回调的方法，返回User对象
        fun loginFailure() //登录失败后回掉的方法
    }
}