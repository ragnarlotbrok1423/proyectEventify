//package com.dev.eventify.data.models
//
//import android.annotation.SuppressLint
//import com.google.firebase.firestore.auth.User
//import java.sql.Connection
//
//class UserModel {
//    @SuppressLint("RestrictedApi")
//    fun getAllUsers(connection: Connection): List<User> {
//        val sql = "SELECT * FROM User"
//        val statement = connection.createStatement()
//        val resultSet = statement.executeQuery(sql)
//
//        val users = ArrayList<User>()
//
//        while (resultSet.next()) {
//            val id = resultSet.getInt("UserId")
//            val name = resultSet.getString("UserTypeCd")
//            val email = resultSet.getString("NickName")
//
//
//            val user = User(id, name, email)
//            users.add(user)
//        }
//
//        return users
//    }
//}