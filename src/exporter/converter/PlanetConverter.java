package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.loading.Description;
import exporter.model.Market;
import exporter.model.Planet;

import java.util.ArrayList;

public class PlanetConverter {
    public Planet convert(PlanetAPI planetAPI) {
        SettingsAPI settings = Global.getSettings();

        Planet planet = new Planet();

        planet.setId(planetAPI.getId());
        planet.setJsonType("PLANET");
        planet.setName(planetAPI.getName());
        planet.setRadius(planetAPI.getRadius());
        if (planetAPI.getFaction() != null) {
            planet.setFactionId(planetAPI.getFaction().getId());
        }
        if (planetAPI.getCustomDescriptionId() != null && !planetAPI.getCustomDescriptionId().isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            Description description = settings.getDescription(planetAPI.getCustomDescriptionId(), Description.Type.CUSTOM);
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
        planet.setTags(new ArrayList<>(planetAPI.getTags()));
        if (planetAPI.getOrbitFocus() != null) {
            planet.setOrbitFocusId(planetAPI.getOrbitFocus().getId());
        }
        planet.setStarSystemId(planetAPI.getStarSystem().getId());

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

        if (planetAPI.getMarket() != null) {
            planet.setMarket(new Market(planetAPI.getMarket()));
        }

        return planet;
    }
}
