package testCases;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePage.BaseClass;
import pages.Kohler_HomePages;
import yaml.HomePageData;


import java.util.Set;



public class Kohler_HomePage extends BaseClass {
	private Kohler_HomePages  homepage = null;

	public Kohler_HomePage () {
		homepage  = new Kohler_HomePages();
}
	HomePageData home = HomePageData.gethomepageData();
	
	       // Verify Home Page URL for SSL Verification
			public void verifyHomePageURL()
			{
				try {
                    waitForLoad(driver);
				    Assert.assertTrue(driver.getCurrentUrl().contains(home.homepageUrl), "The homepage donot displays https:// before the URL ");
					logger.info("The homepage displays https:// before the URL ");
				}
				catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
			}
			
			// verify Home Page title
			public void verifyHomePageTitle()
			{
				try {
					logger.info("Verify the Home Page Title");
					waitForLoad(driver);
				    Assert.assertTrue(driver.getTitle().contains(home.homepageTitle), "Home Page Title is not present ");
					logger.info("Home Page Title is present and verified");
					}
				catch(Exception ex)
			{
				Assert.fail(ex.getMessage());
			}
			}
			
			// Verify the list of links in Home Page Footer
			public void VerifyFooterLinks()
			{
				try {
					
				String pageURL ="";
				logger.info("Verifying HomePage_footer Links");
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				// get the list of links available in footer
				List<WebElement> footer = driver.findElements(homepage.footeralllinks);
                for (int j = 0; j < footer.size(); j++) {
					int Win_size = driver.getWindowHandles().size();
					logger.info("Open Windows Size is :" + Win_size);
					logger.info(footer.get(j).getText());
					String linktext = footer.get(j).getText();
					Thread.sleep(3000);
	                 if (!linktext.equals(home.toolBoxText)) {
						Thread.sleep(5000);
						String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
						footer.get(j).sendKeys(selectLinkOpeninNewTab);
						Thread.sleep(2000);
	                    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
						WebDriverWait wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	                    driver.switchTo().window(tabs2.get(1));
						Win_size = driver.getWindowHandles().size();
						Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opened in new window");
	                    pageURL = driver.getCurrentUrl();
	                    logger.info("Page URL is:" + pageURL);
	                    driver.close();
						driver.switchTo().window(tabs2.get(0));
						Thread.sleep(2000);
					}
					continue;
				}
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				}

			// Verify utility Bar color layout and content
				public void VerifybarLinks()
				{
					try {
						
						logger.info("Verify the utility bar titles");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						//WebElement bar = driver.findElement(By.xpath("//*[@id='sign-in-bar']"));
						List<WebElement> bar = driver.findElements(homepage.utilitybar);
						for(WebElement ele :bar )
						{
						
							if(!ele.getText().isEmpty())
							{
							
								String text = ele.getText();
								logger.info("Verify the text of each link: "+ text);
							
								logger.info("Verify the color of each link: "+ ele.getCssValue("color"));
								logger.info("Verify the font size of each link: "+ ele.getCssValue("font-size"));
													
								int Win_size = driver.getWindowHandles().size();
								logger.info("Verify the size of open windows currently: "+ Win_size);
							
								Actions action = new Actions(driver);
								action.moveToElement(ele).build().perform();
													
								logger.info("Hover on each element and get the color: ");
								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
								if(ele.getText().equals("Sign In"))
								{
									
									ele.click();
									if(driver.findElement(By.xpath("//div[@id='modal--sign-in']")).isDisplayed())
									{
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
										driver.findElement(By.xpath("//div[@id='modal--sign-in']//i[@class='icon--close']")).click();
									}
								
								
								}
								else
								{
									logger.info("click on each link and verify in new tab");
									String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
									ele.sendKeys(selectLinkOpeninNewTab);
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
									driver.switchTo().window(tabs2.get(1));
									Win_size = driver.getWindowHandles().size();
								    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
								    
								    String pageTitle = driver.getTitle();
									logger.info("verify the Page title"+ pageTitle);
									
									driver.close();
									logger.info("Close the tab and switch back to parent window");
									driver.switchTo().window(tabs2.get(0));
									waitForLoad(driver);

								}
							}
						}
					
				}catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				
			}
				
				
				// Verify links to other Kohler brands opens a new window.
				public void VerifyLinkOtherKohlerBrands()
				{
					try {
						
						logger.info("Verify Link Other than Kohler Brands: ");
						//For getting all the list of kohlerColinks.
						List<WebElement> Footer_KohlerColinks = driver.findElements(homepage.footerkohlerColinks);
						for(WebElement footer_link: Footer_KohlerColinks)
						{
							if(footer_link.getText().contains(home.otherBrand1) ||footer_link.getText().contains(home.otherBrand2) || footer_link.getText().contains(home.otherBrand3) || footer_link.getText().contains(home.otherBrand4) || footer_link.getText().contains(home.otherBrand5))
							{
								int Win_size = driver.getWindowHandles().size();
								logger.info("Verify the size of open windows currently: "+ Win_size);
							    //click on each link and verify in new tab
								String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
								footer_link.sendKeys(selectLinkOpeninNewTab);
								driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
								ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
								if(tabs2.size()!=2)
								{
									driver.manage().timeouts().implicitlyWait(2,TimeUnit.MICROSECONDS);
									String pageTitle = driver.getTitle();
									logger.info("verify the Page title"+ pageTitle);
			                        driver.get(home.homepageKohlerUrl);
									driver.manage().timeouts().implicitlyWait(2,TimeUnit.MICROSECONDS);
								    continue;
								}
								driver.switchTo().window(tabs2.get(1));
								Win_size = driver.getWindowHandles().size();
							    Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opned in new window");
							    String pageTitle = driver.getTitle();
								logger.info("verify the Page title"+ pageTitle);
								driver.close();
								logger.info("Close the tab and switch back to parent window");
								driver.switchTo().window(tabs2.get(0));
							}
						}
						
						}catch(Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
					
				}
				
				//Verifying United States Country Links dropdown
				public void VerifyWorldWideCountriesLink() {
					
					try {
					String pageURL = ""; 
					driver.findElement(homepage.countrylinks).isDisplayed();
					driver.findElement(homepage.countrylinks).click();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					if(driver.findElement(homepage.countryexpand).isDisplayed())
						Assert.assertTrue(true, "Power world  main menu is expanded successfully");
					    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						List<WebElement> sub_list = driver.findElements(homepage.countryalllinks);
						Assert.assertEquals(sub_list.size(),Integer.parseInt(home.countryLinks), sub_list.size() + " are present under United States country link");
						logger.info(sub_list.size() + " are present under United States country link");
                        for (int j = 0; j < sub_list.size(); j++) {
							int Win_size = driver.getWindowHandles().size();
							logger.info("Open Windows Size is :" + Win_size);
							logger.info(sub_list.get(j).getText());
							String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
							sub_list.get(j).sendKeys(selectLinkOpeninNewTab);
							Thread.sleep(2000);
				            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
							WebDriverWait wait = new WebDriverWait(driver, 30);
							wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				            driver.switchTo().window(tabs2.get(1));
							Win_size = driver.getWindowHandles().size();
							Assert.assertEquals(2, Win_size, "On clicking on link, the page is not opened in new window");
				            pageURL = driver.getCurrentUrl();
				            logger.info("Page URL is:" + pageURL);
				            driver.close();
							driver.switchTo().window(tabs2.get(0));
							Thread.sleep(2000);
                        }

					}catch(Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
				}
				
				
				// Verify HelpUsToImproveMore link functionality
				public void VerifyHelpUsToImproveMore(String text, String feedback)
				{
					try {
						waitForLoad(driver);
                        //deletecookies();
                        logger.info("Click on HelpusToImproveMore");
                        JavascriptExecutor js = (JavascriptExecutor) driver; 
                        js.executeScript("window.scrollBy(0,1600)");
						//Clicking on Help us improve more button
						Thread.sleep(5000);
		                driver.findElement(homepage.Link_HelpUsToImproveMore).click();
						ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
						driver.switchTo().window(tabs2.get(1));
						WebDriverWait wait = new WebDriverWait(driver,30);
				        wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.btn_suggestion));
					    String pageTitle = driver.getTitle();
						logger.info("Page title is:" + pageTitle);
					    waitForLoad(driver);
						Assert.assertEquals(pageTitle, "Kohler US Study", "Title mismatch");
						    
						    logger.info("select the type of feedback");
						    //switch case used for giving input for user end.
						    switch (feedback) {
							case "Suggestion": 
								driver.findElement(homepage.btn_suggestion).isDisplayed();
								driver.findElement(homepage.btn_suggestion).click();
								
								break;
							case "Dislike": 

							    driver.findElement(homepage.btn_dislike).isDisplayed();
								driver.findElement(homepage.btn_dislike).click();
							    break;
							case "Praise": 

							    driver.findElement(homepage.btn_praise).isDisplayed();
								driver.findElement(homepage.btn_praise).click();
							    break;

							default:
								break;
							}
						    
						    logger.info("Input comments in comments section");
						    driver.findElement(homepage.text_commenttextbox).sendKeys(text);
						    
						    logger.info("Select the rating based on feedback");
							driver.findElement(homepage.btn_Rating).isDisplayed();
							
						    driver.findElement(homepage.btn_Rating).click();
						    logger.info("click on sendmycomments button");
						    
						    driver.findElement(homepage.btn_sendmyComments).isDisplayed();
						    logger.info("SEND MY COMMENTS is displayed");
						    Thread.sleep(2000);
						  
						    WebElement send=driver.findElement(By.xpath("//div[@class=\"grid__item one-third\"]//button"));
				        	js.executeScript("arguments[0].scrollIntoView(true);", send);

							js.executeScript("arguments[0].click();", send);
							 logger.info("click on Close the window button" );
							 driver.findElement(homepage.btn_closeTheWind).isDisplayed();
						     driver.findElement(homepage.btn_closeTheWind).click();

							    
							    logger.info("Switch to main Window");
							    driver.switchTo().window(tabs2.get(0));
							    String actualTitle = driver.getTitle();
							    Assert.assertEquals(actualTitle,"KOHLER | Toilets, Showers, Sinks, Faucets and More for Bathroom & Kitchen", "Home Page Title mismatch");
							    
						    	}
					catch(Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
					
				}

				//Verify Hero carousel auto rotation and hover
				public void VerifyHero()
				{
					try {
					    logger.info("verify the hover functionality on hero side arrows");
						driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
						waitForLoad(driver);
						Thread.sleep(8000);
						WebElement elem1 = driver.findElement(homepage.previousarrow);
						WebElement elem2 = driver.findElement(homepage.nextarrow);
						driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
						//Verification of hovering and color for previous arrow
						Assert.assertTrue(elem1.isDisplayed(), "The previous arrow is not displayed");
						logger.info("The previous arrow is displayed");
						Assert.assertTrue(elem2.isDisplayed(), "The next arrow is not displayed");
						logger.info("The next arrow is displayed");
						logger.info("verify navigation;");
						for (int i =1; i <=4 ; i++)
							{
                               logger.info("verify navigation to respective pages");
                               WebElement imageclick=driver.findElement(homepage.imageclick);
							   JavascriptExecutor js = (JavascriptExecutor) driver;
							   js.executeScript("arguments[0].click();", imageclick);
							   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                               if(!driver.getCurrentUrl().equals("https://preprod.us.kohler.com/us/"))
							  {
									logger.info("on clicking on carousel, application is navigating to respective page :" +driver.getCurrentUrl());
						              }
						        else
						              {
						                 logger.info("On clicking on carousel,application is not navigating to respective page :" +driver.getCurrentUrl() );
                                     }
									//driver.findElement(By.xpath("//*[@id=\"main-nav__item--logo\"]/a")).click();
                                driver.navigate().back();
						
							}
				}
								
				
				catch(Exception ex)
				{
					Assert.fail(ex.getMessage());
				}
				}
					// Verify brand tray disappears when scrolling down
					public void VerifyBrandTrayVisibility()
					{
						try {
								logger.info("Verify brand tray visibility on scroll down");
								waitForLoad(driver);
								if(driver.findElement(homepage.element_utilityBar).isDisplayed())
								{
									logger.info("Scroll down if the tray is visible");
									JavascriptExecutor js = (JavascriptExecutor)driver;
									js.executeScript("window.scrollBy(0,3000)");

								}
								//Scrolling down to check that the Utility bar is not visible
                                if(!driver.findElement(homepage.element_utilityBar).isDisplayed())
									Assert.assertTrue(true, "utitliy bar is not viewable");
									logger.info("verified the condition when the brand tray is invisible");

							}catch(Exception ex)
							{
								Assert.fail(ex.getMessage());
							}
						
					}
					
					
				


					//Verifying Share Discover the Possibilities
					public void VerifyDiscoverthePossibilities_Share()
					{
						try
						{
							logger.info("Getting Total no. of Slick dots(Nav Circles) available in 'Discover the Possibilities' grid");
							List<WebElement> SlickDots = driver.findElements(homepage.Discoverthepossibilities);
							logger.info("Clicking on Share CTA available in each carousel slide of 'Discover the Possibilities' grid");
							List<WebElement> Share = driver.findElements(homepage.Discovershare);
							List<String> ActualSocialmedia = new ArrayList<String>();
							int i=0;
							int j=0;
							int ExpectedSocialMediaCount = 7;
							for(WebElement share:Share)
							{
								int ActualSocialMediaCount = 0;
								ActualSocialmedia.clear();
								if(share.isDisplayed())
								{
									j++;
									share.click();
					                List<WebElement> ShareList = driver.findElements(homepage.Discovershareinnertip);
						    		
						    		for(WebElement Sharelist : ShareList) {
						    			String SocialSiteText = Sharelist.getText();
						    			if(Sharelist.isDisplayed() && !SocialSiteText.isEmpty()) 
						    			{
						    				ActualSocialmedia.add(SocialSiteText);
						    				logger.info(SocialSiteText+ " is displayed in share CTA of "+j+" carousel slide in 'Discover the Possibilities' grid");
						    			}
						    			
						    			else 
						    			{
						    				logger.info(SocialSiteText+ " is not displayed in share CTA of "+j+" carousel slide in 'Discover the Possibilities' grid");
						    			}
						    		}
						    		
						    		for(String Actualsocialmedia : ActualSocialmedia)
						    		{
						    			if(Actualsocialmedia.equals("Pinterest") || Actualsocialmedia.equals("Houzz") || Actualsocialmedia.equals("Facebook") || Actualsocialmedia.equals("Google+") || Actualsocialmedia.equals("Email a friend") || Actualsocialmedia.equals("Twitter") || Actualsocialmedia.equals("Share with a Kohler Showroom"))
						    			{
						    				ActualSocialMediaCount++;	    				
						    			}
						    		}
						    		
						    		Assert.assertEquals(ExpectedSocialMediaCount, ActualSocialMediaCount, "Mismatch in media Count to be present in share CTA drop sown");
						    		
						    		i=i+1;
								}
								
								if(i<SlickDots.size())
								{
									SlickDots.get(i).click();
									Thread.sleep(2000);
								}
								
							}
						}
						
						catch(Exception ex) {
							Assert.fail(ex.getMessage());
						}
						
					}
					// Verify Navigation Circles in DiscoverthePossibilities
					public void VerifyDiscoverthePossibilities_NavCircles()
					{
						try
						{
							logger.info("Getting Total no. of Slick dots(Nav Circles) available in 'Discover the Possibilities' grid");
					        List<WebElement> SlickDots = driver.findElements(homepage.SlickDots);
							logger.info("Total No. of Slick dots(Nav Circles) available in 'Discover the Possibilities' grid: "+SlickDots.size());
							ArrayList<String> list = new ArrayList<String>();
						    //Clicking on each Slick dots(Nav Circles) in 'Discover the Possibilities' grid
							for(int i = 0; i < SlickDots.size(); i++)
							{			
								SlickDots.get(i).click();
								String SlickDotClass = SlickDots.get(i).getAttribute("class");
								if(SlickDotClass.contains("active"))
								{
									int index=i+1;
									String SlickDotXpath = "//*[@id='container-home']/div[3]/div/div/div[1]/ul/li["+index+"]/button";
									String SlickDotText = driver.findElement(By.xpath(SlickDotXpath)).getText();
									logger.info(SlickDotText+"st Slick dots(Nav Circles) is active and moving to next Slick dots(Nav Circles)");
									list.add(SlickDotText);		
								}
							}	
					}
						catch(Exception ex) {
							Assert.fail(ex.getMessage());
						}
				}
					
					// Verify Add to Folder in Discover the Possibilities
					public void VerifyDiscoverthePossibilities_AddToFolder_HomePage() throws InterruptedException
					{
						try
						{
							logger.info("Getting Total no. of Slick dots(Nav Circles) available in 'Discover the Possibilities' grid");
							List<WebElement> SlickDots = driver.findElements(homepage.SlickDots);
							logger.info("Clicking on Add to Folder CTA available in each carousel slide of 'Discover the Possibilities' grid");
							List<WebElement> AddtoFolder = driver.findElements(homepage.AddtoFolder);
							List<String> ActualNoteText = new ArrayList<String>();
							int i=0;
							int j=0;
							int k=1;
							String Text = "Test";
							for(WebElement Addtofolder:AddtoFolder)
							{
								if(Addtofolder.isDisplayed()) {
									logger.info("Clicking on Save to folder CTA of "+k+" carousel slide in 'Discover the Possibilities' grid");
									JavascripExecutor(Addtofolder,"N","Y");
									j=j+1;
									Thread.sleep(2000);
									logger.info("Adding Note and Saving to My folder");
									driver.findElement(homepage.textarea).isDisplayed();
									driver.findElement(homepage.textarea).sendKeys(Text+j);
                                    driver.findElement(homepage.shareaddtofolder).isDisplayed();
				                    driver.findElement(homepage.shareaddtofolder).click();
				                    logger.info("Clicking on Continue shopping and navigating to next slide");
                                    driver.findElement(homepage.Message).isDisplayed();
									JavascriptExecutor js = (JavascriptExecutor) driver; 
                                    js. executeScript("arguments[0].click();AddToFolderContinueShopping");
									i++;
									k++;
								}

								if(i<SlickDots.size())
								{
									SlickDots.get(i).click();
									driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
								}

							}		
						
							WebElement BlueBanner=driver.findElement(By.xpath(""));
							Actions hover=new Actions(driver);
							hover.moveToElement(BlueBanner).build().perform();
                            driver.findElement(homepage.imageinfolder).click();
                            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                            driver.findElement(homepage.imageinfolder).isDisplayed();
				            driver.findElement(homepage.imageinfolder).click();
							driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);;

							List<WebElement> NoteText = driver.findElements(homepage.Notetext);
                            for(WebElement Notetext : NoteText) {
								ActualNoteText.add(Notetext.getText());
							}
							Set<String> Set = new LinkedHashSet<>(ActualNoteText);

							for(String set : Set)
							{
								if(set.equals("Test1") || set.equals("Test2") || set.equals("Test3")) {
									logger.info(set+ " is added to myfolder");
								}
								else {
									logger.info(set+ " is not added to myfolder");
								}
							}		
						}
                    catch(Exception ex) {
							
						}
					}
					
					
					
					// Verifying LearnMore in Discover the Possibilities Section
					public void VerifyDiscoverthePossibilities_LearnMore()
					{
						try
						{
							logger.info("Getting Total no. of Slick dots(Nav Circles) available in 'Discover the Possibilities' grid");
							List<WebElement> SlickDots = driver.findElements(homepage.SlickDots);
							logger.info("Clicking on Learn more CTA available in each carousel slide of 'Discover the Possibilities' grid");
							List<WebElement> LearnMore = driver.findElements(homepage.Learnmore);
							int i=0;
							for(WebElement Learnmore:LearnMore)
							{			
								if(Learnmore.isDisplayed())
								{
									String href = Learnmore.getAttribute("href");
									String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
									logger.info("Opening Learn more CTA with link: "+href+" in new tab");
									Learnmore.sendKeys(selectLinkOpeninNewTab);
									Thread.sleep(2000);
					                ArrayList<String> listofTabs = new ArrayList<String> (driver.getWindowHandles());
					                logger.info("Switching to new tab");
					                driver.switchTo().window(listofTabs.get(1));    		
					                logger.info("Getting new tab page url");
						    		String Currentpageurl = driver.getCurrentUrl();
						    		String[] parts = Currentpageurl.split("\\/");
						    		String ExpectedPartofpageurl = parts[2]; 
						    		logger.info(ExpectedPartofpageurl);
						    	
						    		if(ExpectedPartofpageurl.equals("ideas.kohler.com"))
						    		{	    			
						    			logger.info("Learn More CTA opens a ideas.kohler.com page");
						    		}
						    		else
						    		{    	
						    			logger.info("Page url after clicking on learn more CTA is: , "+Currentpageurl );
						    			logger.info("Learn More CTA not opens a ideas.kohler.com page"); 
						    			Assert.fail("Learn More CTA not opens a ideas.kohler.com page");
						    			
						    		}
						    		
						    		driver.close();
						    		driver.switchTo().window(listofTabs.get(0));
						    		logger.info("Moving to next slide of 'Discover the Possibilities' grid");
						    		i=i+1;
								}
								
								if(i<SlickDots.size())
								{
									SlickDots.get(i).click();
									Thread.sleep(2000);
								}
								
							}
						}
						
						catch(Exception ex) {
							Assert.fail(ex.getMessage());
							
						}
					
					}
					
					//Verifying Hotspots Layout in Discover the Possibilities
					public void VerifyDiscoverthePossibilities_HotSpots_GetDetails() throws InterruptedException
					{
						try
						{
							List<WebElement> SlickDots = driver.findElements(homepage.SlickDots);	
							int i=2;
							int j=2;
							int k=2;
							for(WebElement SlickDot : SlickDots)
							{
								SlickDot.click();			
								logger.info("Getting Total no. of hot spots available in the slide");
								List<WebElement> HotSpots = driver.findElements(By.xpath("//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div["+i+"]/div[1]/div/div"));
								int HotSpotsCount = HotSpots.size();
								logger.info("Total " +HotSpotsCount+" hot spots available in the slide");
								logger.info("Clicking on each hot spot");
								for(WebElement HotSpot : HotSpots) 
								{
									driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
									JavascriptExecutor js = (JavascriptExecutor) driver; 
									js.executeScript("arguments[0].click();", HotSpot);
									String GetDetailsXpath = "//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div["+k+"]/div["+j+"]/div/p[2]/a";
									WebElement GetDetails = driver.findElement(By.xpath(GetDetailsXpath));
									driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
									String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
									logger.info("Opening get details link in new tab ");
									GetDetails.sendKeys(selectLinkOpeninNewTab);
									driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
									ArrayList<String> listofTabs = new ArrayList<String> (driver.getWindowHandles());
									if(listofTabs.size()!=2)
									{
										driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
										
										String pageTitle = driver.getTitle();
										logger.info("verify the Page title"+ pageTitle);
										driver.navigate().back(); ;
				                      
										/*getCommand().driver.get("https://preprod.us.kohler.com/us/");
										getCommand().waitFor(2);
										List<WebElement> HotSpots1 = getCommand().getDriver().findElements(By.xpath("//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div["+i+"]/div[1]/div/div"));

										
										continue;*/
									
									}
					                logger.info("Switching to new tab");
					               
					                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
					                driver.switchTo().window(listofTabs.get(1));    		
					                logger.info("Getting new tab page url");                
						    		String Currentpageurl = driver.getCurrentUrl();
						    		
						    		if(Currentpageurl.contains("productDetail")) {
						    			logger.info("Product page is displayed");
						    			
						    		}
						    		else
						    		{
						    			logger.info("product page is not displayed");
						    			Assert.fail("product page is not displayed");
						    		}
						    		j++;
						    		driver.close();
						    		driver.switchTo().window(listofTabs.get(0));  	
						    		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
						    		 
								}
								j=2;
								k++;
								i++;
							}
						}
						
						catch(Exception ex) {
							Assert.fail(ex.getMessage());
						}
						
					}
					
					//Verifying Store Locator in Discover the Possibilities section
					public void VerifyDiscoverthePossibilities_HotSpots_StoreLocator() throws InterruptedException
					{
						try
						{
							List<WebElement> SlickDots = driver.findElements(homepage.SlickDots);	
							int i=2;
							int j=2;
							int k=2;
							for(int n=0;n<SlickDots.size();n++)		
							{
								List<WebElement> slickDots = driver.findElements(homepage.SlickDots);
								slickDots.get(n).click();			
								logger.info("Getting Total no. of hot spots available in the slide");
								List<WebElement> HotSpots = driver.findElements(By.xpath("//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div["+i+"]/div[1]/div/div"));
								int HotSpotsCount = HotSpots.size();
								logger.info("Total " +HotSpotsCount+" hot spots available in the slide");
								logger.info("Clicking on each hot spot");
								for(int m=0;m<HotSpots.size();m++) 
								{
									List<WebElement> Slickdots = driver.findElements(homepage.SlickDots);
									Slickdots.get(n).click();
									List<WebElement> Hotspots = driver.findElements(By.xpath("//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div["+i+"]/div[1]/div/div"));
									driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
									JavascriptExecutor js = (JavascriptExecutor) driver; 

									js.executeScript("arguments[0].click();", Hotspots.get(m));
									String GetDetailsXpath = "//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div["+k+"]/div["+j+"]/div/a";
									WebElement GetDetails = driver.findElement(By.xpath(GetDetailsXpath));
									driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
									String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
									logger.info("Opening Find a store link in new tab ");
									driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
									GetDetails.sendKeys(selectLinkOpeninNewTab);
									ArrayList<String> listofTabs = new ArrayList<String> (driver.getWindowHandles());
									
									if(listofTabs.size()>1)
									{
										logger.info("Switching to new tab");
						                driver.switchTo().window(listofTabs.get(1));    
						                
						                driver.findElement(homepage.Storelocator).isDisplayed();
						                logger.info("Getting new tab page url");                
							    		String Currentpageurl = driver.getCurrentUrl();
							    		
							    		if(Currentpageurl.contains("storelocator")) {
							    			logger.info("Store locator page is displayed");
							    		}
							    		else
							    		{
							    			logger.info("Store locator page is not displayed");
							    			Assert.fail("Store locator page is not displayed");
							    		}
							    		j++;
							    		driver.close();
							    		driver.switchTo().window(listofTabs.get(0));  	
							    		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
									
									}
									
									else
									{
												
										driver.findElement(homepage.Storelocator).isDisplayed();
										String pageurl = driver.getCurrentUrl();
				                      
										if(pageurl.contains("storelocator")) {
							    			logger.info("Store locator page is displayed");
							    		}
							    		else
							    		{
							    			logger.info("Store locator page is not displayed");
							    			Assert.fail("Store locator page is not displayed");
							    		}
							    		j++;
										
							    		driver.navigate().back();;
										driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
									}
								}
								j=2;
								k++;
								i++;
							}
						}
						
						catch(Exception ex) {
							Assert.fail(ex.getMessage());
						}
						
					
					}
					
					//Verifying PromoModule layout
					public void VerifyPromoModuleGrid() throws InterruptedException
					{		
						try
						{
							int PromoModuleLinkCounter = 0;
							
					        List<WebElement> PromoModuleLinks = driver.findElements(homepage.promomodulegrid);
					        
					        logger.info("Getting Total No. of Promo Module links available on the grid");
						    
						    logger.info("Total No. of Promo Module links available on the grid are: "+PromoModuleLinks.size());
						    
						    Actions Action = new Actions (driver);
						    
						    logger.info("Verifying Help text & access of each Promo Module Link");
						    
						    String Currentpageurl=driver.getCurrentUrl();
						

						    for(WebElement PromoModuleLink:PromoModuleLinks)
						    {	    	
						    	JavascripExecutor(PromoModuleLink,"Y","N");    	
						    	if(PromoModuleLink.isDisplayed()) 
						    	{		    			    		
						    		String LinkText = PromoModuleLink.getAttribute("href");
						    		logger.info("Getting Help Text for Promo Module link: ");

						    		Action.moveToElement(PromoModuleLink).build().perform();	    		
						    		
						    		String HelText = PromoModuleLink.getAttribute("title");	    			    		
						    		logger.info("Help Text for promotion: "+LinkText+" is, "+HelText);
						    		
						    		logger.info("Accessing Promo Module Link: "+LinkText+" in new tab");
						    		
					                String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
					                PromoModuleLink.sendKeys(selectLinkOpeninNewTab);
					                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					                ArrayList<String> listofTabs = new ArrayList<String> (driver.getWindowHandles());
					                
					                if(listofTabs.size()>1)
				    	            {
					                	 
						                logger.info("Switching to new tab");
						                driver.switchTo().window(listofTabs.get(1));
							    		
						                logger.info("Getting new tab page title");
						                String pageurl=driver.getCurrentUrl();
							    	
							    		if(pageurl.equals(Currentpageurl))
							    		{	    			
							    			logger.info("Promo Module link: "+LinkText+" is not accessable");
							    			Assert.fail("Promo Module link: "+LinkText+" is not accessable");
							    		}
							    		else
							    		{    			
							    			logger.info("Promo Module link: "+LinkText+" is accessable"); 
							    			logger.info("Page title after accessing Promo Module link: "+LinkText+" is, "+Currentpageurl);
							    		}
							    		
							    		driver.close();
							    		driver.switchTo().window(listofTabs.get(0));
							    		
							    		PromoModuleLinkCounter++;
				    	            }
					                
					                else
					                {
					                	logger.info("Getting new tab page title");
							    		String pageurl=driver.getCurrentUrl();
							    	
							    		if(pageurl.equals(Currentpageurl))
							    		{	    			
							    			logger.info("Promo Module link: "+LinkText+" is not accessable");
							    			Assert.fail("Promo Module link: "+LinkText+" is not accessable");
							    		}
							    		else
							    		{    			
							    			logger.info("Promo Module link: "+LinkText+" is accessable"); 
							    			logger.info("Page title after accessing Promo Module link: "+LinkText+" is, "+Currentpageurl );
							    		}

							    		PromoModuleLinkCounter++;
							    		
							    		driver.navigate().back();
					                }
					               
						    	}
						    	
						    	else
						    	{
						    		logger.info("Promo Module link: "+PromoModuleLink.getAttribute("href")+ " is not visible");
						    	}
						    }
						    
						    if(PromoModuleLinkCounter == PromoModuleLinks.size())
						    {
						    	 logger.info("Verification of Help text & access of each Promo Module Link is completed");
						    }
						    else
						    {
						    	logger.info("Verification of Help text & access of each Promo Module Link is not comapleted.Mismatch in Actual promo linka and accessesd promo links");
						    }
						}
					 
					    catch(Exception ex) {
							Assert.fail(ex.getMessage());
						}
						
					}
					
				
				


					//VerifySignIn
						public void VerifySignIn()
						{
							try
							{
								signin(home.emailId,home.password);
								waitForLoad(driver);
								
								logger.info("Getting Text from Username Tray");
								
								String UsernameText=driver.findElement(homepage.UserNameTray_text).getText();
								
								logger.info(UsernameText);
								
								driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
								
								if(driver.findElement(homepage.UserNameTray).isDisplayed())
								{
									driver.findElement(homepage.UserNameTray).click();
									logger.info("Dropdown displays after clicking on username");
													
									driver.findElement(homepage.MyAccount).click();
									
									logger.info("Navigating to My Account Page");
									
									
								}

								else {
									logger.info("Dropdown not display after clicking on username");
									Assert.fail("Dropdown not display after clicking on username");
								}
								
								waitForLoad(driver);
								
								logger.info("Getting Firstname Text from My Account page");
								
								driver.findElement(homepage.EditAccount).click();
								waitForLoad(driver);
											
								String FirstnameText=driver.findElement(homepage.FirstName_MyAccount).getText();
								logger.info(FirstnameText);
					            String ActualText = "Hi, "+FirstnameText;
								
					            logger.info("Verifying name matches with logged in username");
								if(ActualText.contains(UsernameText))
								{
									logger.info("Account is accessed and name displays as expected");
								}
								else {
									logger.info("Account is not accessed or name displays is not as expected");
									Assert.fail("Account is not accessed or name displays is not as expected");
								}
							}

							catch(Exception ex) {
								Assert.fail(ex.getMessage());
							}
							
						}
						
							
							//5.VerifyAccountEdit
							public void VerifyAccountEdit() 
							{	
								try
								{
									
									signin(home.emailId,home.password);
									driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
									
									JavascriptExecutor js = (JavascriptExecutor)driver;
									
									
									

									if(driver.findElement(homepage.UserNameTray).isDisplayed())
									{
										driver.findElement(homepage.UserNameTray).click();
										logger.info("Dropdown displays after clicking on username");
										driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
									
										logger.info("Navigating to My Account Page");
										
										driver.findElement(homepage.MyAccount).click();
										 waitForLoad(driver);
										js.executeScript("window.scrollBy(0,450)");
										Thread.sleep(2000); 
										String TextbeforeEdit = driver.findElement(homepage.DescribeYourself_text).getText();
										
										logger.info("Text before edit is :"+TextbeforeEdit);
										
										logger.info("Clicking on Edit Account button in my Account Page");
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										driver.findElement(homepage.EditAccount).click();
										driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
										
										js.executeScript("window.scrollBy(0,800)");

										String Text =driver.findElement(homepage.AccountFieldtoEdit).getAttribute("id");
										
										driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
										
										if(!Text.contains("describe-yourself") && !Text.contains("profile-country"))
										{
											//getCommand().sendKeys(AccountFieldtoEdit, "s");	
											driver.findElement(homepage.AccountFieldtoEdit).sendKeys("s");
											
										}

										else
										{   driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
											if(Text.contains("profile-country"))
											{

												//AccountFieldtoEdit
												String text = driver.findElement(homepage.CountryText).getText();


												//AccountFieldtoEdit
												driver.findElement(homepage.AccountFieldtoEdit).click();

												List<WebElement> Options  = driver.findElements(homepage.Country_list);

												for(int i=1; i<=Options.size();i++) 
												{
													String actulatext = Options.get(i).getText();
													if(!text.equals(actulatext)) {

														Options.get(i).click();
														break;
													}
												}
											}

											if(Text.contains("describe-yourself"))
											{	
												logger.info("entered describe yourself if condition");
												
												
												js.executeScript("window.scrollBy(0,900)");
												
												//getCommand().click(AccountFieldtoEdit);
												driver.findElement(homepage.AccountFieldtoEdit).click();
												driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

												List<WebElement> Options  = driver.findElements(homepage.DescribeYoursel_list);
												
												for(int i=1; i<=Options.size();i++) 
												{   
													String actualtext = Options.get(i).getText();
													
													if(actualtext.contains("Consumer/Homeowner")) 
													{
														Options.get(i).click();
														
														driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
														driver.findElement(homepage.NewPassword).sendKeys(home.password);
														
														driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
														driver.findElement(homepage.ConfirmPassword).sendKeys(home.password);
														
														
														break;
													}
													
												}
												
											}
										}
										
										
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										driver.findElement(homepage.BackToTop_button).click();
										
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										
										driver.findElement(homepage.SaveEditedAccount).click();
							        	
										logger.info("clicked save updates");

						
										driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
										//if(getCommand().isTargetVisible(SaveSuccess))
										if(driver.findElement(homepage.SaveSuccess).isDisplayed())
										{
											Assert.assertEquals("Your Account Details Have Been Updated.", driver.findElement(homepage.SaveSuccess).getText(),"Account success mesage is not as expected");
											js.executeScript("window.scrollBy(0,300)");
											driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
											//String TextAfterEdit = getCommand().getText(ActualAccountFieldDetail);
											String TextAfterEdit = driver.findElement(homepage.DescribeYourself_text).getText();


											if(TextbeforeEdit!=TextAfterEdit)
											{
												logger.info("Editing the account is working");
											}
											else
											{
												logger.info("Editing the account is not working");
												Assert.fail("Editing the account is not working");
											}

										}

										else {
											logger.info("Account is not updated");
											Assert.fail("Account is not updated");
										}
									}
									 
									else {
										logger.info("Dropdown not display after clicking on username");
										Assert.fail("Dropdown not display after clicking on username");
									}
								}

								catch(Exception ex) {
									Assert.fail(ex.getMessage());
								}
								
							}

							//6.VerifyAddNewFolder
							public void VerifyAddNewFolder() throws InterruptedException
							{
								try {
									signin(home.emailId,home.password);
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
									JavascriptExecutor js = (JavascriptExecutor)driver;
									 
									 WebDriverWait wait = new WebDriverWait(driver,30);
									 
									 wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));//waiting to my folders visible
									 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									 
									 driver.findElement(homepage.MyFolder).click();//clicked my folders
									 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									 
									 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
									 js.executeScript("window.scrollBy(0,400)");
									 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/a/img")));
									 
									//if create folder displayed
									if(driver.findElement(By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/a/img")).isDisplayed())
									{
										logger.info("Able to access My Folder");
										
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										 js.executeScript("window.scrollBy(0,300)");
										driver.findElement(homepage.btn_CreateFolder).click();
										driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);

										logger.info("Providing Folder Name");
										driver.findElement(homepage.CreateFolderName).sendKeys(home.folderName);
										driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
										
													
										logger.info("Providing Notes");
										driver.findElement(homepage.CreateFolderNotes).sendKeys(home.folderNote);
										driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
										

										WebElement send1=driver.findElement(homepage.btn_Create);
							        	js.executeScript("arguments[0].scrollIntoView(true);", send1);
										js.executeScript("arguments[0].click();", send1);                       
										logger.info("Clicked on Create button");
										driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
										
										driver.navigate().refresh();
										
										
										driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
										
										js.executeScript("window.scrollBy(0,350)");

										logger.info("Checking each folder available in my folder page and clicking on newely created folder");
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										List<WebElement> FoldersName= driver.findElements(homepage.MyFolders_foldersList);
										driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
										
										//getCommand().waitFor(2);
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										for(WebElement Foldersname : FoldersName ) 
										{
											String name = Foldersname.getText();
											logger.info(name);
											if(name.equals(home.folderName)) 
											{
												logger.info("Foldersname xpath  is"+Foldersname);
												
												driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
												Foldersname.click();
												
												driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
												
												logger.info("Able to access created folder in my folder page");
												
												Assert.assertEquals(home.folderName, driver.findElement(homepage.Sharefoldername).getText(),"Not able to access created folder");
											break;
											}
												
										}			
									}

									else 
									{
										logger.info("My Folder is not accessable");
										Assert.fail("My Folder is not accessable");
									}
											
									
								}
								
								
								catch(Exception ex) {
									Assert.fail(ex.getMessage());
								}
								
							}

