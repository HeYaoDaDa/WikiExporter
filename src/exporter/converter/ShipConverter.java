package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.ShieldAPI;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;
import com.fs.starfarer.api.loading.WeaponSlotAPI;
import exporter.model.Ship;
import exporter.model.WeaponSlot;
import exporter.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShipConverter {
    private static final Logger logger = Global.getLogger(ShipConverter.class);
    private final Map<String, JSONObject> csvObjectMap = new HashMap<>();

    public ShipConverter() throws JSONException, IOException {
        JSONArray csvArray = Global.getSettings().loadCSV("data/hulls/ship_data.csv", true);
        for (int i = 0; i < csvArray.length(); i++) {
            JSONObject csvObject = csvArray.getJSONObject(i);
            String id = csvObject.getString("id");
            if (id != null && !id.isEmpty()) {
                this.csvObjectMap.put(id, csvObject);
            }
        }
    }

    public Ship convert(ShipHullSpecAPI api) throws JSONException {
        String id = api.getBaseHullId();
        JSONObject csvObject = csvObjectMap.get(id);

        Ship ship = new Ship();

        ship.setId(id);
        ship.setName(api.getHullName());
        ship.setDesignation(api.getDesignation());
        ship.setDescriptionPrefix(api.getDescriptionPrefix());
        ship.setDescriptionContent(api.getDescriptionId());
        ship.setSprite(api.getSpriteName());

        ship.setSize(api.getHullSize().name());
        ship.setCrToDeploy(api.getCRToDeploy());
        ship.setRepairPercentPerDay(JsonUtils.getDouble(csvObject, "cr %/day", 0));
        ship.setSuppliesToRecover(api.getSuppliesToRecover());
        ship.setNoCRLossSeconds(api.getNoCRLossSeconds());
        ship.setOrdnancePoints(JsonUtils.getInt(csvObject, "ordnance points", 0));

        ship.setSuppliesPerMonth(api.getSuppliesPerMonth());
        ship.setCargo(api.getCargo());
        ship.setMaxCrew(api.getMaxCrew());
        ship.setMinCrew(api.getMinCrew());
        ship.setFuel(api.getFuel());
        ship.setMaxBurn(JsonUtils.getInt(csvObject, "max burn", 0));
        ship.setFuelPerLY(api.getFuelPerLY());

        ship.setHitPoints(api.getHitpoints());
        ship.setArmorRating(api.getArmorRating());
        ship.setShieldType(api.getShieldType().name());
        //TODO phase
        if (ShieldAPI.ShieldType.OMNI.equals(api.getShieldType()) || ShieldAPI.ShieldType.FRONT.equals(api.getShieldType())) {
            ShipHullSpecAPI.ShieldSpecAPI shieldSpec = api.getShieldSpec();
            ship.setShieldRadius(shieldSpec.getRadius());
            ship.setShieldCost(shieldSpec.getUpkeepCost());
        }
        ship.setPhased(api.isPhase());
        ship.setFluxCapacity(api.getFluxCapacity());
        ship.setFluxDissipation(api.getFluxDissipation());
        ship.setMaxSpeed(api.getEngineSpec().getMaxSpeed());

        ship.setShipSystemId(ship.getShipSystemId());
        ship.setShipDefenseId(ship.getShipDefenseId());

        ship.setBuiltInMods(api.getBuiltInMods());
        ship.setBuiltInWeapons(api.getBuiltInWeapons());
        List<WeaponSlot> weaponSlots = new ArrayList<>();
        for (WeaponSlotAPI weaponSlotAPI : api.getAllWeaponSlotsCopy()) {
            weaponSlots.add(new WeaponSlot(weaponSlotAPI));
        }
        ship.setAllWeaponSlots(weaponSlots);

        ship.setFleetPoints(api.getFleetPoints());
        ship.setBaseValue(api.getBaseValue());

        return ship;
    }
}
