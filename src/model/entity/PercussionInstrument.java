package model.entity;

public class PercussionInstrument implements IInstrumentType{
	private static final String TYPE="PERCUSSION";
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
