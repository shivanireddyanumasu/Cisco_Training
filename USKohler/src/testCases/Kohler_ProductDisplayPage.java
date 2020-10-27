package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePage.BaseClass;
import pages.Kohler_ProductDisplayPages;
import yaml.ProductDisplayPage;

public class Kohler_ProductDisplayPage extends BaseClass 
{
	private Kohler_ProductDisplayPages  productdisplaypage = null;

	public Kohler_ProductDisplayPage () 
	{
		productdisplaypage  = new Kohler_ProductDisplayPages();
}
	
	ProductDisplayPage PDP= ProductDisplayPage.getproductData();

	//Method to verify AddtoCart_PDPPage
		public void  VerifyAddtoCart_PDPPage() throws InterruptedException
		  {
			try
				{	
				   //Removing products from Add to cart
					String pageTitle= driver.getTitle();						
			        String CartText = driver.findElement(productdisplaypage.PDP_CartIconFlag).getText();
			        if(!CartText.equals("0")) 
			    	 {				
			            driver.findElement(productdisplaypage.PDP_CartIconFlag).isDisplayed();			    						    			
			            driver.findElement(productdisplaypage.PDP_CartIconFlag).click();
			            waitForLoad(driver);
			    		WebDriverWait wait4 = new WebDriverWait(driver,120);
			    		wait4.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.Removeproduct));			    		
			    		driver.findElement(productdisplaypage.Removeproduct).click();
			    	}
			            
					String ProductID = PDP.productId1;
					logger.info("Searching for product: "+ ProductID);
					driver.findElement(productdisplaypage.SearchBar).sendKeys("5588-0");
				    waitForLoad(driver);	
					driver.findElement(productdisplaypage.search_icon).click();
						
				     WebDriverWait wait42 = new WebDriverWait(driver,100);
					 wait42.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.PDP_AddToCart));					
					 String cartFlagText= driver.findElement(productdisplaypage.PDP_CartIconFlag).getText();
					 						
					 logger.info("Checking Add To Cart button is displayed in PDP page");					
				   	 boolean add_to_cart = driver.findElement(productdisplaypage.PDP_AddToCart).isDisplayed();
					 Assert.assertTrue( add_to_cart, "Add To Cart button is not displayed in PDP page");
					  {
						logger.info("Add To Cart button is displayed in PDP page");							
						logger.info("Clicking on Add To Cart button in PDP page");	
						 JavascriptExecutor js7 = ((JavascriptExecutor) driver);
						 js7.executeScript("window.scrollTo(0, 200)");
					     //js7.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(productdisplaypage.PDP_AddToCart)); 
						driver.findElement(productdisplaypage.PDP_AddToCart).click();					
						WebDriverWait wait43 = new WebDriverWait(driver,120);
						wait43.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.PDP_AddToCartModalHeader));						
						String Text = driver.findElement(productdisplaypage.PDP_AddToCartModalHeader).getText();														
					  
						logger.info("Checking Add To Cart modal is displayed");														
					    if (driver.findElement(productdisplaypage.PDP_AddToCartModal).isDisplayed() && Text.equals("ADDED TO CART"))
						  {
							logger.info("Add To Cart modal popup is displayed and product added to cart after clicking on Add to cart button");
							logger.info("Clicking on continue shopping inadd to cart modal");
							driver.findElement(productdisplaypage.PDP_AddToCartContinueShopping).isDisplayed();
							driver.findElement(productdisplaypage.PDP_AddToCartContinueShopping).click();
							waitForLoad(driver);
						  }								
						else
						  {								
							Assert.fail("Add To Cart modal popup is not displayed and product not added to cart after clicking on Add to cart button");
						  }
							
						    WebDriverWait wait44 = new WebDriverWait(driver,120);
						    wait44.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.PDP_CartIconFlag));
							String CartFlagtextafterAddingproduct = driver.findElement(productdisplaypage.PDP_CartIconFlag).getText() ; 
						
						    //Checking Quantity of 1 display in the cart icon flag on to top right corner of the page after adding product to cart
							
							if(driver.findElement(productdisplaypage.PDP_CartIconFlag).getText().equals("1") && !CartFlagtextafterAddingproduct.equals(cartFlagText))
							{
								logger.info("Quantity of 1 display in the cart icon flag on to top right corner of the page after adding product to cart");
							}							
							else
							{							
								Assert.fail("Quantity of 1 is not display in the cart icon flag on to top right corner of the page after adding product to cart");
							}
							
							
							logger.info("Clicking on Cart icon and checking product 5588-0 displays on the page");
							
							driver.findElement(productdisplaypage.PDP_CartIcon).isDisplayed();
							driver.findElement(productdisplaypage.PDP_CartIcon).click();
							
							WebDriverWait wait6 = new WebDriverWait(driver,120);
							wait6.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.CartPage_Header));
							
							String Cartpageheadder = driver.findElement(productdisplaypage.CartPage_Header).getText();
							
							if(Cartpageheadder.equals("Your Shopping Cart")) 
							Assert.assertEquals(Cartpageheadder,"Your Shopping Cart", "Cart page is not displayed after clicking on cart icon");
							{
								logger.info("Cart page displays after clicking on cart icon");
								WebDriverWait wait45 = new WebDriverWait(driver,120);
								wait45.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.Productdetail_CartPage));
								
								String ProductDetails = driver.findElement(productdisplaypage.Productdetail_CartPage).getText();													
								Assert.assertEquals(ProductDetails, ProductID, " products matched . Product Displayed: "+ ProductDetails + " and expected: "+ProductID);								
								logger.info(ProductID + " is dispalyed in cart page");
								
								logger.info("Clicking on continue shopping in cart page");
								JavascriptExecutor js8 = ((JavascriptExecutor) driver);
								js8.executeScript("window.scrollTo(0, 700)");
								 //js8.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(productdisplaypage.ContinueShopping_CartPage));        