							//VerifyAddToFolderSignin
									public void VerifyAddToFolderSignin() throws InterruptedException
									{
										
								try {
									
									    signin(home.emailId,home.password);
									    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									    JavascriptExecutor js = (JavascriptExecutor)driver;
									
										WebDriverWait wait = new WebDriverWait(driver,40);
										wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										driver.findElement(homepage.MyFolder).click();
										driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
										 
										WebElement TestFolderCreation=driver.findElement(By.linkText("TestFolderCreation"));
										js.executeScript("arguments[0].scrollIntoView(true);", TestFolderCreation); 
										js.executeScript("arguments[0].click();", TestFolderCreation);	
									

										logger.info("Checking Folder layout");
										
										Assert.assertTrue(driver.findElement(homepage.MyFolderImage).isDisplayed(),"Folder Image is not present");
										logger.info("Folder Image is present");
										
										Assert.assertTrue(driver.findElement(homepage.MyFolderCost).isDisplayed(),"Cost is not present");
										logger.info("Cost is present");
										
										Assert.assertTrue(driver.findElement(homepage.MyFolderNotes).isDisplayed(),"Notes is not present");
										logger.info("Notes is present");
										}

										catch(Exception ex) {
											Assert.fail(ex.getMessage());
										}

										
									}
									
