/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.stereotype;

import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author steven
 */
@Repository
public class MyRepository {
    public void doSomeThing() throws SQLException{
        throw new java.sql.SQLException();
    }
}
