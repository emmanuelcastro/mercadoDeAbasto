package mercado.Excepciones;

public class ContratoNoExisteException extends RuntimeException {

    public ContratoNoExisteException() {

        super("EL CONTRATO NO EXISTE");

    }

}
