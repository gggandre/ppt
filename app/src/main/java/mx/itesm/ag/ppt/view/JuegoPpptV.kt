package mx.itesm.ag.ppt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import mx.itesm.ag.ppt.R
import mx.itesm.ag.ppt.databinding.ActivityMainBinding
import mx.itesm.ag.ppt.model.Elemento
import mx.itesm.ag.ppt.viewmodel.JuegoPptVM

/**

 *@author: Gilberto André García Gaytán
 *La vista del juego PPT
 */

class JuegoPpptV : AppCompatActivity() {
    // viewModel
    private val viewModel: JuegoPptVM by viewModels()

    // binding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarObservables()
        registrarEventos()
    }

    private fun registrarEventos() {
        binding.btnPiedra.setOnClickListener {
            viewModel.jugar(Elemento.PIEDRA)
        }
        binding.btnPapel.setOnClickListener {
            viewModel.jugar(Elemento.PAPEL)
        }
        binding.btnTijeras.setOnClickListener {
            viewModel.jugar(Elemento.TIJERAS)
        }
    }

    private fun configurarObservables() {
        viewModel.puntosJugador.observe(this) { puntos ->
            binding.etPuntosJugador.setText(puntos.toString())

        }
        viewModel.puntosComputadora.observe(this) { puntos ->
            binding.etPuntosComputadora.setText(puntos.toString())
        }
    }

}