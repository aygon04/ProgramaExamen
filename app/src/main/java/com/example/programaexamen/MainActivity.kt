package com.example.programaexamen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.programaexamen.Singleton.dataSetCarrito
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       cargar()
        CargarDialog()
        btnComprar.setOnClickListener{
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, editText.text)
                type = "text/plain"
            }
// Verify that the intent will resolve to an activity
                startActivity(sendIntent)

        }
    }
    fun cargar(){
      for(x in 0..Singleton.dataSetCarrito.size-1)
      {
          editText.text.append("${dataSetCarrito.get(x).nombre} Cantidad:${dataSetCarrito.get(x).cantidad}\nPrecio x Unidad: ${dataSetCarrito.get(x).cantidad
          }\n Precio Total: ${(dataSetCarrito.get(x).cantidad.toString().toInt()*dataSetCarrito.get(x).precio.toString().toInt())}\n")
      }
    }
    private fun CargarDialog() {
        val newFragment = DialogFragment()
        newFragment.show(supportFragmentManager, "DialogFragment")
    }
}
