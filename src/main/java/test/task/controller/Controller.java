package test.task.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import test.task.payment.BankService;

@RestController
public class Controller {

    private final BankService bank;

    public Controller(BankService bank) {
        this.bank = bank;
    }

    @GetMapping("/api/payment/shop/{amount}")
    public void paymentShop(@PathVariable Double amount) {
        bank.doShopPayment(amount);
    }

    @GetMapping("/api/payment/online/{amount}")
    public void paymentOnline(@PathVariable Double amount) {
        bank.doOnlinePayment(amount);
    }

    @GetMapping("/api/bank-account-of-e-money")
    public double paymentShop() {
        return bank.getBankAccountOfEMoney();
    }

    @GetMapping("/api/money")
    public double paymentOnline() {
        return bank.getMoney();
    }
}
