public class Tablero {
    // ******* ATRIBUTOS *******
    Pieza[][] tablero = new Pieza[8][8];

    // ******* CONSTRUCTORES *******
    public Tablero() {
        for (int i = 0; i < 8; i++) {
            tablero[1][i] = new Peon(false, "\u265F"); // Peones negros
            tablero[6][i] = new Peon(true, "\u2659"); // Peones blancos
        }

        // Torres
        tablero[0][0] = new Torre(false, "\u265C"); // Torre negra izquierda
        tablero[0][7] = new Torre(false, "\u265C"); // Torre negra derecha
        tablero[7][0] = new Torre(true, "\u2656");  // Torre blanca izquierda
        tablero[7][7] = new Torre(true, "\u2656");  // Torre blanca derecha

        // Caballos
        tablero[0][1] = new Caballo(false, "\u265E"); // Caballo negro izquierda
        tablero[0][6] = new Caballo(false, "\u265E"); // Caballo negro derecha
        tablero[7][1] = new Caballo(true, "\u2658");  // Caballo blanco izquierda
        tablero[7][6] = new Caballo(true, "\u2658");  // Caballo blanco derecha

        // Alfiles
        tablero[0][2] = new Alfil(false, "\u265D"); // Alfil negro izquierda
        tablero[0][5] = new Alfil(false, "\u265D"); // Alfil negro derecha
        tablero[7][2] = new Alfil(true, "\u2657");  // Alfil blanco izquierda
        tablero[7][5] = new Alfil(true, "\u2657");  // Alfil blanco derecha

        // Damas
        tablero[0][3] = new Reina(false, "\u265B"); // Reina negra
        tablero[7][3] = new Reina(true, "\u2655");  // Reina blanca

        // Reyes
        tablero[0][4] = new Rey(false, "\u265A"); // Rey negro
        tablero[7][4] = new Rey(true, "\u2654");  // Rey blanco
    }

    // ******* MÉTODOS *******
    public void pintarTablero() {
        // Imprimir los números de las columnas
        for (int i = 0; i < tablero.length; i++) {
            if (i == 0)
                System.out.print("  \u2006\u2006");
            System.out.print((i + 1) + "\u2006 ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                // Imprimir las letras de las filas
                if (j == 0) {
                    System.out.print((char) ('A' + i) + " ");
                }

                if (hayPieza(i,j)) {
                    System.out.print("\u2006\u2006" + devuelvePieza(i,j).pintarPieza()); // \u2006 es un espacio para centrar las piezas mas
                } else {
                    if ((i + j) % 2 == 0) {
                        System.out.print(" \u25A1"); // Cuadrado blanco
                    } else {
                        System.out.print(" \u25A0"); // Cuadrado negro
                    }
                }
            }
            System.out.println();
        }
    }

    public boolean hayPieza(int fila, int columna) {
        return tablero[fila][columna] != null;
    }

    public boolean hayPieza(Posicion pos) {
        return hayPieza(pos.getFila(), pos.getColumna());
    }

    public boolean hayPiezasEntre(Movimiento mov) {
        boolean piezaDetectada = false;
        int filaInicialMov = mov.posInicial.getFila();
        int columnaInicialMov = mov.posInicial.getColumna();
        int filaFinalMov = mov.posFinal.getFila();
        int columnaFinalMov = mov.posFinal.getColumna();

        if (mov.esVertical()) {
            if (filaFinalMov < filaInicialMov) {
                int aux = filaFinalMov;
                filaFinalMov = filaInicialMov;
                filaInicialMov = aux;
            }
            for (int i = filaInicialMov + 1; i < filaFinalMov; i++) {
                if (hayPieza(i, columnaInicialMov))
                    piezaDetectada = true;
            }
        } else if (mov.esHorizontal()) {
            if (columnaFinalMov < columnaInicialMov) {
                int aux = columnaFinalMov;
                columnaFinalMov = columnaInicialMov;
                columnaInicialMov = aux;
            }
            for (int i = columnaInicialMov + 1; i < columnaFinalMov; i++) {
                if (hayPieza(filaInicialMov, i))
                    piezaDetectada = true;
            }
        } else if (mov.esDiagonal()) {
            if (filaFinalMov < filaInicialMov) {
                int aux = filaFinalMov;
                filaFinalMov = filaInicialMov;
                filaInicialMov = aux;
            }
            if (columnaFinalMov < columnaInicialMov) {
                int aux = columnaFinalMov;
                columnaFinalMov = columnaInicialMov;
                columnaInicialMov = aux;
            }
            for (int i = filaInicialMov + 1; i < filaFinalMov; i++) {
                for (int j = columnaInicialMov + 1; j < columnaFinalMov + 2; j++) {
                    if (hayPieza(i, j))
                        piezaDetectada = true;
                }
                columnaInicialMov++;
            }
        }

        return piezaDetectada;
    }

    public void ponPieza (Pieza figura, int fila, int columna) {
        tablero[fila][columna] = figura;
    }

    public void ponPieza (Pieza figura, Posicion pos) {
        ponPieza(figura, pos.getFila(), pos.getColumna());
    }

    public void quitaPieza (int fila, int columna) {
        tablero[fila][columna] = null;
    }

    public void quitaPieza (Posicion pos) {
        quitaPieza(pos.getFila(), pos.getColumna());
    }

    public Pieza devuelvePieza (int fila, int columna) {
        return tablero[fila][columna];
    }

    public Pieza devuelvePieza (Posicion pos) {
        return devuelvePieza(pos.getFila(), pos.getColumna());
    }
}
