/**
 * Clase del peón, hija de la clase Pieza
 */
public class Peon extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Peon(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov) {
        return false;
    }
}
