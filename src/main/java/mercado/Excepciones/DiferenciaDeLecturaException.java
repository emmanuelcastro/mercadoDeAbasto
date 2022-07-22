package mercado.Excepciones;

public class DiferenciaDeLecturaException extends RuntimeException {

    public DiferenciaDeLecturaException() {

        super("LA LECTURA ES MENOR AL MES ESTABLECIDO");

    }

}
