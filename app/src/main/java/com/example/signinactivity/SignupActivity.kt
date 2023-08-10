package com.example.signinactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val edtName = findViewById<EditText>(R.id.edt_name)
        val edtId = findViewById<EditText>(R.id.edt_id2)
        val edtPw = findViewById<EditText>(R.id.edt_pw2)
        val signupButton2 = findViewById<Button>(R.id.btn_signup2)

        signupButton2.setOnClickListener {
            val name = edtName.text.toString()
            val id = edtId.text.toString()
            val pw = edtPw.text.toString()

            if (name.isBlank() || id.isBlank() || pw.isBlank()) {
                showToast("입력되지 않은 정보가 있습니다.")
            } else {
                val intent = Intent()
                intent.putExtra("id", id)
                intent.putExtra("pw", pw)
                setResult(RESULT_OK, intent)
                showToast("회원가입 성공")
                finish()
            }
        }
    }
        private fun showToast(message: String) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}