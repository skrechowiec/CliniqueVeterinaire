package fr.eni.veterinaire.bll;

public class BLLException extends Exception {
	
	 	private static final long serialVersionUID = 6830710345461032243L;

		//Constructeurs
		public BLLException() {
			super();
		}

		public BLLException(String message) {
			super(message);
		}

		public BLLException(String message, Throwable exception) {
			super(message, exception);
		}

		//Méthodes
		@Override
		public String getMessage() {
			StringBuffer sb = new StringBuffer("Couche BLL - ");
			sb.append(super.getMessage());

			return sb.toString() ;
		}


	}



