
public class GenericTester {
	
	public static void main(String[] args) {
		
		//Create 6 Contact objects
		Contact jim = new Contact("Jim", "Keeler","125 Main St.", "5551212");
		Contact kim = new Contact("Kim", "Payne","125 Main St.", "5551212");
		Contact jane = new Contact("Jane", "Reynolds","125 Main St.", "5551212");
		Contact steve = new Contact("Steve", "Malone","125 Main St.", "5551212");
		Contact julie = new Contact("Julie", "Reynolds","125 Main St.", "5551212");
		Contact shangwen = new Contact("Shangwen", "Liu", "22 Main St.", "5551212");
		
		RecursiveLinkedCollection<Contact> addressBook = new RecursiveLinkedCollection<>();
		addressBook.add(jim);
		addressBook.add(kim);
		addressBook.add(jane);
		addressBook.add(steve);
		addressBook.add(julie);
		addressBook.add(shangwen);
		
		//Test toString and add methods
		System.out.println("toString expected: Jim Keeler 5551212,Kim Payne 5551212,Jane Reynolds 5551212,Steve Malone 5551212,Julie Reynolds 5551212,Shangwen Liu 5551212");
		System.out.println("toString acutal:   "+addressBook.toString());
		System.out.println();
		
		//Test get method 
		System.out.println("get expected: Steve Malone 5551212");
		System.out.println("get acutal:   "+addressBook.get(steve).toString()) ;
		System.out.println();
		
		//Test contains method - element in collection
		System.out.println("contains expected: true");
		System.out.println("contains acutal:   "+addressBook.contains(shangwen));
		System.out.println();
		
		//Test contains method - element NOT in collection
		Contact notInList = new Contact("Not", "InList","125 Main St.", "5551212");
		System.out.println("contains expected: false");
		System.out.println("contains acutal:   "+addressBook.contains(notInList));
		System.out.println();
		
		//Test isEmpty method
		System.out.println("isEmpty expected: false");
		System.out.println("isEmpty acutal:   "+addressBook.isEmpty());
		System.out.println();
		
		//Test isFull method
		System.out.println("isFull expected: false");
		System.out.println("isFull acutal:   "+addressBook.isFull());
		System.out.println();
		
		//Test size method
		System.out.println("size expected:  6");
		System.out.println("size acutal:    "+addressBook.size());
		System.out.println();
		
		//Test remove methods
		addressBook.remove(shangwen);
		System.out.println("remove expected: Jim Keeler 5551212,Kim Payne 5551212,Jane Reynolds 5551212,Steve Malone 5551212,Julie Reynolds 5551212");
		System.out.println("remove acutal:   "+addressBook.toString());
		System.out.println();
		
		//Test remove methods
		addressBook.remove(jane);
		System.out.println("remove expected: Jim Keeler 5551212,Kim Payne 5551212,Steve Malone 5551212,Julie Reynolds 5551212");
		System.out.println("remove acutal:   "+addressBook.toString());
		System.out.println();
		
		//Test size method
		System.out.println("size expected:  4");
		System.out.println("size acutal:    "+addressBook.size());
		System.out.println();
				
	}
}
