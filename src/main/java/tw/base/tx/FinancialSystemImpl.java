/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author steven
 */
public class FinancialSystemImpl implements FinancialSystem {

    private AccountDAO accountDAO;

    private Long companyId;

    public FinancialSystemImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public Long getCompanyId() {
        return companyId;
    }

    @Override
    @Transactional
    public void salarying() {
        salarying(40000);
    }

    @Override
    @Transactional
    public void salarying(double salary) {
        for (Long id : new Long[]{2L, 3L, 4L, 5L}) {
            try {
                transfer(companyId, id, salary);
            } catch (TransferError e) {
                throw new SalaryingTransferError();
            }
        }
    }

    @Transactional
    @Override
    public void transfer(Long from, Long to, double amount) {
        try {
            Account fromAccount = accountDAO.findById(from);
            Account toAccount = accountDAO.findById(to);
            fromAccount.setAmount(fromAccount.getAmount() - amount);
            toAccount.setAmount(toAccount.getAmount() + amount);
            accountDAO.update(fromAccount);
            accountDAO.update(toAccount);
        } catch (DataAccessException e) {
            throw new TransferError();
        }
    }
}
