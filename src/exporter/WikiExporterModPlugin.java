package exporter;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.*;
import com.fs.starfarer.api.campaign.econ.CommoditySpecAPI;
import com.fs.starfarer.api.campaign.econ.SubmarketSpecAPI;
import com.fs.starfarer.api.characters.MarketConditionSpecAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.impl.campaign.ids.Tags;
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
import java.util.HashSet;
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

        SpecialItemConverter specialItemConverter = new SpecialItemConverter();
        for (SpecialItemSpecAPI specialItemSpecAPI : settings.getAllSpecialItemSpecs()) {
            SpecialItem specialItem = specialItemConverter.convert(specialItemSpecAPI);
            if (specialItem != null) {
                dataJSONArray.put(new JSONObject(specialItem));
            }
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

        MarketConditionConverter marketConditionConverter = new MarketConditionConverter();
        for (MarketConditionSpecAPI marketConditionSpecAPI : settings.getAllMarketConditionSpecs()) {
            MarketCondition marketCondition = marketConditionConverter.convert(marketConditionSpecAPI);
            if (marketCondition != null) {
                dataJSONArray.put(new JSONObject(marketCondition));
            }
        }

        SubMarketConverter subMarketConverter = new SubMarketConverter();
        for (SubmarketSpecAPI submarketSpecAPI : settings.getAllSubmarketSpecs()) {
            SubMarket subMarket = subMarketConverter.convert(submarketSpecAPI);
            if (subMarket != null) {
                dataJSONArray.put(new JSONObject(subMarket));
            }
        }

        SectorAPI sector = Global.getSector();

        List<String> factionIds = new ArrayList<>();
        for (FactionAPI factionAPI : sector.getAllFactions()) {
            factionIds.add(factionAPI.getId());
        }
        FactionConverter factionConverter = new FactionConverter();
        for (FactionAPI factionAPI : sector.getAllFactions()) {
            Faction faction = factionConverter.convert(factionAPI, factionIds);
            if (faction != null) {
                dataJSONArray.put(new JSONObject(faction));
            }
        }

        List<StarSystemAPI> starSystemApis = new ArrayList<>();
        for (StarSystemAPI starSystemAPI : sector.getStarSystems()) {
            if (starSystemAPI.hasTag(Tags.THEME_CORE)) {
                starSystemApis.add(starSystemAPI);
            }
        }
        HashSet<PlanetAPI> planetAPIS = new HashSet<>();
        HashSet<PersonAPI> personAPIS = new HashSet<>();
        for (StarSystemAPI starSystemApi : starSystemApis) {
            planetAPIS.addAll(starSystemApi.getPlanets());
        }
        for (PlanetAPI planetAPI : planetAPIS) {
            if (planetAPI.getMarket() != null) {
                personAPIS.addAll(planetAPI.getMarket().getPeopleCopy());
            }
        }

        StarSystemConverter starSystemConverter = new StarSystemConverter();
        for (StarSystemAPI starSystemAPI : starSystemApis) {
            StarSystem starSystem = starSystemConverter.convert(starSystemAPI);
            if (starSystem != null) {
                dataJSONArray.put(new JSONObject(starSystem));
            }
        }

        PlanetConverter planetConverter = new PlanetConverter();
        for (PlanetAPI planetAPI : planetAPIS) {
            Planet planet = planetConverter.convert(planetAPI);
            if (planet != null) {
                dataJSONArray.put(new JSONObject(planet));
            }
        }

        PersonConverter personConverter = new PersonConverter();
        for (PersonAPI personAPI : personAPIS) {
            Person person = personConverter.convert(personAPI);
            if (person != null) {
                dataJSONArray.put(new JSONObject(person));
            }
        }

        logger.info("export_data_export_" + dataJSONArray);

        logger.info("=================================");
        logger.info("===============End===============");
        logger.info("=================================");
    }
}
