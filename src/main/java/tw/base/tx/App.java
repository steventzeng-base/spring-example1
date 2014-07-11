/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tw.base.tx;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author steven
 */
public class App {

    ApplicationContext applicationContext;

    AccountDAO accountDAO;

    HistroyDAO histroyDAO;

    FinancialSystem financialSystem;

    public static void main(String[] args) {
        App app = new App();
        app.init();
//        app.demo();
//        app.addWithoutTx();
//        app.addWithTx();
//        app.salarying();
        app.bouns();

    }

    public void init() {
        applicationContext = new AnnotationConfigApplicationContext(Config.class);
        accountDAO = applicationContext.getBean(AccountDAO.class);
        histroyDAO = applicationContext.getBean(HistroyDAO.class);
        financialSystem = applicationContext.getBean(FinancialSystem.class);
        financialSystem.setCompanyId(1L);
        financialSystem.setEmpoyeesIds(2L, 3L, 4L, 5L);
    }

    /**
     * list initial db content
     */
    public void demo() {
        list(accountDAO.listAll());
    }

    /**
     * 新增一筆資料
     */
    public void addNewOneAccount() {
        accountDAO.addNewOne(new Account(null, "Tony", 10000));
        listData(accountDAO);
    }

    /**
     * 新增兩筆資料，沒有 transaction，其中一筆成功，但另一筆失敗
     */
    public void addWithoutTx() {
        list(accountDAO.listAll());
        try {
            //新增兩筆資料，沒有 transaction，其中一筆成功，但另一筆失敗
            accountDAO.addNewOne(new Account(null, "richlMan", 10000000));
            accountDAO.addNewOne(new Account(null, "poolMan", -10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        list(accountDAO.listAll());
    }

    /**
     * 新增兩筆資料，有 transaction，任一筆失敗都會造成失敗
     */
    public void addWithTx() {
        list(accountDAO.listAll());
        try {
            //新增兩筆資料，有 transaction，任一筆失敗都會造成失敗
            accountDAO.addMoreNew(new Account(null, "richlMan2", 10000000), new Account(null, "poolMan2", -10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        list(accountDAO.listAll());
    }

    /**
     * 發薪
     */
    public void salarying() {
        System.out.println("FinancilaSystem");
        System.out.println("發薪前");
        list(accountDAO.listAll());
        financialSystem.salarying();
        System.out.println("發薪後");
        list(accountDAO.listAll());
        list(histroyDAO.list());
    }

    public void bouns() {
        System.out.println("salary bonus");
        System.out.println("發薪前");
        list(accountDAO.listAll());

        //轉帳失敗，全部交易 rollback
        try {
            financialSystem.salarying(60000);
        } catch (SalaryingTransferError e) {
            System.out.println(e.getMessage());
        }
        printLine();
        System.out.println("發薪後");
        list(accountDAO.listAll());
        list(histroyDAO.list());
        printLine();
        
        System.out.println("公司進帳");
        financialSystem.transfer(6L, 1L, 10000000);
        //當全部成功時，才全部 commit
        try {
            financialSystem.salarying(60000);
        } catch (SalaryingTransferError e) {
            System.out.println(e.getMessage());
        }
        list(accountDAO.listAll());
        list(histroyDAO.list());
        printLine();
    }

    public static <T> void list(List<T> list) {
        printLine();
        for (T o : list) {
            System.out.println(o);
        }
        printLine();
    }

    private static void listData(AccountDAO dao) {
        printLine();
        for (Account account : dao.listAll()) {
            System.out.println(account);
        }
    }

    private static void printLine() {
        for (int i = 0; i < 40; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
}
