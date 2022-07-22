package mercado.Excepciones;

public class LecturaExisteException extends RuntimeException {

    public LecturaExisteException() {

        super("LECTURA YA REGISTRADA");

    }

}
