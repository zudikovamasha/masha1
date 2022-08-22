import java.util.Scanner;
import java.lang.Math;

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
        double i=1, imax = 2147483647;
        double s2 = 0.0, s1, a = 0.0, a1, a2, h;
        double is=Math.sqrt(i);
        double i1s=Math.sqrt(i-1);
        double c = -1;
        double ps=Math.pow(c, i);
        for (i = 1; i <= imax; i++) {
            h = -1*((is*(i-1))/(i*i1s));
            a1 = ps * (is/i);
            a2 = a1 * h;
            a = a2 - a1;
            s2 += a;
            if ((-accuracy <= a) & (a <= accuracy))
                break;
        }
        a1 = ps * (is/i);
        s1 = s2 - a1;
        if (i > imax)
            System.out.printf("%n Предупреждение: заданная точность не достигнута%n");
        System.out.printf("%n Сумма ряда %f Кол-во слагаемых %d Точность %f%n", s2, i, (a < 0.0) ? -a : a);
        System.out.printf(" Сумма ряда %f Кол-во слагаемых %d (ряд не сходится)%n%n", s1, i);
    }
}
