package com.example.signinactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {
    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.btn_login)
        val signupButton = findViewById<Button>(R.id.btn_signup)
        val editTextId = findViewById<EditText>(R.id.edt_id)
        val editTextPw = findViewById<EditText>(R.id.edt_pw)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK){
                val user_id = it.data?.getStringExtra("id") ?: ""
                val user_pw = it.data?.getStringExtra("pw") ?: ""
                editTextId.setText(user_id)
                editTextPw.setText(user_pw)

            }

        }

        loginButton.setOnClickListener {
            val id = editTextId.text.toString().trim()
            val pw = editTextPw.text.toString().trim()

            if (id.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("name", "김지견")
                    intent.putExtra("id", id)
                    startActivity(intent)
                }
            }
        signupButton.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            activityResultLauncher.launch(intent)
        }
    }
}
