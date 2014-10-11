/**
 * Created by minjian.cai on 2014/10/10.
 */

class Candy {
    static {
        System.out.println("loading Candy");
    }
}

class Gum {
    static {
        System.out.println("loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("loading Cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("after creating Candy");
        try {
//            看下源码
            Class.forName("Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Gum");
        }
        System.out.println("after Class.forName(\"Gum\")");
        new Cookie();
        System.out.println("after creating Cookie");
    }
}
