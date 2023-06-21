package com.example.fragmentsrecycler

import android.annotation.SuppressLint
import android.os.Bundle
import android.content.ContentValues
import android.content.Context
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

import java.lang.reflect.Constructor
import java.util.ArrayList

class LoginBase {

    var database_l: DatabaseLogin? = null
  //  var renter_storage:RenterBase?= null

     constructor(context: Context) {
        database_l = DatabaseLogin(context)
     //   renter_storage= RenterBase(context)
    }

    fun insert_data(
        uname: String?,
        password: String?,
        phoneno: String?,
        Emailid: String?,
        Add: String?,
        State: String?,
        Zip: String?,
        type: String?
    ): Long {
        val db = database_l!!.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(database_l!!.Uname, uname)
        contentValues.put(database_l!!.PWD, password)
        contentValues.put(database_l!!.PhoneNo, phoneno)
        contentValues.put(database_l!!.Address, Add)
        contentValues.put(database_l!!.State, State)
        contentValues.put(database_l!!.ZIP, Zip)
        contentValues.put(database_l!!.EmailID, Emailid)
        contentValues.put(database_l!!.Type, type)
        return db.insert(DatabaseLogin.Table_Name, null, contentValues)
    }
  /*  fun insert_data_renter(uname: String?,
                           password: String?,
                           ownerid:Int?,
                           rentername:String?,
                           phoneno: String?,
                           Emailid: String?,
                           Add: String?,
                           State: String?,
                           Zip: String?,
                           type: String?):Long{
        val rb=renter_storage!!.writableDatabase
        val cv=ContentValues()
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
        cv.put(renter_storage!!.Uname,uname)
        cv.put(renter_storage!!.PWD,password)
        cv.put(renter_storage!!.Ownerid,ownerid)
        cv.put(renter_storage!!.rentername,rentername)
        cv.put(renter_storage!!.PhoneNo, phoneno)
        cv.put(renter_storage!!.Address, Add)
        cv.put(renter_storage!!.State, State)
        cv.put(renter_storage!!.ZIP, Zip)
        cv.put(renter_storage!!.EmailID, Emailid)
        cv.put(renter_storage!!.Type, type)

        return rb.insert(RenterBase.Table_Name_2, null, cv)
    }*/
    fun Search_users(User: String): String? {
        val db = database_l!!.readableDatabase
        val string = arrayOf(
            database_l!!.Uname,
            database_l!!.PWD,
            database_l!!.PhoneNo,
            database_l!!.Address,
            database_l!!.State,
            database_l!!.ZIP,
            database_l!!.EmailID,
            database_l!!.Type
        )
        val cursor = db.query(
            DatabaseLogin.Table_Name,
            string,
            database_l!!.Uname + "=?",
            arrayOf(User),
            null,
            null,
            null
        )
        if (cursor != null && cursor.moveToFirst() && cursor.count > 0) {
            val index = cursor.getColumnIndex(database_l!!.Uname)
            return cursor.getString(index)
        }
        return null
    }
    fun insert_inrecyclerview():MutableList<OwnerData>{
        //lateinit var data:Array<String>
        var store= mutableListOf<OwnerData>()
        val db=database_l!!.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + DatabaseLogin.Table_Name,null)

      if(cursor.moveToFirst()){
            do{
//               // store!!.add(OwnerData(cursor.getString(cursor.getColumnIndex(database_l!!.UID).toInt()),cursor.getString(cursor.getColumnIndex(database_l!!.Uname).toInt()),R.drawable.icon,cursor.getString(cursor.getColumnIndex(database_l!!.Address).toInt())))
            store!!.add(OwnerData(cursor.getString(0),cursor.getString(2),R.drawable.icon,cursor.getString(7)))
            }while(cursor.moveToNext())

    }

