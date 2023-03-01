package test.task.payment;

import org.springframework.stereotype.Service;
import test.task.payment.states.OnlineState;
import test.task.payment.states.ShopState;

@Service
public class BankServiceImpl implements BankService{

    private double bankAccountOfEMoney = 0.;
    private double money = 5000.;

    @Override
    public void doShopPayment(double amount) {
        Payment payment = new Payment();
        payment.setState(new ShopState(this));
        payment.doPayment(amount);
    }

    @Override
    public void doOnlinePayment(double amount) {
        Payment payment = new Payment();
        payment.setState(new OnlineState(this));
        payment.doPayment(amount);
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public double getBankAccountOfEMoney() {
        return bankAccountOfEMoney;
    }

    public void addBankAccountOfMoney(double amount) {
        bankAccountOfEMoney += amount;
    }

    public void debit(double amount) {
        money -= amount;
    }
}
