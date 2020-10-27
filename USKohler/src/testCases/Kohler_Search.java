package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePage.BaseClass;
import pages.Kohler_SearchPage;
import yaml.SearchData;

public class Kohler_Search extends BaseClass {

	private Kohler_SearchPage kohler_search = null;

	public Kohler_Search() {
		kohler_search = new Kohler_SearchPage();
	}

	SearchData search = SearchData.getSearchData();

	// Verify Search functionality for Kitchen
	public void VerifySearchFunctionalityKitchen() {
		try {
			Search_term(search.kitchenKey, search.kitchenPageTitle, 1, true);
			logger.info("Verifying Search option in application");
			Assert.assertEquals(search.kitchenPageTitle, driver.getTitle(),
					"Opened page is not " + search.kitchenKey + " Section Landing page ");
			logger.info("Opened " + search.kitchenKey + " Section Landing page");
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	// Verify Search functionality for Toilets
	public void VerifySearchFunctionalityToilets() {
		try {
			Search_term(search.toiletsKey, search.toiletsPageTitle, 1, true);
			Assert.assertEquals(search.toiletsPageTitle, driver.getTitle(),
					"Opened page is not " + search.toiletsKey + " category Landing page");
			logger.info("Opened " + search.toiletsKey + " Section Landing page");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Vanity
	public void VerifySearchFunctionalityVanity() {
		try {
			Search_term(search.vanityKey, search.vanityPageTitle, 1, true);
			Assert.assertEquals(search.vanityPageTitle, driver.getTitle(),
					"Opened page is not " + search.vanityKey + " category Landing page ");
			logger.info("Opened " + search.vanityKey + " category Landing page");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Faucet
	public void VerifySearchFunctionalityFaucet() {
		try {
			Search_term(search.faucetKey, search.faucetPageTitle, 1, true);
			Assert.assertEquals(search.faucetPageTitle, driver.getTitle(),
					"Opened page is not " + search.faucetKey + " Families Landing page ");
			logger.info("Opened " + search.faucetKey + " Families Landing page");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Products 14660-4-CP and K-73060-4-CP
	public void VerifySearchFunctionalityProduct() {
		try {
			Search_term(search.productSku1, search.productPageTitle1, 1, true);
			Assert.assertEquals(search.productPageTitle1, driver.getTitle(),
					"Opened page is not Product " + search.productSku1 + " page");
			logger.info("Opened Product " + search.productSku1 + " page");

			Search_term(search.productSku2, search.productPageTitle2, 1, true);
			Assert.assertEquals(search.productPageTitle2, driver.getTitle(),
					"Opened page is not Product " + search.productSku2 + " page");
			logger.info("Opened Product " + search.productSku2 + " page");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Arm
	public void VerifySearchFunctionalityArm() {
		try {
			Search_term(search.armKey, null, 1, false);

			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_label));

			List<WebElement> SubMenuLinks = driver.findElements(kohler_search.search_tabs);

			for (int i = 0; i < SubMenuLinks.size(); i++) {
				String link_text = SubMenuLinks.get(i).getText();
				waitForLoad(driver);

				Assert.assertTrue(link_text.contains(kohler_search.search_tabs_text[i]),
						"The search keyword " + search.armKey + " not returned the sublinks ");

				if (link_text.contains(kohler_search.search_tabs_text[i])) {
					logger.info("Verify Tab: " + link_text);
				}
			}

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	// Verify Search functionality for Inspiration tabs
	public void VerifyFunctionalityInspiration() {
		try {
			Search_term(search.topsKey, null, 1, false);

			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_label));

			logger.info("Click on Inspiration tab");
			waitForLoad(driver);
			if (driver.findElements(kohler_search.iperceptions_div).size() > 0) {
				driver.findElement(kohler_search.iperceptions_div_close).click();
			}
			driver.findElement(kohler_search.inspiration_tab).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.show_me_more));

			driver.findElement(kohler_search.show_me_more).click();
			waitForLoad(driver);

			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

			driver.switchTo().window(tabs.get(1));

			WebDriverWait wait1 = new WebDriverWait(driver, 180);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.ideas_h1));

			Assert.assertTrue(driver.getCurrentUrl().contains(search.ideasUrl),
					"Inspiration result not redirecting to ideas.kohler.com");
			logger.info("Inspiration result redirects to ideas.kohler.com");

			driver.switchTo().window(tabs.get(0));

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Resource tabs
	public void VerifyFunctionalityResource() {
		try {
			Search_term(search.topsKey, null, 1, false);

			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_label));

			logger.info("Click on Resources tab");
			driver.findElement(kohler_search.resources_tab).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.read_the_article));

			driver.findElement(kohler_search.read_the_article).click();
			waitForLoad(driver);

			Assert.assertTrue(driver.getCurrentUrl().contains(search.ideasUrl),
					"Resources results redirects to ideas.kohler.com");
			if (driver.getCurrentUrl().contains(search.ideasUrl)) {
				logger.info("The results are shown from " + search.ideasUrl);
			}
			driver.navigate().back();

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	// Verify Search functionality for Moxie
	public void VerifySearchFunctionalityMoxie() {
		try {
			Search_term(search.moxieKey, null, 1, false);
			waitForLoad(driver);

			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_result_text));

			String result_text = driver.findElement(kohler_search.search_result_text).getText();

			Assert.assertTrue(result_text.contains(search.moxieKey), search.moxieKey + " Product is not displayed");
			logger.info(search.moxieKey + " Product is displayed");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Memoirs
	public void VerifySearchFunctionalityMemoirs() {
		try {
			Search_term(search.memoirsKey, null, 1, false);

			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_result_text));

			String result_text = driver.findElement(kohler_search.search_result_text).getText();

			Assert.assertTrue(result_text.contains(search.memoirsKey), search.memoirsKey + " Product is not displayed");
			logger.info(search.memoirsKey + " Product is displayed");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search functionality for Two and results
	public void VerifySearchFunctionalityTw() {
		try {
			Search_term(search.twKey, null, 1, false);
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_label_h2));

			String search_for_two = driver.findElement(kohler_search.search_label_h2).getText();
			Assert.assertTrue(search_for_two.contains(search.twSearch), search.twSearch + " is not displayed");
			logger.info(search.twSearch + " is displayed");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify typeahead with 3 letter i.e.Tou
	public void VerifySearchFunctionalityTou() {
		try {
			Search_term(search.touKey, null, 0, false);

			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.search_suggestion));

			List<WebElement> linkElements = driver.findElements(By.xpath(kohler_search.search_suggestion_div));
			String[] linkTexts = new String[linkElements.size()];
			int i = 0;

			for (WebElement e : linkElements) {
				linkTexts[i] = e.getText();
				Assert.assertTrue(linkTexts[i].contains(search.touchlessKey),
						"Typeahead with 3 letters results are not displayed");

				if (linkTexts[i].contains(search.touchlessKey))
					logger.info("Typeahead with 3 letters results are displayed");
				i++;
			}

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search term(Leed) and the page loads to external website
	public void VerifySearchFunctionalityTerm_Leed() {
		try {
			Search_term(search.leedKey, null, 1, false);
			waitForLoad(driver);

			Assert.assertTrue(driver.getCurrentUrl().contains(search.sustainabilityKey),
					"The searched term " + search.leedKey + " did not open in an external website");
			waitForLoad(driver);
			logger.info("The searched term " + search.leedKey + " opened in an external website");
			driver.navigate().back();

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}
	}

	// Verify Search term(Robern) and the page loads to external website
	public void VerifySearchFunctionalityTerm_Robern() {
		try {
			Search_term(search.robernKey, null, 1, false);
			waitForLoad(driver);

			Assert.assertTrue(driver.getCurrentUrl().contains(search.robernKey),
					"The searched term " + search.robernKey + " did not open in an external website");
			waitForLoad(driver);
			logger.info("The searched term " + search.robernKey + " opened in an external website");
			driver.navigate().back();

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

	}

	// Verify Search term(Privacy) and the page loads to external website
	public void VerifySearchFunctionalityTerm_Privacy() {
		try {
			Search_term(search.privacyKey, null, 1, false);
			waitForLoad(driver);
			Assert.assertTrue(driver.getCurrentUrl().contains(search.privacyKey),
					"The searched term " + search.privacyKey + " did not open in an external website");
			waitForLoad(driver);
			logger.info("The searched term " + search.privacyKey + " opened in an external website");

		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		}

		}
	

	// Verify Search term(Pressure Balance) and the page loads to internal website
			public void VerifySearchFunctionalityTerm_PressureBalance()
			{
				try {
					
						logger.info("Verifying Search option in application");
						String searchterm = search.searchTerm;
						logger.info("Searching for product: "+ searchterm);
						driver.findElement(kohler_search.SearchBar).sendKeys("pressure balance");
					
						waitForLoad(driver);
						driver.findElement(kohler_search.searchicon).click();
				
						String CurrentPageTitle= driver.getTitle();
						   
				     	driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
						Assert.assertEquals(search.PageTitle, CurrentPageTitle, "The searched term 'pressure balance' not opened in an internal website");
						logger.info("The searched term 'pressure balance' opened in an internal website");
						driver.navigate().back();
						
				}
				catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
			}

		
			// Verify Search term(bathtub) and the page loads to internal website

			public void VerifySearchFunctionalityTerm_bathtub()
			{
				try {
						logger.info("Verifying Search option in application");
						String searchterm = search.searchTerm1;
						logger.info("Searching for product: "+ searchterm);
						driver.findElement(kohler_search.SearchBar).sendKeys("bath tub");
						
						waitForLoad(driver);
						driver.findElement(kohler_search.searchicon).click();
					
						String CurrentPageTitle= driver.getTitle();
						   
				     	driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
						Assert.assertEquals(search.PageTitle1, CurrentPageTitle, "The searched term 'Bath tub' not opened in an internal website");
						logger.info("The searched term 'pressure balance' opened in an internal website");
						driver.navigate().back();
						
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
			}	
		
			// Verify Search term(nightlight) and the page loads to internal website

			public void VerifySearchFunctionalityTerm_nightlight()
			{
				try {
						logger.info("Verifying Search option in application");
						String searchterm = search.searchTerm2;
						logger.info("Searching for product: "+ searchterm);
						waitForLoad(driver);
						driver.findElement(kohler_search.SearchBar).sendKeys("night light");
					
						waitForLoad(driver);
						driver.findElement(kohler_search.searchicon).click();
					
						String CurrentPageTitle= driver.getTitle();
						logger.info(CurrentPageTitle);
						String PageTitle = "Nightlight – Lighted toilet seats by Kohler | KOHLER";
						   
				     	driver.manage().timeouts().implicitlyWait(50,TimeUnit.MILLISECONDS);
						Assert.assertEquals(PageTitle, CurrentPageTitle, "The searched term 'Bath tub' not opened in an internal website");
						logger.info("The searched term 'pressure balance' opened in an internal website");
						driver.navigate().back();
						
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
			}

			//Method to verify each term display the same results
		    public void VerifySearchFunctionalityTermsDisplaySameResults_poplin_poplen()
		    {
		    	try 
		    	{
		           logger.info("Verifying Poplin Search results");
		           waitForLoad(driver);
		                      	         
		           driver.findElement(kohler_search.SearchBar).sendKeys("poplin");
		           waitForLoad(driver);
				   
				   driver.findElement(kohler_search.searchicon).click();
				   
				   WebDriverWait wait6 = new WebDriverWait(driver,100);
				   wait6.until(ExpectedConditions.visibilityOfElementLocated((kohler_search.count)));	
				  
				   
				   String poplinproducttitle = driver.findElement(kohler_search.productTitle).getText();
				   logger.info(poplinproducttitle);
				   String poplincount = driver.findElement(kohler_search.count).getText();
		           
		           driver.navigate().back();
		           
		           logger.info("Verifying Poplen Search results");
		           waitForLoad(driver);
				   driver.findElement(kohler_search.SearchBar).sendKeys("poplen");	
				   waitForLoad(driver);
				   driver.findElement(kohler_search.searchicon).click();
				   
				   WebDriverWait wait9 = new WebDriverWait(driver,50);
				   wait9.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.count));	
				   
				   String poplenproducttitle =driver.findElement(kohler_search.productTitle).getText();
				   String poplencount = driver.findElement(kohler_search.count).getText();
		           
		           if(poplinproducttitle.contains("Poplin") && poplenproducttitle.contains("Poplin"))
		           {
		                 Assert.assertEquals(poplencount, poplincount, "Search results for Poplin and Poplen products are different");
		                 logger.info("Poplen/Poplin search results are similar");
		           }                    
		           else
		           {
		                 Assert.fail("Poplin/Poplen search results are dissimilar");
		           }
			    }
			    catch(Exception ex)
			    {
			           Assert.fail(ex.getMessage());
			    }
		    }
		    
		    
		    public void VerifySearchFunctionalityTermsDisplaySameResults_choreo_choreograph()
		    {    
		        try 
			    	{
			           logger.info("Verifying Poplin Search results");
			           waitForLoad(driver);

			           driver.findElement(kohler_search.SearchBar).sendKeys("choreo");	
					   waitForLoad(driver);
					   driver.findElement(kohler_search.searchicon).click();
					   
					   WebDriverWait wait12 = new WebDriverWait(driver,50);
					   wait12.until(ExpectedConditions.visibilityOfElementLocated((kohler_search.count)));	
			
					   
					   String choreoproducttitle = driver.findElement(kohler_search.productTitle).getText();
					   logger.info(choreoproducttitle);
					   String choreocount = driver.findElement(kohler_search.count).getText();
			           
			           driver.navigate().back();
			           
			           logger.info("Verifying Search results");
			           waitForLoad(driver);
			                      	         
			           driver.findElement(kohler_search.SearchBar).sendKeys("choreograph");
			           waitForLoad(driver);
					   
					   driver.findElement(kohler_search.searchicon).click();
					   
					   WebDriverWait wait15 = new WebDriverWait(driver,50);
					   wait15.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.count));	
					   
					   String choreographproducttitle =driver.findElement(kohler_search.productTitle).getText();
					
					   String choreographcount = driver.findElement(kohler_search.count).getText();
			           
			           if(choreoproducttitle.contains("choreograph") && choreographproducttitle.contains("choreograph"))
			           {
			                 Assert.assertEquals(choreocount, choreographcount, "Search results for choreo and choreograph products are different");
			                 
			           }                    
			           else
			           {
			             	Assert.fail("choreo/choreograph search results are dissimilar");
			           }         
		           }
		           catch(Exception ex)
		           {
		              Assert.fail(ex.getMessage());
		           }
		      }
		    
		    
		//  Verify article redirects are turned off by searching 'moxie'
				public void VerifyArticlesTurnedOffbyParts()
				{
					try
					{  
					logger.info("Verifying Parts Landing page in application");
					waitForLoad(driver);
				    driver.findElement(kohler_search.Support).click();
					
					
					logger.info("Clicking on Parts menu");
					//waitForLoad(driver);
					 WebDriverWait wait22 = new WebDriverWait(driver,100);
					 wait22.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.Findparts));
				    driver.findElement(kohler_search.Findparts).click();
				    
				    
				    WebDriverWait wait18 = new WebDriverWait(driver,50);
				    wait18.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.Search_partsTerms));
				    driver.findElement(kohler_search.Search_partsTerms).sendKeys("moxie");
				    driver.findElement(kohler_search.Search_Find).click();
				 			 
					String CurrentPageUrl= driver.getCurrentUrl();
				
					logger.info("checking articles are displayed for moxie");
					WebDriverWait wait19 = new WebDriverWait(driver,50);
				    wait19.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.memoirs_header));
					
					if ( driver.findElement(kohler_search.memoirs_header).isDisplayed() && !CurrentPageUrl.contains("articles") )
					{
						logger.info("articles are not shown");
						driver.navigate().back();
					}
					else
					{
						Assert.fail("articles are displayed for memoirs");
					}	
					     		
			    }
				catch(Exception ex)
			    {
					Assert.fail(ex.getMessage());
			    }
			}

		//  Verify article redirects are turned off by searching 'memoirs'
			public void VerifyCollectionsTurnedOffbyParts()
			{ 
				try
				{
					logger.info("Verifying Parts Landing page in application");
					waitForLoad(driver);
				    
				    driver.findElement(kohler_search.Support).click();
									
					logger.info("Clicking on Parts menu");
					WebDriverWait wait25 = new WebDriverWait(driver,100);
					 wait25.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.Findparts));
				    driver.findElement(kohler_search.Findparts).click();
				    
				    
				    WebDriverWait wait22 = new WebDriverWait(driver,100);
				    wait22.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.Search_partsTerms));
				    driver.findElement(kohler_search.Search_partsTerms).sendKeys("memoirs");
				    driver.findElement(kohler_search.Search_Find).click();
				 			 
					String CurrentPageUrl= driver.getCurrentUrl();
				
					logger.info("checking collections are displayed for memoirs");
					WebDriverWait wait23 = new WebDriverWait(driver,100);
				    wait23.until(ExpectedConditions.visibilityOfElementLocated(kohler_search.memoirs_header));
				
					if ( driver.findElement(kohler_search.memoirs_header).isDisplayed() && !CurrentPageUrl.contains("collections") )
					{
						logger.info("Collections are not shown");
						driver.navigate().back();
					}
					else
					{
						Assert.fail("Collections are displayed for memoirs");
					}	
					     		
			    }
				
				catch(Exception ex)
			    {
					Assert.fail(ex.getMessage());
			    }
			    
			}


	/***************************
	 * Helper Methods
	 ************************************************/

	public void Search_term(String keyword, String pageTitle, int searchClick, boolean waitTitle) {
		waitForLoad(driver);
		if (driver.findElements(kohler_search.iperceptions).size() > 0) {
			driver.switchTo().parentFrame();
		}

		if (driver.findElements(kohler_search.iperceptions_div).size() > 0) {
			driver.findElement(kohler_search.iperceptions_div_close).click();
		}

		if (driver.findElements(kohler_search.cookie_banner).size() > 0) {
			driver.findElement(kohler_search.cookie_accept).click();
		}

//			if(keyword != "toilets")
//			{
		if (driver.findElement(kohler_search.signup_modal).isDisplayed() == true) {
			driver.findElement(kohler_search.signup_modal_close).click();
		}
		// }
		logger.info("Verifying Search in application for: " + keyword);
		driver.findElement(kohler_search.search_box).isDisplayed();
		driver.findElement(kohler_search.search_box).clear();

		driver.findElement(kohler_search.search_box).sendKeys(keyword);

		if (searchClick == 1) {
			logger.info("Click on search button");
			driver.findElement(kohler_search.search_button).isDisplayed();
			driver.findElement(kohler_search.search_button).click();
		}

		if (waitTitle == true) {
			WebDriverWait wait = new WebDriverWait(driver, 180);
			wait.until(ExpectedConditions.titleContains(pageTitle));
		}
	}

	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(pageLoadCondition);
	}

}
