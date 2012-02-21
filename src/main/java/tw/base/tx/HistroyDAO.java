/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import java.util.List;

/**
 *
 * @author steven
 */
public interface HistroyDAO {

    List<String> list();

    void logSuccess();

    public void logFailure();

}
