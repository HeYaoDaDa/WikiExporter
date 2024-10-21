package exporter.model;

import java.util.Set;

public class ShipMod {
    private String id;
    private String jsonType;
    private String name;
    private String description;
    private String icon;

    private boolean isHaveSModEffect;
    private boolean isAlwaysUnlocked;
    private boolean isHidden;
    private boolean isHiddenEverywhere;

    private int frigateCost;
    private int destroyerCost;
    private int cruiserCost;
    private int capitalCost;

    private String frigateDescription;
    private String destroyerDescription;
    private String cruiserDescription;
    private String capitalDescription;

    private String frigateSDescription;
    private String destroyerSDescription;
    private String cruiserSDescription;
    private String capitalSDescription;

    private Set<String> tags;
    private Set<String> uiTags;


    public boolean isAlwaysUnlocked() {
        return isAlwaysUnlocked;
    }

    public void setAlwaysUnlocked(boolean alwaysUnlocked) {
        isAlwaysUnlocked = alwaysUnlocked;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        isHidden = hidden;
    }

    public boolean isHiddenEverywhere() {
        return isHiddenEverywhere;
    }

    public void setHiddenEverywhere(boolean hiddenEverywhere) {
        isHiddenEverywhere = hiddenEverywhere;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isHaveSModEffect() {
        return isHaveSModEffect;
    }

    public void setHaveSModEffect(boolean haveSModEffect) {
        isHaveSModEffect = haveSModEffect;
    }

    public int getFrigateCost() {
        return frigateCost;
    }

    public void setFrigateCost(int frigateCost) {
        this.frigateCost = frigateCost;
    }

    public int getDestroyerCost() {
        return destroyerCost;
    }

    public void setDestroyerCost(int destroyerCost) {
        this.destroyerCost = destroyerCost;
    }

    public int getCruiserCost() {
        return cruiserCost;
    }

    public void setCruiserCost(int cruiserCost) {
        this.cruiserCost = cruiserCost;
    }

    public int getCapitalCost() {
        return capitalCost;
    }

    public void setCapitalCost(int capitalCost) {
        this.capitalCost = capitalCost;
    }

    public String getFrigateDescription() {
        return frigateDescription;
    }

    public void setFrigateDescription(String frigateDescription) {
        this.frigateDescription = frigateDescription;
    }

    public String getDestroyerDescription() {
        return destroyerDescription;
    }

    public void setDestroyerDescription(String destroyerDescription) {
        this.destroyerDescription = destroyerDescription;
    }

    public String getCruiserDescription() {
        return cruiserDescription;
    }

    public void setCruiserDescription(String cruiserDescription) {
        this.cruiserDescription = cruiserDescription;
    }

    public String getCapitalDescription() {
        return capitalDescription;
    }

    public void setCapitalDescription(String capitalDescription) {
        this.capitalDescription = capitalDescription;
    }

    public String getFrigateSDescription() {
        return frigateSDescription;
    }

    public void setFrigateSDescription(String frigateSDescription) {
        this.frigateSDescription = frigateSDescription;
    }

    public String getDestroyerSDescription() {
        return destroyerSDescription;
    }

    public void setDestroyerSDescription(String destroyerSDescription) {
        this.destroyerSDescription = destroyerSDescription;
    }

    public String getCruiserSDescription() {
        return cruiserSDescription;
    }

    public void setCruiserSDescription(String cruiserSDescription) {
        this.cruiserSDescription = cruiserSDescription;
    }

    public String getCapitalSDescription() {
        return capitalSDescription;
    }

    public void setCapitalSDescription(String capitalSDescription) {
        this.capitalSDescription = capitalSDescription;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Set<String> getUiTags() {
        return uiTags;
    }

    public void setUiTags(Set<String> uiTags) {
        this.uiTags = uiTags;
    }
}
