package mercado.Usuario;

import java.util.ArrayList;

public class Quintero extends Cliente {

    private Integer dni;
    ArrayList<Contrato> contratos;

    public Quintero(Integer numeroDeCliente, String razonSocial, String provincia, String localidad,
            String direccionDeCorreoElectronico) {

        super(numeroDeCliente, razonSocial, provincia, localidad, direccionDeCorreoElectronico);

        contratos = new ArrayList<Contrato>();

    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

}