        //store.add(OwnerData("21","Kicks",R.drawable.icon,"Madhapur"))
    return store

    }
   /* fun Search_users_renter(User: String): String? {
        val rb = renter_storage!!.readableDatabase
        val string = arrayOf(
            renter_storage!!.Uname,
            renter_storage!!.PWD,
            renter_storage!!.PhoneNo,
            renter_storage!!.Address,
            renter_storage!!.State,
            renter_storage!!.ZIP,
            renter_storage!!.EmailID,
            renter_storage!!.Type
        )
        val cursor = rb.query(
            RenterBase.Table_Name_2,
            string,
            renter_storage!!.Uname + "=?",
            arrayOf(User),
            null,
            null,
            null
        )
        if (cursor != null && cursor.moveToFirst() && cursor.count > 0) {
            val index = cursor.getColumnIndex(renter_storage!!.Uname)
            return cursor.getString(index)
        }
        return null
    }
*/
    fun Validation(User: String, Password: String): Boolean {
        val db = database_l!!.readableDatabase
        val string = arrayOf(
            database_l!!.Uname,
            database_l!!.PWD,
            database_l!!.PhoneNo,
            database_l!!.Address,
            database_l!!.State,
            database_l!!.ZIP,
            database_l!!.EmailID,
            database_l!!.Type
        )
        val cursor = db.query(
            DatabaseLogin.Table_Name,
            string,
            database_l!!.Uname + "=?",
            arrayOf(User),
            null,
            null,
            null
        )
        if (cursor != null && cursor.moveToFirst() && cursor.count > 0) {
            val index = cursor.getColumnIndex(database_l!!.Uname)
            val index2 = cursor.getColumnIndex(database_l!!.PWD)
            val u = cursor.getString(index)
            val pwd = cursor.getString(index2)
            if (u == User && pwd == Password) {
                return true
            }
        }
        return false
    }
   /* fun Validation_renter(User: String, Password: String): Boolean {
        val rb = renter_storage!!.readableDatabase
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
            renter_storage!!.Uname,
            renter_storage!!.rentername,
            renter_storage!!.Ownerid,
            renter_storage!!.PWD,
           renter_storage!!.PhoneNo,
           renter_storage!!.Address,
            renter_storage!!.State,
           renter_storage!!.ZIP,
            renter_storage!!.EmailID,
           renter_storage!!.Type
        )
        val cursor = rb.query(
            RenterBase.Table_Name_2,
            string,
            renter_storage!!.Uname + "=?",
            arrayOf(User),
            null,
            null,
            null
        )
        if (cursor != null && cursor.moveToFirst() && cursor.count > 0) {
            val index = cursor.getColumnIndex(renter_storage!!.Uname)
            val index2 = cursor.getColumnIndex(renter_storage!!.PWD)
            val u = cursor.getString(index)
            val pwd = cursor.getString(index2)
            if (u == User && pwd == Password) {
                return true
            }
        }
        return false
    }*/

    @SuppressLint("Range")
    fun searchusername(user: String?): List<String>? {
        val db = database_l!!.readableDatabase
        val string = arrayOf(database_l!!.Uname)
        val cursor = db.query(DatabaseLogin.Table_Name, string, null, null, null, null, null)
        val result: MutableList<String> = ArrayList()
        if (cursor.moveToFirst()) {
            do {
                //(cursor.getString(cursor.getColumnIndex(database_l.Uname)));
                result.add(cursor.getString(cursor.getColumnIndex(database_l!!.Uname)))
            } while (cursor.moveToNext())
        }
        return result
    }

    /*public List<UsersClass> searchusers(String user){
        SQLiteDatabase db=database_l.getReadableDatabase();
        String string[]={database_l.Uname,database_l.PWD,database_l.PhoneNo,database_l.Address,database_l.State,database_l.ZIP,database_l.EmailID, database_l.Type};
        Cursor cursor=db.query(database_l.Table_Name,string,database_l.Uname+"LIKE ?",new String[]{"%"+user+"%"},null,null,null);
        List<UsersClass> result=new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                UsersClass u=new UsersClass();
                u.setUsername(cursor.getString(cursor.getColumnIndex(database_l.Uname)));
                u.setEmailid(cursor.getString(cursor.getColumnIndex(database_l.EmailID)));
                u.setAddress(cursor.getString(cursor.getColumnIndex(database_l.Address)));
                result.add(u);
            }while(cursor.moveToNext());
        }
        return result;
    }*/
    class DatabaseLogin(private val context: Context?) :
        SQLiteOpenHelper(context, Database_Name, null, DataBase_version) {
        var UID = "_id"
        var Uname = "Uname"
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
                    " CREATE TABLE " + Table_Name + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Uname + " VARCHAR(255)," + PWD + " VARCHAR(255)," + PhoneNo + " VARCHAR(255)," + EmailID + " VARCHAR(255)," + State + " VARCHAR(255)," + ZIP + " INTEGER," + Address + " VARCHAR(255)," + Type + " VARCHAR(255));"
                db.execSQL(query)
             //   Globalclass.Messages(context, "On create Called")
            } catch (e: SQLException) {
               // Globalclass.Messages(context, "" + e)
            }
        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

        companion object {
             const val Database_Name = "LoginDataBase"
            const val Table_Name = "LoginTable"
            const val DataBase_version = 1
        }
    }
    /*class RenterBase(private val context: Context?):
    SQLiteOpenHelper(context, Database_Name_2, null, DataBase_version_2){
        var UID = "_id"
        var Uname = "Uname"
        var rentername="R_name"
        var Ownerid="Owner_id"
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
                    " CREATE TABLE " + Table_Name_2 + "(" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Uname + " VARCHAR(255),"  + rentername + " VARCHAR(255),"+ Ownerid + "INTEGER,"+ PWD + " VARCHAR(255)," + PhoneNo + " VARCHAR(255)," + EmailID + " VARCHAR(255)," + State + " VARCHAR(255)," + ZIP + " INTEGER," + Address + " VARCHAR(255)," + Type + " VARCHAR(255));"
                db.execSQL(query)
                //   Globalclass.Messages(context, "On create Called")
            } catch (e: SQLException) {
                // Globalclass.Messages(context, "" + e)
            }
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }

        companion object {
            const val Database_Name_2 = "LoginDataBasenew"
            const val Table_Name_2 = "RenterTable"
            const val DataBase_version_2 = 1
        }


    }*/
}