package exporter.model;

import com.fs.starfarer.api.loading.WeaponSlotAPI;

import java.util.HashMap;
import java.util.List;

public class Ship {
    private String id;
    private String name;
    private String designation;
    private String descriptionPrefix;
    private String descriptionContent;
    private String sprite;

    private String baseHullId;
    private String size;
    private double crToDeploy;
    private double repairPercentPerDay;
    private double suppliesToRecover;
    private double noCRLossSeconds;
    private int ordnancePoints;

    private double suppliesPerMonth;
    private double cargo;
    private double maxCrew;
    private double minCrew;
    private double fuel;
    private double maxBurn;
    private double fuelPerLY;

    private double hitPoints;
    private double armorRating;
    private String shieldType;
    private double shieldRadius;
    private double shieldCost;
    private boolean phased;
    private double fluxCapacity;
    private double fluxDissipation;
    private double maxSpeed;

    private String shipSystemId;
    private String shipDefenseId;

    private List<String> builtInMods;
    private HashMap<String, String> builtInWeapons;
    private List<WeaponSlot> allWeaponSlots;

    private int fleetPoints;
    private double baseValue;

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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescriptionPrefix() {
        return descriptionPrefix;
    }

    public void setDescriptionPrefix(String descriptionPrefix) {
        this.descriptionPrefix = descriptionPrefix;
    }

    public String getDescriptionContent() {
        return descriptionContent;
    }

    public void setDescriptionContent(String descriptionContent) {
        this.descriptionContent = descriptionContent;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
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

    public double getRepairPercentPerDay() {
        return repairPercentPerDay;
    }

    public void setRepairPercentPerDay(double repairPercentPerDay) {
        this.repairPercentPerDay = repairPercentPerDay;
    }

    public double getSuppliesToRecover() {
        return suppliesToRecover;
    }

    public void setSuppliesToRecover(double suppliesToRecover) {
        this.suppliesToRecover = suppliesToRecover;
    }

    public double getNoCRLossSeconds() {
        return noCRLossSeconds;
    }

    public void setNoCRLossSeconds(double noCRLossSeconds) {
        this.noCRLossSeconds = noCRLossSeconds;
    }

    public int getOrdnancePoints() {
        return ordnancePoints;
    }

    public void setOrdnancePoints(int ordnancePoints) {
        this.ordnancePoints = ordnancePoints;
    }

    public double getSuppliesPerMonth() {
        return suppliesPerMonth;
    }

    public void setSuppliesPerMonth(double suppliesPerMonth) {
        this.suppliesPerMonth = suppliesPerMonth;
    }

    public double getCargo() {
        return cargo;
    }

    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    public double getMaxCrew() {
        return maxCrew;
    }

    public void setMaxCrew(double maxCrew) {
        this.maxCrew = maxCrew;
    }

    public double getMinCrew() {
        return minCrew;
    }

    public void setMinCrew(double minCrew) {
        this.minCrew = minCrew;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getMaxBurn() {
        return maxBurn;
    }

    public void setMaxBurn(double maxBurn) {
        this.maxBurn = maxBurn;
    }

    public double getFuelPerLY() {
        return fuelPerLY;
    }

    public void setFuelPerLY(double fuelPerLY) {
        this.fuelPerLY = fuelPerLY;
    }

    public double getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(double hitPoints) {
        this.hitPoints = hitPoints;
    }

    public double getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(double armorRating) {
        this.armorRating = armorRating;
    }

    public String getShieldType() {
        return shieldType;
    }

    public void setShieldType(String shieldType) {
        this.shieldType = shieldType;
    }

    public double getShieldRadius() {
        return shieldRadius;
    }

    public void setShieldRadius(double shieldRadius) {
        this.shieldRadius = shieldRadius;
    }

    public double getShieldCost() {
        return shieldCost;
    }

    public void setShieldCost(double shieldCost) {
        this.shieldCost = shieldCost;
    }

    public boolean isPhased() {
        return phased;
    }

    public void setPhased(boolean phased) {
        this.phased = phased;
    }

    public double getFluxCapacity() {
        return fluxCapacity;
    }

    public void setFluxCapacity(double fluxCapacity) {
        this.fluxCapacity = fluxCapacity;
    }

    public double getFluxDissipation() {
        return fluxDissipation;
    }

    public void setFluxDissipation(double fluxDissipation) {
        this.fluxDissipation = fluxDissipation;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
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

    public List<String> getBuiltInMods() {
        return builtInMods;
    }

    public void setBuiltInMods(List<String> builtInMods) {
        this.builtInMods = builtInMods;
    }

    public HashMap<String, String> getBuiltInWeapons() {
        return builtInWeapons;
    }

    public void setBuiltInWeapons(HashMap<String, String> builtInWeapons) {
        this.builtInWeapons = builtInWeapons;
    }

    public List<WeaponSlot> getAllWeaponSlots() {
        return allWeaponSlots;
    }

    public void setAllWeaponSlots(List<WeaponSlot> allWeaponSlots) {
        this.allWeaponSlots = allWeaponSlots;
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
}
