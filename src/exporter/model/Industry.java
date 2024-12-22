package exporter.model;

import java.util.List;

public class Industry {
    private String id;
    private String jsonType;
    private String pluginClass;
    private List<String> tags;
    private String name;
    private String desc;
    private float cost;
    private float buildTime;
    private float upkeep;
    private float income;
    private String imageName;
    private String upgrade;
    private String downgrade;
    private int order;
    private String data;
    private String disruptDanger;

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

    public String getPluginClass() {
        return pluginClass;
    }

    public void setPluginClass(String pluginClass) {
        this.pluginClass = pluginClass;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(float buildTime) {
        this.buildTime = buildTime;
    }

    public float getUpkeep() {
        return upkeep;
    }

    public void setUpkeep(float upkeep) {
        this.upkeep = upkeep;
    }

    public float getIncome() {
        return income;
    }

    public void setIncome(float income) {
        this.income = income;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(String upgrade) {
        this.upgrade = upgrade;
    }

    public String getDowngrade() {
        return downgrade;
    }

    public void setDowngrade(String downgrade) {
        this.downgrade = downgrade;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDisruptDanger() {
        return disruptDanger;
    }

    public void setDisruptDanger(String disruptDanger) {
        this.disruptDanger = disruptDanger;
    }
}
