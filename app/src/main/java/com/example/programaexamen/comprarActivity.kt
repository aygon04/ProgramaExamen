package com.example.programaexamen

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_comprar.*

class comprarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comprar)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }
        val nombre=intent.extras.getString("nombre","NA")

        val precio=intent.extras.getString("precio","NA")
        Toast.makeText(this,"${nombre} ${precio}", Toast.LENGTH_LONG).show()
        //ivImagen.setImageResource(R.drawable.ic_launcher_background)


    }

}
