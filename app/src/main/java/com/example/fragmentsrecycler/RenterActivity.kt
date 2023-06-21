package com.example.fragmentsrecycler

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class RenterActivity:AppCompatActivity() {
    var t: EditText? =null
    var t2:EditText? = null
    var t3:EditText? = null
    var t4:EditText? = null
    var t5:EditText? = null
    var t6: TextInputEditText? = null
    var t7:TextInputEditText? = null
    var t8:EditText?=null
    var s_renterbtn: Button? = null
    var s: String? =
        null
    var s1:kotlin.String? = null
    var s2:kotlin.String? = null
    var s3:kotlin.String? = null
    var s4:kotlin.String? = null
    var s5:kotlin.String? = null
    var s6:kotlin.String? = null
    var s7:String?=null
    var Login_rentermembers: RenterInventoryNew? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rentersignin)
        t = findViewById<View>(R.id.editTextTextPersonName_renter) as EditText
        //  s=t.getText().toString();
        t2 = findViewById<View>(R.id.editTextTextPassword_renter) as EditText
        // s1=t2.getText().toString();
        t3 = findViewById<View>(R.id.editTextTextPersonName2_renter) as EditText
        //  s2=t3.getText().toString();
        t4 = findViewById<View>(R.id.editTextTextPersonName3_renter) as EditText
        //   s3=t4.getText().toString();
        t5 = findViewById<View>(R.id.editTextPhone_renter) as EditText
        // s4=t5.getText().toString();
        t6 = findViewById<View>(R.id.textInputEditText_renter) as TextInputEditText
        //s5=t6.getText().toString();
        t7 = findViewById<View>(R.id.textInputEditText2_renter) as TextInputEditText
        t8=findViewById<View>(R.id.PersonName_renter) as EditText
        //s6=t7.getText().toString();
        Login_rentermembers = RenterInventoryNew(this)

        s_renterbtn = findViewById<View>(R.id.button4_renter) as Button
        s_renterbtn!!.setOnClickListener {
            s = t?.text.toString()
            s1 = t2?.text.toString()
            s2 = t3?.text.toString()
            s3 = t4?.text.toString()
            s5 = t6?.text.toString()
            s6 = t7?.text.toString()
            s7=t8?.text.toString()
            if (Login_rentermembers!!.Search_users_renter(s!!) == s) {
                Toast.makeText(this@RenterActivity, "User Name Already Exists", Toast.LENGTH_SHORT)
                    .show()
            }
            /* insert_data_renter(uname: String?,
                           password: String?,
                           ownerid:Int?,
                           rentername:String?,
                           phoneno: String?,
                           Emailid: String?,
                           Add: String?,
                           State: String?,
                           Zip: String?,
                           type: String?)*/
            else {
                val id = Login_rentermembers!!.insert_data_renter(s, s1,null,s7, s4, s2, s3, s5, s6, "renter",)
                if (id > 0) {
                    val oi = Intent(this@RenterActivity, Signin::class.java)
                    startActivity(oi)
                } else {
                    Toast.makeText(this@RenterActivity,  "Unsuccessful to Sign Up,Please try to fill the details again", Toast.LENGTH_SHORT)
                        .show()
                    /*  Messages(
                          this@OwnerActivity,
                          "Unsuccessful to Sign Up,Please try to fill the details again"
                       )*/
                }
            }
        }
    }
}