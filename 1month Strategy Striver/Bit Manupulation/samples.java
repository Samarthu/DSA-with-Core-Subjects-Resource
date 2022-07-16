// Bits Sample 

import java.util.*;
class samples{
public static void main(String[] args) {
		int col = 5;
		col ^= (1<<4);
		System.out.println(col+"   "+  (1<<11) + " " +((col&(1<<4)) == 0));
		col ^= (1<<4);
		System.out.println(col+"  "+ (1<<4));
	}	
}