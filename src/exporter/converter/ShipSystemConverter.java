package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.combat.ShipSystemSpecAPI;
import com.fs.starfarer.api.loading.Description;
import exporter.model.ShipSystem;
import org.apache.log4j.Logger;

public class ShipSystemConverter {
    private static final Logger logger = Global.getLogger(ShipSystemConverter.class);

    public ShipSystem convert(ShipSystemSpecAPI shipSystemSpecAPI) {
        SettingsAPI settings = Global.getSettings();
        String id = shipSystemSpecAPI.getId();
        Description description = settings.getDescription(id, Description.Type.SHIP_SYSTEM);

        ShipSystem shipSystem = new ShipSystem();
        shipSystem.setId(id);
        shipSystem.setJsonType("SHIP_SYSTEM");
        shipSystem.setName(shipSystemSpecAPI.getName());
        shipSystem.setDescription(description.getText1());
        shipSystem.setShortDescription(description.getText3());
        shipSystem.setIcon(shipSystemSpecAPI.getIconSpriteName());
        return shipSystem;
    }
}
