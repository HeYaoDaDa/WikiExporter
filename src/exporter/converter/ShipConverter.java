package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.characters.PersonAPI;
import com.fs.starfarer.api.combat.*;
import com.fs.starfarer.api.loading.Description;
import com.fs.starfarer.api.loading.WeaponSlotAPI;
import exporter.model.Ship;
import exporter.model.WeaponSlot;
import org.apache.log4j.Logger;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ShipConverter {
    private static final Logger logger = Global.getLogger(ShipConverter.class);

    public Ship convert(ShipHullSpecAPI api) throws JSONException {
        SettingsAPI settings = Global.getSettings();
        CombatEngineAPI combatEngine = Global.getCombatEngine();
        PersonAPI captain = combatEngine.getPlayerShip().getCaptain();
        String id = api.getHullId();
        String baseId = api.getBaseHullId();
        String emptyVariantId = id + "_wiki_exporter_variant";
        ShipVariantAPI emptyVariant = settings.createEmptyVariant(emptyVariantId, api);
        ShipAPI shipAPI = combatEngine.createFXDrone(emptyVariant);
        MutableShipStatsAPI mutableShipStatsAPI = shipAPI.getMutableStats();

        Ship ship = new Ship();

        ship.setId(id);
        ship.setName(api.getHullName());
        ship.setDesignation(api.getDesignation());
        ship.setDescriptionPrefix(api.getDescriptionPrefix());
        StringBuilder stringBuilder = new StringBuilder();
        Description description = settings.getDescription(api.getDescriptionId(), Description.Type.SHIP);
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
        ship.setDescriptionContent(stringBuilder.toString());
        ship.setSprite(api.getSpriteName());

        ship.setBaseHullId(baseId);
        ship.setSize(api.getHullSize().name());
        ship.setCrToDeploy(api.getCRToDeploy());
        ship.setRepairPercentPerDay(mutableShipStatsAPI.getBaseCRRecoveryRatePercentPerDay().getFlatMod());
        ship.setSuppliesToRecover(api.getSuppliesToRecover());
        ship.setNoCRLossSeconds(api.getNoCRLossSeconds());
        ship.setOrdnancePoints(api.getOrdnancePoints(captain.getStats()));

        ship.setSuppliesPerMonth(api.getSuppliesPerMonth());
        ship.setCargo(api.getCargo());
        ship.setMaxCrew(api.getMaxCrew());
        ship.setMinCrew(api.getMinCrew());
        ship.setFuel(api.getFuel());
        ship.setMaxBurn(mutableShipStatsAPI.getMaxBurnLevel().getModifiedInt());
        ship.setFuelPerLY(api.getFuelPerLY());
        ship.setSensorProfile(mutableShipStatsAPI.getSensorProfile().getModifiedInt());
        ship.setSensorStrength(mutableShipStatsAPI.getSensorStrength().getModifiedInt());

        ship.setHitPoints(api.getHitpoints());
        ship.setArmorRating(api.getArmorRating());
        ship.setShieldType(api.getShieldType().name());
        ShipHullSpecAPI.ShieldSpecAPI shieldSpec = api.getShieldSpec();
        ship.setShieldRadius(shieldSpec.getRadius());
        ship.setShieldCost(shieldSpec.getUpkeepCost());
        ship.setFluxPerDamageAbsorbed(shieldSpec.getFluxPerDamageAbsorbed());
        ship.setPhaseCost(shieldSpec.getPhaseCost());
        ship.setPhaseUpKeep(shieldSpec.getPhaseUpkeep());
        ship.setPhased(api.isPhase());
        ship.setFluxCapacity(api.getFluxCapacity());
        ship.setFluxDissipation(api.getFluxDissipation());
        ship.setMaxSpeed(api.getEngineSpec().getMaxSpeed());

        ship.setShipSystemId(api.getShipSystemId());
        ship.setShipDefenseId(api.getShipDefenseId());

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
