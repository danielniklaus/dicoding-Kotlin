package com.daniel.myapplication.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daniel.myapplication.R
import com.daniel.myapplication.models.Item
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerViewAdapter(
    private val context: Context,
    private val items: List<Item>,
    private val listener: (Item) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, position: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {
//        private val name = view.findViewById<TextView>(R.id.name)
//        private val image = view.findViewById<ImageView>(R.id.image)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            itemView.item_name.text = items.name
            items.image?.let { Picasso.get().load(it).into(itemView.image) }
            itemView.setOnClickListener {
                listener(items)
            }
        }

    }
}