package model.entity;

public class Instrument {
	private String name;
	private IInstrumentType type;
	private boolean state;
	public Instrument(String name, IInstrumentType type, boolean state) {
		this.name=name;
		this.type=type;
		this.state=state;
	}
//	public Instrument(String name,String description)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public String getInstrumentDescription() {
		return	type.getInstrumentDescription();
	}
	public void setInstrumentDescription(String instrumentDescription) {
		type.setInstrumentDescription(instrumentDescription);
	}
}
