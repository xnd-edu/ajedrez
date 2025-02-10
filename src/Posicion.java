public class Posicion {
    // ******* ATRIBUTOS *******
    int fila;
    int columna;

    // ******* CONSTRUCTORES *******
    public Posicion() {
        this.fila = 0;
        this.columna = 0;
    }

    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    // ******* SETTERS *******
    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

   // ******* GETTERS *******
    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return this.columna;
    }

    // ******* MÉTODOS *******
    @Override
    public String toString() {
        return super.toString();
    }
}
