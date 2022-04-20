package com.rahulsharma.splitwise.model.expense;

import com.rahulsharma.splitwise.model.User;
import com.rahulsharma.splitwise.model.split.ExactSplit;
import com.rahulsharma.splitwise.model.split.PercentSplit;
import com.rahulsharma.splitwise.model.split.Split;

import java.util.List;

public class PercentageExpense extends Expense {

    public PercentageExpense(double amount, User expensePaidBy, List<Split> splits, ExpenseData expenseData) {
        super(amount, expensePaidBy, splits, expenseData);
    }

    @Override
    public boolean validate() {
        double totalSplitPercent = 0;
        for(Split split: getSplits()){
            if(!(split instanceof PercentSplit)) return false;
            PercentSplit percentSplit = (PercentSplit) split;
            totalSplitPercent+=percentSplit.getPercent();
        }
        return 100 == totalSplitPercent;
    }
}
