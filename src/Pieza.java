public abstract class Pieza {
    // ******* ATRIBUTOS *******
    boolean color; // true = BLANCO , false = NEGRO
    String nombre;

    // ******* CONSTRUCTORES *******
    public Pieza(boolean color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }

    // ******* GETTERS *******
    public boolean getColor() {
        return color;
    }

    public String getNombre() {
        return nombre;
    }

    // ******* MÉTODOS *******
    public abstract boolean validoMovimiento (Movimiento mov);

    public String pintarPieza() {
        return nombre;
    }

    public String toString() {
        return super.toString();
    }
}
