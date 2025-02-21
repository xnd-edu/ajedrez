/**
 * Clase del peón, hija de la clase Pieza
 */
public class Peon extends Pieza {
    // ******* CONSTRUCTORES *******
    public Peon(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento(Movimiento mov, Tablero tablero) {
        if (mov.esVertical() && !tablero.hayPieza(mov.posFinal) && ((color && mov.posInicial.getFila() == 6 && (mov.saltoVertical() == -1 || mov.saltoVertical() == -2)) || (!color && mov.posInicial.getFila() == 1 && (mov.saltoVertical() == 1 || mov.saltoVertical() == 2)))) {
            return true;
        } else if (mov.esDiagonal()) {
            if (color) {
                return mov.saltoVertical() == -1 && tablero.hayPieza(mov.posFinal);
            } else {
                return mov.saltoVertical() == 1 && tablero.hayPieza(mov.posFinal);
            }
        } else
            return mov.esVertical() && (color && mov.saltoVertical() == -1 || !color && mov.saltoVertical() == 1);
    }
}
