/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tw.base.qualifier.Someone;
import tw.base.qualifier.Watch;

/**
 * 變更原程式的預設綁定方式
 * @author steven
 */
@Configuration()
public class QualifierConfig {

    @Autowired
    @Qualifier("kitty")
    private Watch watch;

    @Bean(name = "kitty")
    public Someone someone() {
        return new Someone(watch);
    }
}
