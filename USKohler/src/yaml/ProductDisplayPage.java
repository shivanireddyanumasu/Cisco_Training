package yaml;

import java.io.IOException;
import java.io.InputStream;
import static java.util.Objects.isNull;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class ProductDisplayPage {
                
				public String productID;
                public String expectedTitle;
                public String productId;
                public String UserName;
            	public String password;
            	public String productId1;
            	public String productId2;
            	public String pdpOptions;
            	public String productId3;
            	public String productId4;
            	public String products[];
                               
   public static ProductDisplayPage getproductData() {

        Yaml yaml = new Yaml(new Constructor(ProductDisplayPage.class));
        ProductDisplayPage productData = new ProductDisplayPage();
        try (InputStream inputStream = ProductDisplayPage.class.getClassLoader().getResourceAsStream("productdisplaypage_data.yaml")) {
            if (isNull(inputStream)) {
                throw new IllegalStateException("productdisplaypage_data.yaml not found");
            }
           productData = yaml.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load productdisplaypage_data.yaml file", e);
        }
        return productData;
    }



}


