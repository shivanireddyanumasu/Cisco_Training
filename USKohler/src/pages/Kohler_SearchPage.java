package pages;

import org.openqa.selenium.By;

public class Kohler_SearchPage {
	public By search_box = By.xpath("//*[@id='nav-searchbox']");
	public By search_button = By.xpath("//*[@id='header__button--search-button-desktop']");
	public By iperceptions = By.xpath("//*[@id='iPerceptionsFrame']");
	public By search_label = By.xpath("//*[@id='search-hero']/div/div[2]/h2");
	public By search_tabs = By.xpath("//*[@id='search-hero-navigation']/a");
	public By inspiration_tab = By.xpath("//*[@id=\"search-hero-navigation\"]/a[2]");
	public By show_me_more = By.linkText("Show me more");
	public By cookie_accept = By.xpath("//*[@id=\"truste-consent-button\"]");
	public By cookie_banner = By.xpath("//*[@id=\"truste-consent-content\"]");
	public By ideas_h1 = By.xpath("//div[@class='content col2x']/div/h1");
	public By resources_tab = By.xpath("//*[@id='search-hero-navigation']/a[4]");
	public By read_the_article = By.linkText("Read the article");
	public By iperceptions_div = By.xpath("//*[@id=\"IPEinvL128313\"]");
	public By iperceptions_div_close = By.xpath("//*[@id=\"IPEinvL128313\"]/div[1]/div[2]");
	public By search_label_h2 = By.xpath("//*[@id=\"search-hero\"]/div/div[2]/h2");
	public By search_suggestion = By.xpath("//*[@id=\"search-suggestions--desktop\"]/div/div");
	public String search_suggestion_div = "//*[@id=\"search-suggestions--desktop\"]/div/div";
	public By signup_modal = By.xpath("//*[@id=\"signupModal\"]");
	public By signup_modal_close = By.xpath("//*[@id=\"signupModal\"]/div/span");
	public By search_result = By.xpath("//*[@id=\"search-results-panels\"]/div[1]/div[1]");
	public By search_result_text = By.xpath("//*[@id=\"search-results-panels\"]/div[1]/div[1]/a/p[1]");
	
	public String[] search_tabs_text = {"PRODUCTS", "INSPIRATION", "PARTS" , "RESOURCES" , "TECHNICAL", "HELP"};
	//public String ideas_url = "ideas.kohler.com";
	//public String tw_search = "Showing results for “two”";
	//----
	public By Support = By.xpath("//*[@id=\"main-nav__button--parts\"]/div[2]");
	public By Findparts = By.xpath("//*[@id=\"sub-nav-tab--parts\"]/div[2]/div/div[3]/ul/li[1]/a/span");
	//public By Findparts1 = By.xpath("//*[@id=\"main-nav__item--parts\"]//a//span[contains(text(),'Find Parts')]");
	public By Search_partsTerms = By.xpath("//*[@id=\"searchTerms\"]");
	public By Search_Find = By.xpath("//*[@id=\"findProduct\"]");
	public By memoirs_header = By.xpath("//*[@id=\"search-hero\"]/div/div[2]/h2");
	public By count = By.xpath("//*[@Class=\"result-count\"]");
	public By productTitle = By.xpath("//*[@Class=\"product-panel__description search-results-promo-height\"]");
	public By SearchBar = By.id("nav-searchbox");
	public By searchicon = By.id("header__button--search-button-desktop");
	
}

