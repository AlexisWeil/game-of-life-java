package com.supinfo.gameoflife;

public class AliveCell implements Cell {

    /**
     * Utilisation d'un boolean pour savoir si la cellule est une nouvelle
     */
	private boolean newBorn;

    /**
     * La cellule est créé, et est une nouvelle (donc newBorn = true)
     */
	public AliveCell() {
		newBorn = true;
	}

	@Override
	public Cell newGeneration(int nbNeighbours) {
        // La cellule n'est plus nouvelle
		newBorn = false;
		
		if(nbNeighbours < 2 || nbNeighbours > 3)
			return new DeadCell();
		else
			return this;
	}

	@Override
    /**
     * Affiche 0 si c'est une nouvelle cellule, + sinon
     */
	public String getAsString() {
		return (newBorn ? "0 " : "+ ");
	}

	@Override
	public boolean isAlive() {
		return true;
	}

}
