package tw.base.tx;

import java.util.List;

/**
 *
 * @author steven
 */
public interface HistroyDAO {

    List<String> list();

    void logSuccess(Account account);

    public void logFailure(Account account, String errorMessage);

}
