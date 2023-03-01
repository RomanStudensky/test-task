package test.task.payment;

public interface BankService {

    void doShopPayment(double amount);
    void doOnlinePayment(double amount);
    double getMoney();
    double getBankAccountOfEMoney();
}
