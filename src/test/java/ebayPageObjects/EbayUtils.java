package ebayPageObjects;

public class  EbayUtils {
	private static String username="gridfusion";
	private static String password="SeleniumRocks";
	private static String itemid="171202973367";
	
	
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
	public static String getItemid() {
		return itemid;
	}
	
	public static void setUsername(String username) {
		EbayUtils.username = username;
	}
	public static void setPassword(String password) {
		EbayUtils.password = password;
	}
	

}
