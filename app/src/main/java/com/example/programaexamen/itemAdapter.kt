package com.example.programaexamen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_compra.*
import kotlinx.android.synthetic.main.item_compra.view.*


class itemAdapter(): RecyclerView.Adapter<itemAdapter.ViewHolder>()  {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvNombre=v.tvNombreFF
        val tvPrecio=v.tvPrecio
        val ivImagen=v.ivImagen
    }
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_compra, viewGroup, false)

        return ViewHolder(v)
    }

    override fun getItemCount()=Singleton.dataSet.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener{
            // Toast.makeText(viewHolder.itemView.context,dataSet.get(position).nombre,Toast.LENGTH_LONG).show()
            val intent= Intent(viewHolder.itemView.context,comprarActivity::class.java)
            intent.putExtra("nombre",Singleton.dataSet.get(position).nombre)
            intent.putExtra("precio",Singleton.dataSet.get(position).precio)
            intent.putExtra("position",position)
            viewHolder.itemView.context.startActivity(intent)
        }
        viewHolder.tvNombre.text = Singleton.dataSet.get(position).nombre
        viewHolder.tvPrecio.text = Singleton.dataSet.get(position).precio
        if (Singleton.dataSet.get(position).nombre=="GEL ANTIBACTERIAL")
        {
            viewHolder.ivImagen.setImageResource(R.drawable.gel)
        }
        else if(Singleton.dataSet.get(position).nombre=="CUBREBOCAS"){
            viewHolder.ivImagen.setImageResource(R.drawable.cubrebocas)
        }
        else if(Singleton.dataSet.get(position).nombre=="PAPEL DE BAÑO")
        {
            viewHolder.ivImagen.setImageResource(R.drawable.papel)
        }
 }
}