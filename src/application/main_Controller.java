package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class main_Controller {
	
	@FXML
	TextField TF_Input;
	@FXML
	TextField TF_Display;
	@FXML
	ComboBox CB_Source;
	@FXML
	ComboBox CB_Destination;
	
	//boolean S_Binary, S_Hex, S_Decimal, D_Binary, D_Hex, D_Decimal;
	
	
	public void ConvertClick() {
		boolean S_Binary = false, S_Hex = false, S_Decimal = false, D_Binary = false, D_Hex = false, D_Decimal = false;
		
		try {
			
		
		switch (CB_Source.getSelectionModel().getSelectedIndex()) {
		case 0:
			S_Binary = true;
			break;
		case 1:
			S_Hex = true;
			break;
		case 2:
			S_Decimal = true;
			break;
		default:
			break;
		}
		
		switch (CB_Destination.getSelectionModel().getSelectedIndex()) {
		case 0:
			D_Binary = true;
			break;
		case 1:
			D_Hex = true;
			break;
		case 2:
			D_Decimal = true;
			break;
		default:
			break;
		}
		
		if (S_Binary) {
			
			if (D_Binary) TF_Display.setText("" + TF_Input.getText());
			else if (D_Hex) TF_Display.setText("" + Binary.ToHex(TF_Input.getText()));
			else if (D_Decimal) TF_Display.setText("" + Binary.ToDecimal(TF_Input.getText()));
		}		
		
		else if (S_Hex) {
			
			if (D_Binary) TF_Display.setText("" + Hexadecimal.ToBinary(TF_Input.getText()));
			else if (D_Hex) TF_Display.setText("" + TF_Input.getText());
			else if (D_Decimal) TF_Display.setText("" + Hexadecimal.ToDecimal(TF_Input.getText()));
		}
		
		else if (S_Decimal) {
			
			if (D_Binary) TF_Display.setText("" + Binary.FromDecimal(TF_Input.getText()));
			else if (D_Hex) TF_Display.setText("" + Hexadecimal.FromDecimal(TF_Input.getText()));
			else if (D_Decimal) TF_Display.setText("" + TF_Input.getText());
		}		
		
		
		} catch (Exception e) {
			TF_Display.setText("Invalid");
		}
		
	}
	
}
