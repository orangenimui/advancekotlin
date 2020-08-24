package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

class MainActivity: AppCompatActivity(), View.OnClickListener{

    private val usernameKey:String = "username"
    private val passwordKey:String = "password"

    private lateinit var et_username:EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)

        val button = findViewById<Button>(R.id.btn_login)
        val image_code = findViewById<CodeView>(R.id.code_view)

        button.setOnClickListener(this)
        image_code.setOnClickListener(this)
    }

    private fun login(){
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()
        val user = User(username, password, code)
        if(verify(user)){
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }


    override fun onClick(view: View?) {
        if(view is Button){
            login()
        }else if(view is CodeView){
            view.updateCode()
        }
    }

    private fun verify(user: User): Boolean{
        if(user.username != null && user.username!!.length < 4){
            Utils.toast("用户名不合法")
            return false
        }

        if(user.password != null && user.password!!.length < 4){
            Utils.toast("用户名不合法")
            return false
        }
        return true
    }


}