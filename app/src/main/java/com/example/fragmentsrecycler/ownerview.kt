package com.example.fragmentsrecycler

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import de.codecrafters.tableview.TableView

var Renterdups= mutableListOf<RenterData>(RenterData("1","Vinay","2","3000$","10thAugust2022","10thMay2022"));
class ownerview : AppCompatActivity() {
    var lease_data:Renerleasedata?=null
    var storing=mutableListOf<RenterData>()
    lateinit var Owner_details:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ownerpage1)
        var tableView=findViewById<TableView<Any>>(R.id.table_data_view)
        var headers=arrayOf<String>("Renter","Payment","months","notification","deadline")
        var data=arrayOf<String>()
        storing=lease_data!!.search_renter_owner(Owner_details)
        for(i in storing){
            Renterdups.add(i)
        }
        tableView.headerAdapter.add(headers)
        tableView.dataAdapter.data


    }
}