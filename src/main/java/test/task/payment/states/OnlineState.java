package test.task.payment.states;

import org.springframework.stereotype.Service;
import test.task.payment.BankServiceImpl;
import test.task.payment.Payment;

@Service
public class OnlineState implements State {

    private static final double BONUS = 0.17;
    private static final double BIG_BONUS = 0.3;
    private final BankServiceImpl bankServiceImpl;

    public OnlineState(BankServiceImpl bankServiceImpl) {
        this.bankServiceImpl = bankServiceImpl;
    }

    @Override
    public void handle(double amount, Payment payment) {
        if (amount < 10) {
            payment.setState(new RefundState(bankServiceImpl));
        } else {
            bankServiceImpl.debit(amount);
            if (amount > 300) {
                bankServiceImpl.addBankAccountOfMoney(amount * BIG_BONUS);
            } else {
                bankServiceImpl.addBankAccountOfMoney(amount * BONUS);
            }
            payment.setState(new ClientState());
        }
    }
}
