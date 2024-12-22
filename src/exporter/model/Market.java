package exporter.model;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.econ.MarketConditionAPI;
import com.fs.starfarer.api.campaign.econ.SubmarketAPI;
import com.fs.starfarer.api.characters.PersonAPI;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private String id;
    private String name;
    private String starSystemId;

    private int size;
    private int stability;
    private double tariff;
    private double hazard;

    private double shipQualityFactor;

    private List<String> marketConditionIds;
    private List<String> subMarketIds;
    private List<String> industryIds;

    private List<String> personIds;
    private String adminId;

    private boolean hidden;

    private List<String> tags;

    public Market(MarketAPI api) {
        this.id = api.getId();
        this.name = api.getName();
        this.starSystemId = api.getStarSystem().getId();

        this.size = api.getSize();
        this.stability = api.getStability().getModifiedInt();
        this.tariff = api.getTariff().getModifiedValue();
        this.hazard = api.getHazardValue();

        this.shipQualityFactor = api.getShipQualityFactor();

        this.marketConditionIds = new ArrayList<>();
        for (MarketConditionAPI condition : api.getConditions()) {
            this.marketConditionIds.add(condition.getId());
        }
        this.subMarketIds = new ArrayList<>();
        for (SubmarketAPI submarketAPI : api.getSubmarketsCopy()) {
            this.subMarketIds.add(submarketAPI.getSpecId());
        }
        this.industryIds = new ArrayList<>();
        for (Industry industry : api.getIndustries()) {
            this.industryIds.add(industry.getId());
        }

        this.personIds = new ArrayList<>();
        for (PersonAPI personAPI : api.getPeopleCopy()) {
            this.personIds.add(personAPI.getId());
        }
        this.adminId = api.getAdmin().getId();

        this.hidden = api.isHidden();
        this.tags = new ArrayList<>(api.getTags());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarSystemId() {
        return starSystemId;
    }

    public void setStarSystemId(String starSystemId) {
        this.starSystemId = starSystemId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStability() {
        return stability;
    }

    public void setStability(int stability) {
        this.stability = stability;
    }

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }

    public double getHazard() {
        return hazard;
    }

    public void setHazard(double hazard) {
        this.hazard = hazard;
    }

    public double getShipQualityFactor() {
        return shipQualityFactor;
    }

    public void setShipQualityFactor(double shipQualityFactor) {
        this.shipQualityFactor = shipQualityFactor;
    }

    public List<String> getMarketConditionIds() {
        return marketConditionIds;
    }

    public void setMarketConditionIds(List<String> marketConditionIds) {
        this.marketConditionIds = marketConditionIds;
    }

    public List<String> getSubMarketIds() {
        return subMarketIds;
    }

    public void setSubMarketIds(List<String> subMarketIds) {
        this.subMarketIds = subMarketIds;
    }

    public List<String> getIndustryIds() {
        return industryIds;
    }

    public void setIndustryIds(List<String> industryIds) {
        this.industryIds = industryIds;
    }

    public List<String> getPersonIds() {
        return personIds;
    }

    public void setPersonIds(List<String> personIds) {
        this.personIds = personIds;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
