package com.gavin.design_mode.visitor_mode;

//会计类
public class Accountant implements FinanceOrderViewer {

    @Override
    public void view(ConsumeBill bill) {

        if (bill.getItem().equals("出口税费")) {
            System.out.println("会计查看出口税费，可能有退税政策:" + bill.getAmount());
        } else {
            System.out.println("会计查看本次花费:" + bill.getAmount());
        }
    }

    // 如果是收入，则所有的收入都要交税
    @Override
    public void view(IncomeBill bill) {
        System.out.println("会计查看本次收入:" + bill.getAmount());
    }
}
