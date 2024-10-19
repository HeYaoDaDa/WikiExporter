package exporter.model;

import com.fs.starfarer.api.combat.DamageType;

import java.util.Set;

public class Weapon {
    private String id;
    private String jsonType;
    private String name;
    private String description;
    //    原始数据部分下面的特别说明
    private String customPrimary;
    //    炮塔贴图
    private String turretSprite;
    //    固定槽位贴图
    private String hardPointSprite;

    //    战术应用
    private String primaryRoleStr;
    //    安装类型
    private String size;
    private String mountType;
    //    部署点
    private double ordnancePoint;

    //    武器射程
    private double maxRange;
    //    伤害
    private double damagePerShot;
    //    爆发数量
    private int burstSize;
    //    伤害/秒
    private double dps;
    //    持续伤害DPS
    private double sustainedDps;
    //    EMP伤害
    private double empPerShot;
    //    EMP伤害每秒
    private double empPerSecond;

    //    幅能每秒
    private double fluxPerSecond;
    //    持续幅能每秒
    private double sustainedFluxPerSecond;
    //    幅能/non-EMP伤害
    private double fluxPerDamage;

    private String customAncillary;
    private DamageType damageType;
    private String accuracyStr;
    private String turnRateStr;
    private double reFireDelay;

    private Set<String> tags;

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

    public int getBurstSize() {
        return burstSize;
    }

    public void setBurstSize(int burstSize) {
        this.burstSize = burstSize;
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

    public String getAccuracyStr() {
        return accuracyStr;
    }

    public void setAccuracyStr(String accuracyStr) {
        this.accuracyStr = accuracyStr;
    }

    public String getTurnRateStr() {
        return turnRateStr;
    }

    public void setTurnRateStr(String turnRateStr) {
        this.turnRateStr = turnRateStr;
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
