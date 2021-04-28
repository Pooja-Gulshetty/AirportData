package airport.details.entities;

public class Airport {

	private static final int numberOfFields = 18;

	private String id;

	private String ident;

	private String type;

	private String name;

	private String latitudeDeg;

	private String longitudeDeg;

	private String elevationFt;

	private String continent;

	private String isoCountry;

	private String isoRegion;

	private String municipality;

	private String scheduledService;

	private String gpsCode;

	private String iataCode;

	private String localCode;

	private String homeLink;

	private String wikipediaLink;

	private String keywords;

	public Airport(String[] data) {
		int index = 0;
		this.id = data[index++];
		this.ident = data[index++];
		this.type = data[index++];
		this.name = data[index++];
		this.latitudeDeg = data[index++];
		this.longitudeDeg = data[index++];
		this.elevationFt = data[index++];
		this.continent = data[index++];
		this.isoCountry = data[index++];
		this.isoRegion = data[index++];
		this.municipality = data[index++];
		this.scheduledService = data[index++];
		this.gpsCode = data[index++];
		this.iataCode = data[index++];
		this.localCode = data[index++];
		this.homeLink = data[index++];
		this.wikipediaLink = data[index++];
		this.keywords = data[index];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLatitudeDeg() {
		return latitudeDeg;
	}

	public void setLatitudeDeg(String latitudeDeg) {
		this.latitudeDeg = latitudeDeg;
	}

	public String getLongitudeDeg() {
		return longitudeDeg;
	}

	public void setLongitudeDeg(String longitudeDeg) {
		this.longitudeDeg = longitudeDeg;
	}

	public String getElevationFt() {
		return elevationFt;
	}

	public void setElevationFt(String elevationFt) {
		this.elevationFt = elevationFt;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getIsoCountry() {
		return isoCountry;
	}

	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}

	public String getIsoRegion() {
		return isoRegion;
	}

	public void setIsoRegion(String isoRegion) {
		this.isoRegion = isoRegion;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getScheduledService() {
		return scheduledService;
	}

	public void setScheduledService(String scheduledService) {
		this.scheduledService = scheduledService;
	}

	public String getGpsCode() {
		return gpsCode;
	}

	public void setGpsCode(String gpsCode) {
		this.gpsCode = gpsCode;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getLocalCode() {
		return localCode;
	}

	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}

	public String getHomeLink() {
		return homeLink;
	}

	public void setHomeLink(String homeLink) {
		this.homeLink = homeLink;
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
		return "Airport [id=" + id + ", ident=" + ident + ", type=" + type + ", name=" + name + ", latitudeDeg="
				+ latitudeDeg + ", longitudeDeg=" + longitudeDeg + ", elevationFt=" + elevationFt + ", continent="
				+ continent + ", isoCountry=" + isoCountry + ", isoRegion=" + isoRegion + ", municipality="
				+ municipality + ", scheduledService=" + scheduledService + ", gpsCode=" + gpsCode + ", iataCode="
				+ iataCode + ", localCode=" + localCode + ", homeLink=" + homeLink + ", wikipediaLink=" + wikipediaLink
				+ ", keywords=" + keywords + "]";
	}

	public static int getNumberoffields() {
		return numberOfFields;
	}

}
