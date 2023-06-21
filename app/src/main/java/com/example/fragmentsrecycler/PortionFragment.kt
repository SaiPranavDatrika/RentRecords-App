package com.example.fragmentsrecycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.synthetic.main.fragment_portion.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PortionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PortionFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var name1:String?=null
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
        return inflater.inflate(R.layout.fragment_portion, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var owner_info: OwnerData? = null
        val id = arguments?.getInt("ID")
        id?.let {
            owner_info = ownersdup.find { it.id.toInt() == id }
        }

        owner_info?.let {
            with(it) {
                view.findViewById<TextView>(R.id.info_name).text = name
                /* product_price.text = getString(R.string.product_price, price)
                 product_description.text = shortDescription
                 product_full_description.text = longDescription*/
                view.findViewById<ImageView>(R.id.owner_image).setImageResource(flagid)
               view.findViewById<TextView>(R.id.info_Multi_address).text=loc
               name1=name
                /* buy.setOnClickListener {
                     val bundle = Bundle()
                     bundle.putInt("ID", this.id)
                   //  findNavController().navigate(R.id.action_detail_to_checkout, bundle)
                 }*/
            }
        }
        //findViewById can be replaced with the widget id directly-view.findViewById<RecyclerView>(R.id.owners_items)
        val portionL = view.findViewById<RecyclerView>(R.id.portion_recyclerview).apply {

            layoutManager = LinearLayoutManager(activity)

            adapter = Owner_PortionsAdapter {

                val bundle = Bundle()
                bundle.putInt("ID", it.id)
                bundle.putString("name",name1)
                //findNavController().navigate(R.id.detail, bundle)
                findNavController().navigate(R.id.portin_detailinfo, bundle)
            }
            setHasFixedSize(true)
        }
        (portionL.adapter as Owner_PortionsAdapter).submitList(portionsdup)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PortionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PortionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}