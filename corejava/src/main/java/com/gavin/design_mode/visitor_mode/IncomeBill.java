package com.gavin.design_mode.visitor_mode;

// 收入单子
public class IncomeBill implements Bill{
    private double amount;

    private String item;

    public IncomeBill(double amount, String item) {
        super();
        this.amount = amount;
        this.item = item;
    }

    @Override
    public void accept(FinanceOrderViewer viewer) {
        viewer.view(this);
    }

    public double getAmount() {
        return amount;
    }

    public String getItem() {
        return item;
    }
}
