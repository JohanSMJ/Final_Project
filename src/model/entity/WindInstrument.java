package model.entity;

public  class WindInstrument implements IInstrumentType{
	private static String TYPE="WIND";
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
