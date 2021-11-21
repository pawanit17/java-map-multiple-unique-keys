import java.util.Map;
import java.util.HashMap;

// An implementation to demo uniqueness in Collection on more than one attributes.
public class MultiUniquenessInCollectionsDemo 
{
	// The product catalog
	static Map<ProductKey, ProductInfo> productCatalog = new HashMap<ProductKey, ProductInfo>();

	// The ERP Stock information
	static boolean IN_STOCK = true;
	static boolean OUT_OF_STOCK = false;

	public static final String RED_BRIGHT = "\033[0;91m";    // RED
	public static final String RESET = "\033[0m";  // Text Reset
	
	public static void main(String args[])
	{
		buildCatalog();
		
		displayCatalog();
	}

	// API to build instance of Products and adding them to the catalog map.
	private static void buildCatalog()
	{
		// Add some Shirts
		ProductInfo item1 = new ProductInfo("PoloShirts", "Shirts", "Round collared", 10.76, IN_STOCK );
		ProductInfo item2 = new ProductInfo("TurtleNecks", "Shirts", "Turtle collared", 10.89, IN_STOCK);
		
		// Add some Mobiles
		ProductInfo item3 = new ProductInfo("Nokia Lumia", "Mobiles", "Windows Mobile", 108.67, OUT_OF_STOCK);
		ProductInfo item4 = new ProductInfo("Samsung Galaxy", "Mobiles", "Android Mobile", 201.98, IN_STOCK);
		
		// Add some Laptops
		ProductInfo item5 = new ProductInfo("Apple MacBook", "Laptop", "Mac Laptops", 1191.23, IN_STOCK);
		ProductInfo item6 = new ProductInfo("Dell Workstation", "Laptop", "Windows Laptops", 654.87, IN_STOCK);
		
		// Add some Tabs
		ProductInfo item7 = new ProductInfo("Samsung Galaxy", "Tab", "Android Tablet 5 Inch", 1075, IN_STOCK);
		ProductInfo item8 = new ProductInfo("Samsung Galaxy", "Tab", "Android Tablet 7 Inch", 2050, IN_STOCK);
		
		// Add some Gaming consoles
		ProductInfo item9 = new ProductInfo("PS4", "Gaming Console", "Sony Entertainment", 1200, IN_STOCK);
		ProductInfo item10 = new ProductInfo("PS5", "Gaming Console", "Sony Entertainment", 2400, IN_STOCK);
		
		// Add some Games
		ProductInfo item11 = new ProductInfo("Witcher", "Game", "Adventures of Geralt of Reveria I", 256.99, IN_STOCK);
		ProductInfo item12 = new ProductInfo("Witcher", "Game", "Adventures of Geralt of Reveria II", 317.87, OUT_OF_STOCK);

		// Add Product Information to Map
		productCatalog.put(item1.productIdentifier, item1);
		productCatalog.put(item2.productIdentifier, item2);
		productCatalog.put(item3.productIdentifier, item3);
		productCatalog.put(item4.productIdentifier, item4);
		productCatalog.put(item5.productIdentifier, item5);
		productCatalog.put(item6.productIdentifier, item6);
		productCatalog.put(item7.productIdentifier, item7);
		productCatalog.put(item8.productIdentifier, item8);
		productCatalog.put(item9.productIdentifier, item9);
		productCatalog.put(item10.productIdentifier, item10);
		productCatalog.put(item11.productIdentifier, item11);
		productCatalog.put(item12.productIdentifier, item12);

		System.out.println("Encountered " + (12-productCatalog.size()) + " duplicates keys.\n");

	}

	// API to display the map ( catalog ) contents.
	private static void displayCatalog()
	{
		System.out.println("{");
		for(Map.Entry<ProductKey, ProductInfo> entry : productCatalog.entrySet())
		{
			ProductKey productKey = entry.getKey();
			ProductInfo productValue = entry.getValue();
		    System.out.print("\tProduct Name: " + productKey.productName);
		    System.out.print("\tProduct Category: " + productKey.productCategory);
		    System.out.print("\tProduct Description: " + productValue.productDescription);
		    System.out.print("\tProduct Price: " + productValue.productPrice);
		    System.out.print("\tProduct Availability: " + productValue.productAvailability);
		    System.out.println();
		}
		System.out.println("}");
	}
}

// Classes encapsulating Product metadata.
class ProductKey
{
	String productName;
	String productCategory;

	ProductKey(){}

	ProductKey(String name, String category) 
	{
		productName = name;
		productCategory = category;
	}
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productName == null) ? 0 : productName.hashCode())
                + + ((productCategory == null) ? 0 : productCategory.hashCode());
        return result;
    }

	@Override
    public boolean equals(final Object otherObject) 
	{
        if (this == otherObject)
            return true;

        if (otherObject == null)
            return false;
        
        if (getClass() != otherObject.getClass())
            return false;
        
        final ProductKey other = (ProductKey) otherObject;
        if (productName.equals(other.productName) && productCategory.equals(other.productCategory)) 
            return true;
        else
        	return false;
    }
}

class ProductInfo
{
	ProductKey productIdentifier;
	String productDescription;
	double productPrice;
	boolean productAvailability;
	
	ProductInfo(){}

	ProductInfo(String name, String category, String description, double price, boolean availability)
	{
		productIdentifier = new ProductKey( name, category );

		productDescription = description;
		productPrice = price;
		productAvailability = availability;	
	}	
}
