import java.util.List;

public class MyItem implements IDedObject {
	
	private int itemID;
	private int itemPrice;
	private List<Integer> itemDescription;

	public MyItem(int itemID, int itemPrice, List<Integer> itemDescription) {
		super();
		this.itemID = itemID;
		this.itemPrice = itemPrice;
		this.itemDescription = itemDescription;
	}
	
	@Override
	public int getID() {
		return itemID;
	}

	@Override
	public String printID() {
		StringBuilder detail = new StringBuilder();
		detail.append(String.format("%d %d", itemID, itemPrice));
		for (Integer item : itemDescription) {
			detail.append(" " + item.toString());
		}

		return detail.toString();
	}

}
