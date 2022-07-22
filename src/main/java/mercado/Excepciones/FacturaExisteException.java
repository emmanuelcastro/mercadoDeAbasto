package mercado.Excepciones;

public class FacturaExisteException extends RuntimeException {

    public FacturaExisteException() {

        super("LA FACTURA EXISTE");

    }
}
