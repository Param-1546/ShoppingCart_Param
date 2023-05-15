package StepDefinition;

public interface Locators {
	public static final String AddItem_1 = "//div [@class='columns-3']/ul/li[";
	public static final String AddItem_2 = "]/div/a[2]";
	public static final String ViewCart = "//div[@class = \\\"ellie-thumb-wrapper\\\"][1]/a[3]";
	public static final String ListOfItems = "//table[@class = \\\"shop_table shop_table_responsive cart woocommerce-cart-form__contents\\\"]/tbody/tr";
	public static final String LowestPriceItem_1 = "//table[@class = \"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr[";
	public static final String LowestPriceItem_2 = "]/td[6]/span/span";
	public static final String DeleteItem_1 = "//table[@class = \"shop_table shop_table_responsive cart woocommerce-cart-form__contents\"]/tbody/tr["; 
	public static final String DeleteItem_2 = "]/td[1]/a";
}
