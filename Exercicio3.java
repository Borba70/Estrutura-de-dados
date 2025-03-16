import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da array: ");
        int n = scanner.nextInt();

        int[] A = new int[n];

        System.out.println("Digite os elementos da array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.print("Digite o valor de k: ");
        int k = scanner.nextInt();

        particionarArray(A, k);

        System.out.print("Array reorganizado: ");
        for (int num : A) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    public static void particionarArray(int[] A, int k) {
        int i = 0, j = 0;
        
        while (j < A.length) {
            if (A[j] <= k) {

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++; 
            }
            j++; 
        }
    }
}

