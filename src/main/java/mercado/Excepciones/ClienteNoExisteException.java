package mercado.Excepciones;

public class ClienteNoExisteException extends RuntimeException {

    public ClienteNoExisteException() {

        super(" EL CLIENTE NO EXISTE");

    }

}
