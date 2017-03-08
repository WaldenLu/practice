package codetest;

import java.math.BigDecimal;

/**
* @author ssscorch
* @data   
*
*/
public class Lab1 {
	// 大写
    private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    // 单位
    private static final String[] CN_UPPER_INTEGER_UNIT = {"元",
            "拾", "佰", "仟", "万",
            "拾", "佰", "仟", "亿",
            "拾", "佰", "仟", "兆",
            "拾", "佰", "仟"};
    // 整
    private static final String CN_FULL = "整";
    // 负
    private static final String CN_NEGATIVE = "负";
    // 零元整
    private static final String CN_ZEOR_FULL = "零元" + CN_FULL;
    // 精度，精确到分
    private static final int MONEY_PRECISION = 2;

    public static String number2CN(BigDecimal money) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer subStringBuffer = new StringBuffer();
        int signum = money.signum();
        // 输入为“0”
        if ((signum == 0)) {
            return CN_ZEOR_FULL;
        }
        // 四舍五入，数值取到分位
        long count = money.movePointRight(MONEY_PRECISION)
                .setScale(0, BigDecimal.ROUND_HALF_UP).abs().longValue();
        System.out.println(count);
        // 得到金额小数部分
        long decimal = count % 100;
        System.out.println(decimal);
        // 数值
        int numUnit = 0;
        // 数值单位
        int numIndex = 0;
        // 万、亿、兆
        int zeroSize = 0;

        // 处理整数部分
        long number = count / 100;
        System.out.println(number);
        if (number > 0) {
            while (true) {
                int length = subStringBuffer.length();
                // 删掉元、万、亿、兆前的零
                if (zeroSize > 3) {
                    if ((subStringBuffer.substring(length - 2, length - 1).equals("零"))) {
                        subStringBuffer.delete(length - 2, length - 1);
                    }
                    zeroSize = 0;
                    stringBuffer.insert(0, subStringBuffer.toString());
                    subStringBuffer = new StringBuffer();
                    length = subStringBuffer.length();
                }
                // 若所有位处理完毕，退出循环
                if (number <= 0) {
                    if ((length != 0) && ((subStringBuffer.substring(length - 2, length - 1).equals("零")))) {
                        subStringBuffer.delete(length - 2, length - 1);
                    }
                    stringBuffer.insert(0, subStringBuffer.toString());
                    break;
                }

                // 每次取最后一位数
                numUnit = (int) (number % 10);
                if (length == 0) { // 插入元、万、亿、兆位
                    subStringBuffer.insert(0, CN_UPPER_INTEGER_UNIT[numIndex]);
                    subStringBuffer.insert(0, CN_UPPER_NUMBER[numUnit]);
                } else {
           
                    if (!((subStringBuffer.substring(0, 1).equals("零")) && (numUnit == 0))) {
                        if (numUnit != 0) {
                            subStringBuffer.insert(0, CN_UPPER_INTEGER_UNIT[numIndex]);
                        }
                        subStringBuffer.insert(0, CN_UPPER_NUMBER[numUnit]);
                    } else if (numIndex == 4) {
                        subStringBuffer.insert(0, "万");
                    } else if (numIndex == 8) {
                        subStringBuffer.insert(0, "亿");
                    } else if (numIndex == 12) {
                        subStringBuffer.insert(0, "兆");
                    }
                }
                number /= 10;
                ++numIndex;
                ++zeroSize;
            }
        }

//         处理小数部分
//         最后两位有四种情况：00 10 11 10
        if (decimal == 0) {
            stringBuffer.append(CN_FULL);
        } else if (decimal > 9) {
            stringBuffer.append(CN_UPPER_NUMBER[(int) (decimal / 10)]);
            stringBuffer.append("角");
            decimal %= 10;
            if (!(decimal == 0)) {
                stringBuffer.append(CN_UPPER_NUMBER[(int) decimal]);
                stringBuffer.append("分");
            }

        } else {
            if (!((count / 100) == 0)) {
                stringBuffer.append("零");
            }
            stringBuffer.append(CN_UPPER_NUMBER[(int) decimal]);
            stringBuffer.append("分");
        }

        if (signum < 0) {
            stringBuffer.insert(0, CN_NEGATIVE);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
    	String args1[] = {"1", "1001","1110","1000","1.1","1001.1","1110.1","1000.1","1.01","1001.01","1110.01","1000.01","1.11","1001.11","1110.11","1000.11"};
//                String s1 = "skfjlkdsa";
    	System.out.println(args1.length);
    	for (int i = 0; i < args1.length; i++) {
			String s1 = args1[i];
	
        final BigDecimal MAX = new BigDecimal("10000000000000000");
        final BigDecimal MIN = new BigDecimal("-10000000000000000");
        BigDecimal numberOfMoney = new BigDecimal(s1);
        if (numberOfMoney.compareTo(MAX) > 0) {
            System.out.println("最大支持金额为 9999 9999 9999 9999.99");
            System.exit(0);

        } else if (numberOfMoney.compareTo(MIN) < 0) {

            System.out.println("最小支持金额为 -9999 9999 9999 9999.99");
            System.exit(0);
        }
        String s2 = Lab1.number2CN(numberOfMoney);
        System.out.println("你输入的金额为：" + s1 + "\n人民币大写为[" + s2.toString() + "]");
    	}
        
    }
}
