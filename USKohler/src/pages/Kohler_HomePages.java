package pages;

import org.openqa.selenium.By;

public class Kohler_HomePages {
	
	
	public By Link_HelpUsToImproveMore = By.xpath("//*[@class=\"improve-site\"]//a");
	public By btn_suggestion = By.xpath("//*[@id='QtnId-9741']/fieldset/section/form/ul/li[1]/label/span/span");
	public By btn_dislike = By.xpath("//*[@id='QtnId-9741']/fieldset/section/form/ul/li[2]/label/span/span");
	public By btn_praise = By.xpath("//*[@id='QtnId-9741']/fieldset/section/form/ul/li[3]/label/span/span");
	public By btn_nxt = By.xpath("//button[@class='buttonNav btnNext one-quarter enabled']");
	public By btn_Rating = By.xpath("//*[@id= 'ItemId-35770-2']");
	public By text_email = By.xpath("//input[@type='text']");
	public By btn_sendmyComments = By.xpath("//div[@class=\"grid__item one-third\"]//button");
	//public By btn_sendmyComments = By.xpath("//div[@class=\"grid__item one-third\"]/button[@class=\"submitButton\"]");
	public By footeralllinks = By.xpath("//a[@class=\"footer__link\"]");
	public By footerkohlerColinks = By.xpath("//a[@class=\"footer__link\"]");
	public By countrylinks = By.xpath("//*[@id='sign-in-bar__link--our-brands-button']");
	public By countryalllinks = By.xpath("//*[@class=\"fluid-container\"]/div/div/ul/li/a");
	public By countryexpand = By.xpath("//*[@class=\"fluid-container\"]");
	public By utilitybar = By.xpath("//*[@class=\"sign-in-bar__link\"]");
	public By imageclick = By.xpath("//*[@class=\"vertical-center\"]/div/h2");
	public By previousarrow = By.xpath("//*[@id=\"page-content-home\"]/div/div/div/div[1]/div/div/div[1]/div[1]/button[1]");
	public By nextarrow = By.xpath("//*[@id=\"page-content-home\"]/div/div/div/div[1]/div/div/div[1]/div[1]/button[2]");
    public By ideaslayoutrightarrow= By.xpath("//button[@class=\"curalate-nav curalate-carousel-next-page\"]");
	public By ideaslayoutleftarrow= By.xpath("//button[@class=\"curalate-nav curalate-carousel-previous-page\"]");
	public By gallery= By.className("curalate-view-gallery");
	public By uploadphoto= By.id("curalate-upload-photos");
	public By photobutton= By.xpath("//div[@class=\"curalate-footer\"]//button");
	public By pick= By.id("curalate-photo-picker");
	public By pickframe= By.id("desktop-upload");
    public By btn_closeTheWind = By.xpath("//*[@id= 'Finish']");
	public By text_commenttextbox = By.xpath("//textarea[@id='textarea']");
	public By button_slick_next1 = By.xpath("//*[@id='page-content-home']//button[@class=\\\"slick-next\\\"]");
	public By ele2 = By.xpath("//*[@id='page-content-home']//button[@class=\"slick-next\"]");
	public By ele1 = By.xpath("//*[@id='page-content-home']//button[@class=\\\"slick-prev\\\"]");
    public By element_utilityBar = By.xpath("//*[@id= 'sign-in-bar']");
	public By Discoverthepossibilities = By.xpath("//*[@id='container-home']");
	public By Discovershare = By.xpath("//*[@class='carousel-cta__right']/button[2]");
	public By Discovershareinnertip = By.xpath("//*[@class ='share-tip-inner']/ul/li");
	public By SlickDots = By.xpath("//*[@id='container-home']/div[3]/div/div/div[1]/ul/li");
	public By AddtoFolder = By.xpath("//*[@class ='carousel-cta__right']/button[@data-params='addToFolder,relative,300']");
	public By textarea = By.xpath("//*[@id='addToFolder']/div[4]/div/textarea");
	public By shareaddtofolder = By.xpath("//*[@id='addToFolder']/button[1]");
	public By Message= By.xpath("//*[@id='showThankyou']/div[2]/div/button[2]");
	public By imageinfolder= By.xpath("//*[@id='my-folders']/div[3]/div/div[2]/div/a/img");
	public By Notetext = By.xpath("//*[@class='add_to_cart_folder']/div/div[2]/div[2]/div/p/span[2]");
	public By Learnmore = By.xpath("//*[@class='carousel-cta__right']/a");
	public By promomodulegrid = By.xpath("//*[@class='container' ]/ul/li[@class='promotion']/a");
	public By carouselslides = By.xpath("//*[@id='container-home']/div[3]/div/div/div[1]/div/div/div");
	public By NextArrow = By.xpath("@id='container-home']/div[3]/div/div/div[1]");
	public By NextArrowbutton = By.xpath("[@id='container-home']/div[3]/div/div/div[1]/button[[1]");
	public By Storelocator= By.xpath("//*[@id='store-locator']/div/h1\"");
	
	
   
//	public By  UserNameTray= By.xpath("//*[@id=\"user-name-tray\"]");
//	public By  EmailAddress = By.xpath("//*[@id=\"email\"]");
//	public By  Password= By.xpath("//*[@id=\"password\"]");
//	public By  btn_Signin= By.id("trayProfileSignIn");
//	public By  UserNameTrayDropDown = By.xpath("//*[@id='sign-in-bar__account-dropdown']/div");
//	public By  MyAccount = By.linkText("My Account");
//	public By  FirstName_MyAccount = By.id("profile-first-name");
//	public By  SignOut= By.xpath("//*[@id=\"sign-in-bar__account-dropdown\"]/div/a[2]");
//	
//	public By  EditAccount= By.linkText("EDIT ACCOUNT");
//	public By  AccountFieldtoEdit= By.xpath("//*[@id=\"describe-yourself-dropdown-page_title\"]");
//	public By  NewPassword=By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/form/div[3]/div/div[14]/div[2]/input[1]");
//	public By  ConfirmPassword=By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[1]/form/div[3]/div/div[15]/div[2]/input[1]");
//	public By  SaveEditedAccount=By.xpath("//*[@id=\"account-details--edit\"]/div[3]/div/div[1]/div[2]/a[2]/input[1]");
//	public By  SaveSuccess=By.xpath("//*[@id=\"updateSuccess\"]/span");
//	
//	KohlerIdeasLayout section removed from USKohler site during recent deployment.
//	public By  MyFolder=By.xpath("//*[@id=\"sign-in-bar__inner\"]/span/a");
//	public By  btn_CreateFolder= By.linkText("Create a New Folder");
//	public By  CreateFolderName= By.xpath("//*[@id=\"folder-name\"]");
//	public By  CreateFolderNotes= By.xpath("//*[@id=\"textarea-140\"]");
//	public By  btn_Create=By.xpath("//*[@id=\"createNewFolder\"]/button[1]");
//	
//	public By  SearchField_TextArea=By.xpath("//*[@id=\"nav-searchbox\"]");
//	public By  SearchSymbol=By.xpath("//*[@id=\"header__button--search-button-desktop\"]");
//	public By  AddToFolder = By.xpath("//*[@id=\"addToFolder\"]");	
//	public By  AddToFolderTextArea = By.xpath("//*[@id=\"textarea-140-5\"]");
//	public By  AddToFolderSubmitButton = By.xpath("//*[@id=\"addToFolder\"]/button[1]");
//    public By  AddToFolderContinueShopping = By.xpath("//*[@id=\"showThankyou\"]/div[2]/div/button[2]");	
//    public By  EditTextArea_Folder= By.xpath("//*[@id=\"textarea-140-3\"]");
//    public By  EditSave_Folder= By.xpath("//*[@id=\"editItemNote\"]/button[1]");
//    public By  SelectAllCheckBox1= By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/div[1]/div[2]/label/span[1]");
//    public By  Deletebtn_Folder1= By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/div[1]/div[4]/div/button");
//    public By  DeleteConfirmation= By.xpath("//*[@id=\"deleteItems\"]");
//    
//    public By  MyKohlerFolder = By.linkText("My Kohler Folder");
//    public By  ShareFolderOption=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[4]/div/button[4]");
//	public By  Share_EmailAFriend=By.xpath("/html/body/div[7]/div[3]/ul/li[1]/a");
//	public By  Share_EmailAFriendClose=By.xpath("//*[@id=\"modal-myfolder-email-friend\"]/div/button");
//	public By  Share_KohlerShowroom=By.xpath("/html/body/div[7]/div[3]/ul/li[2]/a");
//	public By  Share_ShareKohlerClose=By.xpath("//*[@id=\"modal-with-showroom\"]/div/button");
//	public By  CopyFolderOption=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[4]/div/button[2]");	
//	public By  CopyFolder_Foldername=By.xpath("/html/body/div[4]/div[5]/div/form/div[3]/div/input[1]");
//	public By  SaveAsNewFolder=By.xpath("//*[@id=\"saveAsNewFolder\"]/button[2]");
//	public By  DeleteFolderOption=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[4]/div/button[1]");
//	public By  DeleteFolderConfirmation=By.xpath("//*[@id=\"removeFolder\"]/button[1]");
//	
//	public By  SelectAllCheckBox_click= By.xpath("//*[@id=\"my-folders-detail__items\"]/div[1]/div[1]/div/div[1]/label/span[1]");
//	public By CopyItemButton=By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/div[2]/div[4]/div/button[1]");
//	public By Addbtn=By.xpath("//*[@id=\"copyToFolder\"]/button[1]");
//	public By MoveItemButton=By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/div[2]/div[4]/div/button[2]");
//	
//	public By MyFolderImage=By.xpath("//*[@id=\"folderMainImage\"]");
//	public By MyFolderCost=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[2]/p[1]");
//	public By MyFolderNotes=By.xpath("//*[@id=\"editFolderNote\"]");
	
