package model.entity;

public class StringInstrument implements IInstrumentType{
	private static final String TYPE="STRING";
	private String instrumentDescription;
	@Override
	public String getInstrumentDescription() {
		return ""+TYPE+", "+instrumentDescription;
	}

	@Override
	public void setInstrumentDescription(String description) {
		this.instrumentDescription=description;
	}

}