//								WebDriverWait wait455 = new WebDriverWait(driver,120);
//								wait455.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.ContinueShopping_CartPage));
				
								driver.findElement(productdisplaypage.ContinueShopping_CartPage).click();														
								String pagetitle = driver.getTitle();
								Assert.assertEquals(pagetitle, pageTitle, "Clciking on continue shopping in cart page not navigating to home page");
								logger.info("Clciking on continue shopping in cart page is navigating to home page");
								driver.navigate().back();
							}								
					  }						
					}
					
					catch(Exception ex) {
						Assert.fail(ex.getMessage());
					}
					
					
				}

							
//Method to verify CompareOverlay Display and Disappear
public void VerifyCompareOverlayDisplayandDisappear() throws InterruptedException
{
	driver.manage().deleteAllCookies();
	try
	{
	    String ProductID = PDP.productId1	;
		driver.findElement(productdisplaypage.SearchBar).sendKeys(ProductID);
		waitForLoad(driver);
		driver.findElement(productdisplaypage.search_icon).click();
		waitForLoad(driver);
		String Product = driver.findElement(By.xpath("//*[@class=\"product-detail__name-and-description\"]")).getText();
		logger.info(Product);
			
	    logger.info("checking compare overlay is already in expanded state");
		                 
	   if(driver.findElement(productdisplaypage.Compare_expand).isDisplayed()) 			    	
	    {
		   driver.findElement(productdisplaypage.CompareOverlay_Expand).click();
		   waitForLoad(driver);
	       driver.findElement(productdisplaypage.CompareOverlay_ClearAll).isDisplayed();			
	       driver.findElement(productdisplaypage.CompareOverlay_ClearAll).click();
	       logger.info("Cleared all products from compare overlay");
	    }
	   else
	   {
		   logger.info("Compare overlay is not in expanded state");
	   }
	   			   
		logger.info("Clicking on Compare button in PDP page");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, 100)"); 
		driver.findElement(productdisplaypage.CompareButton).click();
		waitForLoad(driver);
				
        logger.info("Checking Compare Overlay is displayed after clicking on +Compare button");

        WebDriverWait wait112 = new WebDriverWait(driver,100);
	    wait112.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.CompareOverlay_compare));
        boolean compare_overlay = driver.findElement(productdisplaypage.CompareOverlay_compare).isDisplayed();
        
        Assert.assertTrue(compare_overlay, "Compare Overlay is not displayed");
		{
			logger.info("Compare Overlay is displayed");					
			WebDriverWait wait12 = new WebDriverWait(driver,120);
			wait12.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.CompareOverlay));
			waitForLoad(driver);
			String Text = driver.findElement(productdisplaypage.CompareOverlay_productDetail).getText();
			logger.info(Text);
			Text = Text+"-0";					
			Assert.assertEquals(Text, ProductID, "Mismatch in Product that was added for compare. Actual: "+Text+" Expected: "+ProductID);					
			logger.info("Product is added to compare");
		}				
		
		logger.info("Clicking on Clear all option from Compare overlay display");
		
		driver.findElement(productdisplaypage.CompareOverlay_ClearAll).isDisplayed();
		
		driver.findElement(productdisplaypage.CompareOverlay_ClearAll).click();
		
		logger.info("Checking Compare overlay is dissapeared after Clicking on Clear all option");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		boolean compare_button = driver.findElement(By.xpath("//*[@id=\"compare-products-bar__compare-button\"]")).isDisplayed();
		Assert.assertFalse(compare_button, "Compare Overlay has not dissapearred after clicking on clear all");
		logger.info("Compare Overlay has dissapeared after clicking on clearall");
		driver.navigate().back();
							
	}

	catch(Exception ex)
	{
		Assert.fail(ex.getMessage());
	}
	
}

