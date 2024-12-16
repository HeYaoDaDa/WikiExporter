package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.loading.Description;
import com.fs.starfarer.api.loading.WeaponSlotAPI;
import exporter.model.MutableStat;
import exporter.model.Ship;
import exporter.model.WeaponSlot;
import org.apache.log4j.Logger;
import org.lwjgl.util.vector.Vector2f;

import java.util.*;

public class ShipConverter {
    private static final Logger logger = Global.getLogger(ShipConverter.class);

    public Ship convert(ShipHullSpecAPI hullApi, ShipVariantAPI variantAPI) {
        if (hullApi.isDHull()) {
            return null;
        }

        SettingsAPI settings = Global.getSettings();
        CombatEngineAPI combatEngine = Global.getCombatEngine();

        PersonAPI personAPI = combatEngine.getPlayerShip().getCaptain();
        ShipAPI shipAPI;
        try {
            shipAPI = combatEngine.createFXDrone(variantAPI);
        } catch (Exception e) {
            logger.error(e.toString());
            return null;
        }
        MutableShipStatsAPI shipStatsAPI = shipAPI.getMutableStats();
        ShipSystemAPI system = shipAPI.getSystem();
        ShipSystemAPI defenseSystem = shipAPI.getPhaseCloak();

        Ship ship = new Ship();

        ship.setId(variantAPI.getHullVariantId());
        ship.setJsonType("SHIP");
        ship.setEmptyHullVariant(variantAPI.isEmptyHullVariant());
        ship.setName(hullApi.getHullName());
        ship.setVariantName(variantAPI.getDisplayName());
        ship.setDesignation(hullApi.getDesignation());
        String descriptionPrefix = hullApi.getDescriptionPrefix();
        StringBuilder stringBuilder = new StringBuilder();
        Description description = settings.getDescription(hullApi.getDescriptionId(), Description.Type.SHIP);
        if (descriptionPrefix != null && !descriptionPrefix.isEmpty()) {
            stringBuilder.append(descriptionPrefix);
            stringBuilder.append("\n\n");
        }
        if (description.hasText1()) {
            stringBuilder.append(description.getText1());
        }
        if (description.hasText2()) {
            stringBuilder.append("\n");
            stringBuilder.append(description.getText2());
        }
        if (description.hasText3()) {
            stringBuilder.append("\n");
            stringBuilder.append(description.getText3());
        }
        if (description.hasText4()) {
            stringBuilder.append("\n");
            stringBuilder.append(description.getText4());
        }
        ship.setDescription(stringBuilder.toString());
        ship.setSprite(hullApi.getSpriteName());
        ship.setCenter(new ShipCenter(shipAPI.getSpriteAPI().getCenterX(), shipAPI.getSpriteAPI().getCenterY()));
        if (hullApi.getModuleAnchor() != null) {
            ship.setModuleAnchor(new Vector2f(1 * hullApi.getModuleAnchor().y, 1 * hullApi.getModuleAnchor().x));
        }

        ship.setHullId(hullApi.getHullId());
        ship.setBaseHullId(hullApi.getBaseHullId());

        ship.setCrToDeploy(hullApi.getCRToDeploy());
        ship.setRepairPercentPerDay(new MutableStat(shipStatsAPI.getBaseCRRecoveryRatePercentPerDay()));
        ship.setSuppliesToRecover(new MutableStat(shipStatsAPI.getSuppliesToRecover()));
        ship.setNoCRLossSeconds(new MutableStat(hullApi.getNoCRLossSeconds(), shipStatsAPI.getPeakCRDuration()));
        ship.setSize(hullApi.getHullSize().name());
        ship.setOrdnancePoints(hullApi.getOrdnancePoints(personAPI.getStats()));

        ship.setSuppliesPerMonth(new MutableStat(shipStatsAPI.getSuppliesPerMonth()));
        ship.setCargo(new MutableStat(hullApi.getCargo(), shipStatsAPI.getCargoMod()));
        ship.setMaxCrew(new MutableStat(hullApi.getMaxCrew(), shipStatsAPI.getMaxCrewMod()));
        ship.setMinCrew(new MutableStat(hullApi.getMinCrew(), shipStatsAPI.getMinCrewMod()));
        ship.setFuel(new MutableStat(hullApi.getFuel(), shipStatsAPI.getFuelMod()));
        ship.setMaxBurn(new MutableStat(shipStatsAPI.getMaxBurnLevel()));
        ship.setFuelPerLY(new MutableStat(hullApi.getFuelPerLY(), shipStatsAPI.getFuelUseMod()));
        ship.setSensorProfile(new MutableStat(shipStatsAPI.getSensorProfile()));
        ship.setSensorStrength(new MutableStat(shipStatsAPI.getSensorStrength()));

        ship.setHitPoints(new MutableStat(hullApi.getHitpoints(), shipStatsAPI.getHullBonus()));
        ship.setArmorRating(new MutableStat(hullApi.getArmorRating(), shipStatsAPI.getArmorBonus()));
        ship.setShieldType(hullApi.getShieldType().name());
        ShipHullSpecAPI.ShieldSpecAPI shieldSpec = hullApi.getShieldSpec();
        ship.setShieldArc(new MutableStat(shieldSpec.getArc(), shipStatsAPI.getShieldArcBonus()));
        com.fs.starfarer.api.combat.MutableStat shieldUpkeepMult = shipStatsAPI.getShieldUpkeepMult();
        shieldUpkeepMult.setBaseValue(shieldSpec.getUpkeepCost());
        ship.setShieldUpkeep(new MutableStat(shieldUpkeepMult));
        com.fs.starfarer.api.combat.MutableStat shieldDamageTakenMult = shipStatsAPI.getShieldDamageTakenMult();
        shieldDamageTakenMult.setBaseValue(shieldSpec.getFluxPerDamageAbsorbed());
        ship.setFluxPerDamageAbsorbed(new MutableStat(shieldDamageTakenMult));
        ship.setPhaseCost(new MutableStat(shieldSpec.getPhaseCost(), shipStatsAPI.getPhaseCloakActivationCostBonus()));
        ship.setPhaseUpKeep(new MutableStat(shieldSpec.getPhaseUpkeep(), shipStatsAPI.getPhaseCloakUpkeepCostBonus()));
        ship.setFluxCapacity(new MutableStat(shipStatsAPI.getFluxCapacity()));
        ship.setFluxDissipation(new MutableStat(shipStatsAPI.getFluxDissipation()));
        ship.setMaxSpeed(new MutableStat(shipStatsAPI.getMaxSpeed()));

        ship.setShipSystemId(hullApi.getShipSystemId());
        if (system != null) {
            ship.setSystemFluxPerUse(system.getFluxPerUse());
            ship.setSystemFluxPerSecond(system.getFluxPerSecond());
            ShipSystemSpecAPI systemSpecAPI = system.getSpecAPI();
            ship.setSystemCrPerUse(systemSpecAPI.getCrPerUse());
            ship.setSystemMaxUses(systemSpecAPI.getMaxUses(shipStatsAPI));
            ship.setSystemRegen(systemSpecAPI.getRegen(shipStatsAPI));
            ship.setSystemCooldown(systemSpecAPI.getCooldown(shipStatsAPI));
        }

        ship.setShipDefenseId(hullApi.getShipDefenseId());
        if (defenseSystem != null) {
            ship.setDefenseFluxPerUse(defenseSystem.getFluxPerUse());
            ship.setDefenseFluxPerSecond(defenseSystem.getFluxPerSecond());
            ShipSystemSpecAPI defenseSpecAPI = defenseSystem.getSpecAPI();
            ship.setDefenseCrPerUse(defenseSpecAPI.getCrPerUse());
            ship.setDefenseMaxUses(defenseSpecAPI.getMaxUses(shipStatsAPI));
            ship.setDefenseRegen(defenseSpecAPI.getRegen(shipStatsAPI));
            ship.setDefenseCooldown(defenseSpecAPI.getCooldown(shipStatsAPI));
        }

        List<WeaponSlot> weaponSlots = new ArrayList<>();
        for (WeaponSlotAPI weaponSlotAPI : hullApi.getAllWeaponSlotsCopy()) {
            weaponSlots.add(new WeaponSlot(weaponSlotAPI));
        }
        ship.setAllWeaponSlots(weaponSlots);
        Map<String, String> weaponIdMap = new HashMap<>();
        for (WeaponSlot weaponSlot : weaponSlots) {
            String weaponSlotId = weaponSlot.getId();
            weaponIdMap.put(weaponSlotId, variantAPI.getWeaponId(weaponSlotId));
        }
        ship.setWeaponIdMap(weaponIdMap);

        List<String> builtInMods = hullApi.getBuiltInMods();
        builtInMods.addAll(new ArrayList<>(variantAPI.getPermaMods()));
        builtInMods.removeAll(variantAPI.getSMods());
        ship.setBuiltInMods(builtInMods);
        ship.setStoryMods(new ArrayList<>(variantAPI.getSMods()));
        ship.setNonBuiltInMods(new ArrayList<>(variantAPI.getNonBuiltInHullmods()));

        ship.setWings(hullApi.getFighterBays());
        ship.setBuiltInWingIds(hullApi.getBuiltInWings());
        ship.setNonBuiltInWingIds(variantAPI.getNonBuiltInWings());

        ship.setModuleIdMap(variantAPI.getStationModules());

        ship.setNumFluxCapacitors(variantAPI.getNumFluxCapacitors());
        ship.setNumFluxVents(variantAPI.getNumFluxVents());

        ship.setGoalVariant(variantAPI.isGoalVariant());
        ship.setFighter(variantAPI.isFighter());
        ship.setStation(variantAPI.isStation());
        ship.setCivilian(variantAPI.isCivilian());
        ship.setCombat(variantAPI.isCombat());
        ship.setFleetPoints(hullApi.getFleetPoints());
        ship.setBaseValue(hullApi.getBaseValue());

        Set<String> hints = new HashSet<>();
        for (ShipHullSpecAPI.ShipTypeHints hint : variantAPI.getHints()) {
            hints.add(hint.name());
        }
        ship.setHints(hints);
        ship.setTags(new HashSet<>(variantAPI.getTags()));

        return ship;
    }
}
