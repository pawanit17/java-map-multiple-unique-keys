# java-map-multiple-unique-keys
This is an example of a scenario where a map is used with a key that is made up of multiple attributes. All Java Collections rely on hashCode and equals methods to look up where a certain object is held in the collection or to know where to map a certain object into the collection. So overriding one of them would also need to override the other one as well. This is covered in Effective Java by Joshua Bloch. A summary is also present in this stack overflow post https://stackoverflow.com/a/2265637/815961

# Sample Input of the Program
```
{
	Product Name: PS4	Product Category: Gaming Console	Product Description: Sony Entertainment	Product Price: 1200.0	Product Availability: true
	Product Name: Dell Workstation	Product Category: Laptop	Product Description: Windows Laptops	Product Price: 654.87	Product Availability: true
	Product Name: PS5	Product Category: Gaming Console	Product Description: Sony Entertainment	Product Price: 2400.0	Product Availability: true
	Product Name: Samsung Galaxy	Product Category: Tab	Product Description: Android Tablet 5 Inch	Product Price: 2050.0	Product Availability: true
  Product Name: Samsung Galaxy	Product Category: Tab	Product Description: Android Tablet 7 Inch	Product Price: 2050.0	Product Availability: true
	Product Name: PoloShirts	Product Category: Shirts	Product Description: Round collared	Product Price: 10.76	Product Availability: true
	Product Name: Nokia Lumia	Product Category: Mobiles	Product Description: Windows Mobile	Product Price: 108.67	Product Availability: false
  Product Name: Witcher	Product Category: Game	Product Description: Adventures of Geralt of Reveria I	Product Price: 317.87	Product Availability: false
  Product Name: Witcher	Product Category: Game	Product Description: Adventures of Geralt of Reveria II	Product Price: 317.87	Product Availability: false
	Product Name: TurtleNecks	Product Category: Shirts	Product Description: Turtle collared	Product Price: 10.89	Product Availability: true
	Product Name: Apple MacBook	Product Category: Laptop	Product Description: Mac Laptops	Product Price: 1191.23	Product Availability: true
	Product Name: Samsung Galaxy	Product Category: Mobiles	Product Description: Android Mobile	Product Price: 201.98	Product Availability: true
}
```
- Notice the last two entries in the input having the same Product Name and Product Category.
```
Product Name: Witcher	Product Category: Game	Product Description: Adventures of Geralt of Reveria I	Product Price: 317.87	Product Availability: false
Product Name: Samsung Galaxy	Product Category: Tab	Product Description: Android Tablet 5 Inch	Product Price: 2050.0	Product Availability: true
```
- This will be treated as a duplicate by our Map implementation.

# Sample Output of the Program
```
Encountered 2 duplicates keys.

{
	Product Name: PS4	Product Category: Gaming Console	Product Description: Sony Entertainment	Product Price: 1200.0	Product Availability: true
	Product Name: Dell Workstation	Product Category: Laptop	Product Description: Windows Laptops	Product Price: 654.87	Product Availability: true
	Product Name: PS5	Product Category: Gaming Console	Product Description: Sony Entertainment	Product Price: 2400.0	Product Availability: true
	Product Name: Samsung Galaxy	Product Category: Tab	Product Description: Android Tablet 7 Inch	Product Price: 2050.0	Product Availability: true
	Product Name: PoloShirts	Product Category: Shirts	Product Description: Round collared	Product Price: 10.76	Product Availability: true
	Product Name: Nokia Lumia	Product Category: Mobiles	Product Description: Windows Mobile	Product Price: 108.67	Product Availability: false
	Product Name: Witcher	Product Category: Game	Product Description: Adventures of Geralt of Reveria II	Product Price: 317.87	Product Availability: false
	Product Name: TurtleNecks	Product Category: Shirts	Product Description: Turtle collared	Product Price: 10.89	Product Availability: true
	Product Name: Apple MacBook	Product Category: Laptop	Product Description: Mac Laptops	Product Price: 1191.23	Product Availability: true
	Product Name: Samsung Galaxy	Product Category: Mobiles	Product Description: Android Mobile	Product Price: 201.98	Product Availability: true
}
```

# Implementation
- Overriding equals
  - Plugin the two attributes ProductName and ProductCategory in the comparision in the overridden equals method.  
```
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
```
- Overriding hashCode
  - Plugin the ProductName and ProductCategory in the hashCode generation process.
```
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((productName == null) ? 0 : productName.hashCode())
                + + ((productCategory == null) ? 0 : productCategory.hashCode());
        return result;
    }
```

- Main thing to note is that what ever properties we are going to make as keys in our Collections, we add them to the **hashCode** and **equals** method.
