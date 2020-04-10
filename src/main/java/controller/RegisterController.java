package controller;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

public class RegisterController implements PosController {
	@Override
	public void run() {
		OutputView.printTables(TableRepository.tables());
		Table table = TableRepository.findById(InputView.inputTableNumber());
		OutputView.printMenus(MenuRepository.menus());
		Menu menu = MenuRepository.findById(InputView.inputMenuId());
		table.addOrder(menu, InputView.inputMenuCount());
	}
}
