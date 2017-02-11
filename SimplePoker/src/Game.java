import java.util.Scanner;

/**
 * @author ssscorch
 * @data
 *
 */
public class Game {

	public static void main(String[] args) {
		System.out.println("-------------欢迎------------\n");
		System.out.println("-------本副牌共有52张--------\n");
		System.out.println("-------给每个玩家发两张牌，手牌大的玩家获胜--------\n");
		CardList cl = new CardList();
		cl.creatCard();

		System.out.println("--------开始洗牌--------\n");
		cl.Wash();
		System.out.println("-----------洗牌完成----------\n");

		System.out.println("--------游戏开始---------\n");
		Scanner console = new Scanner(System.in);

		System.out.println("-------");
		System.out.println("----输入第一个玩家的ID-----");
		String stri1 = console.next();
		System.out.println("---------输入玩家的名字-------------");
		String strn1 = console.next();

		System.out.println("-------");
		System.out.println("----输入第二个玩家的ID-----");
		String stri2 = console.next();
		System.out.println("---------输入玩家的名字-------------");
		String strn2 = console.next();
		
		console.close();

		System.out.println("------------------------------");
		System.out.println("-------玩家" + stri1 + "的姓名为"+ strn1);
		
		System.out.println("-------玩家" + stri2 + "的姓名为"+strn2);
		
		

		Card c11 = cl.deal();
		Card c12 = cl.deal();
		Card c21 = cl.deal();
		Card c22 = cl.deal();
		
		System.out.println("------------发牌完成--------------");
		
		Person p1 = new Person(stri1, strn1, c11, c12);
		Person p2 = new Person(stri2, strn2, c21, c22);
		//比较大小并返回较大的那一张牌
		Card c1 = cl.compare(c11, c21);
		Card c2 = cl.compare(c21, c22);
		Card c = cl.compare(c1, c2);
		
		System.out.println("---------------------");
		System.out.println("玩家"+p1.name+"的手牌为<"+c11.pokerSuit+c11.data+">  <"+c12.pokerSuit+c12.data+">");
		System.out.println("玩家"+p2.name+"的手牌为<"+c21.pokerSuit+c21.data+">  <"+c22.pokerSuit+c22.data+">");
		
		if(c.equals(c1)&& !c.equals(c2)){
			System.out.println("------WINNER IS " +p1.name +"------");
		}
		if(c.equals(c2) && !c.equals(c1)){
			System.out.println("------WINNER IS " +p2.name +"------");
			
		}
		if(c.equals(c1) && c.equals(c2)){
			System.out.println("-------------OH MY GOD!!"+p1.name+" "+p2.name+" drew.------------");
		}
	}
}
