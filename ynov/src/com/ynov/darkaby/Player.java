package com.ynov.darkaby;

public class Player {
	
	private String _name;
	private boolean _white;
	
	public String getName() {
		return this._name;
	}
	
	public boolean isWhite() {
		return this._white;
	}
	
	public Player(String name, boolean white){
		this._name = name;
		this._white = white;
	}

}
