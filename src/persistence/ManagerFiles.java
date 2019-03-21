package persistence;

public class ManagerFiles {
	public IFiles selctType(String type) {
		IFiles iFiles=null;
		switch (type) {
		case "txt":
			iFiles=new PlainFile();
			break;
		case "bin":
			iFiles=new BinFIle();
			break;
		case "xml":
			iFiles=new XMLFile();
			break;
		case "json":
			iFiles=new JSONFiles();
			break;
		default:
			iFiles=null;
			break;
		}
		return iFiles;
	}
}
