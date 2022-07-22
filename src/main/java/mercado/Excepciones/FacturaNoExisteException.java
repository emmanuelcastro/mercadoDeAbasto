package mercado.Excepciones;

public class FacturaNoExisteException extends RuntimeException {

    public FacturaNoExisteException() {

        super("FACTURA INEXISTENTE");

    }

}
