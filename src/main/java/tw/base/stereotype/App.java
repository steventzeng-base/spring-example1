/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.stereotype;

import java.sql.SQLException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationScopeMetadataResolver;
import org.springframework.context.annotation.ScopedProxyMode;

/**
 *
 * @author steven
 */
public class App {

    public static void main(String[] args) {
        try {
            final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("tw.base.stereotype");
            applicationContext.setScopeMetadataResolver(new AnnotationScopeMetadataResolver(ScopedProxyMode.TARGET_CLASS));
            applicationContext.getBean(MyRepository.class).doSomeThing();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName());
        }
    }
}
