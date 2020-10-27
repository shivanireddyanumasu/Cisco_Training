package pages;

import org.openqa.selenium.By;

public class Kohler_ProductDisplayPages {
//	public By SearchBar = By.id("nav-searchbox");
//	public By CompareOverlay_Expand = By.xpath("//*[@id='compare-products-bar__dropdown-button']/span[2]/i");
//	public By CompareOverlay_ClearAll = By.xpath("//*[@id='compare-products-bar__clear-all-button']");
//	public By CompareButton= By.xpath("//*[@id='product-detail__compare_wrapper']/div[3]/button");
//	public By CompareOverlay =By.xpath("//*[@id='compare-products-bar__dropdown-button']/span[1]");
//	//public By CompareOverlay_productDetails =By.xpath("//*[@id='compare-products-bar__dropdown-button']/span[1]");
//	public By CompareOverlay_productDetail =By.xpath("//*[@id=\"compare-product--1\"]/div/p[2]");
//	public By CompareOverlay_compare =By.xpath("//*[@id=\"compare-products-bar__dropdown-button-container\"]");
//	public By Compareoverlay_header = By.xpath("//*[@id=\"compare-products-bar__dropdown-button\"]/span[1]");
//	public By CompareOverlay_close = By.xpath("//*[@id=\"compare-products-bar__dropdown-button\"]/span[3]/i");
//	//*[@id="compare-products-bar__dropdown-button"]/span[3]/i
//		
//	//Method to verify Compare product Modal
//	
//	public By kitchen =By.id("main-nav__button--kitchen");
//	public By Accessories =By.linkText("Accessories");
//	public By ProductMaterial = By.xpath("//*[@id='article-page__article-panels']/div/div[1]/div[1]/a/img[1]");
//	public By ProductGrid  = By.xpath("//*[@id='product-category__product-panels']/div[1]/div/a[1]/div/img");
//	
//	//Method to verify PDPPage Options-
//	//public By PairsWell  = By.xpath("//*[@id='product-detail__pairs-well-with']/h2");
//	public By PairsWell = By.xpath("//*[@id='product-detail__pairs-well-with']");
//	public By AddRequiredItems  = By.xpath("//*[@id='product-detail__add-required-items-button']");
//	public By RequiredItemsHeader  = By.xpath("//*[@id='modal--required-items']/div/h4");
//
//	//Method to verify Discontinued Product
//	public By DiscontinuedCrousel  = By.xpath("//*[@id=\"product-detail__carousel-hero-slides\"]/div/div/div/div[1]/div/h2");
//	public By Discontinued  = By.xpath("//*[@id='product-detail__features']/div[2]/p[1]/a");
//	
//	//Method to verify AddtoCart_PDPPage--------------------------------------------
//	public By PDP_CartIcon  = By.xpath("//*[@id='main-nav__item--cart']/a/span");
//	public By CartPage_Header  = By.xpath("//*[@id=\"shopping-cart\"]/div[2]/div/h1");
//	public By Removeproduct = By.xpath("//*[@class='order-detail-table__product-summary-container']/p[4]/a");
//	public By ContinueShopping_CartPage = By.xpath("//*[@id=\"cart-continue-shopping-button\"]");
//	public By PDP_CartIconFlag = By.xpath("//*[@id='main-nav__item--cart']/a/span/span"); 
//	public By PDP_AddToCart = By.xpath("//*[@id='productDetails']/div[3]/button[1]");
//	public By PDP_AddToCartModalHeader = By.xpath("//*[@id='modal--added-to-cart']/div/div[1]/div[2]/h5");
//	public By PDP_AddToCartModal = By.xpath("//*[@id='modal--added-to-cart']/div");
//	public By PDP_AddToCartContinueShopping = By.xpath("//*[@id=\"added-cart-modal-both\"]/footer/div/div[1]/button");
//	public By Productdetail_CartPage = By.xpath("//*[@id=\"shopping-cart\"]/div[3]/div[2]/div[2]/div[1]/div[2]/p[1]/a");
//	
//	//Method for signIn
//	public By Search_HomePage  = By.xpath("//*[@id='nav-searchbox']");
//	public By btn_SigninHomePage  = By.xpath("//*[@id=\"user-name-tray\"]");
//	public By SignInModalPopup = By.xpath("//*[@id=\"modal--sign-in\"]/div/div");
//	public By EmailAddress = By.xpath("//*[@id=\"email\"]");
//	public By Password = By.xpath("//*[@id=\"password\"]"); 
//	public By btn_Signin  = By.xpath("//*[@id=\"trayProfileSignIn\"]");
//	
//	
//	//Method to verify Sellable Service part---------search
//	public By DisContinuedProductSearch  = By.xpath("//*[@id='search-hero-navigation']/a");
//	public By Sellablapart = By.xpath(".//div[@id='search-hero-navigation']/a");
//	
//	public By  FindaStore = By.xpath("//*[@id='storeLocator']/button");
//	//public By PDP_AddToCart  = By.xpath("//*[@id='productDetails']/div[3]/button[1]");
	
