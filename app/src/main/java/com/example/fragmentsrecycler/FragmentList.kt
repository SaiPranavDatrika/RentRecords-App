package com.example.fragmentsrecycler

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import android.R.menu

import android.app.Application
import android.content.Context
import android.widget.Toast
import android.app.SearchManager
import android.util.Log

// import kotlinx.android.synthetic.main.fragment_list.*
import java.util.*


//import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentList.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentList : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   var b:Boolean=false
    lateinit var views:View



    private var searchView: SearchView? = null
    private var queryTextListener: SearchView.OnQueryTextListener? = null
var filteredlist= mutableListOf<OwnerData>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //super.onViewCreated(super.requireView(),savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


       // b=false
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        views=inflater.inflate(R.layout.fragment_list, container, false)
        filteredlist.addAll(ownersdup)
        val productList = views.findViewById<RecyclerView> (R.id.owners_items_frag).apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = OwnerFragment_Adapter {

                val bundle = Bundle()
                bundle.putInt("ID", it.id.toInt())
                //findNavController().navigate(R.id.detail, bundle)
                findNavController().navigate(R.id.portionFragment, bundle)
            }
            setHasFixedSize(true)
        }
        (productList.adapter as OwnerFragment_Adapter).submitList(filteredlist)
        return views;
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu.findItem(R.id.actionSearch)
        val searchManager = activity!!.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        if (searchView != null) {
            searchView!!.setSearchableInfo(searchManager.getSearchableInfo(activity!!.componentName))
            queryTextListener = object : SearchView.OnQueryTextListener {

                override fun onQueryTextChange(newText: String): Boolean {
                    Log.i("onQueryTextChange", newText)
                    filter(newText)
                    views.findViewById<RecyclerView>(R.id.owners_items_frag).adapter!!.notifyDataSetChanged()
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    //Log.i("onQueryTextSubmit", query)

                  // filter(query)
                    views.findViewById<RecyclerView>(R.id.owners_items_frag).adapter!!.notifyDataSetChanged()
                    return true
                }
            }
            searchView!!.setOnQueryTextListener(queryTextListener)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }


    private fun filter(newtext:String){
      //  var filteredlist= mutableListOf<OwnerData>()
       // if(!filteredlist.isEmpty())
           filteredlist.clear()
        for(item in ownersdup){
            if(item.loc.lowercase().contains(newtext.lowercase()))
            {
                filteredlist.add(item)
            }
        }
        if(filteredlist.isEmpty())
        {
           // for(item in ownersdup)
           //     filteredlist.add(item)
            //Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
            Toast.makeText(activity,"No   DataFound...",Toast.LENGTH_LONG).show()
        }
        else {
            b=true
          //  Toast.makeText(activity,"b is true.",Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //findViewById can be replaced with the widget id directly-view.findViewById<RecyclerView>(R.id.owners_items)

    //  super.onCreateOptionsMenu(menu,inflater)
     // setHasOptionsMenu(true)
      //  views_frag=view
       // val adapter=OwnerFragment_Adapter(filteredlist)

    /*    val productList = view.findViewById<RecyclerView> (R.id.owners_items_frag).apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = OwnerFragment_Adapter {

                val bundle = Bundle()
                bundle.putInt("ID", it.id.toInt())
                //findNavController().navigate(R.id.detail, bundle)
                findNavController().navigate(R.id.portionFragment, bundle)
            }
            setHasFixedSize(true)
        }*/

        //


     //   else
       // if(b==false)
      //     (productList.adapter as OwnerFragment_Adapter).submitList(ownersdup)
       // else
    //    (productList.adapter as OwnerFragment_Adapter).submitList(filteredlist)
       // b=true
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentList.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}