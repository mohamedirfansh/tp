package command.budget;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import service.BudgetManager;
import storage.DataManager;
import terminal.Ui;
import utils.Money;

import javax.xml.crypto.Data;
import java.util.concurrent.Callable;

import static constants.ErrorMessage.addBudgetErrorMsg;

@Command(name = "add", mixinStandardHelpOptions = true, description = "Adds a budget plan for the current month.")
public class AddBudgetCommand implements Callable<Integer> {

    @Option(names = {"-v", "--value"}, required = true, description = "Value of the current month's budget")
    Double value;

    @Override
    public Integer call() throws Exception {
        Ui ui = Ui.getUi();
        BudgetManager budgetMgr = BudgetManager.getBudgetMgr();
        DataManager dataMgr = DataManager.getDataMgr();

        try {
            Double budgetValue = Money.truncate(value);
            budgetMgr.addBudget(budgetValue);
            dataMgr.write();
        } catch (Exception error) {
            ui.printMessage(addBudgetErrorMsg);
            return 1;
        }
        return 0;
    }
}

