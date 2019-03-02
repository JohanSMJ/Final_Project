package controller;

import model.dao.ModelManager;
import views.IOManager;

public class ControllerApps {

		ModelManager modelManager;
		IOManager ioManager;
		
		public ControllerApps() {
			modelManager=new ModelManager();
			ioManager=new IOManager();
		}

}
