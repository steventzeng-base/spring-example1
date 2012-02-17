/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author steven
 */
@Component@Qualifier("kitty")
public class KittyWatch extends Watch{

    @Override
    public String getTime() {
        return "Kitty mau mau " + super.getTime();
    }
}
