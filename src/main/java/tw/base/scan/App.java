package tw.base.scan;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.runWithAnno();
//        app.runWithXml();
    }

    protected void runWithAnno() throws IllegalStateException, BeansException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("tw.base.scan");
        applicationContext.refresh();
        Greeter greeter = applicationContext.getBean(Greeter.class);
        greeter.welcomeVisitors();
    }

    protected void runWithXml(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/tw/base/scan/application-context.xml");
        applicationContext.getBean(Greeter.class).welcomeVisitors();
    }
}
