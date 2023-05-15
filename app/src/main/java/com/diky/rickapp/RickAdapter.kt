package com.diky.rickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RickAdapter(val datarick : List<ResultsItem?>?) :RecyclerView.Adapter<RickAdapter.MyViewHolder>() {
    class MyViewHolder (view: View) :RecyclerView.ViewHolder(view){
        val imgMorty = view.findViewById<ImageView>(R.id.item_image_Morty)
        val nameMorty = view.findViewById<TextView>(R.id.item_name_morty)
        val statusMorty = view.findViewById<TextView>(R.id.item_status_morty)
        val speciesMorty = view.findViewById<TextView>(R.id.item_species_morty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameMorty.text = datarick?.get(position)?.name
        holder.statusMorty.text = datarick?.get(position)?.status
        holder.speciesMorty.text = datarick?.get(position)?.species

        Glide.with(holder.imgMorty)
            .load(datarick?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgMorty)

        holder.itemView.setOnClickListener {
            val name = datarick?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        if (datarick != null){
            return datarick.size
        }
        return 0
    }
}