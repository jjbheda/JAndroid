package com.gavin.design_mode.visitor_mode;

import java.util.ArrayList;
import java.util.List;

// 账本类
public class FinanceOrder {
    // 单子列表
    private List<Bill> billList = new ArrayList<>();

    // 添加单子
    public void addBill(Bill bill) {
        billList.add(bill);
    }

    // 供账本的查看者查看账本
    public void show(FinanceOrderViewer viewer) {
        for (Bill bill : billList) {
            bill.accept(viewer);
        }
    }
}
