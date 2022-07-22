package mercado.Excepciones;

public class CobrableNoExisteException extends RuntimeException {

    public CobrableNoExisteException() {

        super("EL CONCEPTO DE COBRO NO EXISTE");

    }

}
