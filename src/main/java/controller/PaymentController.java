package controller;

import domain.Table;
import domain.TableRepository;
import domain.payment.ChickenDiscountPolicy;
import domain.payment.Payment;
import domain.payment.PaymentType;
import view.InputView;
import view.OutputView;

public class PaymentController implements PosController {
	@Override
	public void run() {
		OutputView.printTables(TableRepository.tables());
		Table table = TableRepository.findById(InputView.inputTableNumber());
		OutputView.printOrders(table);
		OutputView.printPaymentStart(table);
		PaymentType paymentType = PaymentType.of(InputView.inputPaymentId());
		Payment payment = new Payment(new ChickenDiscountPolicy(), paymentType, table);
		OutputView.printTotalMoney(payment.calculate());
		table.clear();
	}
}