	public By SearchBar = By.id("nav-searchbox");
	public By CompareOverlay_Expand = By.xpath("//*[@id='compare-products-bar__dropdown-button']/span[2]/i");
	public By CompareOverlay_ClearAll = By.xpath("//*[@id='compare-products-bar__clear-all-button']");
	public By CompareButton= By.xpath("//*[@Class=\"buttonAddToCompare add-to-compare btn btn--gray full-width-sm\"]");
	public By CompareOverlay =By.xpath("//*[@id='compare-products-bar__dropdown-button']/span[1]");
	public By Compare_expand = By.xpath("//*[@id=\"compare-products-bar__compare-button\"]");
	public By CompareOverlay_productDetail =By.xpath("//*[@class=\"compare-product__sku\"]");
	public By CompareOverlay_compare =By.xpath("//*[@id=\"compare-products-bar__dropdown-button-container\"]");
	public By Compareoverlay_header = By.xpath("//*[@id=\"compare-products-bar__dropdown-button\"]/span[1]");
	public By CompareOverlay_close = By.xpath("//*[@id=\"compare-products-bar__dropdown-button\"]/span[3]/i");
    public By kitchen =By.id("main-nav__button--kitchen");
	public By Accessories =By.linkText("Accessories");
	public By ProductMaterial = By.xpath("//*[@id='article-page__article-panels']/div/div[1]/div[1]/a/img[1]");
	public By ProductGrid  = By.xpath("//*[@id='product-category__product-panels']/div[1]/div/a[1]/div/img");
	public By products = By.xpath("//*[@Class=\"col-4-lg col-6-md col-6-sm product-panel product-panel-height-new\"]");
	public By bathroom = By.id("//*[@id=\"main-nav__button--bathroom\"]");
	public By searchicon = By.xpath("//*[@class=\"fas fa-search\"]");
	public By PairsWell = By.xpath("//*[@id=\"product-detail__pairs-well-with\"]/h2");
	public By AddRequiredItems  = By.xpath("//*[@id=\"product-detail__add-required-items-button\"]");
	public By RequiredItemsHeader  = By.xpath("//*[@id='modal--required-items']/div/h4");
    public By include_item = By.xpath("//*[@id='required-items']/div[@class='additional-item row marg-b-30-sm pad-b-30-sm row--bottom-border']");
    public By DiscontinuedCrousel  = By.xpath("//*[@Class=\"product-detail__carousel-hero-copy-inner\"]/h2");
	public By Discontinued  = By.xpath("//*[@id='product-detail__features']/div[2]/p[1]/a");
	public By PDP_CartIcon  = By.xpath("//*[@id='main-nav__item--cart']/a/span");
	public By CartPage_Header  = By.xpath("//*[@id=\"shopping-cart\"]/div[2]/div/h1");
	public By Removeproduct = By.xpath("//*[@class=\"order-detail-table__product-summary-container\"]//p[4]//a");
	public By ContinueShopping_CartPage = By.xpath("//*[@id=\"cart-continue-shopping-button\"]");
	public By PDP_CartIconFlag = By.xpath("//*[@id='main-nav__item--cart']/a/span/span"); 
	public By PDP_AddToCart = By.xpath("//*[@id='productDetails']/div[3]/button[1]");
	public By PDP_AddToCartModalHeader = By.xpath("//*[@Class=\"arrange__size-fit\"]/h5");
	public By PDP_AddToCartModal = By.xpath("//*[@id='modal--added-to-cart']/div");
	public By PDP_AddToCartContinueShopping = By.xpath("//*[@Class=\"continue-shoping\"]");
	public By Productdetail_CartPage = By.xpath("//*[@class=\"order-detail-table__sku\"]//a");
	public By Search_HomePage  = By.xpath("//*[@id='nav-searchbox']");
	public By btn_SigninHomePage  = By.xpath("//*[@id=\"user-name-tray\"]");
	public By SignInModalPopup = By.xpath("//*[@id=\"modal--sign-in\"]/div/div");
	public By EmailAddress = By.xpath("//*[@id=\"email\"]");
	public By Password = By.xpath("//*[@id=\"password\"]"); 
	public By btn_Signin  = By.xpath("//*[@id=\"trayProfileSignIn\"]");
	public By DisContinuedProductSearch  = By.xpath("//*[@id='search-hero-navigation']/a");
	public By Sellablapart = By.xpath(".//div[@id='search-hero-navigation']/a");
	public By search_icon = By.id("header__button--search-button-desktop");
	public By FindaStore_btn = By.id("store-locatores");
	public By Search_Field = By.xpath("//*[@id=\"nav-searchbox\"]");
	public By Search_button= By.xpath("//*[@id=\"header__button--search-button-desktop\"]/i") ;
	public By BreadCrumbs_list= By.xpath("//*[@id='breadcrumb-navigation']/div/a");
	public By BackToTop_button = By.xpath("//*[@id=\"back-to-top\"]/button");
	public By AddToCart_button  = By.xpath("//*[@id='productDetails']/div[3]/button[1]");
	public By StoreLocator_PDPPage = By.xpath("//*[@id='product-detail__tier']/div/div[1]/div/div/div/div/div[2]/button");	
	public By StoreLocatorHeader = By.xpath("//*[@id='store-locator']/div/h1");
	
	
	
}

