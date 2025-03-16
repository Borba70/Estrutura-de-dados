import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o tamanho da array (maior ou igual a 3): ");
            int n = scanner.nextInt();

            if (n < 3) {
                System.out.println("O tamanho da array deve ser pelo menos 3.");
                return;
            }

            ArrayList<Integer> array = new ArrayList<>();

            System.out.println("Digite " + n + " números inteiros:");
            for (int i = 0; i < n; i++) {
                array.add(scanner.nextInt());
            }

            boolean existe = verificaSomaAnterior(array);

            if (existe) {
                System.out.println("Existe um elemento que é a soma de dois anteriores.");
            } else {
                System.out.println("Nenhum elemento é a soma de dois anteriores.");
            }
        } finally {
            scanner.close();
        }
    }

    public static boolean verificaSomaAnterior(ArrayList<Integer> array) {
        int n = array.size();

        for (int i = 2; i < n; i++) {
            int atual = array.get(i);

            for (int j = 0; j < i - 1; j++) {
                for (int k = j + 1; k < i; k++) {
                    if (array.get(j) + array.get(k) == atual) {
                        return true; 
                    }
                }
            }
        }

        return false; 
    }
}
