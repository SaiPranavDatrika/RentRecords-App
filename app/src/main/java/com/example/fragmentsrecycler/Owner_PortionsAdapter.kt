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
//import kotlinx.android.synthetic.main.rentportion_info.*
import org.w3c.dom.Text

class Owner_PortionsAdapter (private val listener: (PortionsData) -> Unit):
    ListAdapter<PortionsData, Owner_PortionsAdapter.ViewHolder>(DiffCallbacks()){


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): Owner_PortionsAdapter.ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.rentportion_info, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (containerView:View) : RecyclerView.ViewHolder(containerView)/*, LayoutContainer*/ {
        init{
            itemView.setOnClickListener{
                listener.invoke(getItem(adapterPosition))
            }
        }

        fun bind(countryData: PortionsData){
            with(countryData){


              //  var t1: ImageView= itemView.findViewById(R.id.ownericon)
               var t2:TextView= itemView.findViewById(R.id.info_size)
                var t3:TextView= itemView.findViewById(R.id.info_No)
               // t1.setImageResource(flagid)
                t2.text=type_portion
                t3.text=floor_No.toString()
                //info_size.text = type_portion
               // info_No.text=floor_No.toString()
                /* product_price.text = itemView.context.getString(R.string.product_price, price)
                 product_description.text = shortDescription*/
            }
        }
    }
}

/*interface LayoutContainer {
    val containerView: View?
}*/

class DiffCallbacks : DiffUtil.ItemCallback<PortionsData>() {
   /* override fun areItemsTheSame(oldItem: OwnerData, newItem: OwnerData): Boolean {
        return oldItem.flagid == newItem.flagid
    }*/

    override fun areContentsTheSame(oldItem: PortionsData, newItem: PortionsData): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: PortionsData, newItem: PortionsData): Boolean {
        TODO("Not yet implemented")
    }
}