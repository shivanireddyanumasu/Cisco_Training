package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePage.BaseClass;
import pages.Kohler_GeneralNavigationPages;
import yaml.GeneralNavigationData;

public class Kohler_GeneralNavigation extends BaseClass {
	private Kohler_GeneralNavigationPages Navigation_Pages=null;
	
	public Kohler_GeneralNavigation () {
		Navigation_Pages  = new Kohler_GeneralNavigationPages();
}
	GeneralNavigationData generalnavigation= GeneralNavigationData.getgeneralnavigationData();

	// verify Bathroom expansion and bathroom links
		public void VerifyBathroomMainMenu() {

			try {

				//verifying if the Bathroom link is displayed and navigated to corresponding page
				driver.findElement(Navigation_Pages.Link_bathroom).isDisplayed();
				driver.findElement(Navigation_Pages.Link_bathroom).click();
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
                if (driver.findElement(Navigation_Pages.Link_bathroomMainMenu).isDisplayed())
                Assert.assertTrue(true, "Bathroom main menu is expanded successfully");
                 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(Navigation_Pages.Link_bathroomPage).isDisplayed();

				int Win_size = driver.getWindowHandles().size();
				logger.info("Open Windows Size is :" + Win_size);
				driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				
				//Opening the Bathroom page link in new tab
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
				driver.findElement(Navigation_Pages.Link_bathroomPage).sendKeys(selectLinkOpeninNewTab);
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
                String pageURl = driver.getCurrentUrl();
				driver.switchTo().window(tabs2.get(1));
                wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.titleContains("Bathroom | KOHLER"));
                String pageTitle = driver.getTitle();
				logger.info("Page title is: " + pageTitle);
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				Assert.assertEquals(pageTitle, "Bathroom | KOHLER", "Page is not navigated to bathroom Page");
				
				//Iterating over all the links in the bathroom page
				List<WebElement> Bathroom_links = driver.findElements(Navigation_Pages.BathroomPage_sublinks);
				for (WebElement a:Bathroom_links) {

					System.out.println(a.getText());
					logger.info("Link text is :" + a.getText());
                    logger.info("Click on link in Bathroom homepage");
					String LinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
					a.sendKeys(LinkOpeninNewTab);
                    WebDriverWait wait1 = new WebDriverWait(driver, 30);
					wait1.until(ExpectedConditions.numberOfWindowsToBe(3));
					ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
                    String BathroompageURl = driver.getCurrentUrl();
					driver.switchTo().window(tabs3.get(2));
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					Win_size = driver.getWindowHandles().size();
					Assert.assertEquals(3, Win_size, "On clicking on link, the page is not opned in new window");
                    String CurrentpageURl = driver.getCurrentUrl();
					logger.info("verify the Page title" + CurrentpageURl);

					if (!CurrentpageURl.isEmpty() && !CurrentpageURl.equals(pageURl)&& !CurrentpageURl.equals(BathroompageURl))
						Assert.assertTrue(true, "Navigated to respective Page");

					driver.close();
					driver.switchTo().window(tabs3.get(1));
                 }
                driver.close();
				driver.switchTo().window(tabs2.get(0));

			} catch (Exception ex) {
				Assert.fail(ex.getMessage());
			}

		}

	//verify Bathroom menu links and link navigation
		public void verifyBathroomSubMenuLinks() {

			try {
				String PageUrl = driver.getCurrentUrl();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.findElement(Navigation_Pages.Link_bathroom).isDisplayed();
				driver.findElement(Navigation_Pages.Link_bathroom).click();

				if (driver.findElement(Navigation_Pages.Link_bathroomMainMenu).isDisplayed())
					Assert.assertTrue(true, "Bathroom main menu is expanded successfully");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				List<WebElement> Bathroom_SubMenuLinks = driver.findElements(Navigation_Pages.Bathroom_sublinks);
				for (WebElement a : Bathroom_SubMenuLinks) {
					String title = a.getText();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if (title.contains("Products")) {
						List<WebElement> Bathroom_ProductsLinks = driver.findElements(Navigation_Pages.Product_Links);
						for (WebElement b : Bathroom_ProductsLinks) {

							String Linktext = b.getText();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

							logger.info("verify the link text" + b.getText());
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

							logger.info("click on each link and verify in new tab");
							String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
							b.sendKeys(selectLinkOpeninNewTab);

							ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							if (tabs2.size() > 1) {
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								logger.info("Switching to new tab");
								driver.switchTo().window(tabs2.get(1));
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								logger.info("Getting new tab page title");

								String Currentpageurl = driver.getCurrentUrl();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								if (PageUrl.equals(Currentpageurl)) {

									Assert.fail("Clicking on link " + Linktext+ " is not redirecting to the corresponding page");
								} else {
									logger.info("Clicking on link " + Linktext + " is redirecting to the corresponding page");
								}

								driver.close();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								driver.switchTo().window(tabs2.get(0));
								driver.findElement(Navigation_Pages.Link_bathroom).click();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

							}

							else {

								String Currentpageurl = driver.getCurrentUrl();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								Assert.assertTrue(PageUrl.equals(Currentpageurl),"Clicking on link " + Linktext + " is not redirecting to the corresponding page");
								logger.info("Clicking on link " + Linktext + " is redirecting to the corresponding page");

								driver.navigate().back();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							}

						}
				} else if (title.contains("Resources & Tools") || title.contains("Featured")|| title.contains("Services")) {
						List<WebElement> Bathroom_FeatureLinks = driver.findElements(Navigation_Pages.Nonproduct_Links);
						for (int i = 6; i <= Bathroom_FeatureLinks.size() - 1; i++) {

							String Linktext = Bathroom_FeatureLinks.get(i).getText();
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							logger.info("verify the link text" + Bathroom_FeatureLinks.get(i).getText());

							logger.info("click on each link and verify in new tab");
							String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
							Bathroom_FeatureLinks.get(i).sendKeys(selectLinkOpeninNewTab);
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

							ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

							if (tabs2.size() > 1) {
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								logger.info("Switching to new tab");
								driver.switchTo().window(tabs2.get(1));
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								logger.info("Getting new tab page title");
								String Currentpageurl = driver.getCurrentUrl();

								if (PageUrl.equals(Currentpageurl)) {
									Assert.fail("Clicking on link " + Linktext+ " is not redirecting to the corresponding page");
								} else {
									logger.info("Clicking on link " + Linktext + " is redirecting to the corresponding page");
								}

								driver.close();
								driver.switchTo().window(tabs2.get(0));
								driver.findElement(Navigation_Pages.Link_bathroom).click();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

							}

							else {
								String Currentpageurl = driver.getCurrentUrl();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								Assert.assertTrue(PageUrl.equals(Currentpageurl),"Clicking on link " + Linktext + " is not redirecting to the corresponding page");
								logger.info("Clicking on link " + Linktext + " is redirecting to the corresponding page");

								driver.navigate().back();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							}

						}
					} else {

						continue;
					}
				}
			} catch (Exception ex) {
				Assert.fail(ex.getMessage());
			}

		}
		
	// Verify choreograph Shower Planner link functionality+ new Window
		public void verifychoreographShowerPlanner() {
			try {
				// verifying the Bathroom link is displayed and expanded
				logger.info("Verify choreograph Shower Planner link");
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				driver.findElement(Navigation_Pages.Link_bathroom).isDisplayed();
				driver.findElement(Navigation_Pages.Link_bathroom).click();

				if (driver.findElement(Navigation_Pages.Link_bathroomMainMenu).isDisplayed())
					Assert.assertTrue(true, "Bathroom main menu is expanded successfully");

				int Win_size = driver.getWindowHandles().size();
				logger.info("Open Windows Size is :" + Win_size);

				// verifying the choreograph shower planner link is navigating to correct page 
				driver.findElement(Navigation_Pages.Link_ChoregraphShowerPlanner).isDisplayed();
				driver.findElement(Navigation_Pages.Link_ChoregraphShowerPlanner).click();
				WebDriverWait wait = new WebDriverWait(driver, 10);

				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));

				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				logger.info("Page URL is: " + driver.getCurrentUrl());
				Win_size = driver.getWindowHandles().size();
				Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");

				logger.info("Close the Child Window: " + driver.getTitle());
				driver.close();
				driver.switchTo().window(tabs.get(0));

			} catch (Exception ex) {
				Assert.fail(ex.getMessage());
			}

		}
			
	// verify bathroom Product Buying guide and Article page
	public void VerifyBathroomProductBuyingGuide(){
		try 
			{
					waitForLoad(driver);
			
					if (driver.findElements(Navigation_Pages.cookie_banner).size() > 0) {
						driver.findElement(Navigation_Pages.cookie_accept).click();
					}
			        
			        //verifying product buying guide link and its navigation
					List<String> ShareLinkTextItems = new ArrayList<String>();
					String Share_linkText=null;
					logger.info("Verify Product Buying Guide link");
					driver.findElement(Navigation_Pages.Link_bathroom).isDisplayed();
				    driver.findElement(Navigation_Pages.Link_bathroom).click();
				    if(driver.findElement(Navigation_Pages.Link_bathroomMainMenu).isDisplayed())
				    Assert.assertTrue(true, "Bathroom main menu is expanded successfully");
				    logger.info("Verify Article page on clicking on PBG link");
                    driver.findElement(Navigation_Pages.Link_BathroomProductBuyingGuide).isDisplayed();
				    driver.findElement(Navigation_Pages.Link_BathroomProductBuyingGuide).click();
				    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				    boolean condtion= true;
					logger.info("Verify the Article Page URL");
					String URL = driver.getCurrentUrl();
					if(URL.contains("article"))
					Assert.assertTrue(condtion);
					
					//verifying if share, bookmark, print options are available
					List<WebElement> buttons = driver.findElements(Navigation_Pages.Guiding_buttons);
					int button_count = buttons.size();
					logger.info(button_count);
					for(WebElement button: buttons)
					{
						
						String text_button = button.getAttribute("class");
						logger.info(text_button);
						String text = text_button.replaceFirst("icon--", "");
						logger.info(text);
						switch (text)
						{
						case "bookmark":
							
	    					WebDriverWait wait = new WebDriverWait(driver,50);
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn--gray btn--icon btn--util triggerPod']")));
							button.click();
							waitForLoad(driver);
							
							//verifying Save to folders pop up is displayed
	     					driver.findElement(Navigation_Pages.Header_SaveToFolder).isDisplayed();
							String Header_text = driver.findElement(Navigation_Pages.Header_SaveToFolder).getText();
							Assert.assertEquals(Header_text,generalnavigation.saveTOFolders, "Application is not navigated to Save to folder window");
							driver.findElement(Navigation_Pages.textBox_SaveToFolder).isDisplayed();
							driver.findElement(Navigation_Pages.textBox_SaveToFolder).sendKeys(generalnavigation.test);
							driver.findElement(Navigation_Pages.button_SaveToFolderSave).isDisplayed();
						    driver.findElement(Navigation_Pages.button_SaveToFolderSave).click();
						    Thread.sleep(2000);
						    if(driver.findElement(Navigation_Pages.Win_ShowThankYou).isDisplayed())
							Assert.assertTrue(true, "Thank you page is expanded successfully");
							    
							//verifying if items are added to folder and success message dispaly
							driver.findElement(Navigation_Pages.title_ItemAddedToFold1).isDisplayed();
							String title1= driver.findElement(Navigation_Pages.title_ItemAddedToFold1).getText();
							logger.info(title1);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							driver.findElement(Navigation_Pages.title_ItemAddedToFold2).isDisplayed();
							String title2= driver.findElement(Navigation_Pages.title_ItemAddedToFold2).getText();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							logger.info(title2);
							String title = title1+" "+title2;
							Assert.assertEquals(title,generalnavigation.title, "Application is not navigated to My Kohler folder");
                            driver.findElement(Navigation_Pages.button_ItemAddedToFoldClose).isDisplayed();
						    driver.findElement(Navigation_Pages.button_ItemAddedToFoldClose).click();
						    
							break;

							case "share":
							
							button.click();
							driver.findElement(Navigation_Pages.Items_shareItems).isDisplayed();
							List<WebElement> shareLinks = driver.findElements(Navigation_Pages.Share_Links);
							//Iterating over all the social platform links
							for(WebElement linkText: shareLinks)
							{
								 Share_linkText = linkText.getText();
								 logger.info("Share options are : " + Share_linkText);
							}
							ShareLinkTextItems.add(Share_linkText);
							driver.findElement(Navigation_Pages.Items_shareItemFaceebook).isDisplayed();
						    driver.findElement(Navigation_Pages.Items_shareItemFaceebook).click();
							driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
							
							ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
							driver.switchTo().window(tabs.get(1));
						    logger.info("Page title is: " + driver.getTitle());
						    int Win_size = driver.getWindowHandles().size();
						    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
						    
						    logger.info("Close the Child Window: "+driver.getTitle());
						    driver.close();
						    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					    	driver.switchTo().window(tabs.get(0));
							
					    	break;
						case "print":
							//button.click();
							break;

						default:
							throw new Exception("The type of functionality is neither of the above.");
							
						}
						
	            }
			
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
			}	
			
	// Verify Kitchen expansion and kitchen links
	public void VerifyKitchenMainMenu() {

			try {
				
				//verifying Kitchen link expansion and navigation
				logger.info("verify Kitchen Main menu");
				driver.findElement(Navigation_Pages.Link_Kitchen).isDisplayed();
				driver.findElement(Navigation_Pages.Link_Kitchen).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                if (driver.findElement(Navigation_Pages.Link_kitchenMainMenu).isDisplayed())
				Assert.assertTrue(true, "Kitchen main menu is expanded successfully");
                driver.findElement(Navigation_Pages.Link_KitchenPage).isDisplayed();
                int Win_size = driver.getWindowHandles().size();
				logger.info("Open Windows Size is :" + Win_size);
                logger.info(driver.findElement(Navigation_Pages.Link_KitchenPage).getText());
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
				driver.findElement(Navigation_Pages.Link_KitchenPage).sendKeys(selectLinkOpeninNewTab);
                WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
                String pageURl = driver.getCurrentUrl();
				driver.switchTo().window(tabs2.get(1));
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
                String pageTitle = driver.getTitle();
				wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.titleContains("Kitchen | KOHLER"));

				logger.info("Page title is:" + pageTitle);
				Assert.assertEquals(pageTitle, "Kitchen | KOHLER", "Page is not navigated to Kitchen Page");

			   //Iterating over the links in the Kitchen page
				List<WebElement> Kitchen_links = driver.findElements(Navigation_Pages.Kitchenpage_links);
				for (WebElement a:Kitchen_links) {

					System.out.println(a.getText());
					logger.info("Link text is :" + a.getText());
                    logger.info("Click on link in Kitchen homepage");
					String LinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
					a.sendKeys(LinkOpeninNewTab);
                    wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.numberOfWindowsToBe(3));
					ArrayList<String> tabs3 = new ArrayList<String>(driver.getWindowHandles());
                    String KitchenpageURl = driver.getCurrentUrl();
					driver.switchTo().window(tabs3.get(2));
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					Win_size = driver.getWindowHandles().size();
					Assert.assertEquals(3, Win_size, "On clicking on link, the page is not opned in new window");
                    String CurrentpageURl = driver.getCurrentUrl();
					logger.info("verify the Page title" + CurrentpageURl);

					if (!CurrentpageURl.isEmpty() && !CurrentpageURl.equals(pageURl)&& !CurrentpageURl.equals(KitchenpageURl))
						Assert.assertTrue(true, "Navigated to respective Page");
                    driver.close();
					driver.switchTo().window(tabs3.get(1));

				}

				driver.close();
				driver.switchTo().window(tabs2.get(0));

			} catch (Exception ex) {
				Assert.fail(ex.getMessage());
			}

		}

	// verify Kitchen menu links and link navigation
	public void verifyKitchenSubMenuLinks() {
		try {

			driver.findElement(Navigation_Pages.Link_Kitchen).isDisplayed();
			driver.findElement(Navigation_Pages.Link_Kitchen).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String pageURl = driver.getCurrentUrl();

			if (driver.findElement(Navigation_Pages.Link_kitchenMainMenu).isDisplayed())
				Assert.assertTrue(true, "Kitchen main menu is expanded successfully");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> Kitchen_InnerLinks = driver.findElements(Navigation_Pages.Kitchen_sublinks);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
			for (WebElement a:Kitchen_InnerLinks) {
				System.out.println(a.getText());
				String Linktext = a.getText();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
				logger.info("verify the link text" + a.getText());

				logger.info("click on each link and verify in new tab");
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
				a.sendKeys(selectLinkOpeninNewTab);

				ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

				if (tabs2.size() > 1) {
					logger.info("Switching to new tab");
					driver.switchTo().window(tabs2.get(1));
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					logger.info("Getting new tab page title");
					String Currentpageurl = driver.getCurrentUrl();

					if (pageURl.equals(Currentpageurl)) {

						Assert.fail("Clicking on link " + Linktext + " is not redirecting to the corresponding page");
					} else {
						logger.info("Clicking on link " + Linktext + " is redirecting to the corresponding page");
						}

					driver.close();
					driver.switchTo().window(tabs2.get(0));
					driver.findElement(Navigation_Pages.Link_Kitchen).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

					}

				else {
					String Currentpageurl = driver.getCurrentUrl();
					Assert.assertTrue(pageURl.equals(Currentpageurl), "Clicking on link " + Linktext + " is not redirecting to the corresponding page");
					driver.navigate().back();
						
				}

				}

			}

			catch (Exception ex) {
				Assert.fail(ex.getMessage());
			}

		}

	// Verify kitchen Planner link functionality+ new Window
	public void verifyKitchenPlanner(){
		
	  try
			{
		  		//verifying kitchen planner link and its navigation
				logger.info("Verify Kitchen Planner link");
				driver.findElement(Navigation_Pages.Link_Kitchen).isDisplayed();
				driver.findElement(Navigation_Pages.Link_Kitchen).click();
					
				if(driver.findElement(Navigation_Pages.Link_kitchenMainMenu).isDisplayed())
						Assert.assertTrue(true, "Kitchen main menu is expanded successfully");
					
					int Win_size = driver.getWindowHandles().size();
					logger.info("Open Windows Size is :" + Win_size);
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(Navigation_Pages.Link_kitchenPlanner).isDisplayed();
				    driver.findElement(Navigation_Pages.Link_kitchenPlanner).click();
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					WebDriverWait wait = new WebDriverWait(driver,50);
					wait.until(ExpectedConditions.numberOfWindowsToBe(2));
					ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs.get(1));
					wait = new WebDriverWait(driver,50);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer-title")));
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					logger.info("Page URL is: " + driver.getCurrentUrl());
				    Win_size = driver.getWindowHandles().size();
				    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
				    logger.info("Close the Child Window: "+driver.getCurrentUrl());
				    driver.close();
			    	driver.switchTo().window(tabs.get(0));
			    	
					}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
		}		
			
	// verify Press room link/ functionality
			public void VerifyPressRoomLink()
			{
				try {
					
					waitForLoad(driver);
					//verifying pressroom link is navigating to press page
					if (driver.findElements(Navigation_Pages.cookie_banner).size() > 0) {
						driver.findElement(Navigation_Pages.cookie_accept).click();
					}
			        driver.findElement(Navigation_Pages.Link_PressRoom).isDisplayed();
				    driver.findElement(Navigation_Pages.Link_PressRoom).click();
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					logger.info("Verify the Press Room Page Title");
					WebDriverWait wait = new WebDriverWait(driver,50);
					wait.until(ExpectedConditions.titleContains("Press Room | KOHLER"));
					Assert.assertEquals(driver.getTitle() ,"Press Room | KOHLER","Home Page Title mismatch");
					driver.findElement(Navigation_Pages.text_pressRoom).isDisplayed();
					String page_title=driver.findElement(Navigation_Pages.text_pressRoom).getText();
					logger.info("The Press Room Page Header is : " +page_title);
					Assert.assertEquals(page_title,generalnavigation.press ,"Page header mis matches");
					
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
			}	
	// verify Find a store functionality
	public void VerifyFindAStore() {
			
		try
				{
					//verifying Find a store Link functionality
					List<String> StoreLocationResults = new ArrayList<String>();
					String resultName=null;
					logger.info("Verify Find a Store link");
					driver.findElement(Navigation_Pages.Link_FindaStore).isDisplayed();
				    driver.findElement(Navigation_Pages.Link_FindaStore).click();
				    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					WebDriverWait wait = new WebDriverWait(driver,50);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='store-locator__num-results']/span[1]")));
					
					//verifying clicking on link is navigated to correct page
					logger.info("Verify the Find a Store Page Title");
					System.out.println(driver.getTitle());
					Assert.assertEquals(driver.getTitle() ,"Results | Find a Store | KOHLER","Home Page Title mismatch");
					
					logger.info("Verify store locator text");
					driver.findElement(Navigation_Pages.text_NoStoreLocator).isDisplayed();
					String storeLocatorText = driver.findElement(Navigation_Pages.text_NoStoreLocator).getText();
					String expectedStoreLocText= "We are sorry, but we have no stores within 250 miles of your location. Please try another search.";
					//checking if the results are displayed 
					if(!storeLocatorText.equalsIgnoreCase(expectedStoreLocText))
					{
						logger.info("Store is within the radius of your location");
						String StoreLocator_text =driver.findElement(Navigation_Pages.text_StoreLocator_num).getText() +driver.findElement(Navigation_Pages.text_StoreLocator_result).getText() + " for " + driver.findElement(Navigation_Pages.text_StoreLocator_location).getText();
						logger.info("Store is within the radius and results are: "+ StoreLocator_text);
						driver.findElement(Navigation_Pages.count_StoreLocator_results).isDisplayed();
						Assert.assertEquals(driver.findElement(Navigation_Pages.text_StoreLocator_num).getText().toString(), driver.findElement(Navigation_Pages.count_StoreLocator_results).getSize(), "Store locator count is not matching with store locator results");
						
						List<WebElement> storeLocator_results = driver.findElements(Navigation_Pages.Count_results);
						//Iterating over all the results
						for (WebElement a:storeLocator_results)
						{
							resultName= a.getText();
							logger.info("Store results name is: "+ resultName);
							StoreLocationResults.add(resultName);	
						}
					}
					else
					{
						logger.info("Store is not within the radius of your location");
					}
					
					logger.info("Input a value in search box to find a store location");
					//verifying ohio results are displayed
					driver.findElement(Navigation_Pages.textbox_FindaStore).isDisplayed();
					driver.findElement(Navigation_Pages.textbox_FindaStore).clear();
					driver.findElement(Navigation_Pages.textbox_FindaStore).sendKeys(generalnavigation.place);
					
					
					driver.findElement(Navigation_Pages.button_FindaStore).isDisplayed();
					driver.findElement(Navigation_Pages.button_FindaStore).click();
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					
					logger.info("Verify store locator text");
					driver.findElement(Navigation_Pages.text_StoreLocator_num).isDisplayed();
					storeLocatorText = driver.findElement(Navigation_Pages.text_StoreLocator_num).getText();
					logger.info(storeLocatorText);
					
					if(!storeLocatorText.equalsIgnoreCase(expectedStoreLocText))
					{
						logger.info("Store is within the radius of your location");
						String StoreLocator_text = storeLocatorText +" "+ driver.findElement(Navigation_Pages.text_StoreLocator_result).getText() + " for " +  driver.findElement(Navigation_Pages.text_StoreLocator_location).getText();
						logger.info("Store is within the radius and results are: "+ StoreLocator_text);
						 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                         driver.findElement(Navigation_Pages.count_StoreLocator_results).isDisplayed();
						
				        List<WebElement> count=driver.findElements(Navigation_Pages.count_StoreLocator_results);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						String countIs = String.valueOf(count.size());
						logger.info(countIs);
						Assert.assertEquals(storeLocatorText.toString(),countIs , "Store locator count is not matching with store locator results");
						
						List<WebElement> storeLocator_results = driver.findElements(Navigation_Pages.Count_results);
					
						
						for (WebElement b:storeLocator_results)
						{
							
							resultName= b.getText();
							logger.info("Store results name is: "+ resultName  );
							StoreLocationResults.add(resultName);
						}
					}
					else
					{
						
						Assert.fail("Unable to find a store within the radius");
					}
					
				}catch(Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
					
			}		
			
	// verify Kitchen Product Buying guide and Article page
	public void VerifyKitchenProductBuyingGuide() {
			
				try 
				{
					waitForLoad(driver);
					if (driver.findElements(Navigation_Pages.cookie_banner).size() > 0) {
						driver.findElement(Navigation_Pages.cookie_accept).click();
					}
					//verifying kitchen link is expanded
					List<String> ShareLinkTextItems = new ArrayList<String>();
					String Share_linkText=null;
					logger.info("Verify Product Buying Guide link");
					driver.findElement(Navigation_Pages.Link_Kitchen).isDisplayed();
					driver.findElement(Navigation_Pages.Link_Kitchen).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					if(driver.findElement(Navigation_Pages.Link_kitchenMainMenu).isDisplayed());
						Assert.assertTrue(true, "Kitchen main menu is expanded successfully");
					
					logger.info("Verify Article page on clicking on PBG link");
					//verifying PBG is navigated to respective page
					driver.findElement(Navigation_Pages.Link_KitchenProductBuyingGuide).isDisplayed();
					driver.findElement(Navigation_Pages.Link_KitchenProductBuyingGuide).click();
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					System.out.println(driver.getCurrentUrl());
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					boolean condtion= true;
					logger.info("Verify the Article Page URL");
					String URL = driver.getCurrentUrl();
					if(URL.contains("article"))
					Assert.assertTrue(condtion);
					
					List<WebElement> buttons = driver.findElements(Navigation_Pages.Guide_buttons);
					//Iterating over all the buttons in PBG page
					for(WebElement button: buttons)
					{
						String text_button = button.getAttribute("class");
						String text = text_button.replaceFirst("icon--", "");
						
						switch (text)
						{
						case "bookmark":
							
							button.click();
							
							driver.findElement(Navigation_Pages.Header_SaveToFolder).isDisplayed();
							String Header_text = driver.findElement(Navigation_Pages.Header_SaveToFolder).getText();
							Assert.assertEquals(Header_text,generalnavigation.saveTOFolders, "Application is not navigated to Save to folder window");

							//verifying save to folder pop up is displayed
							driver.findElement(Navigation_Pages.textBox_SaveToFolder).isDisplayed();
							driver.findElement(Navigation_Pages.textBox_SaveToFolder).sendKeys( generalnavigation.test);
							
							driver.findElement(Navigation_Pages.button_SaveToFolderSave).isDisplayed();
							driver.findElement(Navigation_Pages.button_SaveToFolderSave).click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							WebDriverWait wait2 = new WebDriverWait(driver,50);
							wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='showThankyou']")));
							
							if(driver.findElement(Navigation_Pages.Win_ShowThankYou).isDisplayed());
								
								Assert.assertTrue(true, "Thank you page is expanded successfully");
							
							//verifying if content is added to kohler folder
							driver.findElement(Navigation_Pages.title_ItemAddedToFold1).isDisplayed();
							String title1 = driver.findElement(Navigation_Pages.title_ItemAddedToFold1).getText();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							driver.findElement(Navigation_Pages.title_ItemAddedToFold2).isDisplayed();
							String title2 = driver.findElement(Navigation_Pages.title_ItemAddedToFold2).getText();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							String title = title1+" "+title2;
							Assert.assertEquals(title,generalnavigation.message, "Application is not navigated to My Kohler folder");
							
							driver.findElement(Navigation_Pages.button_ItemAddedToFoldClose).isDisplayed();
							driver.findElement(Navigation_Pages.button_ItemAddedToFoldClose).click();
						
							break;
							
						case "share":
							button.click();
							
							driver.findElement(Navigation_Pages.Items_shareItems).isDisplayed();
							List<WebElement> shareLinks = driver.findElements(Navigation_Pages.Share_links);
							//Iterating over social networking links
							for(WebElement linkText: shareLinks)
							{
								 Share_linkText = linkText.getText();
								 logger.info("Share options are : " + Share_linkText);
							}
							ShareLinkTextItems.add(Share_linkText);
							
							driver.findElement(Navigation_Pages.Items_shareItemFaceebook).isDisplayed();
							driver.findElement(Navigation_Pages.Items_shareItemFaceebook).click();
							driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
							
							ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
							driver.switchTo().window(tabs.get(1));
							driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
							
						    logger.info("Page title is: " + driver.getTitle());
						    int Win_size = driver.getWindowHandles().size();
						    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
						    
						    logger.info("Close the Child Window: "+driver.getTitle());
						    driver.close();
					    	driver.switchTo().window(tabs.get(0));
							
							break;
						case "print":
							
							break;

						default:
							throw new Exception("The type of functionality is neither of the above.");
							
						}
						
				}
			
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
		}

             // Verify HelpUsToImproveMore link functionality
			public void VerifyKitchenHelpUsToImproveMore(String text, String feedback)
			{
				logger.info("Click on HelpusToImproveMore");
				try {
						//Navigating to the Kitchen page
						logger.info("verify Kitchen Main menu");
						driver.findElement(Navigation_Pages.Link_Kitchen).isDisplayed();
						driver.findElement(Navigation_Pages.Link_Kitchen).click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
						if(driver.findElement(Navigation_Pages.Link_kitchenMainMenu).isDisplayed())
						Assert.assertTrue(true, "Kitchen main menu is expanded successfully");
					
						driver.findElement(Navigation_Pages.Link_KitchenPage).isDisplayed();
						driver.findElement(Navigation_Pages.Link_KitchenPage).click();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						String pageTitle = driver.getTitle();
					    System.out.println("Page title is:" + pageTitle);
					    logger.info("Page title is:" + pageTitle);
					    
					    logger.info("MouseHover on HelpUsToImproveMore link");
						driver.findElement(Navigation_Pages.Link_HelpUsToImproveMore).click();
						WebDriverWait wait = new WebDriverWait(driver,50);
						wait.until(ExpectedConditions.numberOfWindowsToBe(2));
						ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
						
						driver.switchTo().window(tabs2.get(1));
					    int Win_size = driver.getWindowHandles().size();
					    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
					    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					    if(driver.getTitle()==null)
					    {
					    	
					    	driver.navigate().refresh();
					    	
					    }
					    //Giving feedback
					    wait = new WebDriverWait(driver,50);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='submitButton']")));
					    pageTitle = driver.getTitle();
					   
					    logger.info("Page title is:" + pageTitle);
					    Assert.assertEquals(pageTitle, "Kohler US Study", "Title mismatch");
					    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					    logger.info("select the type of feedback");
					    
					    switch (feedback) {
						case "Suggestion": 
							    driver.findElement(Navigation_Pages.btn_suggestion).isDisplayed();
								driver.findElement(Navigation_Pages.btn_suggestion).click();
							    logger.info("clicked on suggestion button");
							break;
						case "Dislike": 
						    driver.findElement(Navigation_Pages.btn_dislike).isDisplayed();
							driver.findElement(Navigation_Pages.btn_dislike).click();
						    logger.info("clicked on Dislike button" );
						    break;
						case "Praise": 
						    driver.findElement(Navigation_Pages.btn_praise).isDisplayed();
							driver.findElement(Navigation_Pages.btn_praise).click();
						    logger.info("clicked on praise button");
						    break;

						default:
							break;
						}
					    
					    
					    logger.info("Input comments in comments section");
					    driver.findElement(Navigation_Pages.text_commenttextbox).sendKeys(text);
					    
					    logger.info("Select the rating based on feedback");
					    driver.findElement(Navigation_Pages.btn_Rating).isDisplayed();
					    driver.findElement(Navigation_Pages.btn_Rating).click();
					    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					   
					    
					    logger.info("click on sendmycomments button");
					    driver.findElement(Navigation_Pages.btn_sendmyComments).isDisplayed();
					    logger.info("identified");
					    driver.manage().window().maximize();
					    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						driver.findElement(Navigation_Pages.btn_sendmyComments).click();
						 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					    
					    logger.info("click on Close the window button");
					    driver.findElement(Navigation_Pages.btn_closeTheWind).isDisplayed();
						driver.findElement(Navigation_Pages.btn_closeTheWind).click();
					    
					    logger.info("Switch to main Window");
					    driver.switchTo().window(tabs2.get(0));
					    Assert.assertEquals(driver.getTitle() ,"Kitchen | KOHLER", "Home Page Title mismatch");
					    	
					
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
				
			}
	// Verify Newsletter Sign Up link functionality
	public void VerifyNewsLetterSignUpLink(){
					
					try {
						
							waitForLoad(driver);
							if (driver.findElements(Navigation_Pages.cookie_banner).size() > 0) {
								driver.findElement(Navigation_Pages.cookie_accept).click();
							}
							//Verifying NewsLetterSignup link
							logger.info("verify Newsletter Sign Up link");
							driver.findElement(Navigation_Pages.link_NewsLetterSignUp).isDisplayed();
							driver.findElement(Navigation_Pages.link_NewsLetterSignUp).click();
							
							WebDriverWait wait = new WebDriverWait(driver,10);
							wait.until(ExpectedConditions.numberOfWindowsToBe(2));
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
							driver.switchTo().window(tabs2.get(1));
							int Win_size = driver.getWindowHandles().size();
						    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
						    wait = new WebDriverWait(driver,50);
							wait.until(ExpectedConditions.titleContains(""));
							String pageTitle = driver.getTitle();
							logger.info("verify the Page title"+ pageTitle);
							
							//verifying and passing the values to the form
							logger.info("Input the values to subscribe to News letter");
							driver.findElement(Navigation_Pages.text_Email).isDisplayed();
							driver.findElement(Navigation_Pages.text_Email).sendKeys(generalnavigation.email);
							
							driver.findElement(Navigation_Pages.text_FirstName).isDisplayed();
							driver.findElement(Navigation_Pages.text_FirstName).sendKeys(generalnavigation.firstName);
							
							driver.findElement(Navigation_Pages.text_LastName).isDisplayed();
							driver.findElement(Navigation_Pages.text_LastName).sendKeys(generalnavigation.lastName);
							
							driver.findElement(Navigation_Pages.text_PostalCode).isDisplayed();
							driver.findElement(Navigation_Pages.text_PostalCode).sendKeys(generalnavigation.postalCode);
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							driver.findElement(Navigation_Pages.select_Country).isDisplayed();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							Select Country=new Select(driver.findElement(Navigation_Pages.select_Country));
							Country.selectByIndex(generalnavigation.country);
							
							driver.findElement(Navigation_Pages.select_occupation).isDisplayed();
							Select Occupation=new Select(driver.findElement(Navigation_Pages.select_occupation));
							Country.selectByIndex(generalnavigation.occupation);
							
							driver.findElement(Navigation_Pages.checkbox_Kitchenbathroom).isDisplayed();
							driver.findElement(Navigation_Pages.checkbox_Kitchenbathroom).click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							driver.findElement(Navigation_Pages.button_Submit).isDisplayed();
							driver.findElement(Navigation_Pages.button_Submit).click();
							//verifying if the Success message is displayed
							driver.findElement(Navigation_Pages.text_thankyou).isDisplayed();
							logger.info("On clicking Submit button: "+driver.findElement(Navigation_Pages.text_thankyou).getText());
							
							driver.close();
							logger.info("Close the tab and switch back to parent window");
							driver.switchTo().window(tabs2.get(0));
							
					}catch(Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
	}	
				
	// verify Parts expansion and Parts links
		public void VerifyPartsMainMenu() {

			try {

				waitForLoad(driver);
				if (driver.findElements(Navigation_Pages.cookie_banner).size() > 0) {
					driver.findElement(Navigation_Pages.cookie_accept).click();
				}
				//Verifying the parts page navigation
				String text = null;
				logger.info("verify Parts Main menu");
				driver.findElement(Navigation_Pages.Link_Parts).isDisplayed();
				driver.findElement(Navigation_Pages.Link_Parts).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                if (driver.findElement(Navigation_Pages.Link_PartsMainMenu).isDisplayed())
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Assert.assertTrue(true, "Parts main menu is expanded successfully");

				logger.info("Click on Parts Link");
				driver.findElement(Navigation_Pages.Link_PartsPage).isDisplayed();
				driver.findElement(Navigation_Pages.Link_PartsPage).click();
				logger.info("Clicked");

				driver.findElement(Navigation_Pages.parts).click();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				logger.info("On clicking on Parts link, Parts Page should be displayed");
				Assert.assertEquals(driver.getTitle(), generalnavigation.parts, "Not landed in Parts maintainence Page");

				logger.info("click on Wizard");
				driver.findElement(Navigation_Pages.Link_PartsWizard).isDisplayed();
				driver.findElement(Navigation_Pages.Link_PartsWizard).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				List<WebElement> divs = driver.findElements(Navigation_Pages.Select_options);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				logger.info(divs.size());
				
				//Selecting product from various product options
				for (WebElement a : divs) {
					text = a.getText();
					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					logger.info("get the text of Parts: " + text);

					if (text.contains("ROOM") || text.contains("Room")) {
						driver.findElement(Navigation_Pages.Select_Room).click();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						boolean status = a.isDisplayed();

						logger.info("verify if item is selected and displayed : " + status);
						WebDriverWait wait1 = new WebDriverWait(driver, 50);
						wait1.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("//*[@id='question-product-type']/div[2]/ul/li[1]")));

					} else if (text.contains("PRODUCT") || text.contains("Product")) {
						driver.findElement(Navigation_Pages.Select_product).click();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						boolean status = a.isDisplayed();
						logger.info("verify if item is selected and displayed : " + status);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					}

					else if (text.contains("FEATURE") || text.contains("Features")) {
						driver.findElement(Navigation_Pages.Select_feature).click();
						driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
						boolean status = a.isDisplayed();
						logger.info("verify if item is selected and displayed : " + status);
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					}

				}
				//verifying the results shown are equal to the count
				logger.info("verify the count on results button : ");
				driver.findElement(Navigation_Pages.button_ViewResultsCount).isDisplayed();
				String countIs = driver.findElement(Navigation_Pages.button_ViewResultsCount).getText();
				logger.info(countIs);

				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='btn btn-results hidden-xs']")));
                driver.findElement(Navigation_Pages.button_ViewResults).isDisplayed();
				driver.findElement(Navigation_Pages.button_ViewResults).click();
				Thread.sleep(2000);

				driver.findElement(Navigation_Pages.Count_Results).isDisplayed();
				String count = driver.findElement(Navigation_Pages.Count_Results).getText();

				logger.info(count);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				String TotalCountIs = "";
				TotalCountIs = count.substring(0, 3);
				logger.info(TotalCountIs);
				Assert.assertEquals(countIs, TotalCountIs, "Results are not the same");

			} catch (Exception ex) {
				Assert.fail(ex.getMessage());
			}

		}
		
		// verify Find a Pro Functionality with invalid Zip code
				public void VerifyFindAProInvalidZipCode()
				{
					
					try {		
						WebDriverWait wait = new WebDriverWait(driver,5);
						JavascriptExecutor js = (JavascriptExecutor)driver;
						
						ArrayList<String> elements_value = new ArrayList<String>();
						
						logger.info("verify Find a pro functionality");
						
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(Navigation_Pages.link_FindAPro));
						
						driver.findElement(Navigation_Pages.link_FindAPro).click();
						
						driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
						
						wait.until(ExpectedConditions.titleContains(generalnavigation.title));
						
										
						Assert.assertEquals(driver.getTitle(), generalnavigation.title);
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						
						//customer support column  
						Assert.assertTrue(driver.findElement(Navigation_Pages.Ele_CustomerSupport).isDisplayed(), "Element is not displayed in Find a Pro Page");
					    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						
					    //i need help column   
						Assert.assertTrue(driver.findElement(Navigation_Pages.Ele_NeedHelpWith).isDisplayed(),"Element is not displayed in Find a Pro Page");
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						String val=driver.findElement(Navigation_Pages.Ele_NeedHelpWith).getText();
						
						if(val.equals("I NEED HELP WITH"))
						{ 
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
							List<WebElement> inner_Ele = driver.findElements(By.xpath("//*[@id='pro-finder']//following::div[@class='accordion-item col-12-lg']/button/header/h3"));
							
							int count = inner_Ele.size();
							
							for (int i = 0; i < count; i++)
							{
								logger.info("verify element text in Need help : "+ inner_Ele.get(i).getText());
												
								elements_value.add(inner_Ele.get(i).getText());
								
							}
							
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							
							for (int i= 0; i < count;i++)
							{
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
								
								js.executeScript("window.scrollBy(0,100)");
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								if(inner_Ele.get(i).getText().equalsIgnoreCase(generalnavigation.installationTitle))
								
								{
									
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,100)");
									
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
									driver.findElement(Navigation_Pages.KohlerProdInstal_btn).click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									logger.info(" Kohler installation clicked ");
									
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								    driver.findElement(Navigation_Pages.KohlerProdInstal_value).sendKeys(generalnavigation.inputValue);
								    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
								    
								    WebElement send=driver.findElement(Navigation_Pages.KohlerProdInstal_viewbtn);
									js.executeScript("arguments[0].scrollIntoView(true);", send);				
									js.executeScript("arguments[0].click();", send);
								    
								    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
								    
									logger.info("verify the landing page Title : " +driver.getTitle());
									
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
									String Errormsg=driver.findElement(Navigation_Pages.text_FindAProErrorMsg).getText();
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									if(Errormsg.contains(generalnavigation.actualErrorMessage))
										
									Assert.assertTrue(true, "We are not in related page");
																
									driver.findElement(Navigation_Pages.Link_GoBack).isDisplayed();
									
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									driver.findElement(Navigation_Pages.Link_GoBack).click();
									
					                driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
									wait = new WebDriverWait(driver,30);
									
									wait.until(ExpectedConditions.titleContains(generalnavigation.title));
									driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
									
									
								}
								
									
									js.executeScript("window.scrollBy(0,400)");
									
									driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
									
									driver.findElement(Navigation_Pages.button_BathroomDesignHelp).click();
									
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									WebElement send=driver.findElement(Navigation_Pages.button_getDesignHelp);
									js.executeScript("arguments[0].scrollIntoView(true);", send);				
									js.executeScript("arguments[0].click();", send);
																
									driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
									
									logger.info("verify the landing page Title : " +driver.getTitle());
									
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									driver.navigate().back();
									driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
									
									wait = new WebDriverWait(driver,25);
									wait.until(ExpectedConditions.titleContains(generalnavigation.title));
									
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								
								break;
							}
						}
						
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,300)");
									
									WebElement send=driver.findElement(Navigation_Pages.button_CustSupport);
									js.executeScript("arguments[0].scrollIntoView(true);", send);				
									js.executeScript("arguments[0].click();", send);
									
									
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
									logger.info("verify landing page title : "+ driver.getTitle());
									
									driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
									
									driver.navigate().back();
									
									driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
									
									wait = new WebDriverWait(driver,40);
									wait.until(ExpectedConditions.titleContains(generalnavigation.title));
									
						}
							

						catch(Exception ex)
						{
							Assert.fail(ex.getMessage());
						}
				
				
						}
				



		//verify Find a Pro Functionality with valid Zip code
			public void VerifyFindAPro()
			{
				
				
				try {		
					
					
					logger.info("verify Find a pro functionality");
					
					driver.findElement(Navigation_Pages.link_FindAPro).isDisplayed();
					
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					driver.findElement(Navigation_Pages.link_FindAPro).click();
					logger.info("clicked find a pro");
					
					
					WebDriverWait wait = new WebDriverWait(driver,10);
					wait.until(ExpectedConditions.titleContains(generalnavigation.title1));
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
					Assert.assertEquals(driver.getTitle(), generalnavigation.title1);
				
				
					Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"pro-finder\"]/div/div/div/div[1]/h3")).isDisplayed(), "Element is not displayed in Find a Pro Page");
					
					Assert.assertTrue(driver.findElement(Navigation_Pages.Ele_NeedHelpWith).isDisplayed(),"Element is not displayed in Find a Pro Page");
					
					List<WebElement> inner_Ele = driver.findElements(By.xpath("//*[@id='pro-finder']//following::div[@class='accordion-item col-12-lg']/button/header/h3"));
					
					int count = inner_Ele.size();
							
					for (int i = 0; i < count; i++)
					{		
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						JavascriptExecutor js = (JavascriptExecutor)driver;
						inner_Ele = driver.findElements(By.xpath("//*[@id='pro-finder']//following::div[@class='accordion-item col-12-lg']/button/header/h3"));
							
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							logger.info(inner_Ele.get(i).getText());
							
							
							if(inner_Ele.get(i).getText().equalsIgnoreCase(generalnavigation.installationTitle))
							{ 
								
								js.executeScript("window.scrollBy(0,100)");
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								WebElement sends=driver.findElement(Navigation_Pages.KohlerProdInstal_btn);
								js.executeScript("arguments[0].scrollIntoView(true);", sends);				
								js.executeScript("arguments[0].click();", sends);
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							
							    driver.findElement(Navigation_Pages.KohlerProdInstal_value).sendKeys(generalnavigation.productInstvalue);
							    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
							    
							    WebElement send=driver.findElement(Navigation_Pages.KohlerProdInstal_viewbtn);
								js.executeScript("arguments[0].scrollIntoView(true);", send);				
								js.executeScript("arguments[0].click();", send);
							    
							    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								
								//text_FAPPageHeader
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElement(Navigation_Pages.text_FAPPageHeader).isDisplayed();
								
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								logger.info("verify the text msg in landing page " +driver.findElement(Navigation_Pages.text_FAPPageHeader).getText());
								
								driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
								
								js.executeScript("window.scrollBy(0,550)");
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								Assert.assertTrue(driver.findElement(Navigation_Pages.button_GetAnEstm).isDisplayed(),"Get an Estimation button is not visible");
								
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								logger.info("verify that view result page is displayed with address");
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								
								List<WebElement> address=driver.findElements(Navigation_Pages.addressList);
								logger.info(address.size());
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								if(driver.findElement(Navigation_Pages.result_Address).isDisplayed() &&  address.size()>0)
								{
									Assert.assertTrue(true, "Search results are available and visible");
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								//text_FAPPageHeader
								logger.info("verify the Get an estimation button : " + driver.findElement(Navigation_Pages.button_GetAnEstm).getText());
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								//button_GetAnEstm
								driver.findElement(Navigation_Pages.button_GetAnEstm).isDisplayed();
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
							
								js.executeScript("arguments[0].click()", driver.findElement(Navigation_Pages.button_GetAnEstm));
								
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								logger.info("verify landing page title : "+driver.getTitle());
								
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								Assert.assertEquals(driver.findElement(Navigation_Pages.text_getAnEstmHeader).getText(), generalnavigation.estimateHeader , "Header message mismatches");
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								
								logger.info("Click on Go back link and it should navigate user to previous page");
								
								//Link_GoBack
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								driver.findElement(Navigation_Pages.Link_GoBack).isDisplayed();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								driver.findElement(Navigation_Pages.Link_GoBack).click();
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
								
								wait.until(ExpectedConditions.titleContains(generalnavigation.title));//--
								
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					
								}
							}
							
							else if(inner_Ele.get(i).getText().equals(generalnavigation.bathroomRemodel))
							{
								driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
								
								int x = i+1;
								js.executeScript("window.scrollBy(0,50)");
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(Navigation_Pages.FullBathroomRemodel_btn));
								driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
								WebElement send=driver.findElement(Navigation_Pages.FullBathroomRemodel_btn);
								js.executeScript("arguments[0].scrollIntoView(true);", send);				
								js.executeScript("arguments[0].click();", send);
								
								
								if(x==3)
									x= x-1;
								driver.findElement(Navigation_Pages.FullBathroomRemodel_value).sendKeys(generalnavigation.bathRoomHomeCons);
								WebElement sends=driver.findElement(By.xpath("//div[@class='col-3-md marg-t-10-md']//following::input[@type='submit'][\"+x+\"]"));
								js.executeScript("arguments[0].scrollIntoView(true);", sends);				
								js.executeScript("arguments[0].click();", sends);
								
								driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
								
								logger.info("verify the landing page Title : " +driver.getTitle());
								
								//text_FAPPageHeader
								driver.findElement(Navigation_Pages.text_FAPPageHeader).isDisplayed();
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								logger.info("verify the text msg in landing page "+driver.findElement(Navigation_Pages.text_FAPPageHeader).getText());
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								js.executeScript("window.scrollBy(0,560)");
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								Assert.assertTrue(driver.findElement(Navigation_Pages.button_GetAnEstm).isDisplayed(),"Get an Estimation button is not visible");
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
								List<WebElement> addreessize=driver.findElements(Navigation_Pages.addressList);
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								if(driver.findElement(Navigation_Pages.result_Address).isDisplayed() && addreessize.size()>0)
									Assert.assertTrue(true, "Search results are available and visible");
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								//button_GetAnEstm
								driver.findElement(Navigation_Pages.button_GetAnEstm).click();
								driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
								
								logger.info("verify landing page title : "+driver.getTitle());
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
														
								Assert.assertEquals(driver.findElement(Navigation_Pages.text_getAnEstmHeader).getText(), generalnavigation.estimateHeader, "Header message mismatches");
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								logger.info("Click on Go back link and it should navigate user to previous page");
								
								//Link_GoBack
								driver.findElement(Navigation_Pages.Link_GoBack).isDisplayed();
								
								JavascriptExecutor jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click()", driver.findElement(Navigation_Pages.Link_GoBack));
								
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								wait = new WebDriverWait(driver,25);
								wait.until(ExpectedConditions.titleContains(generalnavigation.landingPageTitle));
								
								logger.info("Click on back button and it should navigate user to previous page"+driver.getTitle());
								
								driver.navigate().back();
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								wait = new WebDriverWait(driver,25);
								wait.until(ExpectedConditions.titleContains(generalnavigation.title));
								
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
							}
							else if(inner_Ele.get(i).getText().equals(generalnavigation.newHomeTitle))
							{
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
								
								int x = i+1;
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								js.executeScript("window.scrollBy(0,70)");
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(Navigation_Pages.NewHomeConstruction_btn));
								JavascriptExecutor jse = (JavascriptExecutor)driver;
								jse.executeScript("arguments[0].click()",driver.findElement(Navigation_Pages.NewHomeConstruction_btn));
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
							    driver.findElement(Navigation_Pages.NewHomeConstruction_value).sendKeys(generalnavigation.bathRoomHomeCons);
								driver.findElement(Navigation_Pages.NewHomeConstruction_viewbtn).click();
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								logger.info("verify the landing page Title : " +driver.getTitle());
								//text_FAPPageHeader
								driver.findElement(Navigation_Pages.text_FAPPageHeader).isDisplayed();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								logger.info("verify the text msg in landing page " + driver.findElement(Navigation_Pages.text_FAPPageHeader).getText());
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								List<WebElement> addreessize=driver.findElements(Navigation_Pages.addressList);
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								if(driver.findElement(Navigation_Pages.result_Address).isDisplayed() && addreessize.size()> 0)
									Assert.assertTrue(true, "Search results are available and visible");
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);				
								
								Boolean isPresent = driver.findElements(Navigation_Pages.button_GetAnEstm).size() > 0;
								if(!isPresent) {
									logger.info("Get an Estimation Button is not visible");	
								}
								
								
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
								
							    logger.info("Click on Go back link and it should navigate user to previous page");
														
								driver.findElement(Navigation_Pages.Link_GoBack).isDisplayed();
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
								
								driver.findElement(Navigation_Pages.Link_GoBack).click();
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								
								wait = new WebDriverWait(driver,25);
								wait.until(ExpectedConditions.titleContains(generalnavigation.title));//--
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
							}
						}
						
					}catch(Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
			
			
			
			}
			
			// verify Kitchen menu links navigation and Page Title
				public void verifyKitchenSubMenuLinksPageTitles()
					{
						ArrayList<String> Pagetitles = new ArrayList<String>();
						try{
							driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
							WebDriverWait wait = new WebDriverWait(driver,25);
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(Navigation_Pages.Link_Kitchen));
							driver.findElement(Navigation_Pages.Link_Kitchen).click();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						
							if(driver.findElement(Navigation_Pages.Link_kitchenMainMenu).isDisplayed())
								Assert.assertTrue(true, "Kitchen main menu is expanded successfully");
							
							driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
							List<WebElement> Kitchen_SubMenuLinks = driver.findElements(By.xpath("//*[@id='sub-nav-tab--kitchen']/div/div/div/div"));
							
						    int link_count = Kitchen_SubMenuLinks.size();
						    
						    for (int i = 1; i <= link_count; i++)
						    {
						    		List<WebElement> Kitchen_Links =driver.findElements(By.xpath("//*[@id='sub-nav-tab--kitchen']/div/div/div["+i+"]/ul/li"));
						    		
						    		int Links_count = Kitchen_Links.size();
						    		for (int m = 1; m <= Links_count; m++)
						    		{
						    			List<WebElement> Kitchen_InnerLinks = driver.findElements(By.xpath("//*[@id='sub-nav-tab--kitchen']/div/div/div["+i+"]/ul/li["+m+"]/a"));
							    		int InnerLinks_count = Kitchen_InnerLinks.size();
							    		for (int n = 0; n < InnerLinks_count; n++) 
							    		{
											System.out.println(Kitchen_InnerLinks.get(n).getText());
											//logger.info("verify the link text : "+  Kitchen_InnerLinks.get(n).getText());
											
											logger.info("click on each link and verify in new tab");
											String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
											Kitchen_InnerLinks.get(n).sendKeys(selectLinkOpeninNewTab);
											
											
											wait.until(ExpectedConditions.numberOfWindowsToBe(2));
											ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
											
											driver.switchTo().window(tabs2.get(1));
																									
											int Win_size = driver.getWindowHandles().size();
											Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
										    
											String pageTitle = driver.getTitle();
											logger.info("verify the Page title : "+ pageTitle);
											System.out.println(pageTitle);
											Pagetitles.add(pageTitle);
															
											driver.close();
											logger.info("Close the tab and switch back to parent window");
											driver.switchTo().window(tabs2.get(0));
											driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
											driver.findElement(Navigation_Pages.Link_Kitchen).click();
										}
									}
						    	
						    		
						    }
							
						    int title_count = Pagetitles.size();
							
							for (int j = 0; j < title_count; j++)
							{
								String titleIs = Pagetitles.get(j);
								String TitleContains ="";
								if(titleIs.length()> 6)
								{
									TitleContains = titleIs.substring(titleIs.length()- 6);
									
									System.out.println(TitleContains);
									if(TitleContains.contains("KOHLER") && TitleContains.length() > 0)
									{
										logger.info("Page title contains is : "+TitleContains);
									}
									else
									{	logger.info("Page title is not ending with KOHLER" +TitleContains);
										Assert.fail("Page title is not ending with KOHLER" + TitleContains);
									}
								}
								
							}
							
							
							}
						
						catch(Exception ex)
						{
							Assert.fail(ex.getMessage());
						}
						
						
					}

			
}		
			
			
			
			
			
			
			
			
				
				
				
						
						
					
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
			
			
