package test.task.payment;

import test.task.payment.states.ClientState;
import test.task.payment.states.State;

public class Payment {
    private State state = new ClientState();

    public void doPayment(double amount) {
        do {
            state.handle(amount, this);
        } while (!(state instanceof ClientState));
    }

    public void setState(State state) {
        this.state = state;
    }
}
