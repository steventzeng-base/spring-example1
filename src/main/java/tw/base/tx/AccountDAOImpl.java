/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author steven
 */
public class AccountDAOImpl implements AccountDAO {

    private final JdbcTemplate template;

    public AccountDAOImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public int addNewOne(Account account) {
        return template.update("INSERT INTO ACCOUNT(NAME, AMOUNT)VALUES(?, ?)", account.getName(), account.getAmount());
    }

    @Override
    @Transactional
    public void addMoreNew(Account... accounts) {
        for (Account account : accounts) {
            addNewOne(account);
        }
    }

    @Override
    public int update(Account account) {
        return template.update("UPDATE ACCOUNT SET NAME= ?, AMOUNT = ? WHERE ID = ?", account.getName(), account.getAmount(), account.getId());
    }

    @Transactional(readOnly=true)
    @Override
    public Account findById(Long id) {
        return template.queryForObject("SELECT * FROM ACCOUNT WHERE ID = ?", ParameterizedBeanPropertyRowMapper.newInstance(Account.class), id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Account> listAll() {
        RowMapper<Account> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Account.class);
        return template.query("SELECT * FROM ACCOUNT", rowMapper);
    }
}
