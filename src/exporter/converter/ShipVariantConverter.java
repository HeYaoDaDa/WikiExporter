package exporter.converter;

import com.fs.starfarer.api.combat.ShipHullSpecAPI;
import com.fs.starfarer.api.combat.ShipVariantAPI;
import exporter.model.ShipVariant;

import java.util.*;

public class ShipVariantConverter {
    public ShipVariant convert(ShipVariantAPI api) {
        if (api.isDHull()) {
            return null;
        }

        ShipVariant shipVariant = new ShipVariant();
        String id = api.getHullVariantId();

        shipVariant.setId(id);
        shipVariant.setName(api.getDisplayName());
        shipVariant.setHullId(api.getHullSpec().getHullId());

        shipVariant.setNumFluxCapacitors(api.getNumFluxCapacitors());
        shipVariant.setNumFluxVents(api.getNumFluxVents());

        ArrayList<String> permanentMods = new ArrayList<>(api.getPermaMods());
        shipVariant.setsMods(new ArrayList<>(api.getSMods()));
        permanentMods.removeAll(shipVariant.getsMods());
        shipVariant.setPermanentMods(permanentMods);
        shipVariant.setNonBuiltInMods(new ArrayList<>(api.getNonBuiltInHullmods()));

        Map<String, String> weaponIdMap = new HashMap<>();
        List<String> weaponSlots = api.getNonBuiltInWeaponSlots();
        for (String weaponSlot : weaponSlots) {
            weaponIdMap.put(weaponSlot, api.getWeaponId(weaponSlot));
        }
        shipVariant.setWeaponIdMap(weaponIdMap);

        shipVariant.setBuiltInWingIds(api.getNonBuiltInWings());
        shipVariant.setNonBuiltInWingIds(api.getNonBuiltInWings());

        shipVariant.setModuleIdMap(api.getStationModules());

        shipVariant.setGoalVariant(api.isGoalVariant());
        shipVariant.setFighter(api.isFighter());
        shipVariant.setStation(api.isStation());
        shipVariant.setCivilian(api.isCivilian());
        shipVariant.setCombat(api.isCombat());
        shipVariant.setMayAutoAssignWeapons(api.isMayAutoAssignWeapons());

        Set<String> hints = new HashSet<>();
        for (ShipHullSpecAPI.ShipTypeHints hint : api.getHints()) {
            hints.add(hint.name());
        }
        shipVariant.setHints(hints);
        shipVariant.setTags(new HashSet<>(api.getTags()));

        return shipVariant;
    }
}
