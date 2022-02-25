package com.shampre.demo12;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 */
public class Solution {
    public String intToRoman(int num) {
        if(num<0||num>3999){
            return null;
        }
        String[] numCharArrs = new String[4];
        int zeroNum = 0, remainder = 0;
        while (num > 0) {
            remainder = num % 10;
            numCharArrs[zeroNum] = convert(remainder, zeroNum);
            zeroNum++;
            num /= 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = zeroNum - 1; i >= 0; i--) {
            stringBuilder.append(numCharArrs[i]);
        }
        return stringBuilder.toString();
    }

/*    {
        I, II, III, IV, V, VI, VII, VIII, IX, X;//1-9
        XI, XII, XIII, XV, XVI, XVII, XVIII, XIX, XX;//11-19
        XXI,...,XXX;//21-29
        XXXI,...,XL;//31-39
        XLI,...,L;//41-49
        LI,...,LX;//51-59
        ...
        XCI,..,C;//91-99
    }*/

    private String convert(int remainder, int zeroNum) {
        String result = "";
        if (remainder > 0 && remainder < 4) {
            for (int i = 0; i < remainder; i++) {
                if (zeroNum == 0) {
                    result += "I";
                } else if (zeroNum == 1) {
                    result += "X";
                } else if (zeroNum == 2) {
                    result += "C";
                }else if(zeroNum == 3){
                    result += "M";
                }
            }
        } else if (remainder == 4) {
            if (zeroNum == 0) {
                result += "IV";
            } else if (zeroNum == 1) {
                result += "XL";
            } else if (zeroNum == 2) {
                result += "CD";
            }
        } else if (remainder == 5) {
            if (zeroNum == 0) {
                result += "V";
            } else if (zeroNum == 1) {
                result += "L";
            } else if (zeroNum == 2) {
                result += "D";
            }
        } else if (remainder > 5 && remainder < 9) {
            if (zeroNum == 0) {
                result += "V";
                for (int i = 0; i < remainder - 5; i++) {
                    result += "I";
                }
            } else if (zeroNum == 1) {
                result += "L";
                for (int i = 0; i < remainder - 5; i++) {
                    result += "X";
                }
            } else if (zeroNum == 2) {
                result += "D";
                for (int i = 0; i < remainder - 5; i++) {
                    result += "C";
                }
            }
        } else if (remainder == 9) {
            if (zeroNum == 0) {
                result += "IX";
            } else if (zeroNum == 1) {
                result += "XC";
            } else if (zeroNum == 2) {
                result += "CM";
            }
        }
        return result;
    }
}