////Method to verify Compare product Modal
public void VerifyCompareproductModal() throws InterruptedException
{
	driver.manage().deleteAllCookies();
	
	try

	{
	
	String[] productids =  PDP.products;
	for (int index=0  ; index<productids.length ; index++)
	  { 
		System.out.println(productids[index]);
		logger.info("Adding products of Toilets category to compare" );
		waitForLoad(driver);
		 WebDriverWait wait3245 = new WebDriverWait(driver,120);
         wait3245.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.SearchBar));

		driver.findElement(productdisplaypage.SearchBar).sendKeys(productids[index]);
		waitForLoad(driver);
		 WebDriverWait wait32495 = new WebDriverWait(driver,120);
         wait32495.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.search_icon));
		driver.findElement(productdisplaypage.search_icon).click();	
		waitForLoad(driver);
		logger.info("Clicking on Compare button in Compare overlay display");
	    JavascriptExecutor js3 = ((JavascriptExecutor) driver);
	    js3.executeScript("window.scrollTo(0, 500)");
	       
			driver.findElement(productdisplaypage.CompareButton).click();
	   
	   }

     logger.info(" checking Compare panel displayed");
     WebDriverWait wait32 = new WebDriverWait(driver,120);
     wait32.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.Compareoverlay_header));
	 String Text = driver.findElement(productdisplaypage.Compareoverlay_header).getText();
	     			
		
			if(Text.equals("COMPARE PRODUCTS"))
			{
				logger.info("opening compare overlay");
 				WebDriverWait wait31 = new WebDriverWait(driver,120);
		        wait31.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.CompareOverlay_Expand));
 				logger.info("clicking on third product to verify 3 products are present in compare overlay");
 				WebDriverWait wait322 = new WebDriverWait(driver,120);
		        wait322.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"compare-product--3\"]")));
				driver.findElement(By.xpath("//*[@id=\"compare-product--3\"]")).click();
				logger.info("Compare modal displayed with 3 products");
				driver.navigate().back();
			}
			
			else
			{				
				Assert.fail("Compare modal is not displayed after cliking on compare button");
			}
		
	}
	
	catch(Exception ex) {
		Assert.fail(ex.getMessage());
	}				
	
}
		 		    
	

