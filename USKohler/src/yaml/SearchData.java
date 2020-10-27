package yaml;

import static java.util.Objects.isNull;

import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class SearchData{
	
	public String kitchenKey;
	public String kitchenPageTitle;
	public String toiletsKey;
	public String toiletsPageTitle;
	public String vanityKey;
	public String vanityPageTitle;
	public String faucetKey;
	public String faucetPageTitle;
	public String productSku1;
	public String productPageTitle1;
	public String productSku2;
	public String productPageTitle2;
	public String armKey;
	public String topsKey;
	public String memoirsKey;
	public String moxieKey;
	public String twKey;
	public String twSearch;
	public String touKey;
	public String leedKey;
	public String robernKey;
	public String privacyKey;
	public String touchlessKey;
	public String sustainabilityKey;
	public String ideasUrl;
	public String PageTitle;
	public String searchTerm;
	public String searchTerm1;
	public String PageTitle1;
	public String searchTerm2;
	public String PageTitle2;


	public static SearchData getSearchData() {

        Yaml yaml = new Yaml(new Constructor(SearchData.class));
        SearchData searchData = new SearchData();
        try (InputStream inputStream = SearchData.class.getClassLoader()
                .getResourceAsStream("search_data.yaml")) {
            if (isNull(inputStream)) {
                throw new IllegalStateException("search_data.yaml not found");
            }
            searchData = yaml.load(inputStream);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load products.yaml file", e);
        }
        return searchData;
    }
}
