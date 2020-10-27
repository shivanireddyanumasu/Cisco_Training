package yaml;

import static java.util.Objects.isNull;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class HomePageData {
	
	public String homepageUrl;
	public String homepageTitle;
	public String toolBoxText;
	public String countryLinks;
	public String otherBrand1;
	public String otherBrand2;
	public String otherBrand3;
	public String otherBrand4;
	public String otherBrand5;
	public String homepageKohlerUrl;
	public String emailId;
    public String password;
    public String folderName;
    public String folderNote;
    public String folderText;
    public String productId;
    public String newFolderText;
    public String shareEmail;
    public String shareShowroom;
    public String showroomText;
    public String emailText;
    public String folderText1;
    public String productId1;
    public String editText;





	
	
	public static HomePageData gethomepageData() {

        Yaml yaml = new Yaml(new Constructor(HomePageData.class));
        HomePageData homepageData = new HomePageData();
        try (InputStream inputStream = HomePageData.class.getClassLoader()
                .getResourceAsStream("homepage_data.yaml")) {
            if (isNull(inputStream)) {
                throw new IllegalStateException("homepage_data.yaml not found");
            }
            homepageData = yaml.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load homepage_data.yaml file", e);
        }
        return homepageData;
    }
}
