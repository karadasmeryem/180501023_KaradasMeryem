package DBCon;
import javax.swing.JOptionPane;

public class Helfer {
	
		public static void showMsg(String str) {
			String msg;
		
			switch (str) {
			case "fill":
				msg = "Bitte geben Sie alle Informationen ein";
				break; 
			case "erfolgreich":
			     msg = "Operation erfolgreich"; 
			     break;
			default:
				msg = str;
			}
			JOptionPane.showMessageDialog(null, msg, "Message", JOptionPane.INFORMATION_MESSAGE);
		} 
		
		public static boolean confirm(String str) { 
			String msg; 
			switch(str) { 
			case"sure" : 
				msg = "Möchten Sie diese Operation wirklich durchführen?"; 
				break; 
			default: 
				msg = str; 
				break;
			} 
			int res = JOptionPane.showConfirmDialog(null, msg,"Achtung!", JOptionPane.YES_NO_CANCEL_OPTION); 
			if(res ==0) { 
				return true; 
			}else { 
				return false;
			}
		}
}
