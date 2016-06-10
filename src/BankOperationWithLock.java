import osa.ora.beans.AccountWithLock;
import osa.ora.beans.TransferWithLock;

/**
 * @author Osama Oransa
 */
public class BankOperationWithLock {

    /**
     * main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankOperationWithLock bankTransfer = new BankOperationWithLock();
        bankTransfer.settleTransfers();
    }

    /**
     * settleTransfers method It run execute 2 concurrent transfers from same
     * to/from accounts
     */
    public void settleTransfers() {
        AccountWithLock firstAccount = new AccountWithLock();
        firstAccount.balance = 10000;
        firstAccount.id = 101;
        AccountWithLock secondAccount = new AccountWithLock();
        secondAccount.balance = 10000;
        secondAccount.id = 102;
        System.out.println("First account=" + firstAccount.id + " balance=" + firstAccount.balance);
        System.out.println("Second account=" + secondAccount.id + " balance=" + secondAccount.balance);
        TransferWithLock transfer1 = new TransferWithLock(1, firstAccount, secondAccount, 20);
        TransferWithLock transfer2 = new TransferWithLock(2, secondAccount, firstAccount, 15);
        Thread t1 = new Thread(transfer1);
        Thread t2 = new Thread(transfer2);
        t1.start();
        t2.start();
    }
}
