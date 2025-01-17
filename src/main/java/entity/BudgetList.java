package entity;

import java.util.ArrayList;

public class BudgetList {
    private static ArrayList<Budget> budgets = new ArrayList<>();

    public static void addBudget(Budget newBudget) {
        budgets.add(newBudget);
    }

    public static void deleteBudget() {
        budgets.remove(budgets.size() - 1);
    }

    public static ArrayList<Budget> getBudgets() {
        return budgets;
    }
}
