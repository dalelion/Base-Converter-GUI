package application;
/**
 * Binary enum to convert from Binary to Hex
 * @author dalelion
 *
 */
public enum Binary {

	/** 0 */
	B0000('0'),
	/** 1 */
	B0001('1'),
	/** 2 */
	B0010('2'),
	/** 3 */
	B0011('3'),
	/** 4 */
	B0100('4'),
	/** 5 */
	B0101('5'),
	/** 6 */
	B0110('6'),
	/** 7 */
	B0111('7'),
	/** 8 */
	B1000('8'),
	/** 9 */
	B1001('9'),
	/** 10 */
	B1010('A'),
	/** 11 */
	B1011('B'),
	/** 12 */
	B1100('C'),
	/** 13 */
	B1101('D'),
	/** 14 */
	B1110('E'),
	/** 15 */
	B1111('F');

	char HexadecimalValue;

	Binary(char H) {
		HexadecimalValue = H;
	}

	//Returns the Binary value of a Binary type
	public String BinaryValue() {
		return this.name().substring(1);
	}

	//Returns the Decimal value of a Binary type
	public int DecimalValue() {
		return this.ordinal();
	}

	//Returns the Hex value of a Binary type
	public char HexValue() {
		return this.HexadecimalValue;
	}

	//Converts Binary String to Binary type
	private static Binary StringToBin(String B) {

		switch (B) {
		case "0000":
			return Binary.B0000;
		case "0001":
			return Binary.B0001;
		case "0010":
			return Binary.B0010;
		case "0011":
			return Binary.B0011;
		case "0100":
			return Binary.B0100;
		case "0101":
			return Binary.B0101;
		case "0110":
			return Binary.B0110;
		case "0111":
			return Binary.B0111;
		case "1000":
			return Binary.B1000;
		case "1001":
			return Binary.B1001;
		case "1010":
			return Binary.B1010;
		case "1011":
			return Binary.B1011;
		case "1100":
			return Binary.B1100;
		case "1101":
			return Binary.B1100;
		case "1110":
			return Binary.B1110;
		case "1111":
			return Binary.B1111;
		default:
			return null;
		}
	}

	//Converts integer to Binary type. Must be less than 16.
	private static Binary IntToBin(int i) {
		switch (i) {
		case 0:
			return Binary.B0000;
		case 1:
			return Binary.B0001;
		case 2:
			return Binary.B0010;
		case 3:
			return Binary.B0011;
		case 4:
			return Binary.B0100;
		case 5:
			return Binary.B0101;
		case 6:
			return Binary.B0110;
		case 7:
			return Binary.B0111;
		case 8:
			return Binary.B1000;
		case 9:
			return Binary.B1001;
		case 10:
			return Binary.B1010;
		case 11:
			return Binary.B1011;
		case 12:
			return Binary.B1100;
		case 13:
			return Binary.B1100;
		case 14:
			return Binary.B1110;
		case 15:
			return Binary.B1111;
		default:
			return null;
		}
	}

	//Sign Extension of Binary String to be multiple of 4
	private static String Sext(String B) {
		return B.length() % 4 != 0 ? Sext("0" + B) : B;
	}

	//Converts binary string to Decimal integer
	public static int ToDecimal(String B) {
		B = Sext(B);
		int Total = 0;
		for (int i = 0; i < B.length(); i += 4) {
			Total = (Total << 4) | StringToBin(B.substring(i, i + 4)).ordinal();
		}

		return Total;
	}

	//Converts Binary String to Hex string
	public static String ToHex(String B) {

		B = Sext(B);
		String Hex = "";

		for (int i = 0; i < B.length(); i += 4) {

			Hex += StringToBin(B.substring(i, i + 4)).HexadecimalValue;

		}

		return Hex;
	}

	//Converts Decimal String to Binary String
	public static String FromDecimal(String D) {
		String Bin = "";
		int Val = Integer.parseInt(D);

		while (Val > 0) {
			Bin = IntToBin((Val & 15)).BinaryValue() + Bin;
			Val = Val >> 4;
		}
		return Bin;
	}
}