//Method For SignIn
	public void signIn()
{		
		try
		{
//			String UserName = PDP.UserName;
//			String password = PDP.password;
			//clicking on sigin button in homepage
			driver.findElement(productdisplaypage.btn_SigninHomePage).click();
			waitForLoad(driver);
            boolean modal = driver.findElement(productdisplaypage.SignInModalPopup).isDisplayed();
			Assert.assertTrue(modal,"sign in modal is not displayed");
			logger.info("sign in modal displays");
			driver.findElement(productdisplaypage.EmailAddress).clear();
			driver.findElement(productdisplaypage.EmailAddress).sendKeys(PDP.UserName);
			driver.findElement(productdisplaypage.Password).clear();
	        driver.findElement(productdisplaypage.Password).sendKeys(PDP.password);
			JavascriptExecutor js3 = ((JavascriptExecutor) driver);
		    js3.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(productdisplaypage.btn_Signin));        
			WebDriverWait wait5 = new WebDriverWait(driver,120);
			wait5.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.btn_Signin));	 			
			driver.findElement(productdisplaypage.btn_Signin).click();
			driver.navigate().back();	 		
		}
	
	catch(Exception ex) {
		Assert.fail(ex.getMessage());
	}
	
}	

//Method to verify PDPPage Options
	public void  VerifyOptions_PDPPage() throws InterruptedException
	{	
     try
     {
 	    String ProductID = PDP.productId2;
 	    logger.info("Searching for product: "+ ProductID);			
	    //driver.findElement(productdisplaypage.SearchBar).sendKeys("K-1949-RA-0");
	    driver.findElement(productdisplaypage.SearchBar).sendKeys(PDP.productId2);

	   WebDriverWait wait6 = new WebDriverWait(driver,100);
	   wait6.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.search_icon));	
	   driver.findElement(productdisplaypage.search_icon).click(); 
	   waitForLoad(driver); 
			
		logger.info("checking for pairs well with"); 					    		
 		String Text = driver.findElement(productdisplaypage.PairsWell).getText();
 		Assert.assertEquals(Text,PDP.pdpOptions, "pairs well with options is not displays");
 		logger.info("pairs well with options displays for"+ ProductID);
 		    				
 		logger.info("Checking Required items displayed for product: "+ProductID); 	    		
 		boolean requited_items = driver.findElement(productdisplaypage.AddRequiredItems).isDisplayed();
 		Assert.assertTrue(requited_items,"Required items  is not displayed for product:"+ProductID);
 		{
 			logger.info("Required items displays for product: "+ProductID); 	    			
 			logger.info("Clicking on Add required items button");
 			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, 300)");
 			WebDriverWait wait62 = new WebDriverWait(driver,100);
	    	wait62.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.AddRequiredItems));
 			driver.findElement(productdisplaypage.AddRequiredItems).click();
 			
 			List<WebElement> IncludeItemsList = driver.findElements(productdisplaypage.include_item);	    			
 			WebDriverWait wait63 = new WebDriverWait(driver,120);
 			wait63.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.RequiredItemsHeader));
 			
 			String Header = driver.findElement(productdisplaypage.RequiredItemsHeader).getText();
 			Assert.assertEquals(Header,"REQUIRED ITEMS", "Required items modal not displayed with items");
 			logger.info("Required items modal displayed with "+IncludeItemsList.size()+" items");	
 			driver.navigate().back();
 		}
 			        
     }
		
		catch(Exception ex) 
     {
			Assert.fail(ex.getMessage());
		}			
	}
	
