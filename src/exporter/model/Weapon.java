package exporter.model;

import com.fs.starfarer.api.combat.DamageType;

import java.util.List;
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
    private String turretUnderSprite;
    private String turretGunSprite;
    private String turretGlowSprite;
    //    固定槽位贴图
    private String hardPointSprite;
    private String hardPointUnderSprite;
    private String hardPointGunSprite;
    private String hardPointGlowSprite;
    //    渲染用标签
    private List<String> renderHints;
    //    导弹位置
    private List<Integer> turretOffsets;
    private List<Integer> hardPointOffsets;
    private String projSpriteName;

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
    //    导弹飞行速度
    private String speedStr;
    //    导弹追踪性能
    private String trackingStr;
    //    武器精准度
    private String accuracyStr;
    //    武器转向速度
    private String turnRateStr;
    //    最大充能数/最大备弹数
    private Integer maxAmmo;
    //    充能时间/装弹时间
    private Integer reloadTime;
    //    每次充能数/每次装弹数
    private int reloadSize;
    //    武器开火间隔
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

    public String getTurretUnderSprite() {
        return turretUnderSprite;
    }

    public void setTurretUnderSprite(String turretUnderSprite) {
        this.turretUnderSprite = turretUnderSprite;
    }

    public String getTurretGunSprite() {
        return turretGunSprite;
    }

    public void setTurretGunSprite(String turretGunSprite) {
        this.turretGunSprite = turretGunSprite;
    }

    public String getTurretGlowSprite() {
        return turretGlowSprite;
    }

    public void setTurretGlowSprite(String turretGlowSprite) {
        this.turretGlowSprite = turretGlowSprite;
    }

    public String getHardPointSprite() {
        return hardPointSprite;
    }

    public void setHardPointSprite(String hardPointSprite) {
        this.hardPointSprite = hardPointSprite;
    }

    public String getHardPointUnderSprite() {
        return hardPointUnderSprite;
    }

    public void setHardPointUnderSprite(String hardPointUnderSprite) {
        this.hardPointUnderSprite = hardPointUnderSprite;
    }

    public String getHardPointGunSprite() {
        return hardPointGunSprite;
    }

    public void setHardPointGunSprite(String hardPointGunSprite) {
        this.hardPointGunSprite = hardPointGunSprite;
    }

    public String getHardPointGlowSprite() {
        return hardPointGlowSprite;
    }

    public void setHardPointGlowSprite(String hardPointGlowSprite) {
        this.hardPointGlowSprite = hardPointGlowSprite;
    }

    public List<String> getRenderHints() {
        return renderHints;
    }

    public void setRenderHints(List<String> renderHints) {
        this.renderHints = renderHints;
    }

    public List<Integer> getTurretOffsets() {
        return turretOffsets;
    }

    public void setTurretOffsets(List<Integer> turretOffsets) {
        this.turretOffsets = turretOffsets;
    }

    public List<Integer> getHardPointOffsets() {
        return hardPointOffsets;
    }

    public void setHardPointOffsets(List<Integer> hardPointOffsets) {
        this.hardPointOffsets = hardPointOffsets;
    }

    public String getProjSpriteName() {
        return projSpriteName;
    }

    public void setProjSpriteName(String projSpriteName) {
        this.projSpriteName = projSpriteName;
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

    public String getSpeedStr() {
        return speedStr;
    }

    public void setSpeedStr(String speedStr) {
        this.speedStr = speedStr;
    }

    public String getTrackingStr() {
        return trackingStr;
    }

    public void setTrackingStr(String trackingStr) {
        this.trackingStr = trackingStr;
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

    public Integer getMaxAmmo() {
        return maxAmmo;
    }

    public void setMaxAmmo(Integer maxAmmo) {
        this.maxAmmo = maxAmmo;
    }

    public Integer getReloadTime() {
        return reloadTime;
    }

    public void setReloadTime(Integer reloadTime) {
        this.reloadTime = reloadTime;
    }

    public int getReloadSize() {
        return reloadSize;
    }

    public void setReloadSize(int reloadSize) {
        this.reloadSize = reloadSize;
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
