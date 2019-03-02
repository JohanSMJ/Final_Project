package model.entity;

import java.util.ArrayList;

public class Event {
	private String name;
	private ArrayList<Institute>challengers=new ArrayList<>();
	
	public Event(String name, ArrayList<Institute>challengers) {
		this.name=name;
		this.challengers=challengers;
	}
}
