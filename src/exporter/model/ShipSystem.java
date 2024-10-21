package exporter.model;

import java.util.Set;

public class ShipSystem {
    private String id;
    private String jsonType;
    private String name;
    private String description;
    private String shortDescription;
    private String icon;
    private Float fluxPerSecond;
    private Float fluxPerSecondBaseRate;
    private Float fluxPerSecondBaseCap;
    private Float fluxPerUse;
    private Float fluxPerUseBaseRate;
    private Float fluxPerUseBaseCap;
    private Float crPerUse;
    private Integer maxUses;
    private Float regen;
    private Float chargeUp;
    private Float active;
    private Float down;
    private Float cooldown;
    private Boolean toggle;
    private Boolean noDissipation;
    private Boolean noHardDissipation;
    private Boolean hardFlux;
    private Boolean noFiring;
    private Boolean noTurning;
    private Boolean noStrafing;
    private Boolean noAccel;
    private Boolean noShield;
    private Boolean noVent;
    private Boolean isPhaseCloak;
    private Set<String> tags;


    public Float getFluxPerSecond() {
        return fluxPerSecond;
    }

    public void setFluxPerSecond(Float fluxPerSecond) {
        this.fluxPerSecond = fluxPerSecond;
    }

    public Float getFluxPerSecondBaseRate() {
        return fluxPerSecondBaseRate;
    }

    public void setFluxPerSecondBaseRate(Float fluxPerSecondBaseRate) {
        this.fluxPerSecondBaseRate = fluxPerSecondBaseRate;
    }

    public Float getFluxPerSecondBaseCap() {
        return fluxPerSecondBaseCap;
    }

    public void setFluxPerSecondBaseCap(Float fluxPerSecondBaseCap) {
        this.fluxPerSecondBaseCap = fluxPerSecondBaseCap;
    }

    public Float getFluxPerUse() {
        return fluxPerUse;
    }

    public void setFluxPerUse(Float fluxPerUse) {
        this.fluxPerUse = fluxPerUse;
    }

    public Float getFluxPerUseBaseRate() {
        return fluxPerUseBaseRate;
    }

    public void setFluxPerUseBaseRate(Float fluxPerUseBaseRate) {
        this.fluxPerUseBaseRate = fluxPerUseBaseRate;
    }

    public Float getFluxPerUseBaseCap() {
        return fluxPerUseBaseCap;
    }

    public void setFluxPerUseBaseCap(Float fluxPerUseBaseCap) {
        this.fluxPerUseBaseCap = fluxPerUseBaseCap;
    }

    public Float getCrPerUse() {
        return crPerUse;
    }

    public void setCrPerUse(Float crPerUse) {
        this.crPerUse = crPerUse;
    }

    public Integer getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(Integer maxUses) {
        this.maxUses = maxUses;
    }

    public Float getRegen() {
        return regen;
    }

    public void setRegen(Float regen) {
        this.regen = regen;
    }

    public Float getChargeUp() {
        return chargeUp;
    }

    public void setChargeUp(Float chargeUp) {
        this.chargeUp = chargeUp;
    }

    public Float getActive() {
        return active;
    }

    public void setActive(Float active) {
        this.active = active;
    }

    public Float getDown() {
        return down;
    }

    public void setDown(Float down) {
        this.down = down;
    }

    public Float getCooldown() {
        return cooldown;
    }

    public void setCooldown(Float cooldown) {
        this.cooldown = cooldown;
    }

    public Boolean getToggle() {
        return toggle;
    }

    public void setToggle(Boolean toggle) {
        this.toggle = toggle;
    }

    public Boolean getNoDissipation() {
        return noDissipation;
    }

    public void setNoDissipation(Boolean noDissipation) {
        this.noDissipation = noDissipation;
    }

    public Boolean getNoHardDissipation() {
        return noHardDissipation;
    }

    public void setNoHardDissipation(Boolean noHardDissipation) {
        this.noHardDissipation = noHardDissipation;
    }

    public Boolean getHardFlux() {
        return hardFlux;
    }

    public void setHardFlux(Boolean hardFlux) {
        this.hardFlux = hardFlux;
    }

    public Boolean getNoFiring() {
        return noFiring;
    }

    public void setNoFiring(Boolean noFiring) {
        this.noFiring = noFiring;
    }

    public Boolean getNoTurning() {
        return noTurning;
    }

    public void setNoTurning(Boolean noTurning) {
        this.noTurning = noTurning;
    }

    public Boolean getNoStrafing() {
        return noStrafing;
    }

    public void setNoStrafing(Boolean noStrafing) {
        this.noStrafing = noStrafing;
    }

    public Boolean getNoAccel() {
        return noAccel;
    }

    public void setNoAccel(Boolean noAccel) {
        this.noAccel = noAccel;
    }

    public Boolean getNoShield() {
        return noShield;
    }

    public void setNoShield(Boolean noShield) {
        this.noShield = noShield;
    }

    public Boolean getNoVent() {
        return noVent;
    }

    public void setNoVent(Boolean noVent) {
        this.noVent = noVent;
    }

    public Boolean getPhaseCloak() {
        return isPhaseCloak;
    }

    public void setPhaseCloak(Boolean phaseCloak) {
        isPhaseCloak = phaseCloak;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
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
}
