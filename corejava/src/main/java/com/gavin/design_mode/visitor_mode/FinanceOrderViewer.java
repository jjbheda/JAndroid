package com.gavin.design_mode.visitor_mode;

// 账单查看者接口（相当于Visitor）
public interface FinanceOrderViewer {
    // 查看消费的单子
    void view(ConsumeBill bill);

    // 查看收入的单子
    void view(IncomeBill bill);
}
