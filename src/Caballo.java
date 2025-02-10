public class Caballo extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Caballo(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov) {
        return false;
    }
}
