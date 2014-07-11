/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import java.util.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author steven
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
//NOT_SUPPORTED 結果與 REQUIRES_NEW 結果相依，但義意不同
//SUPPORTS 與 REQUIRED 結果相同，但義意也不同
public class HistoryDAOImpl implements HistroyDAO {

    private final JdbcTemplate template;

    public HistoryDAOImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public void logSuccess(Account account) {
        template.update("INSERT INTO LOG(NAME, MESSAGE, logtime)VALUES(?, ?, ?)", account.getName(), "Success", new Date());
    }

    @Override
    public void logFailure(Account account, String errorMessage) {
        template.update("INSERT INTO LOG(NAME, MESSAGE, logtime)VALUES(?, ?, ?)", account.getName(), "Failure " + errorMessage, new Date());
    }

    @Override
    public List<String> list() {
        List<Map<String, Object>> result = template.queryForList("SELECT * FROM LOG");
        if (result.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> records = new ArrayList<>();
        for (Map<String, Object> row : result) {
            records.add(String.format("name: %s message:%s : %tF %<tT %<tL", row.get("NAME"), row.get("MESSAGE"), (Date) row.get("LOGTIME")));
        }
        return records;
    }
}
