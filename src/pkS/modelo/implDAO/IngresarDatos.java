package pkS.modelo.implDAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

import pkS.Captura;
import pkS.modelo.dao.IngresoDataosDAO;
import pkS.modelo.dto.VariablesDTO;

public class IngresarDatos implements IngresoDataosDAO {

    Random aleatorio = new Random(System.currentTimeMillis());
    Captura cap = new Captura();
    int com3, com2, com5;
    boolean comp = true, mC = true;
    String barra = File.separator;
    private String LocalizacionC = System.getProperty("user.dir") + barra + "../datosGenerados" + barra;

    @Override
    public void IngresoA(VariablesDTO dto) {
        do {
            try {
                dto.setVarA(aleatorio.nextInt(501));
            } catch (Exception e) {
                System.err.println(e.getMessage() + "\nIngresa Numeros enteros");
                try {
                    dto.setVarA(aleatorio.nextInt(501));
                } catch (Exception e1) {
                    System.err.println(e1.getMessage());
                }
            }

            com2 = dto.getVarA() % 2;
            com3 = dto.getVarA() % 3;
            com5 = dto.getVarA() % 5;
            if ((com2 == 0) || (com3 == 0) || (com5 == 0) || (dto.getVarA() < 1)) {
                comp = false;
                System.err.println("Ingresa un numeros positivos, que no se divisible de 2, 3 y 5");
            } else if ((com2 != 0) && (com3 != 0) && (com5 != 0) && (dto.getVarA() > 0)) {
                comp = true;
            }

        } while (comp != true);
    }

    @Override
    public void IngresoXN(VariablesDTO dto) {
        do {
            try {
                dto.setVarXn(aleatorio.nextInt(8501));
            } catch (Exception e) {
                System.err.println(e.getMessage() + "\nIngresa Numeros enteros");
                try {
                    dto.setVarXn(aleatorio.nextInt(8501));
                } catch (Exception e1) {
                    System.err.println(e.getMessage());
                }
            }
            if (dto.getVarXn() < 1) {
                comp = false;
                System.out.println("Ingresa numeros positivos");
            } else if (dto.getVarXn() < 8000) {
                comp = false;
            } else if (dto.getVarXn() > 0) {
                comp = true;
            }
        } while (comp != true);
        dto.setVarAuxiliarXn(dto.getVarXn());
    }

    @Override
    public void IngresoC(VariablesDTO dto) {
        do {
            try {
                dto.setVarC(aleatorio.nextInt(2001));
            } catch (Exception e) {
                System.err.println(e.getMessage() + "\nIngresa Numeros enteros");
                try {
                    dto.setVarC(aleatorio.nextInt(2001));
                } catch (Exception e1) {
                    System.err.println(e.getMessage());
                }
            }
            if (dto.getVarC() < 1) {
                comp = false;
                System.out.println("Ingresa numeros positivos");
            } else if (dto.getVarC() > 0) {
                comp = true;
            }
        } while (comp != true);
    }

    @Override
    public void IngresoModulo(VariablesDTO dto) {
        do {
            try {
                dto.setVarM(aleatorio.nextInt(10001));
            } catch (Exception e) {
                System.err.println(e.getMessage() + "\nIngresa Numeros enteros");
                try {
                    dto.setVarM(aleatorio.nextInt(10001));
                } catch (Exception e1) {
                    System.err.println(e.getMessage());
                }
            }
            if ((dto.getVarM() < dto.getVarA()) || (dto.getVarM() < dto.getVarXn()) || (dto.getVarM() < dto.getVarC())
                    || (dto.getVarM() < 1)) {
                mC = false;
                System.err.println("El modulo debe ser positivo y mayor que a, Xn y c");
            } else if ((dto.getVarM() > dto.getVarA()) && (dto.getVarM() > dto.getVarXn())
                    && (dto.getVarM() > dto.getVarC()) && (dto.getVarM() > 0)) {
                mC = true;
            }
        } while (mC != true);

    }

    @Override
    public boolean CalculoPSA(VariablesDTO dto) {
        try {
            File folder =new File(LocalizacionC);
            if(!folder.exists()){
                folder.mkdir();
            }
            File com = new File(LocalizacionC + "datosGXn.txt");
            File comXn = new File(LocalizacionC + "Xn.txt");
            if (com.exists() && comXn.exists()) {
                System.out.println("Simon :D");
                BufferedWriter bw = new BufferedWriter(new FileWriter(com));
                bw.write("");
                BufferedWriter bw1 = new BufferedWriter(new FileWriter(comXn));
                bw1.write("");
            }

            File datosXn = new File(LocalizacionC + "datosGXn.txt");
            FileWriter fc = new FileWriter(datosXn, true);
            PrintWriter pc = new PrintWriter(fc);

            File Xn = new File(LocalizacionC + "Xn.txt");
            FileWriter fx = new FileWriter(Xn, true);
            PrintWriter px = new PrintWriter(fx);
            int i = 0;
            dto.setI(0);
            System.out.println("______________________________________________________________");
            pc.println("______________________________________________________________");
            System.out.println("     n° " + "  Xn " + "    (" + "(" + dto.getVarA() + " * " + "Xn" + ")" + "+" + dto.getVarC() + ")" + " mod " + dto.getVarM() + "      Xn+1");
            pc.println("     n° " + "  Xn " + "    (" + "(" + dto.getVarA() + " * " + "Xn" + ")" + "+" + dto.getVarC() + ")" + " mod " + dto.getVarM() + "      Xn+1");
            System.out.println("______________________________________________________________");
            pc.println("______________________________________________________________");

            do {

                System.out.println("     " + (i) + "    " + dto.getVarXn() + "         "
                        + ((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) + " mod " + dto.getVarM() + "             "
                        + (((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) % dto.getVarM()));
                pc.println("     " + (i) + "    " + dto.getVarXn() + "         "
                        + ((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) + " mod " + dto.getVarM() + "             "
                        + (((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) % dto.getVarM()));
                System.out.println("______________________________________________________________");
                pc.println("______________________________________________________________");
                i++;
                dto.setI(i);
                if (dto.getI() > 100) {
                    return false;
                }
                dto.setVarXn2(((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) % dto.getVarM());
                dto.setVarXn(dto.getVarXn2());
                px.println(dto.getVarXn() / 10000);
            } while (dto.getVarXn() != dto.getVarAuxiliarXn());
            System.out.println("     " + (i) + "    " + dto.getVarXn() + "         "
                    + ((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) + " mod " + dto.getVarM() + "             "
                    + (((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) % dto.getVarM()));
            System.out.println("______________________________________________________________");
            pc.println("     " + (i) + "    " + dto.getVarXn() + "         "
                    + ((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) + " mod " + dto.getVarM() + "             "
                    + (((dto.getVarA() * dto.getVarXn()) + dto.getVarC()) % dto.getVarM()));
            pc.close();
            px.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
