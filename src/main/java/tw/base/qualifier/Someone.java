/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author steven
 */
@Component
public class Someone {

    private final Watch watch;

    @Autowired
    public Someone(Watch watch) {
        this.watch = watch;
    }

    public void watchTime() {
        System.out.println(watch.getTime());
    }
}
