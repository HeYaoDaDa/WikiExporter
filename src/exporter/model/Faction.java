package exporter.model;

import java.util.List;
import java.util.Map;

public class Faction {
    private String id;
    private String jsonType;

    private String displayName;
    private String displayNameLong;
    private String personNamePrefix;
    private String shipNamePrefix;
    private String description;

    private String logo;
    private String crest;

    private String pickPersonality;

    private Map<String, Double> relationshipMap;
    private List<String> illegalCommodityIds;

    private List<String> knownShipIds;
    private List<String> alwaysKnownShipIds;
    private List<String> priorityShipIds;

    private List<String> knownWeaponIds;
    private List<String> priorityWeaponIds;
    private Map<String, Float> weaponSellFrequency;

    private List<String> knownFighterIds;
    private List<String> priorityFighterIds;
    private Map<String, Float> fighterSellFrequency;

    private List<String> knownIndustryIds;

    private List<String> knownHullModIds;
    private List<String> priorityHullModIds;
    private Map<String, Float> hullModSellFrequency;

    private double tariffFraction;
    private double tollFraction;
    private double fineFraction;

    private boolean playerFaction;
    private boolean showInIntelTab;
    private boolean neutralFaction;

    private String color;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayNameLong() {
        return displayNameLong;
    }

    public void setDisplayNameLong(String displayNameLong) {
        this.displayNameLong = displayNameLong;
    }

    public String getPersonNamePrefix() {
        return personNamePrefix;
    }

    public void setPersonNamePrefix(String personNamePrefix) {
        this.personNamePrefix = personNamePrefix;
    }

    public String getShipNamePrefix() {
        return shipNamePrefix;
    }

    public void setShipNamePrefix(String shipNamePrefix) {
        this.shipNamePrefix = shipNamePrefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCrest() {
        return crest;
    }

    public void setCrest(String crest) {
        this.crest = crest;
    }

    public String getPickPersonality() {
        return pickPersonality;
    }

    public void setPickPersonality(String pickPersonality) {
        this.pickPersonality = pickPersonality;
    }

    public Map<String, Double> getRelationshipMap() {
        return relationshipMap;
    }

    public void setRelationshipMap(Map<String, Double> relationshipMap) {
        this.relationshipMap = relationshipMap;
    }

    public List<String> getIllegalCommodityIds() {
        return illegalCommodityIds;
    }

    public void setIllegalCommodityIds(List<String> illegalCommodityIds) {
        this.illegalCommodityIds = illegalCommodityIds;
    }

    public List<String> getKnownShipIds() {
        return knownShipIds;
    }

    public void setKnownShipIds(List<String> knownShipIds) {
        this.knownShipIds = knownShipIds;
    }

    public List<String> getAlwaysKnownShipIds() {
        return alwaysKnownShipIds;
    }

    public void setAlwaysKnownShipIds(List<String> alwaysKnownShipIds) {
        this.alwaysKnownShipIds = alwaysKnownShipIds;
    }

    public List<String> getPriorityShipIds() {
        return priorityShipIds;
    }

    public void setPriorityShipIds(List<String> priorityShipIds) {
        this.priorityShipIds = priorityShipIds;
    }

    public List<String> getKnownWeaponIds() {
        return knownWeaponIds;
    }

    public void setKnownWeaponIds(List<String> knownWeaponIds) {
        this.knownWeaponIds = knownWeaponIds;
    }

    public List<String> getPriorityWeaponIds() {
        return priorityWeaponIds;
    }

    public void setPriorityWeaponIds(List<String> priorityWeaponIds) {
        this.priorityWeaponIds = priorityWeaponIds;
    }

    public Map<String, Float> getWeaponSellFrequency() {
        return weaponSellFrequency;
    }

    public void setWeaponSellFrequency(Map<String, Float> weaponSellFrequency) {
        this.weaponSellFrequency = weaponSellFrequency;
    }

    public List<String> getKnownFighterIds() {
        return knownFighterIds;
    }

    public void setKnownFighterIds(List<String> knownFighterIds) {
        this.knownFighterIds = knownFighterIds;
    }

    public List<String> getPriorityFighterIds() {
        return priorityFighterIds;
    }

    public void setPriorityFighterIds(List<String> priorityFighterIds) {
        this.priorityFighterIds = priorityFighterIds;
    }

    public Map<String, Float> getFighterSellFrequency() {
        return fighterSellFrequency;
    }

    public void setFighterSellFrequency(Map<String, Float> fighterSellFrequency) {
        this.fighterSellFrequency = fighterSellFrequency;
    }

    public List<String> getKnownIndustryIds() {
        return knownIndustryIds;
    }

    public void setKnownIndustryIds(List<String> knownIndustryIds) {
        this.knownIndustryIds = knownIndustryIds;
    }

    public List<String> getKnownHullModIds() {
        return knownHullModIds;
    }

    public void setKnownHullModIds(List<String> knownHullModIds) {
        this.knownHullModIds = knownHullModIds;
    }

    public List<String> getPriorityHullModIds() {
        return priorityHullModIds;
    }

    public void setPriorityHullModIds(List<String> priorityHullModIds) {
        this.priorityHullModIds = priorityHullModIds;
    }

    public Map<String, Float> getHullModSellFrequency() {
        return hullModSellFrequency;
    }

    public void setHullModSellFrequency(Map<String, Float> hullModSellFrequency) {
        this.hullModSellFrequency = hullModSellFrequency;
    }

    public double getTariffFraction() {
        return tariffFraction;
    }

    public void setTariffFraction(double tariffFraction) {
        this.tariffFraction = tariffFraction;
    }

    public double getTollFraction() {
        return tollFraction;
    }

    public void setTollFraction(double tollFraction) {
        this.tollFraction = tollFraction;
    }

    public double getFineFraction() {
        return fineFraction;
    }

    public void setFineFraction(double fineFraction) {
        this.fineFraction = fineFraction;
    }

    public boolean isPlayerFaction() {
        return playerFaction;
    }

    public void setPlayerFaction(boolean playerFaction) {
        this.playerFaction = playerFaction;
    }

    public boolean isShowInIntelTab() {
        return showInIntelTab;
    }

    public void setShowInIntelTab(boolean showInIntelTab) {
        this.showInIntelTab = showInIntelTab;
    }

    public boolean isNeutralFaction() {
        return neutralFaction;
    }

    public void setNeutralFaction(boolean neutralFaction) {
        this.neutralFaction = neutralFaction;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
