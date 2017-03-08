package cn.waldenlu.def;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ssscorch
 * @data
 * 比exebute更加完善了，但是还是有bug，不能处理1200这种整数
 */
public class ExeDemo {
	char[] word = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	char[] suff_int = { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿', '拾', '佰', '仟', '万' };
	char[] suff_deci = { '角', '分' };

	public StringBuffer toWord(char[] input, int intLen, int deciLen) {
		StringBuffer sBuffer = new StringBuffer();
		System.out.print("人名币");
		for (int i = 0; i < intLen; i++) {
			int index = input[i] - '0';

			// 是零
			if (index == 0) {
				// 零在万位
				if ((intLen - 5) == i) {
					sBuffer.append("万");
					// 零在亿位
				} else if ((intLen - 9) == i) {
					sBuffer.append("亿");
				} else {
					sBuffer.append(word[index]);
				}
				// 不是零
			} else {
				sBuffer.append(word[index]);
				sBuffer.append(suff_int[intLen - i - 1]);
			}

		}
		if (deciLen == 0)
			sBuffer.append("整");
		for (int i = 0; i < deciLen; i++) {
			int index = input[intLen + i + 1] - '0';
			if (index == 0) {

				sBuffer.append(word[index]);
			} else {

				sBuffer.append(word[index]);
				sBuffer.append(suff_deci[i]);
			}

		}
		return sBuffer;
	}

	// 处理重复的文字零
	public StringBuffer form(StringBuffer sBuffer) {
		StringBuffer outsb = new StringBuffer();
		String regEx = "零{2,}";
		// 编译正则表达式的字面值得到对应的模式Pattern对象
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(sBuffer);
		while (matcher.find()) {
			matcher.appendReplacement(outsb, "零");
		}
		matcher.appendTail(outsb);
		return outsb;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入金额并以回车结束。。。。。");
		String c = in.nextLine();
		in.close();

		Pretreatment pretreatment = new Pretreatment();
		if (pretreatment.isNum(c)) {
			char[] input = pretreatment.getOutput();
			int intLen = pretreatment.getIntLen();
			int deciLen = pretreatment.getDeciLen();

			ExeDemo exeDemo = new ExeDemo();
			StringBuffer s = exeDemo.toWord(input, intLen, deciLen);
			System.out.println();
			System.out.println(exeDemo.form(s));

		} else {
			System.out.println("输入有误");
		}
	}
}
