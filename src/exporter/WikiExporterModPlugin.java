package exporter;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.campaign.PlanetSpecAPI;
import com.fs.starfarer.api.campaign.RepLevel;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.econ.CommoditySpecAPI;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import com.fs.starfarer.api.loading.IndustrySpecAPI;
import com.fs.starfarer.api.loading.WeaponSpecAPI;
import exporter.converter.*;
import exporter.model.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        SettingsAPI settings = Global.getSettings();

        ShipConverter shipConverter = new ShipConverter();
        ShipSystemConverter shipSystemConverter = new ShipSystemConverter();
        ShipModConverter shipModConverter = new ShipModConverter();
        JSONArray dataJSONArray = new JSONArray();

        for (ShipSystemSpecAPI systemSpecAPI : settings.getAllShipSystemSpecs()) {
            ShipSystem shipSystem = shipSystemConverter.convert(systemSpecAPI);
            if (shipSystem != null) {
                dataJSONArray.put(new JSONObject(shipSystem));
            }
        }

        for (HullModSpecAPI hullModSpecAPI : settings.getAllHullModSpecs()) {
            ShipMod shipMod = shipModConverter.convert(hullModSpecAPI);
            if (shipMod != null) {
                dataJSONArray.put(new JSONObject(shipMod));
            }
        }

        for (String variantId : settings.getAllVariantIds()) {
            ShipVariantAPI variant = settings.getVariant(variantId);
            Ship shipVariant = shipConverter.convert(variant.getHullSpec(), variant);
            if (shipVariant != null) {
                dataJSONArray.put(new JSONObject(shipVariant));
            }
        }


        try {
            WeaponConverter weaponConverter = new WeaponConverter();
            for (WeaponSpecAPI weaponSpec : settings.getAllWeaponSpecs()) {
                dataJSONArray.put(new JSONObject(weaponConverter.convert(weaponSpec)));
            }
            for (WeaponSpecAPI weaponSpec : settings.getSystemWeaponSpecs()) {
                if (weaponSpec.getAIHints().contains(WeaponAPI.AIHints.SHOW_IN_CODEX)) {
                    dataJSONArray.put(new JSONObject(weaponConverter.convert(weaponSpec)));
                }
            }
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }

        CommodityConverter commodityConverter = new CommodityConverter();
        for (CommoditySpecAPI commoditySpecAPI : settings.getAllCommoditySpecs()) {
            Commodity commodity = commodityConverter.convert(commoditySpecAPI);
            if (commodity != null) {
                dataJSONArray.put(new JSONObject(commodity));
            }
        }

        IndustryConverter industryConverter = new IndustryConverter();
        for (IndustrySpecAPI industrySpecAPI : settings.getAllIndustrySpecs()) {
            Industry industry = industryConverter.convert(industrySpecAPI);
            if (industry != null) {
                dataJSONArray.put(new JSONObject(industry));
            }
        }

        PlanetTypeConverter planetTypeConverter = new PlanetTypeConverter();
        for (PlanetSpecAPI planetSpecAPI : settings.getAllPlanetSpecs()) {
            PlanetType planetType = planetTypeConverter.convert(planetSpecAPI);
            if (planetType != null) {
                dataJSONArray.put(new JSONObject(planetType));
            }
        }

        logger.info("export_data_export_" + dataJSONArray);

        logger.info("=================================");
        logger.info("===============End===============");
        logger.info("=================================");
    }

    @Override
    public void onGameLoad(boolean newGame) {
        super.onGameLoad(newGame);
        logger.info("===== onGameLoad =====");
        SectorAPI sectorApi = Global.getSector();

//        List<StarSystemAPI> starSystems = sectorApi.getStarSystems();
//        for (StarSystemAPI starSystem : starSystems) {
//            if (starSystem.hasTag(Tags.THEME_CORE)) {
//                logger.info("=====" + starSystem.getName() + "=====" + starSystem.getBaseName());
//                List<PlanetAPI> planets = starSystem.getPlanets();
//                for (PlanetAPI planet : planets) {
//                    logger.info("\t\t" + planet.getName() + " | " + planet.getFullName());
//                }
//            }
//        }

        List<String> factionIds = new ArrayList<>();
        for (FactionAPI factionAPI : sectorApi.getAllFactions()) {
            factionIds.add(factionAPI.getId());
        }
        for (FactionAPI factionAPI : sectorApi.getAllFactions()) {
            logger.info("=====" + factionAPI.getDisplayName() + "=====");
            logger.info("	getId:" + factionAPI.getId());
            logger.info("	getDisplayName:" + factionAPI.getDisplayName());
            logger.info("	getDisplayNameLong:" + factionAPI.getDisplayNameLong());
            logger.info("	getPersonNamePrefix:" + factionAPI.getPersonNamePrefix());
            logger.info("	getShipNamePrefix:" + factionAPI.getShipNamePrefix());

            logger.info("	getLogo:" + factionAPI.getLogo());
            logger.info("	getCrest:" + factionAPI.getCrest());

            logger.info("	getTariffFraction:" + factionAPI.getTariffFraction());
            logger.info("	getTollFraction:" + factionAPI.getTollFraction());
            logger.info("	getFineFraction:" + factionAPI.getFineFraction());

            logger.info("	pickPersonality:" + factionAPI.pickPersonality());

            logger.info("	isShowInIntelTab:" + factionAPI.isShowInIntelTab());
            logger.info("	isNeutralFaction:" + factionAPI.isNeutralFaction());


            StringBuilder illegalCommoditys = new StringBuilder();
            for (String illegalCommodity : factionAPI.getIllegalCommodities()) {
                illegalCommoditys.append(illegalCommodity).append(", ");
            }
            logger.info("	getIllegalCommodities:" + illegalCommoditys);

            for (String factionId : factionIds) {
                if (factionId.equals(factionAPI.getId())) {
                    continue;
                }
                float relationship = factionAPI.getRelationship(factionId);
                logger.info("       " + factionId + ":" + relationship + " - " + RepLevel.getLevelFor(relationship));
            }
        }
    }
}
