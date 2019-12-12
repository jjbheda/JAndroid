package com.gavin;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 */
public class Test {

        public static void main(String[] args) {
            List<Object> list = new ArrayList<>();
            list.add("aaaa");
            list.add(1);
            list.add(new Test());
        }


}
