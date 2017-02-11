import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
* @author ssscorch
* @data   
*
*/
public class CardList {
	public List<Card> cardList;
	
	public CardList(){
		cardList = new ArrayList<Card>();
	}
	
	public void creatCard(){
		
	PokerSuit pSuit	= new PokerSuit();
	Data data = new Data();
	
	for(int i=0;i<13;i++)
		for(int j=0;j<4;j++){
			Card card = new Card(pSuit.pokerSuitlist.get(j), data.datalist.get(i));
			cardList.add(card);
		}
	
	int i =0;
	for(Card card:cardList){
		if(i==4){
			System.out.println("");
			i=0;
		}
		if (i!=4) {
			System.out.println("<"+card.pokerSuit+card.data+">"+"");
			i++;
		}
	}
	System.out.println("\n----------------------牌创建完成--------------------\n");	
	}
	
	/*
	 * éæºæ´ç
	 * */
	public List<Card> Wash(){
		List<Card> listCard = new ArrayList<Card>();
		Random random = new Random();
		int i=0;
		while(i<52){
			Card card = cardList.get(random.nextInt(52));
			if(!listCard.contains(card)){
				listCard.add(card);
				i++;
			}
		}
		return listCard;
	}
	
	public Card deal(){
		Random random = new Random();
		Card card = Wash().get(random.nextInt(52));
		return card;
	}
	/*
	 * æ¯è¾å¤§å°
	 * */
	public Card compare(Card c1,Card c2){
		Data data = new Data();
		PokerSuit pSuit = new PokerSuit();
		Integer i1=data.datalist.indexOf(c1.data);
		Integer i2=data.datalist.indexOf(c2.data);
		int i=i1.compareTo(i2);
		
		if(i==0){
			Integer i3=pSuit.pokerSuitlist.indexOf(c1.pokerSuit);
			Integer i4=pSuit.pokerSuitlist.indexOf(c2.pokerSuit);
			int j=i3.compareTo(i4);
			if(j==0)
				return c1;
			if(j<0)
				return c2;
			if(j>0)
				return c1;
		}
		if(i>0)
			return c1;
		return c2;
	}
	
	public static void main(String[] args){
		CardList cl = new CardList();
	    cl.creatCard();
	    for(Card c:cl.Wash()){
	    	System.out.println("<"+c.pokerSuit+c.data+"");	    	
	    }
	   Card c1 = cl.deal();
	   System.out.println("<"+c1.pokerSuit+c1.data+">");
	   Card c2 = cl.deal();
	   System.out.println("<"+c2.pokerSuit+c2.data+">");
		
	   Card card = cl.compare(c1, c2);
	   System.out.println(card.pokerSuit+card.data);
	    
	}
}
