package com.example.fragmentsrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class Owner_rentertableadapter(private val listener: (RenterData) -> Unit):
    ListAdapter<RenterData, Owner_rentertableadapter.ViewHolder>(DiffCallback1()) {

          override fun onCreateViewHolder(parent: ViewGroup,
                                          viewType: Int): Owner_rentertableadapter.ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.renter_tabledetails, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (containerView: View) : RecyclerView.ViewHolder(containerView)/*, LayoutContainer */{
        init{
            itemView.setOnClickListener{
                listener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(countryData: RenterData){
            with(countryData){
//val rentername_o:String,val Floor_o:String,
// val Payment_o:String,val Deadline_o:String,val LeaseDate_o:String)
               var t1: TextView =itemView.findViewById(R.id.rentername_detail)
                var t2:TextView=itemView.findViewById(R.id.room_no_detail)
                var t3:TextView=itemView.findViewById(R.id.Payment_detail)
                var t4:TextView=itemView.findViewById(R.id.Deadline_detail)
                var t5:TextView=itemView.findViewById(R.id.numberofmonths_detail)
             //   var t3:ImageView=itemView.findViewById(R.id.ownericon)
                t1.text=rentername_o
                t2.text=Floor_o
                t3.text=Payment_o
                t4.text=Deadline_o
                t5.text=LeaseDate_o

                //ownericon.setImageResource(flagid)
               // owner_name.text = name
               // address.text=loc
               /* product_price.text = itemView.context.getString(R.string.product_price, price)
                product_description.text = shortDescription*/
            }
        }
    }
}
class DiffCallback1 : DiffUtil.ItemCallback<RenterData>() {
    override fun areItemsTheSame(oldItem: RenterData, newItem: RenterData): Boolean {
        return oldItem.rentername_o == newItem.rentername_o
    }

    override fun areContentsTheSame(oldItem: RenterData, newItem: RenterData): Boolean {
        return oldItem == newItem
    }
}