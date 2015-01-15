
public class Test {

	public static void main(String[] args) {
		
		CSVBuilder builder = new CSVBuilder();
		builder.append("Vic Vega");
		builder.append("Marcellus Wallace");
		builder.append("Stuntman Mike");
		builder.append("Hans Landa");
		builder.append("Calvin Candie");
		builder.append(null);
		System.out.println(builder.toString());
	}
	
}
