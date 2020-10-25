package com.gavin.design_mode.visitor_mode;

//单个单子的接口
public interface Bill {
    void accept(FinanceOrderViewer viewer);
}
