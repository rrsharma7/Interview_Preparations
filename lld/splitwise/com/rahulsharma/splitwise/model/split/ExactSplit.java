package com.rahulsharma.splitwise.model.split;

import com.rahulsharma.splitwise.model.User;
import com.rahulsharma.splitwise.model.split.Split;

public class ExactSplit extends Split {

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }
}