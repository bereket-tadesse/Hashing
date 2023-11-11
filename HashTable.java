/**
 * A calss which has method to perform linear and double probing hashing techniques
 * @author Bereket
 * @version 1.0
 */
public class HashTable {
	/**
	 * Main method to test the program
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Testing Linear probing <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		int[] myarray = {14,17,18,3,8,1,18,11,13,20};
		int[] finallist = (HashTable.linearProbing(myarray));
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Testing Double probing <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		int[] myarray2 = {2,12,22,32,42,52,62,72,82,92,14,17,18, 3, 8, 1, 18, 11, 13, 20};
		int[] finallist2 = (HashTable.doubleProbing(myarray2));
			
	}
	
	/**
	 * Helper method to print all value of array
	 * @param array
	 */
	private static void printAll(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
	
	/**
	 * A linear probing for open adressing of a hashtable
	 * @param array list to be hashed
	 * @return returns the filled hash table
	 */
	public static int[] linearProbing(int[] array) {
		
		int[] finalArray = new int[10];
		
		//initializng all to -1. (-1 represents an empty spot)
		for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = -1;
        }
		
		//loop through the given array
		for(int i=0;i<=9; i++) {
			
			//hash function
			int index = array[i] % 10;
			//if empty add it
			if(finalArray[index] == -1) {
				finalArray[index] = array[i];
				//print every step
				System.out.println("inserted: " + array[i]+ " at index: "+ index);
				System.out.print("Array after insertion is: ");
				printAll(finalArray);
				System.out.println();
			} else {
				//else loop until insereted
				boolean inserted = false;
				while(!inserted) {
					//if we reach end go back to first
					if(index == finalArray.length-1) {
						index = 0;
					} else {
						//otherwise do linear proving
						index = (index + 1) % 10;
					}
					//if empty add it and sto otherwise continue
					if(finalArray[index] == -1) {
						finalArray[index] = array[i];
						inserted = true;
						//print every step
						System.out.println("inserted: " + array[i]+ " at index: "+ index);
						System.out.print("Array after insertion is: ");
						printAll(finalArray);
						System.out.println();
					}
				}
			}
			
		}
		return finalArray;
	}
	
	/**
	 * hash function one
	 * @param key the data
	 * @param size size of array
	 * @return retunrs the value
	 */
	private static int hash1(int key, int size) {
		return key % size;
	}
	
	/**
	 * hash function 2
	 * @param key the data to be evaluated
	 * @return returns the value
	 */
	private static int hash2(int key) {
		return 7 - (key % 7);
	}
	
	/**
	 * A double probing hashing algorithm for array of size 20.
	 * @param array the array to be hashed
	 * @return returns the hash table
	 */
	public static int[] doubleProbing(int[] array) {
		
		int[] finalArray = new int[20];
		
		//initializng all to -1. (-1 represents empty)
		for (int i = 0; i < finalArray.length; i++) {
            finalArray[i] = -1;
        }
		
		//loop through the given array
		for(int i=0;i<20; i++) {
			
			//using hash one
			int index = hash1(array[i],20);
			//if empty add it.
			if(finalArray[index] == -1) {
				finalArray[index]= array[i];
				//print every step.
				System.out.println("inserted: " + array[i]+ " at index: "+ index);
				System.out.print("Array after insertion is: ");
				printAll(finalArray);
				System.out.println();
			} else {
				//boolean to control while loop
				boolean inserted = false;
				// used for consecutinve probing index as j
				int j = 1;
				while(!inserted) {
					
					//otherwise do linear proving
					index = (hash1(array[i], 20) + j*hash2(array[i]))%20;
					
					//if empty add it and sto otherwise continue
					if(finalArray[index] == -1) {
						finalArray[index] = array[i];
						inserted = true;
						//print every step
						System.out.println("inserted: " + array[i]+ " at index: "+ index);
						System.out.print("Array after insertion is: ");
						printAll(finalArray);
						System.out.println();
					}
					j++;
				}
			}			
		}
		return finalArray;
	}
}

