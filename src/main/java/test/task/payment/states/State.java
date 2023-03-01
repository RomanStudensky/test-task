package test.task.payment.states;

import test.task.payment.Payment;

public interface State {

    void handle(double amount, Payment payment);
}
