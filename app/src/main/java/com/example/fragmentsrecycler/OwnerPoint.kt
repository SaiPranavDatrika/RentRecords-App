package com.example.fragmentsrecycler


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity

import android.widget.TextView


import android.graphics.Color
import android.view.View

import android.widget.TableLayout
import android.widget.TableRow


class OwnerPoint : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ownersview)
        initial()
    }
    fun initial() {
        val stk = findViewById<View>(R.id.tablemain) as TableLayout
        val tbrow0 = TableRow(this)
        val tv0 = TextView(this)
        tv0.text = " Sl.No "
        tv0.setTextColor(Color.WHITE)
        tbrow0.addView(tv0)
        val tv1 = TextView(this)
        tv1.text = " Product "
        tv1.setTextColor(Color.WHITE)
        tbrow0.addView(tv1)
        val tv2 = TextView(this)
        tv2.text = " Unit Price "
        tv2.setTextColor(Color.WHITE)
        tbrow0.addView(tv2)
        val tv3 = TextView(this)
        tv3.text = " Stock Remaining "
        tv3.setTextColor(Color.WHITE)
        tbrow0.addView(tv3)
        stk.addView(tbrow0)
        for (i in 0..24) {
            val tbrow = TableRow(this)
            val t1v = TextView(this)
            t1v.text = "" + i
            t1v.setTextColor(Color.WHITE)
            t1v.gravity = Gravity.CENTER
            tbrow.addView(t1v)
            val t2v = TextView(this)
            t2v.text = "Product $i"
            t2v.setTextColor(Color.WHITE)
            t2v.gravity = Gravity.CENTER
            tbrow.addView(t2v)
            val t3v = TextView(this)
            t3v.text = "Rs.$i"
            t3v.setTextColor(Color.WHITE)
            t3v.gravity = Gravity.CENTER
            tbrow.addView(t3v)
            val t4v = TextView(this)
            t4v.text = "" + i * 15 / 32 * 10
            t4v.setTextColor(Color.WHITE)
            t4v.gravity = Gravity.CENTER
            tbrow.addView(t4v)
            stk.addView(tbrow)
        }
    }
}
