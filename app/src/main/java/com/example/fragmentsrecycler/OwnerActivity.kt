package com.example.fragmentsrecycler

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class OwnerActivity:AppCompatActivity() {
    var t: EditText? =
        null
    var t2:EditText? = null
    var t3:EditText? = null
    var t4:EditText? = null
    var t5:EditText? = null
    var t6: TextInputEditText? = null
    var t7:TextInputEditText? = null
    var s_btn: Button? = null
    var s: String? =
        null
    var s1:kotlin.String? = null
    var s2:kotlin.String? = null
    var s3:kotlin.String? = null
    var s4:kotlin.String? = null
    var s5:kotlin.String? = null
    var s6:kotlin.String? = null
    var Login_members: LoginBase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ownersignin)
        t = findViewById<View>(R.id.PersonName_renter) as EditText
        //  s=t.getText().toString();
        t2 = findViewById<View>(R.id.editTextTextPassword) as EditText
        // s1=t2.getText().toString();
        t3 = findViewById<View>(R.id.editTextTextPersonName2) as EditText
        //  s2=t3.getText().toString();
        t4 = findViewById<View>(R.id.editTextTextPersonName3) as EditText
        //   s3=t4.getText().toString();
        t5 = findViewById<View>(R.id.editTextPhone) as EditText
        // s4=t5.getText().toString();
        t6 = findViewById<View>(R.id.textInputEditText) as TextInputEditText
        //s5=t6.getText().toString();
        t7 = findViewById<View>(R.id.textInputEditText2) as TextInputEditText
        //s6=t7.getText().toString();
        s_btn = findViewById<View>(R.id.button4) as Button
        Login_members = LoginBase(this)
        s_btn!!.setOnClickListener {
            s = t!!.text.toString()
            s1 = t2!!.text.toString()
            s2 = t3!!.text.toString()
            s3 = t4!!.text.toString()
            s5 = t6!!.text.toString()
            s6 = t7!!.text.toString()
            if (Login_members!!.Search_users(s!!) === s) {
                Toast.makeText(this@OwnerActivity, "User Name Already Exists", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val id = Login_members!!.insert_data(s, s1, s4, s2, s3, s5, s6, "Owner")
                if (id > 0) {
                    val oi = Intent(this@OwnerActivity, Signin::class.java)
                    startActivity(oi)
                } else {
                  /*  Messages(
                        this@OwnerActivity,
                        "Unsuccessful to Sign Up,Please try to fill the details again"
                    )*/
                }
            }
        }
    }
}