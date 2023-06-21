package com.example.fragmentsrecycler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Renterview: AppCompatActivity() {

    lateinit var t1:TextView
    lateinit var t2:TextView
    lateinit var t3:TextView
    lateinit var t4:TextView
    lateinit var B1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.renterinfopage)
         var extras:Bundle?=intent.extras
         var user:String?=extras?.getString("Key")
         var owneradd:RenterInventoryNew?=null
         var str=ArrayList<String>()
        owneradd=RenterInventoryNew(this)
         str=owneradd!!.Search_user_renter_detail(user)
         t1=findViewById(R.id.rentername)
          t2=findViewById(R.id.rentercontact)
        t3=findViewById(R.id.renteremail)
        t4=findViewById(R.id.renteraddress)

        t1.text= str?.get(0)
        t2.text=str?.get(3)
        t3.text=str?.get(1)
        t4.text=str?.get(2)

        B1=findViewById(R.id.search_new_address)
        B1.setOnClickListener {
            val i = Intent(this@Renterview, MainActivity::class.java)
            startActivity(i)
        }
    }
}