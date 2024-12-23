package exporter.model;

import org.lwjgl.util.vector.Vector2f;

import java.util.List;

public class StarSystem {
    private String id;
    private String jsonType;
    private String name;
    private Vector2f location;
    private String type;

    private String constellationId;
    private List<String> planetIds;

    private String starId;
    private String secondaryId;
    private String tertiaryId;

    private boolean procgen;
    private List<String> tags;


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

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConstellationId() {
        return constellationId;
    }

    public void setConstellationId(String constellationId) {
        this.constellationId = constellationId;
    }

    public List<String> getPlanetIds() {
        return planetIds;
    }

    public void setPlanetIds(List<String> planetIds) {
        this.planetIds = planetIds;
    }

    public String getStarId() {
        return starId;
    }

    public void setStarId(String starId) {
        this.starId = starId;
    }

    public String getSecondaryId() {
        return secondaryId;
    }

    public void setSecondaryId(String secondaryId) {
        this.secondaryId = secondaryId;
    }

    public String getTertiaryId() {
        return tertiaryId;
    }

    public void setTertiaryId(String tertiaryId) {
        this.tertiaryId = tertiaryId;
    }

    public boolean isProcgen() {
        return procgen;
    }

    public void setProcgen(boolean procgen) {
        this.procgen = procgen;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
