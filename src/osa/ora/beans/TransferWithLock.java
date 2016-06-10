package osa.ora.beans;

/**
 * Created by hme on 10/06/16.
 */
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Osama Oransa
 */
public class TransferWithLock implements Runnable {

    int id;
    AccountWithLock fromAccount;
    AccountWithLock toAccount;
    int amount;

    /**
     * constructor to create Transfer object
     *
     * @param id
     * @param fromAccount
     * @param toAccount
     * @param amonut
     */
    public TransferWithLock(int id, AccountWithLock fromAccount, AccountWithLock toAccount, int amonut) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.id = id;
        this.amount = amonut;
    }

    /**
     * Execution run() method of transfer
     */
    @Override
    public void run() {
        int transferAttempts = 1000;
        while (transferAttempts > 0) {
            if (fromAccount.transfer(fromAccount, toAccount, amount) == true) {;
                System.out.println("After Transfer #" + id + " First account=" + fromAccount.id + " balance now=" + fromAccount.balance);
                System.out.println("After Transfer #" + id + " second account=" + toAccount.id + " balance now=" + toAccount.balance);
                //break;
            }
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            } catch (InterruptedException e) {
            }
        }
    }

}
