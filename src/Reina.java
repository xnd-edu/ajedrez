public class Reina extends Pieza     {
    // ******* CONSTRUCTORES *******
    public Reina(boolean color, String nombre) {
        super(color, nombre);
    }

    // ******* MÉTODOS *******
    public boolean validoMovimiento (Movimiento mov) {
        return false;
    }
}
