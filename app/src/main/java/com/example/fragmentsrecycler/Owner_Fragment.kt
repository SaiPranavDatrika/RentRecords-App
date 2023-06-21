package com.example.fragmentsrecycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Owner_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Owner_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner, container, false)
    }

      override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var renter_info: RenterData? = null
        val id = arguments?.getInt("ID")
        id?.let {
            renter_info = Renterdups.find { it.id.toInt() == id }
        }

        renter_info?.let {
            with(it) {
                view.findViewById<TextView>(R.id.rentername_detail).text = rentername_o
                /* product_price.text = getString(R.string.product_price, price)
                 product_description.text = shortDescription
                 product_full_description.text = longDescription*/
            //    view.findViewById<ImageView>(R.id.owner_image).setImageResource(flagid)

                view.findViewById<TextView>(R.id.room_no_detail).text = Floor_o
                view.findViewById<TextView>(R.id.Payment_detail).text = Payment_o
                view.findViewById<TextView>(R.id.numberofmonths_detail).text=LeaseDate_o
                view.findViewById<TextView>(R.id.Deadline_detail).text = Deadline_o

                /* buy.setOnClickListener {
                     val bundle = Bundle()
                     bundle.putInt("ID", this.id)
                   //  findNavController().navigate(R.id.action_detail_to_checkout, bundle)
                 }*/
            }
        }
        //findViewById can be replaced with the widget id directly-view.findViewById<RecyclerView>(R.id.owners_items)
        val portionL = view.findViewById<RecyclerView>(R.id.recycler_view_table).apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = Owner_rentertableadapter {

                val bundle = Bundle()
                bundle.putString("ID", it.id)
               // bundle.putString("name",name1)
                //findNavController().navigate(R.id.detail, bundle)
              //  findNavController().navigate(R.id.portin_detailinfo, bundle)
            }
            setHasFixedSize(true)
        }
        (portionL.adapter as Owner_rentertableadapter).submitList(Renterdups)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Owner_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Owner_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}