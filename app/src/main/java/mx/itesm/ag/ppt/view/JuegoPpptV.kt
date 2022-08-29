package mx.itesm.ag.ppt.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import mx.itesm.ag.ppt.AcercadeV
import mx.itesm.ag.ppt.R
import mx.itesm.ag.ppt.databinding.ActivityMainBinding
import mx.itesm.ag.ppt.model.Elemento
import mx.itesm.ag.ppt.model.Ganador
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

        binding.fabAcercaDe.setOnClickListener {
            //Mostrar la pantalla de acerca de
            val intAcerca = Intent(this, AcercadeV::class.java) // hacer la transicion entre vistas
            startActivity(intAcerca)
            finish() //Termina la actividad actual
        }
    }

    private fun configurarObservables() {
        viewModel.puntosJugador.observe(this) { puntos ->
            binding.etPuntosJugador.setText(puntos.toString())

        }
        viewModel.puntosComputadora.observe(this) { puntos ->
            binding.etPuntosComputadora.setText(puntos.toString())
        }

        viewModel.resultadoJuego.observe(this){ resultado ->
            Toast.makeText(this, resultado, Toast.LENGTH_SHORT).show()
        }
        viewModel.resultadoPartida.observe(this){ resultado ->
            manejarResultado(resultado)
        }
    }

    private fun manejarResultado(resultado: Ganador) {
        if (resultado==Ganador.JUGADOR || resultado==Ganador.COMPUTADORA){
            val builder = AlertDialog.Builder(this)
                .setTitle("Aviso")
                .setMessage("Ganó: $resultado")
                .setCancelable(false)
                .setPositiveButton("Aceptar"){ _, _ ->
                    viewModel.reset()
                }
            builder.show()
        }

    }

}