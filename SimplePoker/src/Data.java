import java.util.ArrayList;
import java.util.List;

/**
 * @author ssscorch
 * @data
 *
 */
public class Data {
	public List<String> datalist;

	public Data() {
		datalist = new ArrayList<String>();
		for (int i = 1; i < 10; i++) {
			datalist.add((i + 1) + "");
		}
		datalist.add("J");
		datalist.add("Q");
		datalist.add("K");
		datalist.add("A");
	}
	
}
