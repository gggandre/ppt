package mx.itesm.ag.ppt.model

/**
 * Autor:Autor: Gilberto André García Gaytán
 * Representa la logica una partida de ppt
 */
class PiedraPapelTijeras {
    var puntosJugador=0
        private set
    //   private var puntosJugador: int=0
    var puntosComputadora: Int=0
        private set

    /**
     * Ejecuta un juago de ppt individual
     * @param elementoJugador el elemento con el que juega el jugador
     * @param elementoComputadora el elemento con el que jeuga la computadora
     * @return El ganador de este juego
     */
    fun jugar(elementoJugador:Elemento, elementoComputadora:Elemento):Resultado{
        //Es un empate
        if(elementoJugador==elementoComputadora){
            return Resultado.EMPATE
        }
        //Gana jugador
        when(elementoJugador){
            Elemento.PIEDRA->{
                if(elementoComputadora==Elemento.TIJERAS){
                    puntosJugador++
                    return Resultado.GANA_JUGADOR
                }
            }
            Elemento.PAPEL->{
                if(elementoComputadora==Elemento.PIEDRA){
                    puntosJugador++
                    return Resultado.GANA_JUGADOR
                }
            }
            Elemento.TIJERAS->{
                if(elementoComputadora==Elemento.PAPEL){
                    puntosJugador++
                    return Resultado.GANA_COMPUTADORA
                }
            }
        }
        //Gana Computadora
        puntosComputadora++
        return Resultado.GANA_COMPUTADORA
    }
    /**
     * Prueba si algun jugador gana la partida
     */
    private val PUNTOS_GANA =5
    fun probarGanador(): Ganador{
        if(puntosJugador==PUNTOS_GANA){
            return Ganador.JUGADOR
        } else if(puntosComputadora==PUNTOS_GANA){
            return Ganador.COMPUTADORA
        }
        return Ganador.NO_HAY_GANADOR
    }
    /**
     * Regresa un Elemento aleatorio
     * return un Elemento al azar
     */
    fun generarElemento():Elemento{
        return Elemento.values().random()
    }
    /**
     * Restablece los marcadores de la partida
     */
    fun reset(){
        puntosJugador=0
        puntosComputadora=0
    }
}