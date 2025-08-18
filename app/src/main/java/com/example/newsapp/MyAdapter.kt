package com.example.newsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.MyAdapter.MyViewHolder
import androidx.core.graphics.toColorInt

class MyAdapter(val songs: List<Song>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val song = songs[position]
        holder.txtTitle.text = song.title
        holder.txtDescription.text = song.description

        val color = if (position % 2 == 0) "#EEEEEE" else "#CCCCCC"
        holder.container.setBackgroundColor(color.toColorInt())
    }

    override fun getItemCount() = songs.size

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtDescription: TextView = itemView.findViewById(R.id.txtDescription)
        val container: LinearLayout = itemView.findViewById(R.id.container)
    }
}
