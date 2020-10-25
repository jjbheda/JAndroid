package com.gavin.design_mode.visitor_mode;
//经理类，查看账本的类之一
class Manager implements FinanceOrderViewer {

    @Override
    public void view(ConsumeBill bill) {
        System.out.println("经理查看本次支出:"+ bill.getAmount());
    }

    @Override
    public void view(IncomeBill bill) {
        System.out.println("经理查看本次收入:" + bill.getAmount());
    }
}
