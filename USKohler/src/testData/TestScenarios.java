package testData;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePage.BaseClass;
import testCases.Kohler_GeneralNavigation;
import testCases.Kohler_HomePage;
import testCases.Kohler_ProductDisplayPage;
import testCases.Kohler_Search;

public class TestScenarios extends BaseClass {

	private Kohler_HomePage homepage=new Kohler_HomePage();
	private Kohler_GeneralNavigation Navigation_Pages=new Kohler_GeneralNavigation();
    private Kohler_Search kohler_search = new Kohler_Search();
	private Kohler_ProductDisplayPage productpage=new Kohler_ProductDisplayPage();


	@BeforeClass
	public void urlsetup() {
		driver.get(baseURL);
	}

	@BeforeMethod
	public void homePage() {
		driver.navigate().to(baseURL);
	}
//------------------------------------HOMEPAGE---------------------------------------------------
//	@Test(groups={"HomePage"}, description = "Verify footer links",testName="USKohler->USKohler:01")
//	public void VerifyFooterLinks() {
//		homepage.VerifyFooterLinks();
//	}
//	@Test(groups={"HomePage"}, description = "Verify Kohler Ideas layout_Arrow HomePage",testName="Kohler->Homepage:02")
//	public void VerifybarLinks() {
//		homepage.VerifybarLinks();
//	}
//	@Test(groups={"HomePage"}, description = "Verify HelpUsToImproveMore HomePage",testName="Kohler->Homepage:03")
//		public void VerifyHelpUsToImproveMore() {
//			homepage.VerifyHelpUsToImproveMore("Test", "Suggestion");
//	}
//	@Test(groups={"HomePage"}, description = "Verify title of the HomePage",testName="Kohler->Homepage:04")
//		public void verifyHomePageTitle() {
//			homepage.verifyHomePageTitle();
//	}
//	@Test(groups={"HomePage"}, description = "Verify URL layout of HomePage",testName="Kohler->Homepage:05")
//		public void verifyHomePageURL() {
//			homepage.verifyHomePageURL();
//	}
//	@Test(groups={"HomePage"}, description = "Verify World Wide Countries Link HomePage",testName="Kohler->Homepage:06")
//	public void VerifyWorldWideCountriesLink() {
//		homepage.VerifyWorldWideCountriesLink();
//	}
//	@Test(groups={"HomePage"}, description = "Verify Brand Tray Visibility in  HomePage",testName="Kohler->Homepage:07")
//	public void VerifyBrandTrayVisibility() {
//		homepage.VerifyBrandTrayVisibility();
//	}
//	@Test(groups={"HomePage"}, description = "Verify Hero in  HomePage",testName="Kohler->Homepage:08")
//	public void VerifyHero() {
//		homepage.VerifyHero();
//	}
//	@Test(groups={"HomePage"}, description = "Verify link other Kohler Brands in HomePage",testName="Kohler->Homepage:09")
//	public void VerifyLinkOtherKohlerBrands() {
//		homepage.VerifyLinkOtherKohlerBrands();
//	}
//	@Test(groups={"HomePage"}, description = "VerifyPromoModuleGrid",testName="Kohler->Homepage::16")
//	public void VerifyPromoModuleGrid() throws InterruptedException {
//		homepage.VerifyPromoModuleGrid();
//	}
//	@Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_NavCircles",testName="Kohler->Homepage:17")
//	public void VerifyDiscoverthePossibilities_NavCircles() {
//		homepage.VerifyDiscoverthePossibilities_NavCircles();
//	}
////	@Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_Arrows",testName="Kohler->Homepage:18")
////	public void VerifyDiscoverthePossibilities_Arrows() {
////		homepage.VerifyDiscoverthePossibilities_Arrows();
////	}
//	@Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_HotSpots_GetDetails",testName="Kohler->Homepage:19")
//	public void VerifyDiscoverthePossibilities_HotSpots_GetDetails() throws InterruptedException {
//		homepage.VerifyDiscoverthePossibilities_HotSpots_GetDetails();
//	}
//	@Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_HotSpots_StoreLocator",testName="Kohler->Homepage:20")
//	public void VerifyDiscoverthePossibilities_HotSpots_StoreLocator() throws InterruptedException {
//		homepage.VerifyDiscoverthePossibilities_HotSpots_StoreLocator();
//	}
//	@Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_LearnMore",testName="Kohler->Homepage:21")
//	public void VerifyDiscoverthePossibilities_LearnMore() {
//		homepage.VerifyDiscoverthePossibilities_LearnMore();
//	}
//	@Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_AddToFolder",testName="Kohler->Homepage:23")
//	public void VerifyDiscoverthePossibilities_AddToFolder_HomePage() throws InterruptedException {
//		homepage.VerifyDiscoverthePossibilities_AddToFolder_HomePage();
//	}
//	 @Test(groups={"HomePage"}, description = "VerifyDiscoverthePossibilities_Share",testName="Kohler->Homepage:24")
//	public void VerifyDiscoverthePossibilities_Share() {
//		homepage.VerifyDiscoverthePossibilities_Share();
//	}
//	
//--------------------------------------My Account Folder---------------------------------------
//	@Test(groups={"AccountFolder"}, description = "Verify Discover the Possibilities AddToFolder ",testName="Kohler->AccountFolder:01")
//	public void VerifyDiscoverthePossibilities_AddToFolder() throws InterruptedException {
//		homepage.VerifyDiscoverthePossibilities_AddToFolder();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify EditDelete NotSignedIn",testName="Kohler->AccountFolder:02")
//	public void VerifyEditDelete_NotSignedIn() throws InterruptedException {
//		homepage.VerifyEditDelete_NotSignedIn();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify SignIn",testName="Kohler->AccountFolder:03")
//	public void VerifySignIn() {
//		homepage.VerifySignIn();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify Signout",testName="Kohler->AccountFolder:04")
//	public void VerifySignout() throws InterruptedException {
//		homepage.VerifySignout();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify AccountEdit",testName="Kohler->AccountFolder:05")
//	public void VerifyAccountEdit() throws InterruptedException {
//		homepage.VerifyAccountEdit();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify AddNewFolder",testName="Kohler->AccountFolder:06")
//	public void VerifyAddNewFolder() throws InterruptedException {
//		homepage.VerifyAddNewFolder();
//	}
//	
//	@Test(groups={"AccountFolder"}, description = "Verify AddToFolder Signin",testName="Kohler->AccountFolder:07")
//	public void VerifyAddToFolderSignin() throws InterruptedException {
//		homepage.VerifyAddToFolderSignin();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify MyFolders CopyAction SignedIn",testName="Kohler->AccountFolder:08")
//	public void VerifyMyFoldersCopyAction_SignedIn() throws InterruptedException
//	{
//		homepage.VerifyMyFoldersCopyAction_SignedIn();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify MyFolders MoveAction SignedIn",testName="Kohler->AccountFolder:09")
//	public void VerifyMyFoldersMoveAction_SignedIn() throws InterruptedException{
//		homepage.VerifyMyFoldersMoveAction_SignedIn();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify EditDelete SignedIn",testName="Kohler->AccountFolder:10")
//	public void VerifyEditDelete_SignedIn() throws InterruptedException {
//		homepage.VerifyEditDelete_SignedIn();
//	}
//	@Test(groups={"AccountFolder"}, description = "Verify MyFolder PageOptions",testName="Kohler->AccountFolder:11")
//	public void VerifyMyFolderPageOptions() throws InterruptedException {
//		homepage.VerifyMyFolderPageOptions();
//	}
//	

//------------------------------------GENERAL NAVIGATION----------------------------------------

//	@Test(groups={"GenNavigation"}, description = "Verify Bathroom pages main links",testName="USKohler->GeneralNavigation:1")
//	public void VerifyBathroomMainMenu() {
//		Navigation_Pages.VerifyBathroomMainMenu();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = "Verifying bathroom submenu links",testName="USKohler->GeneralNavigation:2")
//	public void verifyBathroomSubMenuLinks() {
//		Navigation_Pages.verifyBathroomSubMenuLinks();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = " Verifying choreograph Shower Planner link functionality",testName="USKohler->GeneralNavigation:3")
//	public void verifychoreographShowerPlanner() {
//		Navigation_Pages.verifychoreographShowerPlanner();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = "verifying bathroom Product Buying guide and Article page",testName="USKohler->GeneralNavigation:4")
//	public void VerifyBathroomProductBuyingGuide() {
//		Navigation_Pages.VerifyBathroomProductBuyingGuide();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = "Verifying Kitchen expansion and kitchen links",testName="USKohler->GeneralNavigation:5")
//	public void VerifyKitchenMainMenu() {
//		Navigation_Pages.VerifyKitchenMainMenu();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = "verifying Kitchen menu links and link navigation",testName="USKohler->GeneralNavigation:6")
//	public void verifyKitchenSubMenuLinks() {
//		Navigation_Pages.verifyKitchenSubMenuLinks();
//	}
//	@Test(groups={"GenNavigation"}, description = "Verifying kitchen Planner link functionality+ new Window",testName="USKohler->GeneralNavigation:7")
//	public void verifyKitchenPlanner() {
//		Navigation_Pages.verifyKitchenPlanner();
//	}
//	@Test(groups={"GenNavigation"}, description = "verifying Press room link/ functionality",testName="USKohler->GeneralNavigation:8")
//	public void  VerifyPressRoomLink() {
//		Navigation_Pages. VerifyPressRoomLink();
//	}
//	@Test(groups={"GenNavigation"}, description = " verifying Find a store functionality",testName="USKohler->GeneralNavigation:9")
//	public void  VerifyFindAStore() {
//		Navigation_Pages. VerifyFindAStore();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = "verifying Kitchen Product Buying guide and Article page",testName="USKohler->GeneralNavigation:10")
//	public void  VerifyKitchenProductBuyingGuide() {
//		Navigation_Pages. VerifyKitchenProductBuyingGuide();
//    }
//	@Test(groups={"GenNavigation"}, description = "Verifying HelpUsToImproveMore link functionality",testName="USKohler->GeneralNavigation:11")
//	public void  VerifyKitchenHelpUsToImproveMore() {
//		String text="Very Good Experience";
//		Navigation_Pages. VerifyKitchenHelpUsToImproveMore(text,"Suggestion");
//	}	
//	@Test(groups={"GenNavigation"}, description = "verifying Parts expansion and Parts links",testName="USKohler->GeneralNavigation:12")
//		public void  VerifyPartsMainMenu() {
//			Navigation_Pages. VerifyPartsMainMenu();
//	 }
//	@Test(groups={"GenNavigation"}, description = "verifying NewsLetterSignUp Functionality",testName="USKohler->GeneralNavigation:13")
//	public void  VerifyNewsLetterSignUpLink() {
//		Navigation_Pages. VerifyNewsLetterSignUpLink();
//     }
//	
//	@Test(groups={"GenNavigation"}, description = "Verify general layout of homepage",testName="USKohler->GeneralNavigation:14")
//	public void VerifyFindAProInvalidZipCode()  {
//		Navigation_Pages.VerifyFindAProInvalidZipCode();
//	}
//	
//	@Test(groups={"GenNavigation"}, description = "Verify general layout of homepage",testName="USKohler->GeneralNavigation:15")
//	public void VerifyFindAPro() {
//		Navigation_Pages.VerifyFindAPro();
//	}
//	@Test(groups={"GenNavigation"}, description = "Verify page title of submenu links under Kitchen",testName="USKohler->GeneralNavigation:16")
//	public void verifyKitchenSubMenuLinksPageTitles() {
//		Navigation_Pages.verifyKitchenSubMenuLinksPageTitles();
//	}


//-------------------------------------SEARCHRESULTS---------------------------------------------
//	@Test(groups = {"Search"}, description = "Verify access to Kitchen section landing page ", testName = "Kohler->Search:1")
//	public void VerifySearchFunctionalityKitchen() {
//		kohler_search.VerifySearchFunctionalityKitchen();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify access to Toilets category landing page ", testName = "Kohler->Search:2")
//	public void VerifySearchFunctionalityToilets() {
//		kohler_search.VerifySearchFunctionalityToilets();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify access to Vanity category landing page ", testName = "Kohler->Search:3")
//	public void VerifySearchFunctionalityVanity() {
//		kohler_search.VerifySearchFunctionalityVanity();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify access to Faucet category landing page ", testName = "Kohler->Search:4")
//	public void VerifySearchFunctionalityFaucet() {
//		kohler_search.VerifySearchFunctionalityFaucet();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify access to Product detail page ", testName = "Kohler->Search:5")
//	public void VerifySearchFunctionalityProduct() {
//		kohler_search.VerifySearchFunctionalityProduct();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify search for keyword Arm ", testName = "Kohler->Search:6")
//	public void VerifySearchFunctionalityArm() {
//		kohler_search.VerifySearchFunctionalityArm();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify Inspiration tab ", testName = "Kohler->Search:7")
//	public void VerifySearchFunctionalityInspiration() {
//		kohler_search.VerifyFunctionalityInspiration();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify Resource tab ", testName = "Kohler->Search:7")
//	public void VerifySearchFunctionalityResource() {
//		kohler_search.VerifyFunctionalityResource();
//	}
//	
//	@Test(groups = {"Search"}, description = "Verify search and collection is displayed ", testName = "Kohler->Search:8")
//	public void VerifySearchFunctionalityMemoirs() {
//		kohler_search.VerifySearchFunctionalityMemoirs();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify search and moxie aricle is displayed ", testName = "Kohler->Search:09")
//	public void VerifySearchFunctionalityMoxie() {
//		kohler_search.VerifySearchFunctionalityMoxie();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify search and results for 'did you mean two? ", testName = "Kohler->Search:10")
//	public void VerifySearchFunctionalityTw() {
//		kohler_search.VerifySearchFunctionalityTw();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify typeahead with 3 letters ", testName = "Kohler->Search:11")
//	public void VerifySearchFunctionalityTou() {
//		kohler_search.VerifySearchFunctionalityTou();
//	}
//
//	@Test(groups = {"Search"}, description = "Verify search and page loads to external website ", testName = "Kohler->Search:12")
//	public void VerifySearchFunctionalityToLoadExternalWebSite() {
//		kohler_search.VerifySearchFunctionalityTerm_Leed();
//		kohler_search.VerifySearchFunctionalityTerm_Robern();
//		kohler_search.VerifySearchFunctionalityTerm_Privacy();
//	}
//	@Test(groups={"Search"}, description = "Verify Search term(Pressure Balance) and the page loads to internal website",testName="Kohler->Search:13")
//	public void VerifySearchFunctionalityTerm_PressureBalance() throws InterruptedException {
//		kohler_search.VerifySearchFunctionalityTerm_PressureBalance();
//	}
//	@Test(groups={"Search"}, description = "Verify Search term(bath tub) and the page loads to internal website",testName="Kohler->Search:13")
//	public void VerifySearchFunctionalityTerm_bathtub() throws InterruptedException {
//		kohler_search.VerifySearchFunctionalityTerm_bathtub();
//	}
//	@Test(groups={"Search"}, description = "Verify Search term(night light) and the page loads to internal website",testName="Kohler->Search:13")
//	public void VerifySearchFunctionalityTerm_nightlight() throws InterruptedException {
//		kohler_search.VerifySearchFunctionalityTerm_nightlight();
//	}
//	@Test(groups={"Search"}, description = "Method to verify each term display the same results",testName="Kohler->Search:14")
//    public void VerifySearchFunctionalityTermsDisplaySameResults_poplin_poplen() throws InterruptedException {
//		kohler_search.VerifySearchFunctionalityTermsDisplaySameResults_poplin_poplen();
//	}
//	
//	@Test(groups={"Search"}, description = "Method to verify each term display the same results",testName="Kohler->Search:14")
//    public void VerifySearchFunctionalityTermsDisplaySameResults_choreo_choreograph() throws InterruptedException {
//		kohler_search.VerifySearchFunctionalityTermsDisplaySameResults_choreo_choreograph();
//	}
//	@Test(groups={"Search"}, description = "Verify article redirects are turned off by searching 'moxie'",testName="Kohler->Search:15")
//	public void VerifyArticlesTurnedOffbyParts() throws InterruptedException {
//		kohler_search.VerifyArticlesTurnedOffbyParts();
//	}
//	@Test(groups={"Search"}, description = "Verify collections redirects are turned off by searching 'memoirs'",testName="Kohler->Search:16")
//	public void VerifyCollectionsTurnedOffbyParts() throws InterruptedException {
//		kohler_search.VerifyCollectionsTurnedOffbyParts();
//	}
	
	
	//------------------------------PRODUCTDISPLAYPAGE-----------------------------------------
    @Test(groups={"ProductDisplayPage"}, description = "Verify VerifyPDPpage",testName="kohler->PDP:01")
	public void VerifyPDPpage() {
		productpage.VerifyPDPpage();
	}
	@Test(groups={"ProductDisplayPage"}, description = "VerifyBreadcrumbs_StoreLocator_PDPpage",testName="kohler->PDP:02")
	public void VerifyBreadcrumbs_StoreLocator_PDPpage() {
		productpage.VerifyBreadcrumbs_StoreLocator_PDPpage();
	}
	@Test(groups={"ProductDisplayPage"}, description = "Verify compare overlay display and Disaapear method",testName="kohler->PDP:03")
	public void VerifyCompareOverlayDisplayandDisappear() throws InterruptedException {
		productpage.VerifyCompareOverlayDisplayandDisappear();
	}
	@Test(groups={"ProductDisplayPage"}, description = "Verify compare product modal",testName="kohler->PDP:04")
	public void VerifyCompareproductModal() throws InterruptedException {
		productpage.VerifyCompareproductModal();
	}
	@Test(groups={"ProductDisplayPage"}, description = "Method to verify AddtoCart_PDPPage",testName="kohler->PDP:05")
	public void VerifyAddtoCart_PDPPage() throws InterruptedException {
		productpage.VerifyAddtoCart_PDPPage();
	}
	@Test(groups={"ProductDisplayPage"}, description = "Method for signIn",testName="kohler->PDP:06")
	public void signIn() throws InterruptedException {
		productpage.signIn();
	}
	@Test(groups={"ProductDisplayPage"}, description = "verify PDP Page Options",testName="kohler->PDP:08")
	public void VerifyOptions_PDPPage() throws InterruptedException {
		productpage.VerifyOptions_PDPPage();
	}
	@Test(groups={"ProductDisplayPage"}, description = "verify Discontinued Product",testName="kohler->PDP:09")
	public void DiscontinuedProduct() throws InterruptedException {
		productpage.DiscontinuedProduct();
	}
    @Test(groups={"ProductDisplayPage"}, description = "verify Sellable Service part",testName="kohler->PDP:10")
	public void SellableServicepart() throws InterruptedException {
		productpage.SellableServicepart();
	}

}

