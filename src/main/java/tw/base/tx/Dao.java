/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author steven
 */
public class Dao {

    private final JdbcTemplate template;
    public Dao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    public int insert() {
        return 0;
    }
}
