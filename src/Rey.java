public class Rey extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Rey(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov) {
        return false;
    }
}
