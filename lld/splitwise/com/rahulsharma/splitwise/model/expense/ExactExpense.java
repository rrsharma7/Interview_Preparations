package com.rahulsharma.splitwise.model.expense;

import com.rahulsharma.splitwise.model.User;
import com.rahulsharma.splitwise.model.split.EqualSplit;
import com.rahulsharma.splitwise.model.split.ExactSplit;
import com.rahulsharma.splitwise.model.split.Split;

import java.util.List;

public class ExactExpense extends Expense {

    public ExactExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        double totalAmount = getAmount();
        double totalSplitAmount = 0;
        for(Split split: getSplits()){
            if(!(split instanceof ExactSplit)) return false;
            ExactSplit exactSplit = (ExactSplit) split;
            totalSplitAmount+=exactSplit.getAmount();
        }
        return totalAmount == totalSplitAmount;
    }
}
