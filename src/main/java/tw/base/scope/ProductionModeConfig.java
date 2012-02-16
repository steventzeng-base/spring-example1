/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

import org.springframework.context.annotation.Bean;

/**
 *
 * @author steven
 */
public class ProductionModeConfig {

    @Bean
    public AppleForm appleForm() {
        return new AppleForm();
    }

    @Bean
    public Vendor vendor() {
        return new Vendor(appleForm());
    }
}
