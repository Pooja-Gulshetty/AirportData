package airport.details.entities;

public class Country {

	private static final int numberOfFields = 6;

	private String id;

	private String code;

	private String name;

	private String continent;

	private String wikipediaLink;

	private String keywords;

	public Country(String[] data) {
		int index = 0;
		this.id = data[index++];
		this.code = data[index++];
		this.name = data[index++];
		this.continent = data[index++];
		this.wikipediaLink = data[index++];
		this.keywords = data[index];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getWikipediaLink() {
		return wikipediaLink;
	}

	public void setWikipediaLink(String wikipediaLink) {
		this.wikipediaLink = wikipediaLink;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", code=" + code + ", name=" + name + ", continent=" + continent
				+ ", wikipediaLink=" + wikipediaLink + ", keywords=" + keywords + "]";
	}

	public static int getNumberoffields() {
		return numberOfFields;
	}

}
