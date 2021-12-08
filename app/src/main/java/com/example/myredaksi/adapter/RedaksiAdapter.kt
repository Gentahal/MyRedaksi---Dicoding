package com.example.myredaksi.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myredaksi.adapter.RedaksiAdapter.*
import com.example.myredaksi.data.Redaksi
import com.example.myredaksi.databinding.RowItemListBinding
import com.example.myredaksi.home.DetailActivity

class RedaksiAdapter(private val listRedaksi: ArrayList <Redaksi>): RecyclerView.Adapter<RedaksiAdapter.MyViewHolder>(){

    inner class MyViewHolder(private val itemRedaksiBinding: RowItemListBinding) :
    RecyclerView.ViewHolder(itemRedaksiBinding.root){

        fun bindItem(redaksi: Redaksi){
            itemRedaksiBinding.tvDataJudul.text = redaksi.nama
            itemRedaksiBinding.tvDataDetail.text = redaksi.detail
            itemRedaksiBinding.imgDetail.setImageResource(redaksi.gambar)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        RowItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(listRedaksi[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA_REDAKSI,listRedaksi[position])
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listRedaksi.size

}