package entity

import java.io.Serializable

class User(var name: String, var password: String) : Serializable {
    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}