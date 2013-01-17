package com.supinfo.gameoflife;

import java.util.Random;

public class World {
	
	private Cell[][] world;
	
	
	public World(int nbColumns, int nbRows) {
		Random rand = new Random();
		world = new Cell[nbRows][nbColumns];
		
		for(int i = 0 ; i < nbRows ; i++) {
			for(int j = 0 ; j < nbColumns ; j++) {
				world[i][j] = (rand.nextBoolean() ? new AliveCell() : new DeadCell());
			}
		}
	}
	
	public World(Cell[][] world) {
		this.world = world;
	}
	
	public void newGeneration() {
		for(int i = 0 ; i < this.world.length ; i++) {
			for(int j = 0 ; j < this.world[i].length ; j++) {
				int nbNeighbours = 0;
				
				if(i > 0) {
					nbNeighbours += (world[i - 1][j].isAlive() ? 1 : 0);
				
					if(j > 0)
						nbNeighbours += (world[i - 1][j - 1].isAlive() ? 1 : 0);
					
					if(j < world[i].length - 1)
						nbNeighbours += (world[i - 1][j + 1].isAlive() ? 1 : 0);
				}
				
				if(i < world.length - 1) {
					nbNeighbours += (world[i + 1][j].isAlive() ? 1 : 0);
					
					if(j > 0)
						nbNeighbours += (world[i + 1][j - 1].isAlive() ? 1 : 0);
					
					if(j < world[i].length - 1)
						nbNeighbours += (world[i + 1][j + 1].isAlive() ? 1 : 0);
				}
				
				if(j > 0)
					nbNeighbours += (world[i][j - 1].isAlive() ? 1 : 0);
				
				if(j < world[i].length - 1)
					nbNeighbours += (world[i][j + 1].isAlive() ? 1 : 0);
				
				
				world[i][j] = world[i][j].newGeneration(nbNeighbours);
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Cell[] cells : this.world) {
			for(Cell c : cells) {
				sb.append(c.getAsString());
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}

	
}
