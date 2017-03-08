package cn.waldenlu.def;

import java.util.Scanner;

/**
 * @author ssscorch
 * @data
 *
 */
public class Execute {
	char[] word = { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
	char[] suff_int = { '元', '拾', '佰', '仟', '万', '拾', '佰', '仟', '亿', '拾', '佰', '仟', '万' };
	char[] suff_deci = { '角', '分' };

	public void toWord(char[] input, int intLen, int deciLen) {
		System.out.print("人名币");
		for (int i = 0; i < intLen; i++) {
			int index = input[i] - '0';
			if (index == 0) {
				System.out.print(word[index]);
			} else {
				System.out.print(word[index] + "" + suff_int[intLen - i - 1]);
			}
		}
		if (deciLen == 0)
			System.out.println("整");
		for (int i = 0; i < deciLen; i++) {
			int index = input[intLen + i + 1] - '0';
			if (index == 0) {
				System.out.print(word[index]);
			} else {
				System.out.print(word[index] + "" + suff_deci[i]);
			}

		}
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

			Execute execute = new Execute();
			execute.toWord(input, intLen, deciLen);

		} else {
			System.out.println("输入有误");
		}
	}
}
