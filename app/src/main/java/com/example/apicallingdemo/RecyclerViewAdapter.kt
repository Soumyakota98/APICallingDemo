package com.example.apicallingdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerViewAdapter(val mlist:List<Heros>):RecyclerView.Adapter<RecyclerViewAdapter.HerosViewHolder>() {

    class HerosViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.image)
        val textView :TextView = itemView.findViewById(R.id.hero)
        val realNameTextView : TextView = itemView.findViewById(R.id.marvelRealName)
        val teamTextView : TextView = itemView.findViewById(R.id.marvelTeam)
        val firstTextView : TextView = itemView.findViewById(R.id.firstAppearance)
        val createdTextView : TextView = itemView.findViewById(R.id.createdBy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HerosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
        return HerosViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: HerosViewHolder, position: Int) {
        val list = mlist [position]
        holder.textView.text= "Name:" + list.name
        holder.realNameTextView.text= "RealName: "+list.realname
        holder.teamTextView.text= "Team: "+list.team
        holder.firstTextView.text= "FirstAppearance: "+list.firstappearance
        holder.createdTextView.text= "Created By: "+list.createdby

        Glide.with(holder.itemView).load(list.imageurl).into(holder.img)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }
}