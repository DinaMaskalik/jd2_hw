package it.academy.copy;

import it.academy.data.Expenses;

import java.util.List;

public class CopyOfExpensesList {

    public String[] getStringArrayFoExpensesList(List<Expenses> expensesList){
        int count=0;
        String[] expensesArray = new String[expensesList.size()];
        for (Expenses item: expensesList) {
            expensesArray[count]=item.toString();
            count++;
        }

        return expensesArray;
    }
}
