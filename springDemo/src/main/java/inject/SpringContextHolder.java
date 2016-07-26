package inject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/3/28 0028.
 */
public class SpringContextHolder {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");

        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");

        System.out.println(helloWorld.sayHello());
    }

}
