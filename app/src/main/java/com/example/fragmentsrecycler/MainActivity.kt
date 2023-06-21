package com.example.fragmentsrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import java.util.zip.Inflater

var ownersdup=mutableListOf<OwnerData>(OwnerData("1001","chandu",R.drawable.icon,"Malkajgiri"),
    OwnerData("1002","Valentoni Rossi",R.drawable.icon,"Moula-ali"),
    OwnerData("1003","Fabio Quartararo",R.drawable.icon,"Vidyanagr"),
    OwnerData("1004","Marc Maquez",R.drawable.icon,"Moula-ali"),
    OwnerData("1005","BINDER",R.drawable.icon,"Jubilee hills"),
    OwnerData("1006","Virat",R.drawable.icon,"Jubilee hills"),
    OwnerData("1007","Miller",R.drawable.icon,"Jubilee hills"),
    OwnerData("1008","Virendra Sehwag",R.drawable.icon,"Malkajgiri"),
    OwnerData("1009","Vikram",R.drawable.icon,"Madhapur"),
    OwnerData("1010","charminar",R.drawable.icon,"Madhapur"),
    OwnerData("1011","Pikachu",R.drawable.icon,"Vidyanagr"),
    OwnerData("1012","Pokemon",R.drawable.icon,"Malkajgiri"),
    OwnerData("1013","Doraemon",R.drawable.icon,"Vidyanagr"),
    OwnerData("1014","MiniCooper",R.drawable.icon,"Moula-ali"),
    OwnerData("1015","Ravi",R.drawable.icon,"Jubilee hills"),
    OwnerData("1016","Ramu",R.drawable.icon,"Madhapur"),
    OwnerData("1017","Rathode",R.drawable.icon,"Moula-ali"),
    OwnerData("1018","Kick",R.drawable.icon,"Madhapur"),
    OwnerData("1019","Khiladi",R.drawable.icon,"Vidyanagr"),
    OwnerData("1020","chandu",R.drawable.icon,"Malkajgiri")
)
var portionsdup= mutableListOf<PortionsData>(PortionsData(1,"2BHK",2),
    PortionsData(2,"2BHK",2),
    PortionsData(3,"2BHK",2),
    PortionsData(4,"2BHK",2))
var Renterdup= mutableListOf<RenterData>(RenterData("1","Vinay","2","3000$","10thAugust2022","10thMay2022"));
class MainActivity : AppCompatActivity() {
    var b:Boolean=false
    //var filteredlist= mutableListOf<OwnerData>()
    var collecting_data:LoginBase?=null
    var sending= mutableListOf<OwnerData>()
    var lease_data:Renerleasedata?=null
    var storing=mutableListOf<RenterData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        collecting_data= LoginBase(this)
       sending=collecting_data!!.insert_inrecyclerview()
       lease_data= Renerleasedata(this)
        for(i in sending!!){
            ownersdup.add(i)
        }
      //  storing=lease_data.search_renter_owner()
        setContentView(R.layout.activity_main)

       // set
    /*    val fragment= FragmentList()
        val fragmenttransaction=supportFragmentManager.beginTransaction()
        fragmenttransaction.add(R.id.main_container,fragment,"FragmentList")
        fragmenttransaction.commit()*/


    }
    /*fun filtereddata():MutableList<OwnerData>{
       if(b)
        return filteredlist
        else
            return ownersdup
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
       // return super.onCreateOptionsMenu(menu)
        var inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.search_menu, menu)


        val searchItem = menu?.findItem(R.id.actionSearch)

        var searchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
                filter(newText)
                return false
            }
        })
        return true;
    }
    private fun filter(newtext:String){
        //  var filteredlist= mutableListOf<OwnerData>()
        for(item in ownersdup){
            if(item.loc.lowercase().contains(newtext.lowercase()))
            {
                filteredlist.add(item)
            }
        }
        if(filteredlist.isEmpty())
        {

            //Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
            Toast.makeText(this,"No   DataFound...", Toast.LENGTH_LONG).show()
        }
       else
           b=true
    }*/
}