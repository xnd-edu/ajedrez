/**
 * Clase del alfil, hija de la clase Pieza
 */
public class Alfil extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Alfil(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov) {
        return mov.esDiagonal();
    }
}
