/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.qualifier;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author steven
 */
@Component
public class Watch {

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
