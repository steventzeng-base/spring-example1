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

    private final AccountDAO accountDAO;

    private final HistroyDAO histroyDAO;

    private Long companyId;
    
    private long[] employeeIds;

    public FinancialSystemImpl(AccountDAO accountDAO, HistroyDAO histroyDAO) {
        this.accountDAO = accountDAO;
        this.histroyDAO = histroyDAO;
    }

    @Override
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public void setEmpoyeesIds(long... ids) {
        this.employeeIds = ids;
    }
    
    

    /**
     * 發薪資
     */
    @Override
    @Transactional
    public void salarying() {
        salarying(40000);
    }

    @Override
    @Transactional
    public void salarying(double salary) {
        for (Long id : this.employeeIds) {
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
            Account fromAccount = accountDAO.findById(from);
            Account toAccount = accountDAO.findById(to);
        try {
            fromAccount.setAmount(fromAccount.getAmount() - amount);
            toAccount.setAmount(toAccount.getAmount() + amount);
            accountDAO.update(fromAccount);
            accountDAO.update(toAccount);
        } catch (DataAccessException e) {
            histroyDAO.logFailure(toAccount, e.getMessage());
            throw new TransferError();
        }
        histroyDAO.logSuccess(toAccount);
    }
}
