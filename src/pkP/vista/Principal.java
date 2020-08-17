package pkP.vista;

import pkS.Captura;
import pkS.modelo.dto.VariablesDTO;
import pkS.modelo.dao.IngresoDataosDAO;
import pkS.modelo.implDAO.IngresarDatos;

public class Principal {

    public static void main(String arg[]) throws Exception {
        VariablesDTO dto = new VariablesDTO();
        IngresoDataosDAO dao = new IngresarDatos();
        int cilos = 0;
        do {
            System.out.println("Metodo mixto");
            System.out.println("Ingresa el valor de A");
            dao.IngresoA(dto);
            System.out.println("Ingresa el valor inicial de Xn");
            dao.IngresoXN(dto);
            System.out.println("Ingresa el valor de C");
            dao.IngresoC(dto);
            System.out.println("Ingresa el valor del modulo");
            dao.IngresoModulo(dto);
            dao.CalculoPSA(dto);
            cilos++;
        } while (dto.getI() != 100);
        System.out.println("Se generaron " + cilos + " ciclos");
    }
}
