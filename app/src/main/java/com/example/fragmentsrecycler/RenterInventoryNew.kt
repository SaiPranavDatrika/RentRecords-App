package com.example.fragmentsrecycler

import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RenterInventoryNew {
    var renter_store: RenterStorageNew?= null
    constructor(context: Context){
        renter_store= RenterStorageNew(context)
    }
    fun insert_data_renter(uname: String?,
                           password: String?,
                           ownerid:Int?,
                           rentername:String?,
                           phoneno: String?,
                           Emailid: String?,
                           Add: String?,
                           State: String?,
                           Zip: String?,
                           type: String?):Long{
        val rb=renter_store!!.writableDatabase
        val cv= ContentValues()
        /*var UID = "_id"
        var Uname = "Uname"
        var rentername="R_name"
        var Ownerid="Owner_id"
        var PWD = "Pwd"
        var PhoneNo = "PhoneNo"
        var Address = "Address"
        var State = "State"
        var ZIP = "Zip"
        var Type = "type"
        var EmailID = "Email_id"*/
        cv.put(renter_store!!.Uname,uname)
        cv.put(renter_store!!.Owner_index,ownerid)
        cv.put(renter_store!!.rentername,rentername)
        cv.put(renter_store!!.PWD,password)
        cv.put(renter_store!!.PhoneNo, phoneno)
        cv.put(renter_store!!.Address, Add)
        cv.put(renter_store!!.State, State)
        cv.put(renter_store!!.ZIP, Zip)
        cv.put(renter_store!!.EmailID, Emailid)
        cv.put(renter_store!!.Type, type)

        return rb.insert(RenterStorageNew.Table_Name_new, null, cv)
    }
    fun Validation_renter(User: String, Password: String): Boolean {
        val rb = renter_store!!.readableDatabase
        /*var UID = "_id"
        var Uname = "Uname"
        var rentername="R_name"
        var Ownerid="Owner_id"
        var PWD = "Pwd"
        var PhoneNo = "PhoneNo"
        var Address = "Address"
        var State = "State"
        var ZIP = "Zip"
        var Type = "type"
        var EmailID = "Email_id"*/
        val string = arrayOf(
            renter_store!!.Uname,
            renter_store!!.rentername,
            renter_store!!.Owner_index,
            renter_store!!.PWD,
            renter_store!!.PhoneNo,
            renter_store!!.Address,
            renter_store!!.State,
            renter_store!!.ZIP,
            renter_store!!.EmailID,
            renter_store!!.Type
        )
        val cursor = rb.query(
            RenterStorageNew.Table_Name_new,
            string,
            renter_store!!.Uname + "=?",
            arrayOf(User),
            null,
            null,
            null
        )
        if (cursor != null  && cursor.count > 0) {
            cursor.moveToFirst()
            val index = cursor.getColumnIndex(renter_store!!.Uname)
            val index2 = cursor.getColumnIndex(renter_store!!.PWD)
            val u:String = cursor.getString(index)
            val pwd:String = cursor.getString(index2)

            if (u == User && pwd == Password) {
                cursor.close()
                rb.close()
                return true
            }

        }
        cursor.close()
        rb.close()
        return false
    }
    fun addowner(owner_user:String?,renter:String){
        val rb=renter_store!!.readableDatabase
        val string = arrayOf(
            renter_store!!.Uname,
            renter_store!!.rentername,
            renter_store!!.Owner_index,
            renter_store!!.PWD,
            renter_store!!.PhoneNo,
            renter_store!!.Address,
            renter_store!!.State,
            renter_store!!.ZIP,
            renter_store!!.EmailID,
            renter_store!!.Type
        )
       /* val cursor = rb.query(
            RenterStorageNew.Table_Name_new,
            string,
            renter_store!!.Uname + "=?",
            arrayOf(st),
            null,
            null,
            null
        )*/
        var whereargs=arrayOf<String>(renter)
        var cv=ContentValues()
        cv.put(renter_store!!.Owner_index,owner_user)
        rb.update(RenterStorageNew.Table_Name_new,cv,renter_store!!.rentername + "=?",whereargs)

    }

    fun Search_user_Owner_renter_(Owner_:String?):ArrayList<String>{
        var arraylist=ArrayList<String>()
        val rb=renter_store!!.readableDatabase
        val string = arrayOf(
            renter_store!!.Uname,
            renter_store!!.Owner_index,
            renter_store!!.rentername,
            renter_store!!.PWD,
            renter_store!!.PhoneNo,
            renter_store!!.Address,
            renter_store!!.State,
            renter_store!!.ZIP,
            renter_store!!.EmailID,
            renter_store!!.Type
        )
        val cursor=rb.query(RenterStorageNew.Table_Name_new,string,renter_store!!.Owner_index+"=?",
            arrayOf(Owner_),
            null,
            null,
            null
            )
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            val index = cursor.getColumnIndex(renter_store!!.Uname)
            val index1=cursor.getColumnIndex(renter_store!!.EmailID)
            val index2=cursor.getColumnIndex(renter_store!!.Address)
            val index3=cursor.getColumnIndex(renter_store!!.PhoneNo)
            var t1:String=cursor.getString(index)
            // st.set(0,t1)
            arraylist.add(t1)
            arraylist.add(cursor.getString(index1))
            arraylist.add(cursor.getString(index2))
            arraylist.add(cursor.getString(index3))
            /*
            st.set(0,cursor.getString(index))
            st.set(1,cursor.getString(index1))
            st.set(2,cursor.getString(index2))
            st.set(3,cursor.getString(index3))*/

            cursor.close()
            return arraylist
        }

        return arraylist
    }

    fun Search_user_renter_detail(User: String?): ArrayList<String>{
      //var st=arrayOf<String>()
        var arraylist=ArrayList<String>()
        val rb = renter_store!!.readableDatabase
        val string = arrayOf(
            renter_store!!.Uname,
            renter_store!!.Owner_index,
            renter_store!!.rentername,
            renter_store!!.PWD,
            renter_store!!.PhoneNo,
            renter_store!!.Address,
            renter_store!!.State,
            renter_store!!.ZIP,
            renter_store!!.EmailID,
            renter_store!!.Type
        )
       // val cursor=rb.rawQuery("SELECT * FROM RenterStorageNew.Table_Name_new Where Uname = ?", arrayOf(User))
        val cursor = rb.query(
            RenterStorageNew.Table_Name_new,
            string,
            renter_store!!.Uname + "=?",
            arrayOf(User),
            null,
            null,
            null
        )
        if (cursor != null && cursor.count > 0) {
            cursor.moveToFirst()
            val index = cursor.getColumnIndex(renter_store!!.Uname)
            val index1=cursor.getColumnIndex(renter_store!!.EmailID)
            val index2=cursor.getColumnIndex(renter_store!!.Address)
            val index3=cursor.getColumnIndex(renter_store!!.PhoneNo)
            var t1:String=cursor.getString(index)
           // st.set(0,t1)
            arraylist.add(t1)
            arraylist.add(cursor.getString(index1))
            arraylist.add(cursor.getString(index2))
            arraylist.add(cursor.getString(index3))
            /*
            st.set(0,cursor.getString(index))
            st.set(1,cursor.getString(index1))
            st.set(2,cursor.getString(index2))
            st.set(3,cursor.getString(index3))*/

            cursor.close()
            return arraylist
        }
      return arraylist
    }
    fun Search_users_renter(User: String): String? {
        val rb = renter_store!!.readableDatabase

        val string = arrayOf(
            renter_store!!.Uname,
            renter_store!!.Owner_index,
            renter_store!!.rentername,
            renter_store!!.PWD,
            renter_store!!.PhoneNo,
            renter_store!!.Address,
            renter_store!!.State,
            renter_store!!.ZIP,
            renter_store!!.EmailID,
            renter_store!!.Type
        )
        /* val cursor = rb.query(
             RenterBase.Table_Name_2,
             string,
             renter_storage!!.Uname + "=?",
             arrayOf(User),
             null,
             null,
             null
         )*/
        val cursor=rb.query(RenterStorageNew.Table_Name_new,string,renter_store!!.Uname+ "=?",arrayOf(User), null,null,null)
        if (cursor != null && cursor.moveToFirst() && cursor.count > 0) {
            val index = cursor.getColumnIndex(renter_store!!.Uname)
            val str:String=cursor.getString(index)
            cursor.close()
            return str
        }
        cursor.close()
        rb.close()
        return null
    }

    class RenterStorageNew(private val context: Context?):
        SQLiteOpenHelper(context,
            Database_Name_new, null,
            DataBase_version_new
        ){
        var UID = "_id"
        var Uname = "Uname"
        var rentername="rentername"
        var Owner_index="Owner_index"
        var PWD = "Pwd"
        var PhoneNo = "PhoneNo"
        var Address = "Address"
        var State = "State"
        var ZIP = "Zip"
        var Type = "type"
        var EmailID = "Email_id"
        override fun onCreate(db: SQLiteDatabase) {
            try {
                val query =
                    " CREATE TABLE " + Table_Name_new + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ Uname + " VARCHAR(255),"+ rentername + " VARCHAR(255),"+ Owner_index + " INTEGER,"+ PWD + " VARCHAR(255),"+ PhoneNo + " VARCHAR(255),"+ EmailID + " VARCHAR(255),"+ State + " VARCHAR(255),"+ ZIP + " INTEGER,"+ Address + " VARCHAR(255),"+ Type + " VARCHAR(255));"
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
            const val Database_Name_new = "RenterInventory_final"
            const val Table_Name_new = "RenterTablenew_final"
            const val DataBase_version_new = 1
        }

    }
}