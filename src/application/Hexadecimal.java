package application;
/**
 * Hex enum to convert from Hex to Binary
 * @author dalelion
 *
 */
public enum Hexadecimal {

	/** 0 */
	x0("0000"),
	/** 1 */
	x1("0001"),
	/** 2 */
	x2("0010"),
	/** 3 */
	x3("0011"),
	/** 4 */
	x4("0100"),
	/** 5 */
	x5("0101"),
	/** 6 */
	x6("0110"),
	/** 7 */
	x7("0111"),
	/** 8 */
	x8("1000"),
	/** 9 */
	x9("1001"),
	/** 10 */
	xA("1010"),
	/** 11 */
	xB("1011"),
	/** 12 */
	xC("1100"),
	/** 13 */
	xD("1101"),
	/** 14 */
	xE("1110"),
	/** 15 */
	xF("1111");

	String BinaryNumber;
	
	//Used to store the Binary value at each Hex location
	Hexadecimal(String B) {
		BinaryNumber = B;
	}
	
	//Used to retrieve the Binary value of a single character
	public static String BinaryValue(char H) {
		String HexString = "x" + H;
		return Hexadecimal.valueOf(HexString).BinaryNumber;
	}

	//Retrieves the Hex character value of a Hex type
	public char HexValue() {
		return this.name().charAt(1);
	}

	//Converts character into hex type
	private static Hexadecimal CharToHex(char C) {
		switch (C) {
		case '0':
			return Hexadecimal.x0;
		case '1':
			return Hexadecimal.x1;
		case '2':
			return Hexadecimal.x2;
		case '3':
			return Hexadecimal.x3;
		case '4':
			return Hexadecimal.x4;
		case '5':
			return Hexadecimal.x5;
		case '6':
			return Hexadecimal.x6;
		case '7':
			return Hexadecimal.x7;
		case '8':
			return Hexadecimal.x8;
		case '9':
			return Hexadecimal.x9;
		case 'A':
			return Hexadecimal.xA;
		case 'B':
			return Hexadecimal.xB;
		case 'C':
			return Hexadecimal.xC;
		case 'D':
			return Hexadecimal.xD;
		case 'E':
			return Hexadecimal.xE;
		case 'F':
			return Hexadecimal.xF;
		default:
			return null;
		}
	}
	
	//Converts integer value to Hex type. Must be less than 16.
	private static Hexadecimal intToHex(int i) {
		switch (i) {
		case 0:
			return Hexadecimal.x0;
		case 1:
			return Hexadecimal.x1;
		case 2:
			return Hexadecimal.x2;
		case 3:
			return Hexadecimal.x3;
		case 4:
			return Hexadecimal.x4;
		case 5:
			return Hexadecimal.x5;
		case 6:
			return Hexadecimal.x6;
		case 7:
			return Hexadecimal.x7;
		case 8:
			return Hexadecimal.x8;
		case 9:
			return Hexadecimal.x9;
		case 10:
			return Hexadecimal.xA;
		case 11:
			return Hexadecimal.xB;
		case 12:
			return Hexadecimal.xC;
		case 13:
			return Hexadecimal.xD;
		case 14:
			return Hexadecimal.xE;
		case 15:
			return Hexadecimal.xF;
		default:
			return null;
		}
	}
	
	//Returns the decimal value of a hex type
	public int DecimalValue() {
		return this.ordinal();
	}
	
	//Converts Hex string to Binary String
	public static String ToBinary(String H) {
		
		String Bin = "";
		
		for (int i = 0; i < H.length(); ++i) {
			
			Bin += CharToHex(H.charAt(i)).BinaryNumber;
			
		}
		
		return Bin;
	}

	//Converts hex string to Decimal integer
	public static int ToDecimal(String H) {
		int Total = 0;
		for (int i = 0; i < H.length(); ++i) {
			Total = (Total << 4) | CharToHex(H.charAt(i)).ordinal();
		}
		return Total;
	}
	
	//Converts Decimal String to Hex String
	public static String FromDecimal(String D) {
		
		String Hex = "";
		int Val = Integer.parseInt(D);
		
		while (Val > 0) {
			Hex = intToHex((Val & 15)).HexValue() + Hex;
			Val = Val >> 4;
		}
		return Hex;
	}
}