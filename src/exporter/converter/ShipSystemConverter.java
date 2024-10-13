package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.loading.Description;
import exporter.model.ShipSystem;
import exporter.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShipSystemConverter {
    private static final Logger logger = Global.getLogger(ShipSystemConverter.class);
    private final Map<String, JSONObject> csvObjectMap = new HashMap<>();

    public ShipSystemConverter() throws JSONException, IOException {
        JSONArray csvArray = Global.getSettings().loadCSV("data/shipsystems/ship_systems.csv", true);
        for (int i = 0; i < csvArray.length(); i++) {
            JSONObject csvObject = csvArray.getJSONObject(i);
            String id = csvObject.getString("id");
            if (id != null && !id.isEmpty()) {
                this.csvObjectMap.put(id, csvObject);
            }
        }
    }

    public ShipSystem convert(ShipSystemSpecAPI shipSystemSpecAPI) throws JSONException {
        SettingsAPI settings = Global.getSettings();
        String id = shipSystemSpecAPI.getId();
        Description description = settings.getDescription(id, Description.Type.SHIP_SYSTEM);
        JSONObject csvObject = csvObjectMap.get(id);

        ShipSystem shipSystem = new ShipSystem();
        shipSystem.setId(id);
        shipSystem.setName(shipSystemSpecAPI.getName());
        shipSystem.setDescription(description.getText1());
        shipSystem.setShortDescription(description.getText3());
        shipSystem.setIcon(shipSystemSpecAPI.getIconSpriteName());

        shipSystem.setFluxPerUse(shipSystemSpecAPI.getFluxPerUse());
        shipSystem.setFluxPerSecond(shipSystemSpecAPI.getFluxPerSecond());
        shipSystem.setFluxPerSecondBaseRate(shipSystemSpecAPI.getFluxPerSecondBaseRate());
        shipSystem.setFluxPerSecondBaseCap(shipSystemSpecAPI.getFluxPerSecondBaseCap());
        shipSystem.setFluxPerUseBaseRate(shipSystemSpecAPI.getFluxPerUseBaseRate());
        shipSystem.setFluxPerUseBaseCap(shipSystemSpecAPI.getFluxPerUseBaseCap());
        shipSystem.setCrPerUse(shipSystemSpecAPI.getCrPerUse());

        shipSystem.setMaxUses(JsonUtils.getInt(csvObject, "max uses", 0));
        shipSystem.setRegen(JsonUtils.getDouble(csvObject, "regen", 0));
        return shipSystem;
    }

}
