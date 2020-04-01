package com.example.programaexamen

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_first.tvNombreFF
import kotlinx.android.synthetic.main.fragment_first.tvPrecio
import kotlinx.android.synthetic.main.item_compra.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvPrecio.text= activity?.intent?.getStringExtra("precio")
        if (activity?.intent?.getStringExtra("nombre")=="GEL ANTIBACTERIAL")
        {
         imageView2.setImageResource(R.drawable.gel)
        }
        else if(activity?.intent?.getStringExtra("nombre")=="CUBREBOCAS"){
            imageView2.setImageResource(R.drawable.cubrebocas)
        }
        else if(activity?.intent?.getStringExtra("nombre")=="PAPEL DE BAÑO")
        {
            imageView2.setImageResource(R.drawable.papel)
        }
        tvNombreFF.text= activity?.intent?.getStringExtra("nombre")
        btnAgregar.setOnClickListener {
            val objeto =
                ItemsCarrito("${tvNombreFF.text}", "${tvPrecio.text}",txtNumero.text.toString().toInt())
            Singleton.dataSetCarrito.add(objeto)
            Snackbar.make(view, "Objeto agregado al carrito", Snackbar.LENGTH_LONG).show()
        }
        btnTerminar.setOnClickListener{
            val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
    }}

