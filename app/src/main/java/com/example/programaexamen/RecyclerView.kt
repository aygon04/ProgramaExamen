package com.example.programaexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        LoadData()

        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=itemAdapter()
    }
    private fun LoadData()
    {
        Singleton.dataSet.add(Items("CUBREBOCAS","500"))
        Singleton.dataSet.add(Items("PAPEL DE BAÑO","250"))
        Singleton.dataSet.add(Items("GEL ANTIBACTERIAL","800"))
    }
}
