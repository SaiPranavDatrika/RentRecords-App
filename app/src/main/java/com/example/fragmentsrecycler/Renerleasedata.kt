package com.example.fragmentsrecycler

import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.NullPointerException

class Renerleasedata {
    var renter_lease:RenterLeaseStorageNew?= null

    constructor(context: Context?){
       renter_lease= RenterLeaseStorageNew(context)
    }
//data class RenterData(val id:String,val rentername_o:String,val Floor_o:String,val Payment_o:String,val Deadline_o:String,val LeaseDate_o:String)
    fun insert_renterlease(id:String,rentername_o:String,ownername:String,FloorNo_o:String,Payment_o:String,Deadline_o:String,LeaseDate_o:String,Moveout_o:String):Long{
          val rb=renter_lease!!.writableDatabase
          val cv=ContentValues()
          cv.put(renter_lease!!.UID,id)
          cv.put(renter_lease!!.rentername,rentername_o)
          cv.put(renter_lease!!.Owner_under,ownername)
          cv.put(renter_lease!!.Floor,FloorNo_o)
          cv.put(renter_lease!!.Paymenttopay,Payment_o)
          cv.put(renter_lease!!.Deadlinetopay,Deadline_o)
          cv.put(renter_lease!!.LeaseDate,LeaseDate_o)
          cv.put(renter_lease!!.Moveout,Moveout_o)

          return rb.insert(RenterLeaseStorageNew.Table_Lease_new,null,cv)

    }
    fun search_renter_owner(Owner_:String):MutableList<RenterData>{
        var arrayList=mutableListOf<RenterData>()
        var rb=renter_lease!!.readableDatabase
        val string= arrayOf(
            renter_lease!!.UID,
            renter_lease!!.rentername,
            renter_lease!!.Paymenttopay,
            renter_lease!!.Deadlinetopay,
            renter_lease!!.Floor,
            renter_lease!!.LeaseDate,
            renter_lease!!.Moveout,
            renter_lease!!.Owner_under,
        )
       /* rentername + " VARCHAR(255),"
        + Paymenttopay + " VARCHAR(255),"
        + Deadlinetopay + " VARCHAR(255),"
        + Floor+ " VARCHAR(255),"
        + LeaseDate+ " VARCHAR(255),"
        + Moveout+ " VARCHAR(255),"
        + Owner_under+ " VARCHAR(255));"*/
   //data class RenterData(val id:String,val rentername_o:String,val Floor_o:String,val Payment_o:String,val Deadline_o:String,val LeaseDate_o:String)
        val cursor=rb.query(RenterLeaseStorageNew.Table_Lease_new,string,renter_lease!!.Owner_under+ "=?",
            arrayOf(Owner_),null,null,null)

        if(cursor.moveToFirst()!=null) {
                       do {
                var index = cursor.getColumnIndex(renter_lease!!.UID)
                var index2 = cursor.getColumnIndex(renter_lease!!.Owner_under)
                var index3 = cursor.getColumnIndex(renter_lease!!.Floor)
                var index4 = cursor.getColumnIndex(renter_lease!!.Paymenttopay)
                var index5 = cursor.getColumnIndex(renter_lease!!.Deadlinetopay)
                var index6 = cursor.getColumnIndex(renter_lease!!.LeaseDate)

                arrayList.add(
                    RenterData(
                        cursor.getString(index),
                        cursor.getString(index2),
                        cursor.getString(index3),
                        cursor.getString(index4),
                        cursor.getString(index5),
                        cursor.getString(index6)
                    )
                )
            }while(cursor.moveToNext())
        }
        return arrayList

    }

    class RenterLeaseStorageNew(private val context: Context?):
        SQLiteOpenHelper(context,
            Database_Lease_new, null,
            DataBase_Leaseversion_new
        ){
        var UID = "_id"
        var rentername="rentername"
        var Paymenttopay="Payment"
        var Deadlinetopay="Deadline"
        var Floor="FloorNo"
        var LeaseDate="Date_entry"
        var Moveout="Date_toleave"
        var Owner_under="Owner_living"
        override fun onCreate(db: SQLiteDatabase) {
            try {
                val query =
                    " CREATE TABLE " + Table_Lease_new + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ rentername + " VARCHAR(255),"+ Paymenttopay + " VARCHAR(255),"+ Deadlinetopay + " VARCHAR(255),"+ Floor+ " VARCHAR(255),"+ LeaseDate+ " VARCHAR(255),"+ Moveout+ " VARCHAR(255),"+ Owner_under+ " VARCHAR(255));"
                /*val query =
                    " CREATE TABLE " + Table_Name_new + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ Uname + " VARCHAR(255),"+ rentername + " VARCHAR(255),"+ Owner_index + " INTEGER,"+ PWD + " VARCHAR(255),"+ PhoneNo + " VARCHAR(255),"+ EmailID + " VARCHAR(255),"+ State + " VARCHAR(255),"+ ZIP + " INTEGER,"+ Address + " VARCHAR(255),"+ Type + " VARCHAR(255));"
                */
                    db.execSQL(query)
                //Toast.makeText(this@RenterBase, "On create Called", Toast.LENGTH_SHORT)
                //   Globalclass.Messages(context, "On create Called")
            } catch (e: SQLException) {
                // Globalclass.Messages(context, "" + e)
            }
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }
        companion object {
            const val Database_Lease_new = "RenterLease_final"
            const val Table_Lease_new = "RenterLeaseTablenew_final"
            const val DataBase_Leaseversion_new = 1
        }

    }
}