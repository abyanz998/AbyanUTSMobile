package com.vokasi.abyan_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (val userList: ArrayList<User>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val user: User=userList[position]
        holder?.textViewName?.text = user.id
        holder?.textViewAddress?.text = user.judul
        holder?.textViewNumber?.text = user.waktu
        holder?.textViewPenulis?.text = user.penulis
        holder?.textViewIsi?.text = user.isi

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent?.context).inflate(R.layout.list_layout, parent, false)
        return  ViewHolder(v)

    }


    override fun getItemCount(): Int {

        return userList.size
    }



    class  ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        val textViewNumber = itemView.findViewById(R.id.textViewNumber) as TextView
        val textViewAddress = itemView.findViewById(R.id.textViewAddress) as TextView
        val textViewPenulis = itemView.findViewById(R.id.textViewPenulis) as TextView
        val textViewIsi = itemView.findViewById(R.id.textViewIsi) as TextView





    }


}
