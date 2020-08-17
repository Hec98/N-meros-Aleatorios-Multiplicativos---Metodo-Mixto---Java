package pkS.modelo.dao;

import pkS.modelo.dto.VariablesDTO;

public interface IngresoDataosDAO {

    public void IngresoA(VariablesDTO dto);

    public void IngresoXN(VariablesDTO dto);

    public void IngresoC(VariablesDTO dto);

    public void IngresoModulo(VariablesDTO dto);

    public boolean CalculoPSA(VariablesDTO dto);
}
