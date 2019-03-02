package model.entity;

public class Instrument {
	private String name;
	private IInstrumentType type;
	private boolean state;
	private String descriptionState;

	public Instrument(String name, IInstrumentType type, boolean state, String descriptionState) {
		this.name=name;
		this.type=type;
		this.state=state;
		this.descriptionState=descriptionState;
	}
	
	
}
