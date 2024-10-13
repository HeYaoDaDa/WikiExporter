package exporter.model;

public class ShipSystem {
    private String id;
    private String name;
    private String description;
    private String shortDescription;
    private String icon;

    private float fluxPerUse;
    private float fluxPerSecond;
    private float fluxPerSecondBaseRate;
    private float fluxPerSecondBaseCap;
    private float fluxPerUseBaseRate;
    private float fluxPerUseBaseCap;
    private float crPerUse;

    private int maxUses;
    private double regen;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getFluxPerUse() {
        return fluxPerUse;
    }

    public void setFluxPerUse(float fluxPerUse) {
        this.fluxPerUse = fluxPerUse;
    }

    public float getFluxPerSecond() {
        return fluxPerSecond;
    }

    public void setFluxPerSecond(float fluxPerSecond) {
        this.fluxPerSecond = fluxPerSecond;
    }

    public float getFluxPerSecondBaseRate() {
        return fluxPerSecondBaseRate;
    }

    public void setFluxPerSecondBaseRate(float fluxPerSecondBaseRate) {
        this.fluxPerSecondBaseRate = fluxPerSecondBaseRate;
    }

    public float getFluxPerSecondBaseCap() {
        return fluxPerSecondBaseCap;
    }

    public void setFluxPerSecondBaseCap(float fluxPerSecondBaseCap) {
        this.fluxPerSecondBaseCap = fluxPerSecondBaseCap;
    }

    public float getFluxPerUseBaseRate() {
        return fluxPerUseBaseRate;
    }

    public void setFluxPerUseBaseRate(float fluxPerUseBaseRate) {
        this.fluxPerUseBaseRate = fluxPerUseBaseRate;
    }

    public float getFluxPerUseBaseCap() {
        return fluxPerUseBaseCap;
    }

    public void setFluxPerUseBaseCap(float fluxPerUseBaseCap) {
        this.fluxPerUseBaseCap = fluxPerUseBaseCap;
    }

    public float getCrPerUse() {
        return crPerUse;
    }

    public void setCrPerUse(float crPerUse) {
        this.crPerUse = crPerUse;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(int maxUses) {
        this.maxUses = maxUses;
    }

    public double getRegen() {
        return regen;
    }

    public void setRegen(double regen) {
        this.regen = regen;
    }
}
