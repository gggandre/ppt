package mx.itesm.ag.ppt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.ag.ppt.model.Elemento
import mx.itesm.ag.ppt.model.Ganador
import mx.itesm.ag.ppt.model.PiedraPapelTijeras

class JuegoPptVM: ViewModel() {
    /**

     *@author: Gilberto André García Gaytán
     *View Model de @JuegoPptv
     */

    //Modelo
    private val ppt = PiedraPapelTijeras()


    //Vista. Variables Observables
    val puntosJugador = MutableLiveData(0)
    val puntosComputadora = MutableLiveData(0)

    //resultados
    val resultadoJuego = MutableLiveData<String>()
    val resultadoPartida = MutableLiveData<Ganador>()


    // Interfaz. Funciones que proporciona el ViewModel
    // Normalmente llamados por los eventos de la Vista<<
    fun jugar(elementoJugador: Elemento) {
        // La computadora juega al azar
        val elementoComputadora = ppt.generarElemento()
        // pedimos al modelo que resuelva
        val resultado = ppt.jugar(elementoJugador, elementoComputadora)

        //Resultado
        val strResultado = "$elementoJugador vs $elementoComputadora: $resultado" //$ convierte la variable en cadena
        //Resultado juego individual
        resultadoJuego.value = strResultado
        //ResultadoPartida
        resultadoPartida.value = ppt.probarGanador()
        //Puntajes?
        // Actualizamos las variables Observables
        actualizarPuntajes()
    }

    private fun actualizarPuntajes() {
        //Puntajes?
        puntosJugador.value = ppt.puntosJugador
        puntosComputadora.value = ppt.puntosComputadora
    }

    fun reset() {
        ppt.reset()
        actualizarPuntajes()
    }


}