package mercado.Excepciones;

public class CobrableExisteException extends RuntimeException {

    public CobrableExisteException() {

        super("EL CONCEPTO DE COBRO YA EXISTE");

    }

}
