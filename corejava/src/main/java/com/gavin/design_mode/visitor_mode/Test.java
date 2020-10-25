package com.gavin.design_mode.visitor_mode;

class Test {
    public static void main(String[] args) {
        FinanceOrder accountBook = new FinanceOrder();

        // 添加两条收入
        accountBook.addBill(new IncomeBill(10000,"出口贸易"));
        accountBook.addBill(new IncomeBill(12000,"租赁库房"));

        // 添加两条支出
        accountBook.addBill(new ConsumeBill(1000,"出口税费"));
        accountBook.addBill(new ConsumeBill(2000,"材料费"));

        FinanceOrderViewer manager = new Manager();
        FinanceOrderViewer accountant = new Accountant();

        // 两个访问者分别访问账本
        accountBook.show(manager);
        accountBook.show(accountant);

    }
}
