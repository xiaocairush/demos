package inject;

/**
 * Created by Administrator on 2016/3/28 0028.
 */
public class HelloWorld {

    public String sayHello() {
        return "hello world";
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {

            public void hello(){
                System.out.println("hello");
            }
            public void run() {
                try {
                    synchronized (this) {
                        this.wait();
                        hello();
                        this.notifyAll();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
    }

}
