/**
 * Created by minjian.cai on 2014/10/10.
 */
interface HasBatteries{}
interface WaterProof{}
interface Shoots {}
class Toy{
    Toy(){}
    Toy(int i){}
}
class FancyToy extends Toy implements HasBatteries,WaterProof,Shoots{
    FancyToy(){
        super(1);
    }
}
public class ToyTest {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("不能初始化");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("不能访问");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }

    private static void printInfo(Class c) {
        System.out.println("class name: "+c.getName() +
        " is interface?["+c.isInterface()+"]"
        );
        System.out.println("simple name:"+c.getSimpleName());
        System.out.println("Canonical name:"+c.getCanonicalName());
    }
}
