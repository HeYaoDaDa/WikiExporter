package exporter.model;

public class MarketCondition {
    private String id;
    private String jsonType;
    private String name;
    private String desc;
    private String icon;
    private String scriptClass;
    private float order;
    private boolean planetary;
    private boolean decivRemove;

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

    public float getOrder() {
        return order;
    }

    public void setOrder(float order) {
        this.order = order;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getScriptClass() {
        return scriptClass;
    }

    public void setScriptClass(String scriptClass) {
        this.scriptClass = scriptClass;
    }

    public boolean isPlanetary() {
        return planetary;
    }

    public void setPlanetary(boolean planetary) {
        this.planetary = planetary;
    }

    public boolean isDecivRemove() {
        return decivRemove;
    }

    public void setDecivRemove(boolean decivRemove) {
        this.decivRemove = decivRemove;
    }
}
