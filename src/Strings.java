public class Strings {
    private String idioma;

    public Strings() {
        this.idioma = "en";
    }

    public String getIdioma() {
        return this.idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String toString(String idioma, String string) {
        switch (this.idioma) {
            default:
                // Si no se especifica idioma usar el inglés
            case "en":
                switch (string) {
                    // Clase main
                    case "empezarJuego":
                        return "Starting game...";
                    case "turnoBlancas":
                        return "---------------------------------------\n|             WHITES turn             |\n---------------------------------------";
                    case "turnoNegras":
                        return "---------------------------------------\n|             BLACKS turn             |\n---------------------------------------";
                    case "introduceJugada":
                        return "Introduce move (Example: A2B3):";
                    case "errPiezasEnMedio":
                        return "Error: There are pieces in between.";
                    // Clase Juego
                    case "errLongitudJugada":
                        return "Error: The move must have 4 characters. (Example: A2B3)";
                    case "errFormato":
                        return "Error: Incorrect format.";
                    case "errNoPieza":
                        return "Error: There is no piece in that position.";
                    case "errColorIncorrecto":
                        return "Error: That piece does not belong to you.";
                    case "errCanibal":
                        return "Error: You cannot eat your own pieces.";
                }

            case "es":
                switch (string) {
                    // Clase main
                    case "empezarJuego":
                        return "Empezando el juego...";
                    case "turnoBlancas":
                        return "-----------------------------------------\n|             Turno BLANCAS             |\n-----------------------------------------";
                    case "turnoNegras":
                        return "-----------------------------------------\n|             Turno NEGRAS              |\n-----------------------------------------";
                    case "introduceJugada":
                        return "Introduce jugada (Ejemplo: A2B3):";
                    case "errPiezasEnMedio":
                        return "Error: Hay piezas en medio.";
                    // Clase Juego
                    case "errLongitudJugada":
                        return "Error: La jugada debe tener 4 caracteres. (Ejemplo: A2B3)";
                    case "errFormato":
                        return "Error: Formato incorrecto.";
                    case "errNoPieza":
                        return "Error: No hay ninguna pieza en esa posición.";
                    case "errColorIncorrecto":
                        return "Error: Esa pieza no te pertenece.";
                    case "errCanibal":
                        return "Error: No puedes comerte tus propias piezas.";

                }
        }
        return "STRING NOT LOCALISED";
    }
}
