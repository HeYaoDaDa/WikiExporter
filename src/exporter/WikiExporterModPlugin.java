package exporter;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import com.fs.starfarer.api.loading.WeaponSpecAPI;
import exporter.converter.*;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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
        try {
            ShipSystemConverter shipSystemConverter = new ShipSystemConverter();
            JSONArray shipSystemJSONArray = new JSONArray();
            for (ShipSystemSpecAPI shipSystemSpecAPI : settings.getAllShipSystemSpecs()) {
                shipSystemJSONArray.put(new JSONObject(shipSystemConverter.convert(shipSystemSpecAPI)));
            }
            logger.info("export_ship_systems_export_" + shipSystemJSONArray);

            ShipModConverter shipModConverter = new ShipModConverter();
            JSONArray shipModJSONArray = new JSONArray();
            for (HullModSpecAPI hullModSpecAPI : settings.getAllHullModSpecs()) {
                shipModJSONArray.put(new JSONObject(shipModConverter.convert(hullModSpecAPI)));
            }
            logger.info("export_ship_mods_export_" + shipModJSONArray);

            WeaponConverter weaponConverter = new WeaponConverter();
            JSONArray weaponJSONArray = new JSONArray();
            for (WeaponSpecAPI weaponSpecAPI : settings.getAllWeaponSpecs()) {
                weaponJSONArray.put(new JSONObject(weaponConverter.convert(weaponSpecAPI)));
            }
            logger.info("export_weapons_export_" + weaponJSONArray);

            ShipConverter shipConverter = new ShipConverter();
            JSONArray shipJSONArray = new JSONArray();
            for (ShipHullSpecAPI shipHullSpecAPI : settings.getAllShipHullSpecs()) {
                shipJSONArray.put(new JSONObject(shipConverter.convert(shipHullSpecAPI)));
            }
            logger.info("export_ships_export_" + shipJSONArray);

            ShipVariantConverter shipVariantConverter = new ShipVariantConverter();
            JSONArray shipVariantJsonArray = new JSONArray();
            for (String variantId : settings.getAllVariantIds()) {
                ShipVariantAPI variant = settings.getVariant(variantId);
                shipVariantJsonArray.put(new JSONObject(shipVariantConverter.convert(variant)));
            }
            logger.info("export_ship_variants_export_" + shipVariantJsonArray);
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("");
        logger.info("=================================");
        logger.info("===============End===============");
        logger.info("=================================");
    }
}
