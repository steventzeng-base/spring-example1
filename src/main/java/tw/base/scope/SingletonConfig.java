/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author steven
 */
@Configuration
public class SingletonConfig {

    @Bean
    public Apple apple() {
        return new Apple();
    }

    @Bean(name = "Brian")
    public Person brian() {
        return new Person("Brian", apple());
    }

    @Bean(name = "David")
    public Person david() {
        return new Person("David", apple());
    }

    @Bean(name = "Shirly")
    public Person shirly() {
        return new Person("Shirly", apple());
    }
}
