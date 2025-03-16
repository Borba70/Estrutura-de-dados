import java.util.ArrayList;
import java.util.Scanner;

class Triangulo {
    double a, b, c; 

    Triangulo(double lado1, double lado2, double lado3) {
        if ((lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1)) {
            a = lado1;
            b = lado2;
            c = lado3;
        } else {
            System.out.println("Os valores informados não formam um triângulo válido.");
            a = b = c = 0;
        }
    }

    double calcularPerimetro() {
        return a + b + c;
    }

    double calcularArea() {
        double p = (a + b + c) / 2; 
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    double[] calcularCentroide() {
        double lambda = (a * a + b * b - c * c) / (2 * a * b);
        double x = (b + a * lambda) / 3;
        double y = (a / 3) * Math.sqrt(1 - lambda * lambda);

        return new double[]{x, y};
    }

    void exibirDados() {
        if (a == 0 || b == 0 || c == 0) {
            System.out.println("Triângulo inválido, não há dados para exibir.");
            return;
        }
        double[] centroide = calcularCentroide();
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("Centróide: (" + centroide[0] + ", " + centroide[1] + ")");
        System.out.println();
    }
}

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Triangulo> listaTriangulos = new ArrayList<>();

        System.out.print("Quantos triângulos deseja cadastrar? ");
        int quantidade = scanner.nextInt();

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite os três lados do triângulo " + (i + 1) + ":");
            double lado1 = scanner.nextDouble();
            double lado2 = scanner.nextDouble();
            double lado3 = scanner.nextDouble();

            Triangulo t = new Triangulo(lado1, lado2, lado3);
            listaTriangulos.add(t);
        }

        System.out.println("\nResultados:");
        for (Triangulo t : listaTriangulos) {
            t.exibirDados();
        }

        scanner.close();
    }
}