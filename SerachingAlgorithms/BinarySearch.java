
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static int binarySearch(int[] data, int key) {
		int low = 0;
		int hight = data.length;
		int middle = (low + hight + 1) / 2;
		int location = -1;

		do {
//			System.out.println(remainingElements(data, low, hight));
//			for (int i = 0; i < middle; i++)
//				System.out.print("  ");
//			System.out.println(" * ");

			if (key == data[middle])
				location = middle;
			else if (key < data[middle])
				hight = middle - 1;
			else
				low = middle + 1;
			middle = (low + hight + 1) / 2;
		} while ((low <= hight) && (location == -1));

		return location;
	}

//	private static String remainingElements(int[] data, int low, int hight) {
//		StringBuilder temporary = new StringBuilder();
//
//		for (int i = 0; i < low; i++) {
//			temporary.append("  ");
//		}
//		for (int i = low; i < hight; i++) {
//			temporary.append(data[i] + " ");
//		}
//		return String.format("%s%n", temporary);
//	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SecureRandom generator = new SecureRandom();

		int[] data = new int[15];
		
		for (int i = 0; i < data.length; i++) {
			data[i] = 10+generator.nextInt(90);
		}
		Arrays.sort(data);
		System.out.printf("%s%n%n", Arrays.toString(data));
		
		System.out.print("Sayi girin (Cikmak icin -1 olmasın) = ");
		int searchInt = input.nextInt();
		 	
		while(searchInt !=-1){
			int location = binarySearch(data, searchInt);
			if(location == -1)
				System.out.printf("%d bulunamadı\n",searchInt);
			else
				System.out.printf("%d bulundu ve yeri %d.indis\n",searchInt,location);
			
			System.out.print("Yeni Sayi girin (Cikmak icin -1 olmasın) = ");
			searchInt = input.nextInt();
		}
		System.out.printf("Program Sonlandı");
	}
}
