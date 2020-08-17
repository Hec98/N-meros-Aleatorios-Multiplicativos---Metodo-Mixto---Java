package pkS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Captura {

    public String getString() throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
