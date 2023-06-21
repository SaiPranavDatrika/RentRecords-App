package com.example.fragmentsrecycler

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Signin:AppCompatActivity() {
    var s: String? = null
    var p: String? = null
    var t: TextView? = null
    var Login_btn: Button? = null
    var t1: TextInputEditText? = null
    var e: EditText? = null
    var ownersigninbtn: Button? = null
    var Login_details: LoginBase? = null
    var Renter_details:RenterInventoryNew?=null
    var rentersignup: Button? = null
    //Login_details=new LoginBase(this);
  //  var context:Context=applicationContext
    //Login_details=new LoginBase(this);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage)
        t1 = findViewById(R.id.tv1_12)
        // s=t1.getText().toString();
        e = findViewById(R.id.editTextTextPassword2)
        //  p=e.getText().toString();
       Login_btn = findViewById<View>(R.id.button) as Button


        Login_details = LoginBase(this)
        Renter_details=RenterInventoryNew(this)
          Login_btn!!.setOnClickListener {
              s = t1!!.text.toString()
              p = e!!.text.toString()
            val cam = Login_details!!.Validation(s!!, p!!)
              val cam2=Renter_details!!.Validation_renter(s!!,p!!)
            /* if(Login_details.Search_users(s)==null)
                {
                    Toast.makeText(MainActivity.this, "Please sign in the app and try to login again", Toast.LENGTH_SHORT).show();
                }
                else*/
              if (cam) {
           val i = Intent(this@Signin, ownerview::class.java)
            startActivity(i)
        }
          else if(cam2)
          {
              val i = Intent(this@Signin, Renterview::class.java)
              i.putExtra("Key",s)
              startActivity(i)
          }
          else {
            // Toast.makeText(getApplicationContext(),p,Toast.LENGTH_SHORT).show();
            Toast.makeText(this@Signin, "Wrong Password", Toast.LENGTH_SHORT).show()
        }
        }
        ownersigninbtn = findViewById<View>(R.id.button3) as Button
        ownersigninbtn!!.setOnClickListener {
            val oi = Intent(this@Signin , OwnerActivity::class.java)
            startActivity(oi)
        }
        rentersignup = findViewById<View>(R.id.button2) as Button
        rentersignup!!.setOnClickListener {
            val oi = Intent(this@Signin, RenterActivity::class.java)
            startActivity(oi)
        }
          }

}