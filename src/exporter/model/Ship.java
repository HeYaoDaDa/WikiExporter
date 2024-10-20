package exporter.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ship {
    //    Variant id
    private String id;
    private String jsonType;
    private boolean emptyHullVariant;
    private String name;
    private String variantName;
    private String designation;
    private String description;
    private String sprite;

    private String hullId;
    private String baseHullId;

    //    作战后消耗的战备值(CR)
    private double crToDeploy;
    //    战备值(CR)恢复速率(每天)
    private MutableStat repairPercentPerDay;
    //    部署成本(补给)
    private MutableStat suppliesToRecover;
    //    峰值时间(秒)
    private MutableStat noCRLossSeconds;
    //    船体大小
    private String size;
    //    部署点
    private int ordnancePoints;

    //    维护消耗(补给/月)
    private MutableStat suppliesPerMonth;
    //    载货量
    private MutableStat cargo;
    //    最大载员
    private MutableStat maxCrew;
    //    必要船员
    private MutableStat minCrew;
    //    燃料容量
    private MutableStat fuel;
    //    最大宇宙航速
    private MutableStat maxBurn;
    //    燃料消耗(光年)
    private MutableStat fuelPerLY;
    //    被侦察范围
    private MutableStat sensorProfile;
    //    探测范围
    private MutableStat sensorStrength;

    //    结构值
    private MutableStat hitPoints;
    //    装甲值
    private MutableStat armorRating;
    //    防御方式
    private String shieldType;
    //    护盾角度
    private MutableStat shieldArc;
    //    护盾维持(幅能/秒)
    private MutableStat shieldUpkeep;
    //    护盾效率(幅能/伤害)
    private MutableStat fluxPerDamageAbsorbed;
    //    相位线圈激活
    private MutableStat phaseCost;
    //    相位线圈维持(幅能/秒)
    private MutableStat phaseUpKeep;
    //    幅能容量
    private MutableStat fluxCapacity;
    //    幅能耗散
    private MutableStat fluxDissipation;
    //    最高航速
    private MutableStat maxSpeed;

    //    战术系统
    private String shipSystemId;
    private double systemFluxPerUse;
    private double systemFluxPerSecond;
    private double systemCrPerUse;
    private int systemMaxUses;
    private double systemRegen;
    private double systemCooldown;

    //    特殊系统
    private String shipDefenseId;
    private double defenseFluxPerUse;
    private double defenseFluxPerSecond;
    private double defenseCrPerUse;
    private int defenseMaxUses;
    private double defenseRegen;
    private double defenseCooldown;

    private List<WeaponSlot> allWeaponSlots;
    private Map<String, String> weaponIdMap;

    private List<String> builtInMods;
    private List<String> storyMods;
    private List<String> nonBuiltInMods;

    private int wings;
    private List<String> builtInWingIds;
    private List<String> nonBuiltInWingIds;

    private Map<String, String> moduleIdMap;

    //    幅能寄存器
    private int numFluxCapacitors;
    //    耗散通道
    private int numFluxVents;

    private boolean goalVariant;
    private boolean fighter;
    private boolean station;
    private boolean civilian;
    private boolean combat;
    //    自动分
    private int fleetPoints;
    //    基础价值
    private double baseValue;

    private Set<String> hints;
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

    public boolean isEmptyHullVariant() {
        return emptyHullVariant;
    }

    public void setEmptyHullVariant(boolean emptyHullVariant) {
        this.emptyHullVariant = emptyHullVariant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getHullId() {
        return hullId;
    }

    public void setHullId(String hullId) {
        this.hullId = hullId;
    }

    public String getBaseHullId() {
        return baseHullId;
    }

    public void setBaseHullId(String baseHullId) {
        this.baseHullId = baseHullId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getCrToDeploy() {
        return crToDeploy;
    }

    public void setCrToDeploy(double crToDeploy) {
        this.crToDeploy = crToDeploy;
    }

    public MutableStat getRepairPercentPerDay() {
        return repairPercentPerDay;
    }

    public void setRepairPercentPerDay(MutableStat repairPercentPerDay) {
        this.repairPercentPerDay = repairPercentPerDay;
    }

    public MutableStat getSuppliesToRecover() {
        return suppliesToRecover;
    }

    public void setSuppliesToRecover(MutableStat suppliesToRecover) {
        this.suppliesToRecover = suppliesToRecover;
    }

    public MutableStat getNoCRLossSeconds() {
        return noCRLossSeconds;
    }

    public void setNoCRLossSeconds(MutableStat noCRLossSeconds) {
        this.noCRLossSeconds = noCRLossSeconds;
    }

    public int getOrdnancePoints() {
        return ordnancePoints;
    }

    public void setOrdnancePoints(int ordnancePoints) {
        this.ordnancePoints = ordnancePoints;
    }

    public MutableStat getSuppliesPerMonth() {
        return suppliesPerMonth;
    }

    public void setSuppliesPerMonth(MutableStat suppliesPerMonth) {
        this.suppliesPerMonth = suppliesPerMonth;
    }

    public MutableStat getCargo() {
        return cargo;
    }

    public void setCargo(MutableStat cargo) {
        this.cargo = cargo;
    }

    public MutableStat getMaxCrew() {
        return maxCrew;
    }

    public void setMaxCrew(MutableStat maxCrew) {
        this.maxCrew = maxCrew;
    }

    public MutableStat getMinCrew() {
        return minCrew;
    }

    public void setMinCrew(MutableStat minCrew) {
        this.minCrew = minCrew;
    }

    public MutableStat getFuel() {
        return fuel;
    }

    public void setFuel(MutableStat fuel) {
        this.fuel = fuel;
    }

    public MutableStat getMaxBurn() {
        return maxBurn;
    }

    public void setMaxBurn(MutableStat maxBurn) {
        this.maxBurn = maxBurn;
    }

    public MutableStat getFuelPerLY() {
        return fuelPerLY;
    }

    public void setFuelPerLY(MutableStat fuelPerLY) {
        this.fuelPerLY = fuelPerLY;
    }

    public MutableStat getSensorProfile() {
        return sensorProfile;
    }

    public void setSensorProfile(MutableStat sensorProfile) {
        this.sensorProfile = sensorProfile;
    }

    public MutableStat getSensorStrength() {
        return sensorStrength;
    }

    public void setSensorStrength(MutableStat sensorStrength) {
        this.sensorStrength = sensorStrength;
    }

    public MutableStat getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(MutableStat hitPoints) {
        this.hitPoints = hitPoints;
    }

    public MutableStat getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(MutableStat armorRating) {
        this.armorRating = armorRating;
    }

    public String getShieldType() {
        return shieldType;
    }

    public void setShieldType(String shieldType) {
        this.shieldType = shieldType;
    }

    public MutableStat getShieldArc() {
        return shieldArc;
    }

    public void setShieldArc(MutableStat shieldArc) {
        this.shieldArc = shieldArc;
    }

    public MutableStat getShieldUpkeep() {
        return shieldUpkeep;
    }

    public void setShieldUpkeep(MutableStat shieldUpkeep) {
        this.shieldUpkeep = shieldUpkeep;
    }

    public MutableStat getFluxPerDamageAbsorbed() {
        return fluxPerDamageAbsorbed;
    }

    public void setFluxPerDamageAbsorbed(MutableStat fluxPerDamageAbsorbed) {
        this.fluxPerDamageAbsorbed = fluxPerDamageAbsorbed;
    }

    public MutableStat getPhaseCost() {
        return phaseCost;
    }

    public void setPhaseCost(MutableStat phaseCost) {
        this.phaseCost = phaseCost;
    }

    public MutableStat getPhaseUpKeep() {
        return phaseUpKeep;
    }

    public void setPhaseUpKeep(MutableStat phaseUpKeep) {
        this.phaseUpKeep = phaseUpKeep;
    }

    public MutableStat getFluxCapacity() {
        return fluxCapacity;
    }

    public void setFluxCapacity(MutableStat fluxCapacity) {
        this.fluxCapacity = fluxCapacity;
    }

    public MutableStat getFluxDissipation() {
        return fluxDissipation;
    }

    public void setFluxDissipation(MutableStat fluxDissipation) {
        this.fluxDissipation = fluxDissipation;
    }

    public MutableStat getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(MutableStat maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getShipSystemId() {
        return shipSystemId;
    }

    public void setShipSystemId(String shipSystemId) {
        this.shipSystemId = shipSystemId;
    }

    public String getShipDefenseId() {
        return shipDefenseId;
    }

    public void setShipDefenseId(String shipDefenseId) {
        this.shipDefenseId = shipDefenseId;
    }

    public List<WeaponSlot> getAllWeaponSlots() {
        return allWeaponSlots;
    }

    public void setAllWeaponSlots(List<WeaponSlot> allWeaponSlots) {
        this.allWeaponSlots = allWeaponSlots;
    }

    public Map<String, String> getWeaponIdMap() {
        return weaponIdMap;
    }

    public void setWeaponIdMap(Map<String, String> weaponIdMap) {
        this.weaponIdMap = weaponIdMap;
    }

    public List<String> getBuiltInMods() {
        return builtInMods;
    }

    public void setBuiltInMods(List<String> builtInMods) {
        this.builtInMods = builtInMods;
    }

    public List<String> getStoryMods() {
        return storyMods;
    }

    public void setStoryMods(List<String> storyMods) {
        this.storyMods = storyMods;
    }

    public List<String> getNonBuiltInMods() {
        return nonBuiltInMods;
    }

    public void setNonBuiltInMods(List<String> nonBuiltInMods) {
        this.nonBuiltInMods = nonBuiltInMods;
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    public List<String> getBuiltInWingIds() {
        return builtInWingIds;
    }

    public void setBuiltInWingIds(List<String> builtInWingIds) {
        this.builtInWingIds = builtInWingIds;
    }

    public List<String> getNonBuiltInWingIds() {
        return nonBuiltInWingIds;
    }

    public void setNonBuiltInWingIds(List<String> nonBuiltInWingIds) {
        this.nonBuiltInWingIds = nonBuiltInWingIds;
    }

    public Map<String, String> getModuleIdMap() {
        return moduleIdMap;
    }

    public void setModuleIdMap(Map<String, String> moduleIdMap) {
        this.moduleIdMap = moduleIdMap;
    }

    public int getNumFluxCapacitors() {
        return numFluxCapacitors;
    }

    public void setNumFluxCapacitors(int numFluxCapacitors) {
        this.numFluxCapacitors = numFluxCapacitors;
    }

    public int getNumFluxVents() {
        return numFluxVents;
    }

    public void setNumFluxVents(int numFluxVents) {
        this.numFluxVents = numFluxVents;
    }

    public boolean isGoalVariant() {
        return goalVariant;
    }

    public void setGoalVariant(boolean goalVariant) {
        this.goalVariant = goalVariant;
    }

    public boolean isFighter() {
        return fighter;
    }

    public void setFighter(boolean fighter) {
        this.fighter = fighter;
    }

    public boolean isStation() {
        return station;
    }

    public void setStation(boolean station) {
        this.station = station;
    }

    public boolean isCivilian() {
        return civilian;
    }

    public void setCivilian(boolean civilian) {
        this.civilian = civilian;
    }

    public boolean isCombat() {
        return combat;
    }

    public void setCombat(boolean combat) {
        this.combat = combat;
    }

    public int getFleetPoints() {
        return fleetPoints;
    }

    public void setFleetPoints(int fleetPoints) {
        this.fleetPoints = fleetPoints;
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public Set<String> getHints() {
        return hints;
    }

    public void setHints(Set<String> hints) {
        this.hints = hints;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public double getSystemFluxPerUse() {
        return systemFluxPerUse;
    }

    public void setSystemFluxPerUse(double systemFluxPerUse) {
        this.systemFluxPerUse = systemFluxPerUse;
    }

    public double getSystemFluxPerSecond() {
        return systemFluxPerSecond;
    }

    public void setSystemFluxPerSecond(double systemFluxPerSecond) {
        this.systemFluxPerSecond = systemFluxPerSecond;
    }

    public double getSystemCrPerUse() {
        return systemCrPerUse;
    }

    public void setSystemCrPerUse(double systemCrPerUse) {
        this.systemCrPerUse = systemCrPerUse;
    }

    public int getSystemMaxUses() {
        return systemMaxUses;
    }

    public void setSystemMaxUses(int systemMaxUses) {
        this.systemMaxUses = systemMaxUses;
    }

    public double getSystemRegen() {
        return systemRegen;
    }

    public void setSystemRegen(double systemRegen) {
        this.systemRegen = systemRegen;
    }

    public double getSystemCooldown() {
        return systemCooldown;
    }

    public void setSystemCooldown(double systemCooldown) {
        this.systemCooldown = systemCooldown;
    }

    public double getDefenseFluxPerUse() {
        return defenseFluxPerUse;
    }

    public void setDefenseFluxPerUse(double defenseFluxPerUse) {
        this.defenseFluxPerUse = defenseFluxPerUse;
    }

    public double getDefenseFluxPerSecond() {
        return defenseFluxPerSecond;
    }

    public void setDefenseFluxPerSecond(double defenseFluxPerSecond) {
        this.defenseFluxPerSecond = defenseFluxPerSecond;
    }

    public double getDefenseCrPerUse() {
        return defenseCrPerUse;
    }

    public void setDefenseCrPerUse(double defenseCrPerUse) {
        this.defenseCrPerUse = defenseCrPerUse;
    }

    public int getDefenseMaxUses() {
        return defenseMaxUses;
    }

    public void setDefenseMaxUses(int defenseMaxUses) {
        this.defenseMaxUses = defenseMaxUses;
    }

    public double getDefenseRegen() {
        return defenseRegen;
    }

    public void setDefenseRegen(double defenseRegen) {
        this.defenseRegen = defenseRegen;
    }

    public double getDefenseCooldown() {
        return defenseCooldown;
    }

    public void setDefenseCooldown(double defenseCooldown) {
        this.defenseCooldown = defenseCooldown;
    }
}
