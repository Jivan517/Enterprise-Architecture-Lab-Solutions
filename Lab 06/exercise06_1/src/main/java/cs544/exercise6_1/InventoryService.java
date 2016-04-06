package cs544.exercise6_1;

public class InventoryService implements IInventoryService{

	@Override
	public int getNumberInStock(int productNumber) {

		return productNumber - 200;
	}

	 
}
