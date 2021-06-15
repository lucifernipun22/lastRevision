public class BankC extends Bank{
    @Override
    protected int getBalance() {
        System.out.println("Bank C has an amount of "+setDepositAmount(2050)+"$");
        return 0;
    }
}