//Method to verify Discontinued Product FOR 1003736-0
	public void DiscontinuedProduct() throws InterruptedException
	{
		try
		{

			String ProductID = PDP.productId3;
			logger.info("Searching for product: "+ ProductID);
		    //driver.findElement(productdisplaypage.SearchBar).sendKeys("1003736-0");
		    driver.findElement(productdisplaypage.SearchBar).sendKeys(PDP.productId3);

			WebDriverWait wait7 = new WebDriverWait(driver,50);
		    wait7.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.search_icon));	
			driver.findElement(productdisplaypage.search_icon).click();
			waitForLoad(driver);
    	 					
			logger.info("Checking Discontinued product detail page displays for product"+ ProductID);				
			String text = driver.findElement(productdisplaypage.DiscontinuedCrousel).getText();    			
			
			if(driver.findElement(productdisplaypage.DiscontinuedCrousel).isDisplayed() && text.equals("Discontinued"))
			{
				logger.info("Discontinued product detail page displays for product"+ ProductID);
			}
			
			else
			{
				Assert.fail("Discontinued product detail page is not displays for product"+ ProductID);
			}
			
			
			logger.info("Checking Discontinued product Links to replacement parts (if applicable)"+ ProductID);							    	   
		    waitForLoad(driver);

			List<WebElement> Links = driver.findElements(productdisplaypage.Discontinued);
			
			if(Links.size()>0)
			{
				logger.info("Links to replacement parts are present");
				
				String pageTitle = driver.getCurrentUrl();
				
				for(WebElement Link : Links)
				{
					String LinkText = Link.getText();
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
					Link.sendKeys(selectLinkOpeninNewTab);
		     
		            driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		            ArrayList<String> listofTabs = new ArrayList<String> (driver.getWindowHandles());
		            logger.info("Switching to new tab");
		            driver.switchTo().window(listofTabs.get(1));
		    		
		            logger.info("Getting new tab page url");
		    		String CurrentpageTitle = driver.getCurrentUrl();
		    		
		    		logger.info("Checking "+LinkText+" to replacement parts is navigated to respective page");
		    	
		    		if(pageTitle.equals(CurrentpageTitle))
		    		{	    							   
		    			Assert.fail("Link "+LinkText+" to replacement parts is not working");
		    		}
		    		else
		    		{    			
		    			logger.info("Link "+LinkText+" to replacement parts is navigated to respective page"); 
		    		}
		    		
		    		driver.close();
		    		driver.switchTo().window(listofTabs.get(0));				    						    		
				}
				driver.navigate().back();
			}
			
			else
			{
				Assert.fail("Links to replacement parts are not present");
			}
		}
		
		catch(Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

//Method to verify Sellable Service part
public void SellableServicepart() throws InterruptedException
{
	try
	{
		String ProductID = PDP.productId4;
		logger.info("Searching for product: "+ ProductID);
		waitForLoad(driver);
		//driver.findElement(productdisplaypage.SearchBar).sendKeys("K-14660-4-CP");
		driver.findElement(productdisplaypage.SearchBar).sendKeys(PDP.productId4);

		WebDriverWait wait8 = new WebDriverWait(driver,50);
	    wait8.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.search_icon));	
		driver.findElement(productdisplaypage.search_icon).click();
	
		WebDriverWait wait81 = new WebDriverWait(driver,100);
		wait81.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.PDP_AddToCart));
		
		logger.info("Checking Add To Cart button is displayed in PDP page");
		boolean Add_to_cart = driver.findElement(productdisplaypage.PDP_AddToCart).isDisplayed();
        Assert.assertTrue(Add_to_cart, "Add to cart  is not displayed");
		logger.info("Add To Cart button is displayed in PDP page");
			
		logger.info("Clicking on Add To Cart button");
		JavascriptExecutor js2 = ((JavascriptExecutor) driver);
		js2.executeScript("window.scrollTo(0, 300)");
		//js2.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(productdisplaypage.PDP_AddToCart));        
		driver.findElement(productdisplaypage.PDP_AddToCart).click();				
		waitForLoad(driver);
						
		String Text =  driver.findElement(productdisplaypage.PDP_AddToCartModalHeader).getText();										
		logger.info("Checking Add To Cart modal is displayed");
		if( driver.findElement(productdisplaypage.PDP_AddToCartModal).isDisplayed() && Text.equals("ADDED TO CART"))
			{
				logger.info("Add To Cart modal popup is displayed and product added to cart after clicking on Add to cart button");
				logger.info("Clicking on continue shopping in add to cart modal");
				
				WebDriverWait wait82 = new WebDriverWait(driver,200);
     			wait82.until(ExpectedConditions.visibilityOfElementLocated(productdisplaypage.PDP_AddToCartContinueShopping));
				JavascriptExecutor js5 = ((JavascriptExecutor) driver);
				js5.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(productdisplaypage.PDP_AddToCartContinueShopping));        		
				driver.findElement(productdisplaypage.PDP_AddToCartContinueShopping).click();
				driver.navigate().back();
			}			
		
			else
			{
		
				Assert.fail("Add To Cart modal popup is not displayed and product not added to cart after clicking on Add to cart button");
			}						
	}
	
	catch(Exception ex) {
		Assert.fail(ex.getMessage());
	}
			
}
		//Method to verify PDPpage
		public void VerifyPDPpage()
		{
			try
			{
				driver.findElement(productdisplaypage.FindaStore_btn).click();
				
				driver.findElement(productdisplaypage.Search_Field).sendKeys(PDP.productID);
				
				driver.findElement(productdisplaypage.Search_button).click();
				waitForLoad(driver);
				
				String ActualTitle = driver.getTitle();
				String SkuDetails = "K-"+PDP.productID;
				String SkuFromTitle = ActualTitle.substring(0, 9);
				
				logger.info("Verifying The Sku/product number in the page title is feature as (K-14660-4 or K-14660-4-CP)");
				Assert.assertEquals(SkuDetails, SkuFromTitle, "The Sku/product number in the page title is not feature as (K-14660-4 or K-14660-4-CP). Expected: "+ SkuDetails+ ", Actula: "+SkuFromTitle);
				
				logger.info("Verifying page title");
				Assert.assertEquals(ActualTitle, PDP.expectedTitle, "Mismatch in page title. Expected: "+ PDP.expectedTitle+ ", Actula: "+ActualTitle);
				
				logger.info("Page title is as expected");
			}
			
			catch(Exception ex) {
				Assert.fail(ex.getMessage());
			}
			
			
		}
		
		//Method to verify Breadcrumbs_StoreLocator_PDPpage
		public void VerifyBreadcrumbs_StoreLocator_PDPpage()
		{
			try
			{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.findElement(productdisplaypage.FindaStore_btn).click();
				
				driver.findElement(productdisplaypage.Search_Field).sendKeys(PDP.productId);
				
				driver.findElement(productdisplaypage.Search_button).click();
           
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(productdisplaypage.AddToCart_button).isDisplayed();
				
				List<WebElement> BreadCrumbs = driver.findElements(productdisplaypage.BreadCrumbs_list);
				
				String pageTitle = driver.getTitle();
								
				for(WebElement BreadCrumb : BreadCrumbs)
				{
					String BreadCrumbText = BreadCrumb.getText();
					BreadCrumbText = BreadCrumbText.substring(0, BreadCrumbText.length()-2);
					
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
					
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					BreadCrumb.sendKeys(selectLinkOpeninNewTab);
					
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
		            ArrayList<String> listofTabs = new ArrayList<String>(driver.getWindowHandles());
		            
		            logger.info("Switching to new tab");
		            
		            driver.switchTo().window(listofTabs.get(1));
		            logger.info("Getting new tab page title");
		    		String CurrentpageTitle = driver.getTitle();
		    	
		    		if(!pageTitle.equals(CurrentpageTitle))
		    		{	    			
		    			logger.info("Clicking on breadcrumb "+BreadCrumbText+" redirecting correctly");
		    		}
		    		else
		    		{    			
		    			
		    			logger.info("Clicking on breadcrumbs links not redirecting correctly");
		    			Assert.fail("Clicking on breadcrumbs links not redirecting correctly");
		    		}
		    		
		    		
		    		driver.switchTo().window(listofTabs.get(0));
		    		
		    		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
				
				
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				driver.findElement(productdisplaypage.BackToTop_button).click();
				
				driver.findElement(productdisplaypage.FindaStore_btn).isDisplayed();
					
				driver.findElement(productdisplaypage.FindaStore_btn).click();
					
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.findElement(productdisplaypage.StoreLocatorHeader).isDisplayed();
				
				String StorelocatorpageTitle =driver.getTitle();
				
				String PageText = driver.findElement(productdisplaypage.StoreLocatorHeader).getText();
				
				if(!pageTitle.equals(StorelocatorpageTitle) && StorelocatorpageTitle.contains(PageText))
				{	    			
					logger.info("Clicking on Find a store redirecting correctly");
				}
				else
				{    			
					logger.info("Clicking on Find a store not redirecting correctly");
					Assert.fail("Clicking on Find a store not redirecting correctly");
				}
			}
			
			catch(Exception ex) {
				Assert.fail(ex.getMessage());
			}
			
			
		}
			
		}

	

