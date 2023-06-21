package com.example.fragmentsrecycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
//import kotlinx.android.synthetic.main.fragment_portin_detailinfo.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Portin_detailinfo.newInstance] factory method to
 * create an instance of this fragment.
 */
class Portin_detailinfo : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var addowner_:RenterInventoryNew?= null
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
        return inflater.inflate(R.layout.fragment_portin_detailinfo, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var product: PortionsData? = null
        val id = arguments?.getInt("ID")
        var st:String?=arguments?.getString("name")
        id?.let {
            product = portionsdup.find { it.id == id }
        }

        product?.let{
            with(it){
               /* product_name.text = name
                product_price.text = getString(R.string.product_price, price)
                product_description.text = shortDescription
                product_full_description.text = longDescription
                product_image.setImageResource(imageId)*/
                var t5:TextView=view.findViewById(R.id.info_No_detail)
                var t6:TextView=view.findViewById(R.id.info_size_detail)
                //info_No_detail.text=floor_No.toString()
                //info_size_detail.text=type_portion
                t5.text=floor_No.toString()
                t6.text=type_portion
                var b1:Button=view.findViewById(R.id.continuerent)
                var b2:Button=view.findViewById(R.id.getin)
                b2.setOnClickListener{
                    addowner_?.addowner(st,"sai")
                }
                b1.setOnClickListener {

                    //findNavController().navigate(R.id.action_detail_to_checkout, bundle)
                    findNavController().navigate(R.id.home_list)
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Portin_detailinfo.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Portin_detailinfo().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}