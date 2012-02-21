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
public interface AccountDAO {

    int addNewOne(Account account);

    List<Account> listAll();

    void addMoreNew(Account... accounts);

    int update(Account account);

    Account findById(Long id);
}
