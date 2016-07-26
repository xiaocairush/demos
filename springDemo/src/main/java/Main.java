import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/5/7 0007.
 */
public class Main {

    static int n,m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        if( m == 0) {
            System.out.println(n-1);
            return ;
        }
        int l = n+1,r=0;
        for(int i=0;i<m;i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if(b>a) {
                int t = a;
                a = b;
                b = t;
            }
            l = Math.min(a,l);
            r = Math.max(b,r);
        }
        int c = l - r - 1;
        if(c < 0)
            System.out.println(0);
        else {
            BigInteger bigInt = new BigInteger("2");
            System.out.println(bigInt.pow(c));
        }
    }
}
