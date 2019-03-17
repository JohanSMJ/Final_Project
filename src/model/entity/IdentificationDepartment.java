package model.entity;

public enum IdentificationDepartment {
	BOYACA("Boyaca","0"),CUNDINAMARCA("Cundinamarca","1"),ANTIOQUIA("Antioquia","2"),CALDAS("Caldas","3"),
	CAUCA("Cauca","4"),CAQUETA("Caqueta","5"),CESAR("Cesar","6"),CHOCO("Choco","7"),HUILA("Huila","8"),
	NARIÑO("Nariño","9"),NORTE_DE_SANTANDER("Norte De Santander","10"),PUTUMAYO("Putumayo","11"),
	QUINDIO("Quindio","12"),RISARALDA("Risaralda","13"),SANTANDER("Santander","14"),TOLIMA("Tolima","15");
	private String name;
	private String iD;
	IdentificationDepartment(String name,String iD) {
		this.name=name;
		this.iD=iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
}
