package com.supinfo.gameoflife;

import java.util.Scanner;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		int nbRows = 0, nbColumns = 0;
		int minRows = 10, minCols = 10;
		boolean cont = true;
		
		while(cont) {
			try {
				System.out.println("Enter a number of rows (min " + minRows + ") : ");
				nbRows = new Scanner(System.in).nextInt();
				
				if(nbRows < minRows)
					throw new Exception();
				
				cont = false;
			}
			catch(Exception e) {
				System.out.println("\nPlease, enter a correct number of rows (min " + minRows + ")\n");
			}
		}
		
		cont = true;		
		while(cont) {
			try {
				System.out.println("Enter a number of columns (min " + minCols + ") : ");
				nbColumns = new Scanner(System.in).nextInt();
				
				if(nbColumns < minCols)
					throw new Exception();
				
				cont = false;
			}
			catch(Exception e) {
				System.out.println("\nPlease, enter a correct number of columns (min " + minCols + ")\n");
			}
		}
		
		
		World world = new World(nbRows, nbColumns);
		
		for(int i = 0 ; i < 100 ; i++) {
			world.newGeneration();
			
			System.out.println("World n°" + (i + 1) + " : \n");
			System.out.println(world);

            Thread.sleep(1000);
		}
	}

}
