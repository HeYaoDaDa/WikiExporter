package exporter.model;

import com.fs.starfarer.api.combat.DamageType;

import java.util.Set;

public class Weapon {
    private String id;
    private String name;
    private String description;
    private String customPrimary;
    private String turretSprite;
    private String hardPointSprite;

    private String primaryRoleStr;
    private String size;
    private String mountType;
    private double ordnancePoint;

    private double maxRange;
    private double damagePerShot;
    private double damagePerSecond;
    private double empPerShot;
    private double empPerSecond;

    private double fluxPerSecond;
    private double sustainedFluxPerSecond;
    private double dps;
    private double sustainedDps;
    private double fluxPerDamage;

    private String customAncillary;
    private DamageType damageType;
    private boolean isSoftFlux;
    private String accuracyStr;
    private double turnRate;
    private double reFireDelay;

    private Set<String> tags;

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

    public String getCustomPrimary() {
        return customPrimary;
    }

    public void setCustomPrimary(String customPrimary) {
        this.customPrimary = customPrimary;
    }

    public String getTurretSprite() {
        return turretSprite;
    }

    public void setTurretSprite(String turretSprite) {
        this.turretSprite = turretSprite;
    }

    public String getHardPointSprite() {
        return hardPointSprite;
    }

    public void setHardPointSprite(String hardPointSprite) {
        this.hardPointSprite = hardPointSprite;
    }

    public String getPrimaryRoleStr() {
        return primaryRoleStr;
    }

    public void setPrimaryRoleStr(String primaryRoleStr) {
        this.primaryRoleStr = primaryRoleStr;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMountType() {
        return mountType;
    }

    public void setMountType(String mountType) {
        this.mountType = mountType;
    }

    public double getOrdnancePoint() {
        return ordnancePoint;
    }

    public void setOrdnancePoint(double ordnancePoint) {
        this.ordnancePoint = ordnancePoint;
    }

    public double getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    public double getDamagePerShot() {
        return damagePerShot;
    }

    public void setDamagePerShot(double damagePerShot) {
        this.damagePerShot = damagePerShot;
    }

    public double getDamagePerSecond() {
        return damagePerSecond;
    }

    public void setDamagePerSecond(double damagePerSecond) {
        this.damagePerSecond = damagePerSecond;
    }

    public double getEmpPerShot() {
        return empPerShot;
    }

    public void setEmpPerShot(double empPerShot) {
        this.empPerShot = empPerShot;
    }

    public double getEmpPerSecond() {
        return empPerSecond;
    }

    public void setEmpPerSecond(double empPerSecond) {
        this.empPerSecond = empPerSecond;
    }

    public double getFluxPerSecond() {
        return fluxPerSecond;
    }

    public void setFluxPerSecond(double fluxPerSecond) {
        this.fluxPerSecond = fluxPerSecond;
    }

    public double getSustainedFluxPerSecond() {
        return sustainedFluxPerSecond;
    }

    public void setSustainedFluxPerSecond(double sustainedFluxPerSecond) {
        this.sustainedFluxPerSecond = sustainedFluxPerSecond;
    }

    public double getDps() {
        return dps;
    }

    public void setDps(double dps) {
        this.dps = dps;
    }

    public double getSustainedDps() {
        return sustainedDps;
    }

    public void setSustainedDps(double sustainedDps) {
        this.sustainedDps = sustainedDps;
    }

    public double getFluxPerDamage() {
        return fluxPerDamage;
    }

    public void setFluxPerDamage(double fluxPerDamage) {
        this.fluxPerDamage = fluxPerDamage;
    }

    public String getCustomAncillary() {
        return customAncillary;
    }

    public void setCustomAncillary(String customAncillary) {
        this.customAncillary = customAncillary;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public boolean isSoftFlux() {
        return isSoftFlux;
    }

    public void setSoftFlux(boolean softFlux) {
        isSoftFlux = softFlux;
    }

    public String getAccuracyStr() {
        return accuracyStr;
    }

    public void setAccuracyStr(String accuracyStr) {
        this.accuracyStr = accuracyStr;
    }

    public double getTurnRate() {
        return turnRate;
    }

    public void setTurnRate(double turnRate) {
        this.turnRate = turnRate;
    }

    public double getReFireDelay() {
        return reFireDelay;
    }

    public void setReFireDelay(double reFireDelay) {
        this.reFireDelay = reFireDelay;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}
