package test.task.payment.states;

import org.springframework.stereotype.Service;
import test.task.payment.BankServiceImpl;
import test.task.payment.Payment;

@Service
public class ShopState implements State {
    private static final double bonus = 0.1;
    private final BankServiceImpl bankServiceImpl;

    public ShopState(BankServiceImpl bankServiceImpl) {
        this.bankServiceImpl = bankServiceImpl;
    }

    @Override
    public void handle(double amount, Payment payment) {
        bankServiceImpl.debit(amount);
        bankServiceImpl.addBankAccountOfMoney(amount * bonus);
        payment.setState(new ClientState());
    }
}
