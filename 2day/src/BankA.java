public class BankA extends Bank{

    @Override
    protected int getBalance() {
        System.out.println("Bank A has an amount of "+setDepositAmount(1000)+"$");
        return 0;
    }
}
