package com.gavin.datastructure.leetcode.easy;

/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 *
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 */
class 二进制求和 {

   public static String addBinary(String a, String b) {
      StringBuffer ans = new StringBuffer();

      int n = Math.max(a.length(), b.length()),
              carry = 0;
      for (int i = 0; i < n; i++) {
         // 注意计算时，是从最后一位开始计算的，即从右向左计算。所以ans 存储的顺序是从低位开始存储，最后需要反转一下
         carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;  //若超出最大长度补0操作
         carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;  //若超出最大长度补0操作
         ans.append((char) (carry % 2 + '0'));
         carry /= 2;
      }

      if (carry > 0) {
         ans.append('1');
      }
      ans.reverse();

      return ans.toString();
   }

   public static void main(String[] args) {
      String result = addBinary("1010","1011");
      System.out.println(result);
   }


   public static String addBinary2(String a, String b) {
      StringBuffer ans = new StringBuffer();
      int n = Math.max(a.length(), b.length());
      int carry = 0;

      for (int i = 0; i < n; i++) {
         carry += i < a.length() ? (a.charAt(a.length() -1 -i) - '0') : 0;
         carry += i < b.length() ? (b.charAt(b.length() -1- i) - '0') : 0;
         ans.append((char)(carry % 2+ '0'));
         carry /= 2;
      }

      if (carry > 0) {
         ans.append('1');
      }

      ans.reverse();
      return ans.toString();
   }
}
