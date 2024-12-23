package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.loading.Description;
import exporter.model.Market;
import exporter.model.Planet;

import java.util.ArrayList;

public class PlanetConverter {
    public Planet convert(SectorEntityToken sectorEntityToken) {
        SettingsAPI settings = Global.getSettings();

        Planet planet = new Planet();

        planet.setId(sectorEntityToken.getId());
        planet.setJsonType("PLANET");
        planet.setName(sectorEntityToken.getName());
        planet.setRadius(sectorEntityToken.getRadius());
        if (sectorEntityToken.getFaction() != null) {
            planet.setFactionId(sectorEntityToken.getFaction().getId());
        }
        if (sectorEntityToken.getCustomDescriptionId() != null && !sectorEntityToken.getCustomDescriptionId().isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            Description description = settings.getDescription(sectorEntityToken.getCustomDescriptionId(), Description.Type.CUSTOM);
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
            planet.setCustomDescription(stringBuilder.toString());
        }
        planet.setTags(new ArrayList<>(sectorEntityToken.getTags()));
        if (sectorEntityToken.getOrbitFocus() != null) {
            planet.setOrbitFocusId(sectorEntityToken.getOrbitFocus().getId());
        }
        planet.setStarSystemId(sectorEntityToken.getStarSystem().getId());

        if (sectorEntityToken instanceof PlanetAPI) {
            PlanetAPI planetAPI = (PlanetAPI) sectorEntityToken;
            planet.setTypeId(planetAPI.getTypeId());
            if (planetAPI.getDescriptionIdOverride() != null && !planetAPI.getDescriptionIdOverride().isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                Description description = settings.getDescription(planetAPI.getDescriptionIdOverride(), Description.Type.CUSTOM);
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
                planet.setOverrideDesc(stringBuilder.toString());
            }
        } else {
            planet.setTypeId("STATION");
        }

        if (sectorEntityToken.getMarket() != null) {
            planet.setMarket(new Market(sectorEntityToken.getMarket()));
        }

        planet.setLocation(sectorEntityToken.getLocation());
        planet.setLocationInHyperspace(sectorEntityToken.getLocationInHyperspace());

        return planet;
    }
}
