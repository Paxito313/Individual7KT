package com.example.individual7kt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.individual7kt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var saldo: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWelcome.text = getString(R.string.welcome_title)

        binding.btnVerSaldo.setOnClickListener {
            Toast.makeText(this, "Tu saldo es: $saldo", Toast.LENGTH_SHORT).show()
        }

        binding.btnIngresarDinero.setOnClickListener {
            val cantidad = binding.etCantidad.text.toString().toDoubleOrNull()
            if (cantidad != null && cantidad > 0) {
                saldo += cantidad
                Toast.makeText(this, "Has ingresado: $cantidad", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor ingresa una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSacarDinero.setOnClickListener {
            val cantidad = binding.etCantidad.text.toString().toDoubleOrNull()
            if (cantidad != null && cantidad > 0) {
                if (cantidad <= saldo) {
                    saldo -= cantidad
                    Toast.makeText(this, "Has retirado: $cantidad", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "No tienes saldo suficiente", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor ingresa una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSalir.setOnClickListener {
            finishAffinity()
        }
    }
}
