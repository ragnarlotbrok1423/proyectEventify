package com.dev.eventify.data.connections

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectionMysql {


    fun connectToDatabase(): Connection? {
        val url = "jdbc:mysql://localhost:3306/eventify"
        val user = "root"
//        tu contrasena
        val password = "030318"

        return try {
            DriverManager.getConnection(url, user, password)
        } catch (e: SQLException) {
            null
        }
    }
}