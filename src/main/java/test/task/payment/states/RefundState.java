package test.task.payment.states;

import test.task.payment.BankServiceImpl;
import test.task.payment.Payment;

public class RefundState implements State {
    private static final double COMMISSION = 0.1;
    private final BankServiceImpl bankServiceImpl;

    public RefundState(BankServiceImpl bankServiceImpl) {
        this.bankServiceImpl = bankServiceImpl;
    }

    @Override
    public void handle(double amount, Payment payment) {
        bankServiceImpl.debit(amount + (amount * COMMISSION));
        payment.setState(new ClientState());
    }
}
