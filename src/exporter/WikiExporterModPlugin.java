package exporter;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import com.fs.starfarer.api.loading.WeaponSpecAPI;
import exporter.converter.ShipConverter;
import exporter.converter.ShipModConverter;
import exporter.converter.ShipSystemConverter;
import exporter.converter.WeaponConverter;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WikiExporterModPlugin extends BaseModPlugin {
    private static final Logger logger = Global.getLogger(WikiExporterModPlugin.class);

    @Override
    public void onApplicationLoad() throws Exception {
        super.onApplicationLoad();
        Global.getSettings().setDevMode(true);
    }

    @Override
    public void onDevModeF8Reload() {
        super.onDevModeF8Reload();
        try {
            ShipSystemConverter shipSystemConverter = new ShipSystemConverter();
            JSONArray shipSystemJSONArray = new JSONArray();
            for (ShipSystemSpecAPI shipSystemSpecAPI : Global.getSettings().getAllShipSystemSpecs()) {
                shipSystemJSONArray.put(new JSONObject(shipSystemConverter.convert(shipSystemSpecAPI)));
            }
            logger.info("export_ship_systems_export_" + shipSystemJSONArray);

            ShipModConverter shipModConverter = new ShipModConverter();
            JSONArray shipModJSONArray = new JSONArray();
            for (HullModSpecAPI hullModSpecAPI : Global.getSettings().getAllHullModSpecs()) {
                shipModJSONArray.put(new JSONObject(shipModConverter.convert(hullModSpecAPI)));
            }
            logger.info("export_ship_mods_export_" + shipModJSONArray);

            WeaponConverter weaponConverter = new WeaponConverter();
            JSONArray weaponJSONArray = new JSONArray();
            for (WeaponSpecAPI weaponSpecAPI : Global.getSettings().getAllWeaponSpecs()) {
                weaponJSONArray.put(new JSONObject(weaponConverter.convert(weaponSpecAPI)));
            }
            logger.info("export_weapons_export_" + weaponJSONArray);

            ShipConverter shipConverter = new ShipConverter();
            JSONArray shipJSONArray = new JSONArray();
            for (ShipHullSpecAPI shipHullSpecAPI : Global.getSettings().getAllShipHullSpecs()) {
                shipJSONArray.put(new JSONObject(shipConverter.convert(shipHullSpecAPI)));
            }
            logger.info("export_ships_export_" + shipJSONArray);
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("===============End===============");
//        JSONArray shipMods = new JSONArray();
//        for (HullModSpecAPI hullModSpecAPI : Global.getSettings().getAllHullModSpecs()) {
//            try {
//                shipMods.put(convertHullModSpecAPI(hullModSpecAPI));
//            } catch (JSONException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        JSONArray weapons = new JSONArray();
//        for (WeaponSpecAPI weaponSpecAPI : Global.getSettings().getAllWeaponSpecs()) {
//            Map<String, Object> map = convertWeaponSpecAPI(weaponSpecAPI);
//            JSONObject jsonObject = new JSONObject(map);
//            weapons.put(jsonObject);
//        }
//
//        JSONArray systems = new JSONArray();
//        for (ShipSystemSpecAPI shipSystemSpec : Global.getSettings().getAllShipSystemSpecs()) {
//            JSONObject jsonObject = new JSONObject(shipSystemSpec);
//            systems.put(jsonObject);
//        }
//
//        JSONArray ships = new JSONArray();
//        for (ShipHullSpecAPI shipHullSpecAPI : Global.getSettings().getAllShipHullSpecs()) {
//            JSONObject jsonObject = new JSONObject(shipHullSpecAPI);
//            ships.put(jsonObject);
//        }
//
//        JSONArray shipVariant = new JSONArray();
//        for (String variantId : Global.getSettings().getAllVariantIds()) {
//            ShipVariantAPI variant = Global.getSettings().getVariant(variantId);
//            Map<String, Object> map = convertShipVariantAPI(variant);
//            JSONObject jsonObject = new JSONObject(map);
//            shipVariant.put(jsonObject);
//        }
//
//        logger.info("export_ship_mods_export_" + shipMods);
//        logger.info("export_weapons_export_" + weapons);
//        logger.info("export_systems_export_" + systems);
//        logger.info("export_ships_export_" + ships);
//        logger.info("export_ship_variants_export_" + shipVariant);
    }

    public static JSONObject convertHullModSpecAPI(HullModSpecAPI hullModSpecAPI) throws JSONException {
        ShipAPI playerShip = Global.getCombatEngine().getPlayerShip();
        MutableShipStatsAPI mutableShipStatsAPI = playerShip.getMutableStats();
        logger.info("----start convert hullMod:" + hullModSpecAPI.getId() + ",name:" + hullModSpecAPI.getDisplayName() + ",class:" + hullModSpecAPI.getEffectClass());
        logger.info("--Bonus is Null:" + (mutableShipStatsAPI.getBallisticWeaponRangeBonus() == null));
        JSONObject result = new JSONObject(hullModSpecAPI);
        JSONObject descriptionObject = new JSONObject();
        JSONObject sDescriptionObject = new JSONObject();
        for (ShipAPI.HullSize hullSize : ShipAPI.HullSize.values()) {
            if (!ShipAPI.HullSize.DEFAULT.equals(hullSize) && !ShipAPI.HullSize.FIGHTER.equals(hullSize)) {
                hullModSpecAPI.getEffect().applyEffectsBeforeShipCreation(hullSize, mutableShipStatsAPI, "export");
                logger.info("--ShipApi is Null:" + (mutableShipStatsAPI.getEntity() == null));
                hullModSpecAPI.getEffect().applyEffectsAfterShipCreation(playerShip, "export");
                descriptionObject.put(hullSize.name().toLowerCase(), hullModSpecAPI.getDescription(hullSize));
                if (hullModSpecAPI.getEffect().hasSModEffect()) {
                    sDescriptionObject.put(hullSize.name().toLowerCase(), hullModSpecAPI.getSModDescription(hullSize));
                }
            }
        }
        result.put("description", descriptionObject);
        result.put("sDescription", sDescriptionObject);
        return result;
    }

    public static Map<String, Object> convertWeaponSpecAPI(WeaponSpecAPI weaponSpecAPI) {
        Map<String, Object> map = new HashMap<>();
        map.put("aIHints", weaponSpecAPI.getAIHints());
        map.put("type", weaponSpecAPI.getType());
        map.put("ammoPerSecond", weaponSpecAPI.getAmmoPerSecond());
        map.put("tier", weaponSpecAPI.getTier());
        map.put("baseValue", weaponSpecAPI.getBaseValue());
        map.put("maxAmmo", weaponSpecAPI.getMaxAmmo());
        map.put("weaponId", weaponSpecAPI.getWeaponId());
        map.put("size", weaponSpecAPI.getSize());
        map.put("weaponName", weaponSpecAPI.getWeaponName());
        map.put("burstSize", weaponSpecAPI.getBurstSize());
        map.put("tags", weaponSpecAPI.getTags());
        map.put("rarity", weaponSpecAPI.getRarity());
//            map.put("derivedStats", weaponSpecAPI.getDerivedStats());
        map.put("hardpointFireOffsets", weaponSpecAPI.getHardpointFireOffsets());
        map.put("hardpointAngleOffsets", weaponSpecAPI.getHardpointAngleOffsets());
        map.put("turretFireOffsets", weaponSpecAPI.getTurretFireOffsets());
        map.put("turretAngleOffsets", weaponSpecAPI.getTurretAngleOffsets());
        map.put("hiddenFireOffsets", weaponSpecAPI.getHiddenFireOffsets());
        map.put("hiddenAngleOffsets", weaponSpecAPI.getHiddenAngleOffsets());
        map.put("hardpointSpriteName", weaponSpecAPI.getHardpointSpriteName());
        map.put("turretSpriteName", weaponSpecAPI.getTurretSpriteName());
        map.put("hardpointUnderSpriteName", weaponSpecAPI.getHardpointUnderSpriteName());
        map.put("turretUnderSpriteName", weaponSpecAPI.getTurretUnderSpriteName());
        map.put("manufacturer", weaponSpecAPI.getManufacturer());
        map.put("autofitCategory", weaponSpecAPI.getAutofitCategory());
        map.put("autofitCategoriesInPriorityOrder", weaponSpecAPI.getAutofitCategoriesInPriorityOrder());
        map.put("weaponGroupTag", weaponSpecAPI.getWeaponGroupTag());
        map.put("beam", weaponSpecAPI.isBeam());
        map.put("primaryRoleStr", weaponSpecAPI.getPrimaryRoleStr());
        map.put("speedStr", weaponSpecAPI.getSpeedStr());
        map.put("trackingStr", weaponSpecAPI.getTrackingStr());
        map.put("turnRateStr", weaponSpecAPI.getTurnRateStr());
        map.put("accuracyStr", weaponSpecAPI.getAccuracyStr());
        map.put("customPrimary", weaponSpecAPI.getCustomPrimary());
        map.put("customPrimaryHL", weaponSpecAPI.getCustomPrimaryHL());
        map.put("customAncillary", weaponSpecAPI.getCustomAncillary());
        map.put("customAncillaryHL", weaponSpecAPI.getCustomAncillaryHL());
        map.put("noDPSInTooltip", weaponSpecAPI.isNoDPSInTooltip());
        map.put("glowColor", weaponSpecAPI.getGlowColor());
        map.put("interruptibleBurst", weaponSpecAPI.isInterruptibleBurst());
        map.put("noImpactSounds", weaponSpecAPI.isNoImpactSounds());
        map.put("damageType", weaponSpecAPI.getDamageType());
        map.put("renderAboveAllWeapons", weaponSpecAPI.isRenderAboveAllWeapons());
        map.put("noShieldImpactSounds", weaponSpecAPI.isNoShieldImpactSounds());
        map.put("noNonShieldImpactSounds", weaponSpecAPI.isNoNonShieldImpactSounds());
        map.put("minSpread", weaponSpecAPI.getMinSpread());
        map.put("maxSpread", weaponSpecAPI.getMaxSpread());
        map.put("spreadDecayRate", weaponSpecAPI.getSpreadDecayRate());
        map.put("spreadBuildup", weaponSpecAPI.getSpreadBuildup());
        map.put("burstDuration", weaponSpecAPI.getBurstDuration());
        map.put("autofireAccBonus", weaponSpecAPI.getAutofireAccBonus());
        map.put("projectileSpec", weaponSpecAPI.getProjectileSpec());
        map.put("beamChargeupTime", weaponSpecAPI.getBeamChargeupTime());
        map.put("beamChargedownTime", weaponSpecAPI.getBeamChargedownTime());
        map.put("unaffectedByProjectileSpeedBonuses", weaponSpecAPI.isUnaffectedByProjectileSpeedBonuses());
        map.put("chargeTime", weaponSpecAPI.getChargeTime());
        map.put("mountType", weaponSpecAPI.getMountType());
        map.put("extraArcForAI", weaponSpecAPI.getExtraArcForAI());
        map.put("maxRange", weaponSpecAPI.getMaxRange());
        map.put("showDamageWhenDecorative", weaponSpecAPI.isShowDamageWhenDecorative());
        map.put("burstBeam", weaponSpecAPI.isBurstBeam());
        map.put("stopPreviousFireSound", weaponSpecAPI.isStopPreviousFireSound());
        map.put("playFullFireSoundOne", weaponSpecAPI.isPlayFullFireSoundOne());
        map.put("reloadSize", weaponSpecAPI.getReloadSize());
        map.put("turnRate", weaponSpecAPI.getTurnRate());
        map.put("restrictToSpecifiedMountType", weaponSpecAPI.isRestrictToSpecifiedMountType());
        return map;
    }

    public static Map<String, Object> convertShipVariantAPI(ShipVariantAPI variant) {
        Map<String, Object> map = new HashMap<>();
        map.put("hullId", variant.getHullSpec().getHullId());
        map.put("displayName", variant.getDisplayName());
        map.put("designation", variant.getDesignation());
        map.put("hullMods", variant.getHullMods());
        map.put("hints", variant.getHints());
        map.put("numFluxVents", variant.getNumFluxVents());
        map.put("numFluxCapacitors", variant.getNumFluxCapacitors());
        map.put("nonBuiltInWeaponSlots", variant.getNonBuiltInWeaponSlots());
        map.put("fittedWeaponSlots", variant.getFittedWeaponSlots());
        map.put("source", variant.getSource());
        map.put("stockVariant", variant.isStockVariant());
        map.put("emptyHullVariant", variant.isEmptyHullVariant());
        map.put("hullVariantId", variant.getHullVariantId());
        map.put("weaponGroups", variant.getWeaponGroups());
        map.put("hullSize", variant.getHullSize());
        map.put("fighter", variant.isFighter());
        map.put("fullDesignationWithHullName", variant.getFullDesignationWithHullName());
        map.put("combat", variant.isCombat());
        map.put("station", variant.isStation());
        map.put("wings", variant.getWings());
        map.put("launchBaysSlotIds", variant.getLaunchBaysSlotIds());
        map.put("fittedWings", variant.getFittedWings());
        map.put("permaMods", variant.getPermaMods());
        map.put("carrier", variant.isCarrier());
        map.put("sortedMods", variant.getSortedMods());
        map.put("suppressedMods", variant.getSuppressedMods());
        map.put("goalVariant", variant.isGoalVariant());
        map.put("nonBuiltInHullmods", variant.getNonBuiltInHullmods());
        map.put("civilian", variant.isCivilian());
        map.put("moduleSlots", variant.getModuleSlots());
//            map.put("statsForOpCosts", variant.getStatsForOpCosts());
        map.put("liner", variant.isLiner());
        map.put("freighter", variant.isFreighter());
        map.put("tanker", variant.isTanker());
        map.put("dHull", variant.isDHull());
        map.put("stationModules", variant.getStationModules());
        map.put("nonBuiltInWings", variant.getNonBuiltInWings());
        map.put("tags", variant.getTags());
        map.put("originalVariant", variant.getOriginalVariant());
        map.put("transport", variant.isTransport());
        map.put("variantFilePath", variant.getVariantFilePath());
        map.put("sMods", variant.getSMods());
        map.put("fullDesignationWithHullNameForShip", variant.getFullDesignationWithHullNameForShip());
        map.put("sModdedBuiltIns", variant.getSModdedBuiltIns());
        map.put("mayAutoAssignWeapons", variant.isMayAutoAssignWeapons());
        return map;
    }
}
