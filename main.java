import java.util.Scanner;
import java.util.Random;


class c_matrix{
    short[][] gen_matrix(int n, int m) {

        if (n <= 0 || m <= 0) {
            System.out.println(" \n Помилка! Розміри матриці були введені неправильно !");
            System.exit(0);
        }

        Random rand = new Random();
        short[][] b_matrix = new short[m][n];

        System.out.println(" \n Вміст згенерованої матриці В");

        for(int i = 0; i<m; i++){
            System.out.print(" |");
            for(int b = 0; b<n; b++){
                b_matrix[i][b] = (short) rand.nextInt(-20,20);
                System.out.print(" " + b_matrix[i][b] + " ");
            }
            System.out.println("| ");
        }
        return b_matrix;
    }

    short[][] calc_matrix(short[][] m_work, int a) {
        int len_x = m_work[0].length;
        int len_y = m_work.length;

        short[][] с_matrix = new short[len_y][len_x];

        System.out.println(" ");
        System.out.println(" Вміст матриці С");

        for(int i = 0; i<len_y; i++){
            System.out.print(" |");
            for(int b = 0; b<len_x; b++){
                с_matrix[i][b] = (short) (m_work[i][b] * (short) a);
                System.out.print(" " +с_matrix[i][b] + " ");
            }
            System.out.println("| ");
        }
        return с_matrix;
    }

    void max_min(short[][] m_work) {
        int len_x = m_work[0].length;
        int len_y = m_work.length;

        short sum_max = 0;
        short sum_min = 0;

        for(int i = 0; i<len_y; i++){

            if (((i+1)%2) == 0) {
                short local_max = m_work[i][0];
                for (int b = 0; b < len_x; b++) {
                    if (local_max < m_work[i][b]) {
                        local_max = m_work[i][b];
                    }
                }
                sum_max += local_max;
            } else{
                short local_mim = m_work[i][0];
                for (int b = 0; b < len_x; b++) {
                    if (local_mim > m_work[i][b]) {
                        local_mim = m_work[i][b];
                    }
                }
                sum_min += local_mim;
                }
            }
        System.out.println(" \nCума найбільших елементів в рядках матриці С з парними номерами = " + sum_max);
        System.out.println("Cума найменших елементів в рядках матриці С з непарними номерами = " + sum_min);
        }
    }



public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        c_matrix matrix = new c_matrix();

        System.out.println(" ");
        System.out.println("С5 = " + 1115 % 5);
        System.out.println("С7 = " + 1115 % 7);
        System.out.println("С11 = " + 1115 % 11);
        System.out.println(" \nДія з матрицею: C=a×B, a - const");
        System.out.println("Тип елементів матриці - short\n ");
        System.out.println("Введіть значення константи a");

        System.out.print("a: ");
        int a = scan.nextInt();
        System.out.println("Введіть розмір матриці B: ");
        System.out.print("Кількість стовпців n: ");
        int n = scan.nextInt();
        System.out.print("Кількість рядків m: ");
        int m = scan.nextInt();

        short[][] b_matrix = matrix.gen_matrix(n, m);
        short[][] c_matrix = matrix.calc_matrix(b_matrix, a);

        matrix.max_min(c_matrix);
    }
}