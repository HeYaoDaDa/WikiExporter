package exporter.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShipVariant {
    private String id;
    private String name;
    private String hullId;

    private int numFluxCapacitors;
    private int numFluxVents;

    private List<String> permanentMods;
    private List<String> sMods;
    private List<String> nonBuiltInMods;

    private Map<String, String> weaponIdMap;

    private List<String> builtInWingIds;
    private List<String> nonBuiltInWingIds;

    private Map<String, String> moduleIdMap;

    private boolean goalVariant;
    private boolean fighter;
    private boolean station;
    private boolean civilian;
    private boolean combat;
    private boolean mayAutoAssignWeapons;

    private Set<String> hints;
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

    public String getHullId() {
        return hullId;
    }

    public void setHullId(String hullId) {
        this.hullId = hullId;
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

    public List<String> getPermanentMods() {
        return permanentMods;
    }

    public void setPermanentMods(List<String> permanentMods) {
        this.permanentMods = permanentMods;
    }

    public List<String> getsMods() {
        return sMods;
    }

    public void setsMods(List<String> sMods) {
        this.sMods = sMods;
    }

    public List<String> getNonBuiltInMods() {
        return nonBuiltInMods;
    }

    public void setNonBuiltInMods(List<String> nonBuiltInMods) {
        this.nonBuiltInMods = nonBuiltInMods;
    }

    public Map<String, String> getWeaponIdMap() {
        return weaponIdMap;
    }

    public void setWeaponIdMap(Map<String, String> weaponIdMap) {
        this.weaponIdMap = weaponIdMap;
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

    public boolean isMayAutoAssignWeapons() {
        return mayAutoAssignWeapons;
    }

    public void setMayAutoAssignWeapons(boolean mayAutoAssignWeapons) {
        this.mayAutoAssignWeapons = mayAutoAssignWeapons;
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
}
