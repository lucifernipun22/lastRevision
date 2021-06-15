public class BankB extends Bank {
    @Override
    protected int getBalance() {
        System.out.println("Bank B has an amount of "+setDepositAmount(140)+"$");;
        return 0;
    }
}
