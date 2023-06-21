package com.example.fragmentsrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
//import kotlinx.android.extensions.LayoutContainer
//import kotlinx.android.synthetic.main.owner_details.*

class OwnerFragment_Adapter(private val listener: (OwnerData) -> Unit):
    ListAdapter<OwnerData, OwnerFragment_Adapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): OwnerFragment_Adapter.ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.owner_details, parent, false)

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

        fun bind(countryData: OwnerData){
            with(countryData){

               var t1:TextView=itemView.findViewById(R.id.owner_name)
                var t2:TextView=itemView.findViewById(R.id.address)
                var t3:ImageView=itemView.findViewById(R.id.ownericon)
                t1.text=name
                t2.text=loc
                t3.setImageResource(flagid)
                //ownericon.setImageResource(flagid)
               // owner_name.text = name
               // address.text=loc
               /* product_price.text = itemView.context.getString(R.string.product_price, price)
                product_description.text = shortDescription*/
            }
        }
    }
}
class DiffCallback : DiffUtil.ItemCallback<OwnerData>() {
    override fun areItemsTheSame(oldItem: OwnerData, newItem: OwnerData): Boolean {
        return oldItem.flagid == newItem.flagid
    }

    override fun areContentsTheSame(oldItem: OwnerData, newItem: OwnerData): Boolean {
        return oldItem == newItem
    }
}