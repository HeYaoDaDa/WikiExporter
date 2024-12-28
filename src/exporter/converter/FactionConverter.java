package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.FactionAPI;
import com.fs.starfarer.api.loading.Description;
import exporter.model.Faction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static exporter.utils.CommonUtils.convertToHex;

public class FactionConverter {
    public Faction convert(FactionAPI factionAPI, List<String> allFactionIds) {
        SettingsAPI settings = Global.getSettings();
        String id = factionAPI.getId();
        Description description = settings.getDescription(id, Description.Type.FACTION);
        Faction faction = new Faction();

        faction.setId(id);
        faction.setJsonType("FACTION");

        faction.setDisplayName(factionAPI.getDisplayName());
        faction.setDisplayNameLong(factionAPI.getDisplayNameLong());
        faction.setPersonNamePrefix(factionAPI.getPersonNamePrefix());
        faction.setShipNamePrefix(factionAPI.getShipNamePrefix());
        faction.setDescription("");
        if (description.hasText1()) {
            faction.setDescription(description.getText1());
        }

        faction.setLogo(factionAPI.getLogo());
        faction.setCrest(factionAPI.getCrest());

        faction.setPickPersonality(factionAPI.pickPersonality());


        faction.setKnownShipIds(new ArrayList<>(factionAPI.getKnownShips()));
        faction.setAlwaysKnownShipIds(new ArrayList<>(factionAPI.getAlwaysKnownShips()));
        faction.setPriorityShipIds(new ArrayList<>(factionAPI.getPriorityShips()));

        faction.setKnownWeaponIds(new ArrayList<>(factionAPI.getKnownWeapons()));
        faction.setPriorityWeaponIds(new ArrayList<>(factionAPI.getPriorityWeapons()));
        faction.setWeaponSellFrequency(factionAPI.getWeaponSellFrequency());

        faction.setKnownFighterIds(new ArrayList<>(factionAPI.getKnownFighters()));
        faction.setPriorityFighterIds(new ArrayList<>(factionAPI.getPriorityFighters()));
        faction.setFighterSellFrequency(factionAPI.getFighterSellFrequency());

        faction.setKnownIndustryIds(new ArrayList<>(factionAPI.getKnownIndustries()));

        faction.setKnownHullModIds(new ArrayList<>(factionAPI.getKnownHullMods()));
        faction.setPriorityHullModIds(new ArrayList<>(factionAPI.getPriorityFighters()));
        faction.setHullModSellFrequency(factionAPI.getHullmodSellFrequency());


        Map<String, Double> relationshipMap = new HashMap<>();
        for (String factionId : allFactionIds) {
            if (factionId.equals(factionAPI.getId())) {
                continue;
            }
            float relationship = factionAPI.getRelationship(factionId);
            relationshipMap.put(factionId, (double) relationship);
        }
        faction.setRelationshipMap(relationshipMap);
        faction.setIllegalCommodityIds(new ArrayList<>(factionAPI.getIllegalCommodities()));

        faction.setTariffFraction(factionAPI.getTariffFraction());
        faction.setTollFraction(factionAPI.getTollFraction());
        faction.setFineFraction(factionAPI.getFineFraction());

        faction.setPlayerFaction(factionAPI.isPlayerFaction());
        faction.setShowInIntelTab(factionAPI.isShowInIntelTab());
        faction.setNeutralFaction(factionAPI.isNeutralFaction());
        faction.setColor(convertToHex(factionAPI.getColor()));

        return faction;
    }
}
