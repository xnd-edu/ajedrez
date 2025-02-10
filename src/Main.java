import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean finJuego = false;
        boolean valido = false;
        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        Scanner sc = new Scanner(System.in);
        Movimiento mov = new Movimiento();
        Strings strings = new Strings();
        String idioma = strings.getIdioma();

        System.out.println("Choose your language:");
        System.out.println("1. English");
        System.out.println("2. Español (Spanish)");
        int opcion = sc.nextInt();
        if (opcion == 1)
            strings.setIdioma("en");
        else if (opcion == 2)
            strings.setIdioma("es");
        System.out.println(strings.toString(idioma, "empezarJuego") + "\n");

        // Limpiar escáner
        sc.nextLine();

        do {
            if (juego.getTurno())
                System.out.println(strings.toString(idioma, "turnoBlancas"));
            else
                System.out.println(strings.toString(idioma, "turnoNegras"));

            tablero.pintarTablero();

            do {
                valido = false;
                System.out.println(strings.toString(idioma, "introduceJugada"));
                String jugada = sc.nextLine().toUpperCase();

                if (jugada.equals("QUIT") || jugada.equals("SALIR")) {
                    finJuego = true;
                    break;
                }

                mov = juego.jugada(jugada, tablero, strings);

                if (mov != null) {
                    if ((tablero.hayPiezasEntre(mov) && !tablero.devuelvePieza(mov.posInicial).getNombre().equals("\u265E")) || (tablero.hayPiezasEntre(mov) && !tablero.devuelvePieza(mov.posInicial).getNombre().equals("\u2658")))
                        System.out.println(strings.toString(idioma, "errPiezasEnMedio"));
                    else
                        valido = true;
                }
            } while (!valido);

            tablero.ponPieza(tablero.devuelvePieza(mov.posInicial), mov.posFinal);
            tablero.quitaPieza(mov.posInicial);

            juego.setTurno(!juego.getTurno());
        } while (!finJuego);
    }
}
