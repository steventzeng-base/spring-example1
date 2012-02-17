/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.qualifier;

import tw.base.QualifierConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author steven
 */
public class App {
    public static void main(String[] args) {
        //Use default config
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("tw.base.qualifier");
        applicationContext.refresh();
        applicationContext.getBean( Someone.class).watchTime();

        //alter default config
        applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("tw.base.qualifier");
        applicationContext.register(QualifierConfig.class);
        applicationContext.refresh();
        applicationContext.getBean("kitty", Someone.class).watchTime();
    }
}
