package yaml;

import static java.util.Objects.isNull;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class GeneralNavigationData {
	
	 public String title;
	 public String saveTOFolders;
	 public String test;
	 public String press;
	 public String place;
	 public String message;
	 public String email;
	 public String firstName;
	 public String lastName;
	 public String postalCode;
	 public int country;
	 public int occupation;
	 public String parts;
	 public String inputValue;
     public String title1;
     public String installationTitle;
     public String bathroomRemodel;
     public String newHomeTitle;
     public String actualErrorMessage;
     public String productInstvalue;
     public String bathRoomHomeCons;
     public String estimateHeader;
     public String landingPageTitle;
	 
	 
	public static GeneralNavigationData getgeneralnavigationData() {

        Yaml yaml = new Yaml(new Constructor(GeneralNavigationData.class));
        GeneralNavigationData generalnavigationData = new GeneralNavigationData();
        try (InputStream inputStream = GeneralNavigationData.class.getClassLoader()
                .getResourceAsStream("generalnavigation_data.yaml")) {
            if (isNull(inputStream)) {
                throw new IllegalStateException("generalnavigation_data.yaml not found");
            }
            generalnavigationData = yaml.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load generalnavigation_data.yaml file", e);
        }
        return generalnavigationData;
    }

}
