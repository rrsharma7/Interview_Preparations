package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test32 {
	public String reformatDate(String date) {

		HashMap<String, String> months = new HashMap<String, String>();
		months.put("Jan", "01");
		months.put("Feb", "02");
		months.put("Mar", "03");
		months.put("Apr", "04");
		months.put("May", "05");
		months.put("Jun", "06");
		months.put("Jul", "07");
		months.put("Aug", "08");
		months.put("Sep", "09");
		months.put("Oct", "10");
		months.put("Nov", "11");
		months.put("Dec", "12");

		StringBuilder sb = new StringBuilder("");
		String delim = " ";
		StringTokenizer st = new StringTokenizer(date, delim);
		String Day = st.nextToken();
		String Month = st.nextToken();
		String Year = st.nextToken();

		String DD = Day.substring(0, Day.length() - 2);
		String MM = months.get(Month);
		String YYYY = Year;

		sb.append(YYYY);
		sb.append("-");
		sb.append(MM);
		sb.append("-");
		if (DD.length() == 1)
			sb.append("0");
		sb.append(DD);
		String res = sb.toString();
		return res;
	}

	public static void main(String[] args) {
		Test32 test26 = new Test32();
		test26.reformatDate("1st Mar 2068");
	}
}
