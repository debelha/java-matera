package collections.lista;

import java.util.ArrayList;
import java.util.List;

public class TesteLista {
    public static void main(String[] args) {

        List<String> contas = new ArrayList<>();

        contas.add("Conta Poupança");
        contas.add("Conta Corrente");
        contas.add("Conta Pagamento");
        contas.add("Conta Poupança");

        System.out.println("Conta 1: " + contas.get(0));
        System.out.println("Conta 2: " + contas.get(1));
        System.out.println("Conta 3: " + contas.get(2));
        System.out.println("Conta 3: " + contas.get(3));

    }
}
