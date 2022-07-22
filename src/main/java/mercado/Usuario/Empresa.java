package mercado.Usuario;

import java.util.ArrayList;

public class Empresa extends Cliente {

    private Integer cuil;
    ArrayList<Contrato> contratos;

    public Empresa(Integer numeroDeCliente, String razonSocial, String provincia, String localidad,
            String direccionDeCorreoElectronico) {

        super(numeroDeCliente, razonSocial, provincia, localidad, direccionDeCorreoElectronico);

        contratos = new ArrayList<Contrato>();

    }

    public Integer getCuil() {
        return cuil;
    }

    public void setCuil(Integer cuil) {
        this.cuil = cuil;
    }

}