	public By cookie_accept = By.xpath("//*[@id=\"truste-consent-button\"]");
	public By cookie_banner = By.xpath("//*[@id=\"truste-consent-content\"]");
	public By  UserNameTray= By.xpath("//*[@id=\"user-name-tray\"]");
	public By  UserNameTray_text=By.xpath("//*[@id='user-name-tray']");
	public By  EmailAddress = By.xpath("//*[@id=\"email\"]");
	public By  Password= By.xpath("//*[@id=\"password\"]");
	//public By  btn_Signin= By.id("trayProfileSignIn");
	public By  btn_Signin= By.xpath("//*[@class=\"btn--primary btn_submit\"]");

	public By  UserNameTrayDropDown = By.xpath("//*[@id='sign-in-bar__account-dropdown']/div");
	//public By  MyAccount = By.linkText("My Account");
	public By  MyAccount = By.xpath("//*[@id='sign-in-bar__account-dropdown']/div/a[1]");
	public By  FirstName_MyAccount = By.xpath("(//*[@class='form-group row'])[1]/p");
	public By  SignOut= By.xpath("//*[@id=\"sign-in-bar__account-dropdown\"]/div/a[2]");
	public By  EditAccount= By.xpath("//*[@id='account-details--button']");
	public By  AccountFieldtoEdit= By.xpath("//*[@id='describe-yourself-dropdown-page_title']");
	public By  CountryText = By.id("describe-yourself-dropdown-page_title");
	public By  Country_list = By.xpath("//*[@id='account-details--edit']/div[3]/div/div[6]/div[2]/div/div[2]/div[2]/ul/li");
	public By  DescribeYoursel_list=By.xpath("//*[@id='account-details--edit']/div[3]/div/div[9]/div[2]/div/div[2]/div[2]/ul/li");
	//public By  DescribeYourself_text = By.xpath("//*[@id='describe-yourself-dropdown-page_title']/span[1]");
	public By  DescribeYourself_text = By.xpath("//*[@id='tabbed-results__account-details']/div/div[1]/div/div[7]/p");
	public By  NewPassword=By.xpath("(//*[@id='pass'])[2]");
	public By  ConfirmPassword=By.xpath("(//*[@id='passwordAgain'])");
	public By  SaveEditedAccount=By.xpath("//*[@id='account-details--edit']/div[3]/div/div/div[2]/a[2]/input");
	public By  SaveSuccess=By.xpath("//*[@id=\"updateSuccess\"]/span");
	public By  MyFolder=By.xpath("//*[@id=\"sign-in-bar__inner\"]/span/a");
	public By  btn_CreateFolder= By.linkText("Create a New Folder");
	public By  CreateFolderName= By.xpath("//*[@id=\"folder-name\"]");
	public By  CreateFolderNotes= By.xpath("//*[@id=\"textarea-140\"]");
	public By  btn_Create=By.xpath("//*[@id=\"createNewFolder\"]/button[1]");
	public By  Search_Field=By.xpath("//*[@id=\"nav-searchbox\"]");
	public By  Search_button=By.xpath("//*[@id=\"header__button--search-button-desktop\"]");
	public By  AddToFolder_btn = By.xpath("//*[@id=\"addToFolder\"]");	
	public By  AddToFolderField = By.xpath("//*[@id=\"textarea-140-5\"]");
	public By  FolderDropdown = By.xpath("//*[@id='folderDropdown_msdd']");
	public By  FolderList = By.xpath("//div[@id='folderDropdown_child']/ul/li"); 
	public By  AddToFolderSubmitButton = By.xpath("//*[@id=\"addToFolder\"]/button[1]");
    public By  AddToFolderContinueShopping = By.xpath("//*[@id=\"showThankyou\"]/div[2]/div/button[2]");
    public By  NoteText_List=By.xpath("//*[@id='my-folders-detail__items']/div/div/div/div[2]/div[2]/div/p/span[2]");
    public By  Edit_List = By.xpath("//*[@id='my-folders-detail__items']/div/div/div/div[2]/div[2]/div/a");
    public By  EditTextArea_Folder= By.xpath("//*[@id=\"textarea-140-3\"]");
    public By  EditSave_Folder= By.xpath("//*[@id=\"editItemNote\"]/button[1]");
    public By  SelectAllCheckBox1= By.xpath("(//*[@class='checkbox'])[1]");
    public By  Deletebutton= By.xpath("//*[@class='flex-actions selectAllOptions']/button[3]");
    public By  DeleteConfirmation= By.xpath("//*[@id='deleteItems']");
    public By  TotalPrice=By.xpath("//*[@id='my-folders-detail__items']/div[1]/div/div[4]/p/span[2]");
    public By  MyKohlerFolder = By.linkText("My Kohler Folder");
    public By  ShareFolderOption=By.xpath("(//div[@class='flex-actions'])[1]/button[4]");
	public By  Share_EmailAFriend=By.xpath("(//li[@class='social-share-item'])[1]");
	public By  Email_Text=By.xpath("//*[@id=\"modal-myfolder-email-friend\"]/div/h4");
	public By  EmailCloseButton=By.xpath("//*[@id=\"modal-myfolder-email-friend\"]/div/button");
	public By  Share_Showroombtn=By.xpath("(//li[@class='social-share-item'])[2]");
	public By  Showroom_text = By.xpath("//*[@class='modal__inner']/h4[1]");
	public By  ShowroomCloseButton=By.xpath("//*[@id='modal-with-showroom']/div/button");
	public By  Sharefoldername=By.id("shareFolderName");
	public By  MyFolders_foldersList=By.xpath("//*[@id='my-folders']/div[3]/div/form/div/p/a");
	public By  BackToTop_button= By.xpath("//*[@id='back-to-top']/button");
	public By  ItemsinFolder=By.xpath("//*[@id='my-folders-detail__items']/div/div/div/div[2]/div[2]/div/p");
	public By  FolderNotes=By.xpath("//*[@id=\"textarea-140-1\"]");
	public By  CopyFolderOption=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[4]/div/button[2]");	
	public By  CopyFolderName=By.xpath("(//*[@id='folder-name'])[2]");
	public By  SaveAsNewFolder=By.xpath("//*[@id=\"saveAsNewFolder\"]/button[2]");
	public By  DeleteFolderOption=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[4]/div/button[1]");
	public By  DeleteFolderConfirmation=By.xpath("//*[@id=\"removeFolder\"]/button[1]");
	public By CopyItemButton=By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/div[2]/div[4]/div/button[1]");
	public By Addbutton=By.xpath("//*[@id=\"copyToFolder\"]/button[1]");
	public By MoveItemButton=By.xpath("//*[@id=\"my-folders\"]/div[3]/div/div/div/div[2]/div[4]/div/button[2]");
	public By MyFolderImage=By.xpath("//*[@id=\"folderMainImage\"]");
	public By MyFolderCost=By.xpath("//*[@id=\"my-folders\"]/div[1]/div/div[2]/div/div[2]/p[1]");
	public By MyFolderNotes=By.xpath("//*[@id=\"editFolderNote\"]");
	public By BlueBanner = By.xpath("//*[@id='promobanner-tf-usa']");
	public By SlickDots1 = By.xpath("//div[@class='carousel-hot-spots']/following::ul[@class='slick-dots']/li/button");
	public By AddtoFolderList = By.xpath("//*[@id=\"page-content-home\"]/div/div/div/div[3]/div/div/div[1]/div[1]/div/div/div[2]/div/div/div/div/div[3]/div[2]/button");
	
	
	

}

