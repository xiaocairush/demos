import java.util.Random;

/**
 * Created by minjian.cai on 2014/10/10.
 */
class Initable{
    static final int staticFinal = 47;
    static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
    static {
        System.out.println("初始化Initable");
    }

}
class Initable2{
    static int staticNonFinal = 147;
    static {
        System.out.println("初始化Initable2");
    }
}
class Initable3{
    static int staticNonFinal = 74;
    static {
        System.out.println("初始化Initable3");
    }

}
public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("after creating Initable ref");
        System.out.println(Initable.staticFinal);
        System.out.println(Initable.staticFinal2);
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("Initable3");
        System.out.println("after creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
}
