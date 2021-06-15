public abstract class Bank {


    protected double depositAmount;
        protected abstract int getBalance();


        protected double setDepositAmount(double amount){
            return this.depositAmount = amount;
        }
}
