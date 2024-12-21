package exporter.model;

public class Commodity {
    private String id;
    private String jsonType;
    private String name;
    private String description;
    private String iconName;
    private int stackSize;
    private double order;
    private double cargoSpace;
    private double basePrice;
    private double utility;
    private String demandClass;
    private double economyTier;
    private double econUnit;
    private double iconWidthMult;
    private double exportValue;
    private boolean primary;
    private boolean exotic;
    private boolean meta;
    private boolean nonEcon;
    private boolean personnel;
    private boolean fuel;
    private boolean supplies;
    private double priceVariability;
    private String baseDanger;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonType() {
        return jsonType;
    }

    public void setJsonType(String jsonType) {
        this.jsonType = jsonType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public double getOrder() {
        return order;
    }

    public void setOrder(double order) {
        this.order = order;
    }

    public double getCargoSpace() {
        return cargoSpace;
    }

    public void setCargoSpace(double cargoSpace) {
        this.cargoSpace = cargoSpace;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) {
        this.utility = utility;
    }

    public String getDemandClass() {
        return demandClass;
    }

    public void setDemandClass(String demandClass) {
        this.demandClass = demandClass;
    }

    public double getEconomyTier() {
        return economyTier;
    }

    public void setEconomyTier(double economyTier) {
        this.economyTier = economyTier;
    }

    public double getEconUnit() {
        return econUnit;
    }

    public void setEconUnit(double econUnit) {
        this.econUnit = econUnit;
    }

    public double getIconWidthMult() {
        return iconWidthMult;
    }

    public void setIconWidthMult(double iconWidthMult) {
        this.iconWidthMult = iconWidthMult;
    }

    public double getExportValue() {
        return exportValue;
    }

    public void setExportValue(double exportValue) {
        this.exportValue = exportValue;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public boolean isExotic() {
        return exotic;
    }

    public void setExotic(boolean exotic) {
        this.exotic = exotic;
    }

    public boolean isMeta() {
        return meta;
    }

    public void setMeta(boolean meta) {
        this.meta = meta;
    }

    public boolean isNonEcon() {
        return nonEcon;
    }

    public void setNonEcon(boolean nonEcon) {
        this.nonEcon = nonEcon;
    }

    public boolean isPersonnel() {
        return personnel;
    }

    public void setPersonnel(boolean personnel) {
        this.personnel = personnel;
    }

    public boolean isFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }

    public boolean isSupplies() {
        return supplies;
    }

    public void setSupplies(boolean supplies) {
        this.supplies = supplies;
    }

    public double getPriceVariability() {
        return priceVariability;
    }

    public void setPriceVariability(double priceVariability) {
        this.priceVariability = priceVariability;
    }

    public String getBaseDanger() {
        return baseDanger;
    }

    public void setBaseDanger(String baseDanger) {
        this.baseDanger = baseDanger;
    }
}
