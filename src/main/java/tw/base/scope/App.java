/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author steven
 */
public class App {

    public static void main(String[] args) {
        //final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SingletonConfig.class);
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PrototypeConfig.class);
        Person brian = applicationContext.getBean("Brian", Person.class);
        brian.eating();
        Person shirly = applicationContext.getBean("Shirly", Person.class);
        shirly.eating();
        Person david = applicationContext.getBean("David", Person.class);
        david.eating();
    }
}
