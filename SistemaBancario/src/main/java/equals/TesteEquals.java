package equals;

public class TesteEquals {
    public static void main(String[] args) {
        String nome1 = "deborah";
        String nome2 = "Deborah";
        String nome3 = new String("Deborah");

        System.out.println("nome1 == nome2: " + (nome1 == nome2));
        System.out.println("nome1 == nome3: " + (nome1 == nome3));
        System.out.println("nome1.equals(nome2): " + nome1.equals(nome2));
        System.out.println("nome1.equals(nome3): " + nome1.equals(nome3));
        System.out.println("nome1.equalsIgnoreCase(nome2): " + nome1.equalsIgnoreCase(nome2));
    }
}
