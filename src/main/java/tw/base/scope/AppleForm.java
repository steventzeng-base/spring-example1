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
public class AppleForm {

    @Bean
    public Apple get() {
        return new Apple();
    }
}
