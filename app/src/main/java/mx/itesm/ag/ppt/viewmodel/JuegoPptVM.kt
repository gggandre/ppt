package mx.itesm.ag.ppt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.itesm.ag.ppt.model.Elemento
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

    // Interfaz. Funciones que proporciona el ViewModel
    // Normalmente llamados por los eventos de la Vista<<
    fun jugar(elementoJugador: Elemento) {
        // La computadora juega al azar
        val elementoComputadora = ppt.generarElemento()
        // pedimos al modelo que resuelva
        val resultado = ppt.jugar(elementoJugador, elementoComputadora)
        // Actualizamos las variables Observables
        puntosJugador.value = ppt.puntosJugador
        puntosComputadora.value = ppt.puntosComputadora
    }
}