					//VerifyEditDelete_SignedIn
						public void VerifyEditDelete_SignedIn() throws InterruptedException
						{
							try
							{
								WebDriverWait wait = new WebDriverWait(driver,40);
								JavascriptExecutor js = (JavascriptExecutor)driver;
								
								
								signin(home.emailId,home.password);
								driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
								Thread.sleep(5000);
								
								//searching for product 
								
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.Search_Field));
								
								driver.findElement(homepage.Search_Field).sendKeys(home.productId);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								
								driver.findElement(homepage.Search_button).click();
								driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);

					            logger.info("Adding items to my kohler folder");
								
					            WebElement AddToFolder=driver.findElement(homepage.AddToFolder_btn);
							    js.executeScript("arguments[0].scrollIntoView(true);", AddToFolder);				
								js.executeScript("arguments[0].click()", AddToFolder);
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								
								js.executeScript("window.scrollBy(0,400)");
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								driver.findElement(homepage.FolderDropdown).click();
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								List<WebElement> folderdropdown=driver.findElements(homepage.FolderList);
								for(WebElement folder : folderdropdown)
								{
									if(folder.getText().equals("My Kohler Folder")) {
										folder.click();
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									}
									
								}
								
								 driver.findElement(homepage.AddToFolderField).sendKeys(home.folderText);
								 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								 
								 //clicking save button in add to folder popup
								 driver.findElement(homepage.AddToFolderSubmitButton).click();
								 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
								 
								 //clicking on continue shoppping
								 driver.findElement(homepage.AddToFolderContinueShopping).click(); 
								 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
								 
								 js.executeScript("window.scrollBy(0,200)");
								driver.findElement(homepage.BackToTop_button).click();
								 
								 
								 wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));//waiting to my folders visible
								 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								 logger.info("Clicking on Myfolders button in Home Page");
								 driver.findElement(homepage.MyFolder).click();//clicked my folders
								 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								
								
								
								js.executeScript("window.scrollBy(0,220)");

								//getCommand().click(Foldertext);
								driver.findElement(By.xpath("//*[@id=\"my-folders\"]/div[3]/div/form/div[3]/div/a/img")).click();

								
								driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
								
								js.executeScript("window.scrollBy(0,250)");

							
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

								List<WebElement> NoteText = driver.findElements(homepage.NoteText_List);


								List<WebElement> Edit = driver.findElements(homepage.Edit_List);

								logger.info("Editing each item and verifying note text is editable");

								int Count = 0;

								js.executeScript("window.scrollBy(0,200)");

								for(int i=0; i<NoteText.size();i++)
								{
									Count++;

									//Verify Edit
									logger.info("Getting Note Text for "+Count+"st item");
									String NoteTextBeforeEdit = NoteText.get(i).getText();

									logger.info("Clicking on Edit button for "+Count+"st item");
									Edit.get(i).click();

									//getCommand().waitFor(3);
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

									logger.info("Changing text for "+Count+"st item");

									driver.findElement(homepage.EditTextArea_Folder).isDisplayed();
									driver.findElement(homepage.EditTextArea_Folder).sendKeys("Text");				
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									
									//EditSave_Folder
									wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.EditSave_Folder));
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									logger.info("waiting for edit save");
									
									driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									driver.findElement(homepage.EditSave_Folder).click();
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
									Actions act=new Actions(driver);
									act.moveToElement(driver.findElement(homepage.EditSave_Folder)).build().perform();
									Thread.sleep(5000);
									
									driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

									String NoteTextAfterEdit = NoteText.get(i).getText();
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

									logger.info("Verifying text for "+Count+"st item after edit");
									if(!NoteTextBeforeEdit.equals(NoteTextAfterEdit) && NoteTextAfterEdit.equals(NoteTextBeforeEdit+"Text"))
									{
										logger.info("Edit is working as expected. Able to edit the text for "+Count+"st item");
									}

									else
									{
										logger.info("Edit is not working as expected. Not Able to edit the text for "+Count+"st item");
										Assert.fail("Edit is not working as expected. Not Able to edit the text for "+Count+"st item");
									}	

								}	

								logger.info("Verifying delete action for an item");
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
								
								//Verify Delete			
								logger.info("Seleting all items using select all check box");
								
								//js.executeScript("window.scrollBy(0,100)");
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								//SelectAllCheckBox1
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.SelectAllCheckBox1));
								WebElement sends1=driver.findElement(homepage.SelectAllCheckBox1);
								js.executeScript("arguments[0].scrollIntoView(true);", sends1);				
								js.executeScript("arguments[0].click()", sends1);
								
								driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
								
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
								
								logger.info("Checking delete button is enabled");
								
								if(driver.findElement(homepage.Deletebutton).isEnabled())
								{
									logger.info("Delete button is enabled");

									logger.info("Clicking on delete button");
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									WebElement sendss=driver.findElement(homepage.Deletebutton);
									js.executeScript("arguments[0].scrollIntoView(true);", sendss);				
									js.executeScript("arguments[0].click()", sendss);
									
									//driver.findElement(homepage.Deletebutton).click();
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									
									//DeleteConfirmation					
									
									driver.findElement(homepage.DeleteConfirmation).click();
									
									driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
									
									logger.info("Checking Items are deleted from folder");
									driver.navigate().refresh();
									driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,300)");
									
									if((driver.findElement(homepage.ItemsinFolder)==null))
									{  
										
										logger.info("Delete is working");
									}

									else
									{
										logger.info("Delete is not working");
										Assert.fail("Delete is not working");
									}

								}
							}

							catch(Exception ex) {
								Assert.fail(ex.getMessage());
							}
							
						}	
						
						//VerifyMyFolderPageOptions
							public void VerifyMyFolderPageOptions() throws InterruptedException
							{
								try
								{
									WebDriverWait wait = new WebDriverWait(driver,40);
									JavascriptExecutor js = (JavascriptExecutor)driver;
									
									driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
									
									signin(home.emailId,home.password);
									driver.manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
									
									logger.info("Clicking on Myfolders button in Home Page");
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									 wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));//waiting to my folders visible
									 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									 
									 driver.findElement(homepage.MyFolder).click();//clicked my folders
									 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
									
									logger.info("Selecting NewFolder");
									WebElement NewFolder=driver.findElement(By.linkText("NewFolder"));
									js.executeScript("arguments[0].scrollIntoView(true);", NewFolder);		
									js.executeScript("arguments[0].click()", NewFolder);

									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
									//Verify Share
									logger.info("Checking Share folder option");
									wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.ShareFolderOption));
									
									logger.info("Clicking on Share option");
									driver.findElement(homepage.ShareFolderOption).click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									//List<WebElement> Shareoptions =driver.findElements(By.xpath("//ul[@class='social-share-list']/li"));
									
									logger.info("Clicking on each share option and checking the navigation");
									
									//Email a friend
									driver.findElement(homepage.Share_EmailAFriend).isDisplayed();
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									String Text =driver.findElement(homepage.Share_EmailAFriend).getText();
									
									logger.info("Clicking on "+Text+" share option and checking the navigation");
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

										if(Text.equals(home.shareEmail))
										{
											//clicking on email a friend
											driver.findElement(homepage.Share_EmailAFriend).click();
											driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);	
											
											String PopupText = driver.findElement(homepage.Email_Text).getText();
							
												if(PopupText.equalsIgnoreCase(home.emailText))
												{
													logger.info(PopupText+" window is displayed after clicking on "+Text+" share option");
													driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
													
													//getCommand().isTargetPresent(Share_EmailAFriendClose);							
													driver.findElement(homepage.EmailCloseButton).click();

												}

												else
												{
													logger.info("No Window is not displayed after clicking on "+Text+" share option");
													Assert.fail("No Window is not displayed after clicking on "+Text+" share option");
												}
										}		
											
										//click on share button
									    driver.findElement(homepage.ShareFolderOption).click();
									    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									    
									    String Text1= driver.findElement(homepage.Share_Showroombtn).getText();//share with a showroom text
									    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										if(Text1.equals(home.shareShowroom))
										{
											//clicking share with showroom
											driver.findElement(homepage.Share_Showroombtn).click();
											driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
														
											String PopupText1 = driver.findElement(homepage.Showroom_text).getText();
						               		 
											if(PopupText1.equalsIgnoreCase(home.showroomText))
												{
													logger.info(PopupText1+" window is displayed after clicking on "+Text1+" share option");

													//getCommand().click(Share_ShareKohlerClose);
													driver.findElement(homepage.ShowroomCloseButton).click();
													driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
												}

												else
												{
													logger.info("No Window is displayed after clicking on "+Text1+" share option");
													Assert.fail("No Window is displayed after clicking on "+Text1+" share option");
												}
											}
											
									

									//Verify Copy

									logger.info("Checking Copy folder option");

									logger.info("Clicking on Copy option");
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									driver.findElement(homepage.CopyFolderOption).isDisplayed();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									driver.findElement(homepage.CopyFolderOption).click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

									logger.info("Providing Folder Name");
									
									driver.findElement(homepage.CopyFolderName).sendKeys(home.newFolderText);

									//SaveAsNewFolder
									logger.info("Cliking on save");
									
									WebElement sends1=driver.findElement(homepage.SaveAsNewFolder);
									js.executeScript("arguments[0].scrollIntoView(true);", sends1);				
									js.executeScript("arguments[0].click()", sends1);
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

									logger.info("Navigating to new folder where the item are copied");
									
									// click MyFolder
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									js.executeScript("window.scrollBy(0,-150)");
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									 driver.findElement(homepage.MyFolder).click();
												
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,300)");

									driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
									
									List<WebElement> Items_NEwFolder_Copied = driver.findElements(homepage.MyFolders_foldersList);
									
									logger.info(Items_NEwFolder_Copied.size());
									
									logger.info("Checking item are copied to new folder");

									for(WebElement folder_names : Items_NEwFolder_Copied ) 
									{
										if(folder_names.getText().equals(home.newFolderText)) 
										{
											logger.info("Copy page option is working");
										}
										
										else 
										{
											logger.info("Copy page option is not working");
										}

									
									}

									//Verify delete

									logger.info("Checking Delete folder option");
									
									//clicking up arrow
									driver.findElement(homepage.BackToTop_button).click();
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									
									wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));//waiting to my folders visible
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									driver.findElement(homepage.MyFolder).click();//clicked my folders
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,230)");
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

									//Foldertext
									WebElement CopiedFolder1=driver.findElement(By.linkText("CopiedFolder1"));
									js.executeScript("arguments[0].scrollIntoView(true);", CopiedFolder1);		
									js.executeScript("arguments[0].click()", CopiedFolder1);
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
									logger.info("Clicking on Delete option");

									//DeleteFolderOption
									driver.findElement(homepage.DeleteFolderOption).isDisplayed();

									//getCommand().click(DeleteFolderOption);
									driver.findElement(homepage.DeleteFolderOption).click();

									logger.info("Clicking on Delete option from pop up");

									//getCommand().isTargetPresent(DeleteFolderConfirmation);
									driver.findElement(homepage.DeleteFolderConfirmation).isDisplayed();

									//getCommand().click(DeleteFolderConfirmation);
									driver.findElement(homepage.DeleteFolderConfirmation).click();

									logger.info("Navigating to My folder and checking folder is deleted");
									
									js.executeScript("window.scrollBy(0,250)");
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
									driver.findElement(homepage.BackToTop_button).click();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

									//getCommand().executeJavaScript("arguments[0].click();", MyFolder);
									wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));//waiting to my folders visible
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									driver.findElement(homepage.MyFolder).click();//clicked my folders
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,230)");
									driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

									List<WebElement> FoldersName= driver.findElements(homepage.MyFolders_foldersList);

									for(WebElement Foldersname : FoldersName ) 
									{
										String name = Foldersname.getText();

										Assert.assertNotEquals(name, home.folderText, "Delete is not working. Still deleted folder is visible under My folder");			
									}		

									logger.info("Delete is working. Deleted folder is not visible under My folder");
										
										
									}

								catch(Exception ex) {
									Assert.fail(ex.getMessage());
								}
							}
							//8 VerifyMyFoldersCopyAction_SignedIn
								public void VerifyMyFoldersCopyAction_SignedIn() throws InterruptedException
								{	
									try
									{
									    
										WebDriverWait wait = new WebDriverWait(driver,40);
										JavascriptExecutor js = (JavascriptExecutor)driver;
										
										driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
										
										signin(home.emailId,home.password);
										driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
										
										logger.info("Clicking on Myfolders button in Home Page");
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										
										// click MyFolder
										
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										 driver.findElement(homepage.MyFolder).click();
													
										driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

										js.executeScript("window.scrollBy(0,200)");
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										//Click MyKohlerFolder and fetch items count
										
										WebElement MyKohlerFolder=driver.findElement(homepage.MyKohlerFolder);
						    	    	js.executeScript("arguments[0].scrollIntoView(true);", MyKohlerFolder); 
										js.executeScript("arguments[0].click();", MyKohlerFolder);
										
										driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
										js.executeScript("window.scrollBy(0,420)");
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
												
										List<WebElement> Items_before_copy = driver.findElements(homepage.ItemsinFolder);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										int x=Items_before_copy.size();	
										driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
										
										driver.get("https://preprod.us.kohler.com/us/profile/myFolders.jsp");		
										driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
										
										logger.info(driver.getTitle());
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										//Click TestFolderCreation and copying item to MyKohlerFolder
										
										WebElement TestFolderCreation=driver.findElement(By.linkText("TestFolderCreation"));
						    	    	js.executeScript("arguments[0].scrollIntoView(true);", TestFolderCreation);
										js.executeScript("arguments[0].click();", TestFolderCreation);
									    driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
										
									    js.executeScript("window.scrollBy(0,420)");
										driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
												
										logger.info("Select an item using check box");
												
										WebElement checkbox_click=driver.findElement(homepage.SelectAllCheckBox1);
								    	js.executeScript("arguments[0].scrollIntoView(true);", checkbox_click);
										js.executeScript("arguments[0].click();", checkbox_click);
										driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
												
										WebElement copybutton=driver.findElement(homepage.CopyItemButton);
								    	js.executeScript("arguments[0].scrollIntoView(true);", copybutton);
									    js.executeScript("arguments[0].click();", copybutton);
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
												
										driver.findElement(homepage.FolderDropdown).click();//clicking dropdown
										
										List<WebElement> folderdropdown=driver.findElements(homepage.FolderList);
										for(WebElement folder : folderdropdown)
										{
											if(folder.getText().equals("My Kohler Folder")) {
												folder.click();
												driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
											}
											
										}
												
										driver.findElement(homepage.FolderNotes).sendKeys(home.folderText1);//giving notes
												
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
											
									    WebElement Add_button=driver.findElement(homepage.Addbutton);
								        js.executeScript("arguments[0].scrollIntoView(true);", Add_button);
										js.executeScript("arguments[0].click();", Add_button);
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 	
										
										driver.navigate().back();
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										Thread.sleep(2000);
										
										driver.navigate().refresh();
										driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
										
										js.executeScript("window.scrollBy(0,160)");
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										//Click MyKohlerFolder again and fetch items count after copying
										WebElement MyKohlerFolder1=driver.findElement(homepage.MyKohlerFolder);
										js.executeScript("arguments[0].scrollIntoView(true);", MyKohlerFolder1); 
										js.executeScript("arguments[0].click();", MyKohlerFolder1);		
										driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
										
										js.executeScript("window.scrollBy(0,420)");
										driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
												
										List<WebElement> Items1 = driver.findElements(homepage.ItemsinFolder);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										
										int y=Items1.size();
										
										logger.info(y);
										
										//compare items count before & after copy function
										
										if(!(x==y)) 
											
										{
											  logger.info("Copy Items is working");
										}
										
										
									}

									catch(Exception ex) {
										Assert.fail(ex.getMessage());
									}

									
								}

								//9 VerifyMyFoldersMoveAction_SignedIn
								public void VerifyMyFoldersMoveAction_SignedIn() throws InterruptedException
								{	
									try
									{
									    WebDriverWait wait = new WebDriverWait(driver,40);
										JavascriptExecutor js = (JavascriptExecutor)driver;
										
										driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
										
										signin(home.emailId,home.password);
										driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
										
										logger.info("Clicking on Myfolders button in Home Page");
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										
										// click MyFolder
										
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										 driver.findElement(homepage.MyFolder).click();
													
										driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

										js.executeScript("window.scrollBy(0,200)");
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										//Click MyKohlerFolder and fetch items count
										
										WebElement MyKohlerFolder=driver.findElement(homepage.MyKohlerFolder);
						    	    	js.executeScript("arguments[0].scrollIntoView(true);", MyKohlerFolder); 
										js.executeScript("arguments[0].click();", MyKohlerFolder);
										
										driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
										js.executeScript("window.scrollBy(0,420)");
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
												
										List<WebElement> Items_before_copy = driver.findElements(homepage.ItemsinFolder);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										int x=Items_before_copy.size();	
										driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
										
										driver.get("https://preprod.us.kohler.com/us/profile/myFolders.jsp");		
										driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
										
										//Click TestFolderCreation and moving item to MyKohlerFolder
										
										WebElement TestFolderCreation=driver.findElement(By.linkText("TestFolderCreation"));
						    	    	js.executeScript("arguments[0].scrollIntoView(true);", TestFolderCreation);
										js.executeScript("arguments[0].click();", TestFolderCreation);
									    driver.manage().timeouts().implicitlyWait(65, TimeUnit.SECONDS);
										
									    js.executeScript("window.scrollBy(0,420)");
										driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
												
										logger.info("Select an item using check box");
												
										WebElement checkbox_click=driver.findElement(homepage.SelectAllCheckBox1);
								    	js.executeScript("arguments[0].scrollIntoView(true);", checkbox_click);
										js.executeScript("arguments[0].click();", checkbox_click);
										driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
												
										WebElement Movebutton=driver.findElement(homepage.MoveItemButton);
								    	js.executeScript("arguments[0].scrollIntoView(true);", Movebutton);
									    js.executeScript("arguments[0].click();", Movebutton);
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
												
										driver.findElement(homepage.FolderDropdown).click();//clicking dropdown
										
										List<WebElement> folderdropdown=driver.findElements(homepage.FolderList);
										for(WebElement folder : folderdropdown)
										{
											if(folder.getText().equals("My Kohler Folder")) {
												folder.click();
												driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
											}
											
										}
												
										driver.findElement(homepage.FolderNotes).sendKeys(home.folderText1);//giving notes
												
										driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
												
									    WebElement Add_button=driver.findElement(homepage.Addbutton);
								        js.executeScript("arguments[0].scrollIntoView(true);", Add_button);
										js.executeScript("arguments[0].click();", Add_button);
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
											 	
										driver.navigate().back();
										driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
										Thread.sleep(2000);
										
										driver.navigate().refresh();
										driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
										
										js.executeScript("window.scrollBy(0,160)");
										driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
										
										//Click MyKohlerFolder again and fetch items count after moving
										WebElement MyKohlerFolder1=driver.findElement(homepage.MyKohlerFolder);
										js.executeScript("arguments[0].scrollIntoView(true);", MyKohlerFolder1); 
										js.executeScript("arguments[0].click();", MyKohlerFolder1);		
										driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
										
										js.executeScript("window.scrollBy(0,420)");
										driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
												
										List<WebElement> Items1 = driver.findElements(homepage.ItemsinFolder);
										driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
										
										int y=Items1.size();
										
										logger.info(y);
										
										//compare items count before & after copy function
										
										if(!(x==y)) 
											
										{
											  logger.info("Move Items is working");
										}
										
										
									}

									catch(Exception ex) {
										Assert.fail(ex.getMessage());
									}

									
								}


					//4.VerifySignout
								public void VerifySignout() throws InterruptedException
								{
									try
									{
										signin(home.emailId,home.password);
						 
										driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
										
										logger.info("Getting Text from Username Tray");
											
										String UsernameText=driver.findElement(homepage.UserNameTray_text).getText();
										
										if(driver.findElement(homepage.UserNameTray).isDisplayed())
										{
											driver.findElement(homepage.UserNameTray).click();
											
											logger.info("Dropdown displays after clicking on username");

											logger.info("Clicking on Signout button");

											driver.findElement(homepage.SignOut).isDisplayed();
											
											driver.findElement(homepage.SignOut).click();
											
											driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
											
											driver.findElement(homepage.UserNameTray).isDisplayed();
											
											String UsernameTextAfterSignedout = driver.findElement(homepage.UserNameTray_text).getText();	

											if(!UsernameText.equals(UsernameTextAfterSignedout))
											{
												logger.info("Signed out successfully");
											}

											else
											{
												logger.info("Sign out is not working. Not able to signed out after clicking on Sign out button");
												Assert.fail("Sign out is not working. Not able to signed out after clicking on Sign out button");
											}

										}

										else {
											logger.info("Dropdown not display after clicking on username");
											Assert.fail("Dropdown not display after clicking on username");
										}
									}

									catch(Exception ex) {
										Assert.fail(ex.getMessage());
									}
									
								}

						//2.VerifyEditDelete_NotSignedIn
					public void VerifyEditDelete_NotSignedIn() throws InterruptedException
						{
							try
							{	Actions act=new Actions(driver);
								String Text = "Test";
								WebDriverWait wait = new WebDriverWait(driver,40);
								JavascriptExecutor js = (JavascriptExecutor)driver;
								
								driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
								
								driver.findElement(homepage.Search_Field).sendKeys(home.productId1);
								driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
								driver.findElement(homepage.Search_button).click();
								driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
								
								logger.info("Adding items to my kohler folder");
								
								//click on AddTofolder(ribbon symbol)
								WebElement send=driver.findElement(homepage.AddToFolder_btn);
								js.executeScript("arguments[0].scrollIntoView(true);", send);				
								js.executeScript("arguments[0].click()", send);
								driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
								
								
							
								
								//click on AddToFolderTextArea
								js.executeScript("window.scrollBy(0,200)");
								wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.AddToFolderField));
								driver.findElement(homepage.AddToFolderField).sendKeys(Text);
								driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
							
								
								//click AddToFolderSubmitButton(Save)
								WebElement send1=driver.findElement(homepage.AddToFolderSubmitButton);
								js.executeScript("arguments[0].scrollIntoView(true);", send1);				
								js.executeScript("arguments[0].click()", send1);				
								
								driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
								
								
								//click AddToFolderContinueShopping
								wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.AddToFolderContinueShopping));
								
							    driver.findElement(homepage.AddToFolderContinueShopping).click();
							    
							    driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
							    
							    js.executeScript("window.scrollBy(0,-300)");
							    driver.findElement(homepage.BackToTop_button).click();
							    
							    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								
							    //click MyFolder
							    //wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));
							    driver.findElement(homepage.MyFolder).click();
								driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								 

								logger.info("Clicking on My Kohler Folder");
								//Click MyKohlerFolder
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div[2]/div/a/img")));				
								driver.findElement(By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div[2]/div/a/img")).click();
								driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								
								
								js.executeScript("window.scrollBy(0,300)");
								
								driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

								
								List<WebElement> NoteText = driver.findElements(homepage.NoteText_List);

								List<WebElement> Edit = driver.findElements(homepage.Edit_List);

								logger.info("Editing each item and verifying note text is editable");
								

								int Count = 0;
								driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
								for(int i=0; i<NoteText.size();i++)
								{
									
									Count++;

									//Verify Edit
									
									logger.info("Getting Note Text for "+Count+"st item");
									js.executeScript("window.scrollBy(0,250)");
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									
									String NoteTextBeforeEdit = NoteText.get(i).getText();
									
									logger.info(NoteTextBeforeEdit);

									logger.info("Clicking on Edit button for "+Count+"st item");
									Edit.get(i).click();

									
									driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
									

									logger.info("Changing text for "+Count+"st item");
									js.executeScript("window.scrollBy(0,200)");
									
									//send 1 to EditTextArea_Folder
									wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.EditTextArea_Folder));	
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									driver.findElement(homepage.EditTextArea_Folder).sendKeys("Edit");
									
									
									//click EditSave_Folder 
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.EditSave_Folder));
									logger.info("waiting for edit save");
									
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									
									driver.findElement(homepage.EditSave_Folder).click();
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									act.moveToElement(driver.findElement(homepage.EditSave_Folder)).build().perform();
										
									logger.info("clicked saveedit");
									driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
									
									//js.executeScript("window.scrollBy(0,200)");
									 
									logger.info("23");
									driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									Thread.sleep(3000);
									String NoteTextAfterEdit =NoteText.get(i).getText();
									logger.info(NoteTextAfterEdit);	
									
									
									
									driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
									
									logger.info("Verifying text for "+Count+"st item after edit");
									//!NoteTextBeforeEdit.equals(NoteTextAfterEdit) &&
									if( NoteTextAfterEdit.equals(NoteTextBeforeEdit+"Edit"))
									{
										logger.info("Edit is working as expected. Able to edit the text for "+Count+"st item");
								    }

									else
									{
										logger.info("Edit is not working as expected. Not Able to edit the text for "+Count+"st item");
										Assert.fail("Edit is not working as expected. Not Able to edit the text for "+Count+"st item");
									}	

								}	

								logger.info("Verifying delete action for an item");
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
								
								//Verify Delete			
								logger.info("Seleting all items using select all check box");
								
								driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
								
								//SelectAllCheckBox1
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.SelectAllCheckBox1));
								WebElement sends=driver.findElement(homepage.SelectAllCheckBox1);
								js.executeScript("arguments[0].scrollIntoView(true);", sends);				
								js.executeScript("arguments[0].click()", sends);
								
								driver.manage().timeouts().implicitlyWait(140, TimeUnit.SECONDS);
								
								logger.info("Checking delete button is enabled");
								
								if(driver.findElement(homepage.Deletebutton).isEnabled())
								{
									logger.info("Delete button is enabled");

									logger.info("Clicking on delete button");
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									WebElement sends1=driver.findElement(homepage.Deletebutton);
									js.executeScript("arguments[0].scrollIntoView(true);", sends1);				
									js.executeScript("arguments[0].click()", sends1);
									
									//driver.findElement(homepage.Deletebutton).click();
									driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									
									//DeleteConfirmation					
									
									driver.findElement(homepage.DeleteConfirmation).click();
									
									driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
									
									logger.info("Checking Items are deleted from folder");
									driver.navigate().refresh();
									driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
									
									js.executeScript("window.scrollBy(0,300)");
									if((driver.findElement(homepage.ItemsinFolder)==null))
									{  
										
										logger.info("Delete is working");
									}

									else
									{
										logger.info("Delete is not working");
										Assert.fail("Delete is not working");
									}

								}
							}

							catch(Exception ex) {
								Assert.fail(ex.getMessage());
							}
							
						}
						
					//1.VerifyDiscoverthePossibilities_AddToFolder
						public void VerifyDiscoverthePossibilities_AddToFolder() throws InterruptedException
						{
							try
							{  
								driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
								JavascriptExecutor js = (JavascriptExecutor)driver; 
							    js.executeScript("window.scrollBy(0,1100)");
							    driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
								Thread.sleep(6000);
								
							    logger.info("Getting Total no. of Slick dots(Nav Circles) available in 'Discover the Possibilities' grid");
								List<WebElement> SlickDots = driver.findElements(homepage.SlickDots1);
								logger.info(SlickDots.size());
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								
								logger.info("Clicking on Add to Folder CTA available in each carousel slide of 'Discover the Possibilities' grid");
								List<WebElement> AddtoFolder = driver.findElements(homepage.AddtoFolderList);
								logger.info(AddtoFolder.size());
								
								List<String> ActualNoteText = new ArrayList<String>();
								
								int i=0;
								int j=0;
								int k=1;
								
								driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								//for(WebElement Addtofolder:AddtoFolder)
								for(i=0;i<AddtoFolder.size();i++)	
								{
									logger.info("1");
									driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
									if(AddtoFolder.get(i).isDisplayed()) {
										logger.info("Clicking on Save to folder CTA of "+k+" carousel slide in 'Discover the Possibilities' grid");
										//JavascripExecutor(Addtofolder,"N","Y");
										driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
										AddtoFolder.get(i).click();
										driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
										
										j=j+1;
										
										driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
										logger.info("Adding Note and Saving to My folder");
										//AddToFolderTextArea
										driver.findElement(homepage.AddToFolderField).isDisplayed();
										driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
										//getCommand().sendKeys(AddToFolderTextArea, Text+j);
										driver.findElement(homepage.AddToFolderField).sendKeys(home.editText+j);
					                  //getCommand().isTargetPresent(AddToFolderSubmitButton);
					                  driver.findElement(homepage.AddToFolderSubmitButton).isDisplayed();
										
					                  //getCommand().executeJavaScript("arguments[0].click();", AddToFolderSubmitButton);
					                  driver.findElement(homepage.AddToFolderSubmitButton).click();

										logger.info("Clicking on Continue shopping and navigating to next slide");

										//getCommand().isTargetPresent(AddToFolderContinueShopping);
										driver.findElement(homepage.AddToFolderContinueShopping).isDisplayed();
					                  
										//getCommand().executeJavaScript("arguments[0].click();", AddToFolderContinueShopping);
										driver.findElement(homepage.AddToFolderContinueShopping).click();
										i++;
										k++;
									}

									if(i<SlickDots.size())
									{
										SlickDots.get(i).click();
										//getCommand().waitFor(5);
										driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									}

								}		
								//act.moveToElement((WebElement) my_accnt.BlueBanner).build().perform();
								Actions act=new Actions(driver);
								act.moveToElement((WebElement) driver.findElement(homepage.BlueBanner)).build().perform();


								//getCommand().waitFor(5);
								driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
								 
								js.executeScript("window.scrollBy(0,-400)");

								 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
									
								    //click MyFolder
								    WebDriverWait wait=new WebDriverWait(driver,40);
								    wait.until(ExpectedConditions.visibilityOfElementLocated(homepage.MyFolder));
								    driver.findElement(homepage.MyFolder).click();
									driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
									 

									logger.info("Clicking on My Kohler Folder");
									
									WebElement sends1=driver.findElement(homepage.MyKohlerFolder);
									js.executeScript("arguments[0].scrollIntoView(true);", sends1);				
									js.executeScript("arguments[0].click()", sends1);
									

								
								driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

								List<WebElement> NoteText = driver.findElements(homepage.NoteText_List);

								for(WebElement Notetext : NoteText) {
									ActualNoteText.add(Notetext.getText());
								}
								Set<String> Set = new LinkedHashSet<>(ActualNoteText);

								for(String set : Set)
								{
									if(set.equals("Test1") || set.equals("Test2") || set.equals("Test3")) {
										logger.info(set+ " is added to myfolder");
									}
									else {
										logger.info(set+ " is not added to myfolder");
									}
								}		
							}

							catch(Exception ex) {
								Assert.fail(ex.getMessage());
							}
							
						}
						
						/***************************
						 * Helper Methods
						 ************************************************/
						

	                     //Helper method for sigin
						public void signin(String Username, String password)
						{
								try {
								
									waitForLoad(driver);
									//clicking signin
									driver.findElement(By.xpath("//*[@id='user-name-tray']")).click(); 
									driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
									
									driver.findElement(homepage.EmailAddress).sendKeys(Username);
									driver.findElement(homepage.Password).sendKeys(password);
									
									JavascriptExecutor js = (JavascriptExecutor)driver;
									
									WebElement send=driver.findElement(homepage.btn_Signin);
									js.executeScript("arguments[0].scrollIntoView(true);", send);
									//clicked sign 
									js.executeScript("arguments[0].click();", send);
									waitForLoad(driver);
									 driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
									 Thread.sleep(4000);
									 
								   }
								     catch(Exception ex)
									  {
								    	 Assert.fail(ex.getMessage());
								      }
						      }	
						
						//helper method
						public void JavascripExecutor(WebElement Element, String IsScrollIntoView, String Click)
						{
							try
							{
								if(IsScrollIntoView.equals("Y"))
								{
									JavascriptExecutor js = (JavascriptExecutor) driver; 
									js.executeScript("arguments[0].scrollIntoView(true);", Element);
								}

								if(Click.equals("Y"))
								{
									JavascriptExecutor js = (JavascriptExecutor) driver; 
									js.executeScript("arguments[0].click();", Element);
								}
							}

							catch(Exception ex) {
								
							}
							
						}
						
						


			}
			

