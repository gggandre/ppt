package mx.itesm.ag.ppt

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.itesm.ag.ppt.databinding.ActivityAcercaBinding
import mx.itesm.ag.ppt.databinding.ActivityMainBinding

class AcercadeV : AppCompatActivity() {


    //binding
    private lateinit var binding: ActivityAcercaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_acerca)
        binding = ActivityAcercaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarEventos()
    }

    private fun configurarEventos() {
        binding.btnRegresar.setOnClickListener{
            finish()
        }
    }
}