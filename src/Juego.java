/**
 * Clase que maneja los turnos y las jugadas
 */
public class Juego {
    private boolean elTurno; // Como el color de pieza: true = BLANCAS , false = NEGRAS

    /**
     * Constructor del juego. El turno por defecto es true (blancas).
     */
    public Juego() {
        this.elTurno = true;
    }

    /**
     * Devuelve el turno actual
     * @return El turno (true = turno blancas, false = turno negras)
     */
    public boolean getTurno() {
        return elTurno;
    }

    /**
     * Cambia el turno del juego
     * @param elTurno El turno (true = turno blancas, false = turno negras)
     */
    public void setTurno(boolean elTurno) {
        this.elTurno = elTurno;
    }

    /**
     * Método que valida y convierte la jugada introducida por el usuario a un movimiento
     * @param jugada Coordenadas introducidas por el usuario (Ej: A2B3)
     * @param tablero Tablero donde se ejecuta la jugada
     * @param strings Sistema de strings para la localización
     * @return Movimiento de la pieza. Si el movimiento es nulo es que no es válido.
     */
    public Movimiento jugada(String jugada, Tablero tablero, Strings strings) {
        Movimiento mov = null;
        String idioma = strings.getIdioma();

        // La jugada debe tener 4 caracteres
        if (jugada.length() != 4)
            System.out.println(strings.toString(idioma, "errLongitudJugada"));
        // Los caracteres pares deben ser letras de de la A a la H
        else if (jugada.charAt(0) < 'A' || jugada.charAt(0) > 'H' || jugada.charAt(2) < 'A' || jugada.charAt(2) > 'H')
            System.out.println(strings.toString(idioma, "errFormato"));
        // Los caracteres impares deben ser números del 1 al 8
        else if (jugada.charAt(1) < '1' || jugada.charAt(1) > '8' || jugada.charAt(3) < '1' || jugada.charAt(3) > '8')
            System.out.println(strings.toString(idioma, "errFormato"));
        else {
            // Transformar el string
            int filaInicial = jugada.charAt(0) - 'A';
            int columnaInicial = jugada.charAt(1) - '1';
            int filaFinal = jugada.charAt(2) - 'A';
            int columnaFinal = jugada.charAt(3) - '1';

            // Crear las posiciones del movimiento
            Posicion posInicial = new Posicion(filaInicial, columnaInicial);
            Posicion posFinal = new Posicion(filaFinal, columnaFinal);

            // Debe haber una pieza en la posición inicial, si no que estás moviendo?
            if (!tablero.hayPieza(posInicial)) {
                System.out.println(strings.toString(idioma, "errNoPieza"));
                // El color de la pieza debe ser del turno del mismo color, tramposo
            } else if (tablero.devuelvePieza(posInicial).getColor() != getTurno()) {
                System.out.println(strings.toString(idioma, "errColorIncorrecto"));
            } else if (tablero.hayPieza(posFinal)) {
                if (tablero.devuelvePieza(posFinal).getColor() == getTurno())
                    System.out.println(strings.toString(idioma, "errCanibal"));
            } else {
                // Si todo va bien crea una instancia del movimiento
                mov = new Movimiento(posInicial, posFinal);
            }
        }
        return mov;
    }
}
