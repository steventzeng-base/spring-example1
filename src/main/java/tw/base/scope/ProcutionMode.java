/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author steven
 */
public class ProcutionMode {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ProductionModeConfig.class);
        Vendor vendor = applicationContext.getBean(Vendor.class);
        for (int i = 0; i < 30; i++) {
            vendor.sell();
        }
    }
}
