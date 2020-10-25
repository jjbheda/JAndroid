package com.gavin.design_mode.visitor_mode;

// 消费的单子
class ConsumeBill implements Bill {

    private double amount;
    private String item;

    public ConsumeBill(double amount, String item) {
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
