import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Digite o tamanho do array (maior ou igual a 2): ");
            int n = scanner.nextInt();

            if (n < 2) {
                System.out.println("O tamanho do array deve ser pelo menos 2.");
                return;
            }

            ArrayList<Integer> array = new ArrayList<>();

            System.out.println("Digite " + n + " números inteiros no intervalo de 1 a " + (n - 1) + ":");
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num < 1 || num >= n) {
                    System.out.println("Número fora do intervalo. Tente novamente.");
                    return;
                }
                array.add(num);
            }

            int repetido = encontrarRepetido(array);
            System.out.println("Número repetido = " + repetido);
        } finally {
            scanner.close();
        }
    }

    public static int encontrarRepetido(ArrayList<Integer> array) {
        ArrayList<Integer> visitado = new ArrayList<>();

        for (int num : array) {
            if (visitado.contains(num)) {
                return num; 
            }
            visitado.add(num);
        }

        return -1;
    }
}