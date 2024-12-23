package exporter.model;

import org.lwjgl.util.vector.Vector2f;

import java.util.List;

public class Planet {
    private String id;
    private String jsonType;
    private String name;
    private double radius;
    private String factionId;
    private String customDescription;
    private List<String> tags;
    private String orbitFocusId;
    private String starSystemId;

    // PlanetSpecApi
    private String typeId;
    private String overrideDesc;

    private Market market;
    private Vector2f location;
    private Vector2f locationInHyperspace;

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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getFactionId() {
        return factionId;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    public String getCustomDescription() {
        return customDescription;
    }

    public void setCustomDescription(String customDescription) {
        this.customDescription = customDescription;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getOrbitFocusId() {
        return orbitFocusId;
    }

    public void setOrbitFocusId(String orbitFocusId) {
        this.orbitFocusId = orbitFocusId;
    }

    public String getStarSystemId() {
        return starSystemId;
    }

    public void setStarSystemId(String starSystemId) {
        this.starSystemId = starSystemId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getOverrideDesc() {
        return overrideDesc;
    }

    public void setOverrideDesc(String overrideDesc) {
        this.overrideDesc = overrideDesc;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public Vector2f getLocationInHyperspace() {
        return locationInHyperspace;
    }

    public void setLocationInHyperspace(Vector2f locationInHyperspace) {
        this.locationInHyperspace = locationInHyperspace;
    }
}
