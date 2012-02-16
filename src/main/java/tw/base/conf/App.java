package tw.base.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        runWithXmlConf();
//        runWithJavaConf();
    }

    protected static void runWithXmlConf() throws BeansException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/tw/base/conf/application-context.xml");
        applicationContext.getBean(Greeter.class).welcomeVisitors();
    }

    protected static void runWithJavaConf() throws BeansException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        applicationContext.getBean(Greeter.class).welcomeVisitors();
    }
}
