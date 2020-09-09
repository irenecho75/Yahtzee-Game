package smashBros;

import java.util.Arrays;

public class Smash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"Marth", "Pikachu", "Peach"};
		String[] b = {"Alaska", "Pikachu", "Bowser"};
		System.out.println(countDuplicates(a, b));
		System.out.println(Arrays.toString(mergeRosters(a,b)));
	}
	
	public static int countDuplicates(String[] a, String[] b) {
		int count = 0;
		
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<b.length; j++) {
				if(a[i].equals(b[j])) {
					count++;
				}
			}
		}
		return count;
	}
	public static String[] mergeRosters(String[] a, String[] b) {
		int duplicates = countDuplicates(a, b);
		int uniqueVal = a.length+b.length-duplicates;
		
		//merges a and b
		String[] merge = new String[a.length+b.length];
		for(int i = 0; i<a.length; i++) {	
			merge[i] = a[i];
		}
		for(int i = 0; i<b.length; i++) {
			merge[a.length + i] = b[i];
		}
		
		//sorts by name
		for (int lastPos = merge.length-1; lastPos>=0; lastPos--) {
			for(int index = 0; index<= lastPos-1; index++) {
				if(merge[index].charAt(0) > merge[index+1].charAt(0)) {
					String temp = merge[index];
					merge[index] = merge[index+1];
					merge[index+1] = temp;
					} else if(merge[index].charAt(0) == merge[index+1].charAt(0)) {
						if(merge[index].charAt(1) > merge[index+1].charAt(1)) {
							String temp = merge[index];
							merge[index] = merge[index+1];
							merge[index+1] = temp;
						}
					} else {
						
					}
			}
		}
		
		//removes duplicates
		for(int i = 0; i<merge.length-1; i++) {
			if(merge[i].equals(merge[i+1])) {
				merge[i] = "";
			}
			
		}
		
		//constructs final array
		String[] finalMerge = new String[uniqueVal];
		int index = 0;
		for(String str: merge) {
			if (str.length()>0) {
				finalMerge[index] = str;
				index++;
			}
		}
		
		
		return finalMerge;
		
		
			
	}

}
