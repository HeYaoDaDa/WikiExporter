package exporter;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import com.fs.starfarer.api.loading.WeaponSpecAPI;
import exporter.converter.ShipConverter;
import exporter.converter.ShipModConverter;
import exporter.converter.ShipSystemConverter;
import exporter.converter.WeaponConverter;
import exporter.model.Ship;
import exporter.model.ShipMod;
import exporter.model.ShipSystem;
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

        ShipConverter shipConverter = new ShipConverter();
        ShipSystemConverter shipSystemConverter = new ShipSystemConverter();
        ShipModConverter shipModConverter = new ShipModConverter();
        JSONArray shipJSONArray = new JSONArray();

        for (ShipSystemSpecAPI systemSpecAPI : settings.getAllShipSystemSpecs()) {
            ShipSystem shipSystem = shipSystemConverter.convert(systemSpecAPI);
            if (shipSystem != null) {
                shipJSONArray.put(new JSONObject(shipSystem));
            }
        }

        for (HullModSpecAPI hullModSpecAPI : settings.getAllHullModSpecs()) {
            ShipMod shipMod = shipModConverter.convert(hullModSpecAPI);
            if (shipMod != null) {
                shipJSONArray.put(new JSONObject(shipMod));
            }
        }

        for (String variantId : settings.getAllVariantIds()) {
            ShipVariantAPI variant = settings.getVariant(variantId);
            Ship shipVariant = shipConverter.convert(variant.getHullSpec(), variant);
            if (shipVariant != null) {
                shipJSONArray.put(new JSONObject(shipVariant));
            }
        }


        try {
            WeaponConverter weaponConverter = new WeaponConverter();
            for (WeaponSpecAPI weaponSpec : settings.getAllWeaponSpecs()) {
                shipJSONArray.put(new JSONObject(weaponConverter.convert(weaponSpec)));
            }
            for (WeaponSpecAPI weaponSpec : settings.getSystemWeaponSpecs()) {
                if (weaponSpec.getAIHints().contains(WeaponAPI.AIHints.SHOW_IN_CODEX)) {
                    shipJSONArray.put(new JSONObject(weaponConverter.convert(weaponSpec)));
                }
            }
        } catch (JSONException | IOException e) {
            throw new RuntimeException(e);
        }
        logger.info("export_data_export_" + shipJSONArray);

        logger.info("=================================");
        logger.info("===============End===============");
        logger.info("=================================");
    }
}
