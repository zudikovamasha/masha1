import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.printf("%n Введите точность (0;1): ");
        Scanner in = new Scanner(System.in);
        double accuracy = in.nextDouble();
        in.close ();
        if ((accuracy <= 0.0) | (accuracy >= 1.0)) {
            System.out.printf("%n Ошибка: неверно задана точность%n");
            return;
        }
        long k, k1, k2 = 0, kmax = 2147483647;
        double s2 = 0.0, s1, a = 0.0, a1, a2;
        for (k = 1; k <= kmax; k++) {
            k2 = k * 2;
            k1 = k2 - 1;
            a2 = (k2 * 2.0 + 100.0) / (k2 * 3.0 + 1.0);
            a1 = (k1 * 2.0 + 100.0) / (k1 * 3.0 + 1.0);
            a = a2 - a1;
            s2 += a;
            if ((-accuracy <= a) & (a <= accuracy))
                break;
        }
        k1 = k2 + 1;
        a1 = (k1 * 2.0 + 100.0) / (k1 * 3.0 + 1.0);
        s1 = s2 - a1;
        if (k > kmax)
            System.out.printf("%n Предупреждение: заданная точность не достигнута%n");
        System.out.printf("%n Сумма ряда %f Кол-во слагаемых %d Точность %f%n", s2, k2, (a < 0.0) ? -a : a);
        System.out.printf(" Сумма ряда %f Кол-во слагаемых %d (ряд не сходится)%n%n", s1, k1);
    }
}
