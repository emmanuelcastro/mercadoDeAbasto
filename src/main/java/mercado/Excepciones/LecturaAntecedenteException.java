package mercado.Excepciones;

public class LecturaAntecedenteException extends RuntimeException {

    public LecturaAntecedenteException() {

        super("LA LECTURA MENOR AL MES ANTERIOR");

    }

}
