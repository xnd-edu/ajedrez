public class Movimiento {
    // ******* ATRIBUTOS *******
    Posicion posInicial;
    Posicion posFinal;

    // ******* CONSTRUCTORES *******
    public Movimiento() {
        this.posInicial = new Posicion(0,0);
        this.posFinal = new Posicion(0,0);
    }

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    // ******* MÉTODOS *******
    public boolean esVertical() {
        return posInicial.getColumna() == posFinal.getColumna();
    }

    public boolean esHorizontal() {
        return posInicial.getFila() == posFinal.getFila();
    }

    public boolean esDiagonal() {
        return posInicial.getFila() != posFinal.getFila() && posInicial.getColumna() != posFinal.getColumna();
    }

    public int saltoHorizontal() {
        return posFinal.getColumna() - posInicial.getColumna();
    }

    public int saltoVertical() {
        return posFinal.getFila() - posInicial.getFila();
    }
}
