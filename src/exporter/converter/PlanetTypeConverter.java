package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.PlanetSpecAPI;
import com.fs.starfarer.api.loading.Description;
import exporter.model.PlanetType;

public class PlanetTypeConverter {
    public PlanetType convert(PlanetSpecAPI planetSpecAPI) {
        SettingsAPI settings = Global.getSettings();
        Description description = settings.getDescription(planetSpecAPI.getDescriptionId(), Description.Type.PLANET);

        PlanetType planetType = new PlanetType();

        planetType.setId(planetSpecAPI.getPlanetType());
        planetType.setName(planetSpecAPI.getName());
        planetType.setJsonType("PLANET_TYPE");
        planetType.setDescriptionId(planetSpecAPI.getDescriptionId());
        planetType.setDescription("");
        if (description.hasText1()) {
            planetType.setDescription(description.getText1());
        }
        planetType.setTilt(planetSpecAPI.getTilt());
        planetType.setPitch(planetSpecAPI.getPitch());
        planetType.setRotation(planetSpecAPI.getRotation());
        planetType.setAtmosphereThickness(planetSpecAPI.getAtmosphereThickness());
        planetType.setStar(planetSpecAPI.isStar());
        planetType.setAtmosphereThicknessMin(planetSpecAPI.getAtmosphereThicknessMin());
        planetType.setCloudRotation(planetSpecAPI.getCloudRotation());
        planetType.setCoronaSize(planetSpecAPI.getCoronaSize());
        planetType.setCloudTexture(planetSpecAPI.getCloudTexture());
        planetType.setTexture(planetSpecAPI.getTexture());
        planetType.setCoronaTexture(planetSpecAPI.getCoronaTexture());
        planetType.setGlowTexture(planetSpecAPI.getGlowTexture());
        planetType.setUseReverseLightForGlow(planetSpecAPI.isUseReverseLightForGlow());
        planetType.setIconTexture(planetSpecAPI.getIconTexture());
        planetType.setBlackHole(planetSpecAPI.isBlackHole());
        planetType.setNebulaCenter(planetSpecAPI.isNebulaCenter());
        planetType.setScaleMultMapIcon(planetSpecAPI.getScaleMultMapIcon());
        planetType.setScaleMultStarscapeIcon(planetSpecAPI.getScaleMultStarscapeIcon());
        planetType.setStarscapeIcon(planetSpecAPI.getStarscapeIcon());
        planetType.setPulsar(planetSpecAPI.isPulsar());
        planetType.setShieldThickness(planetSpecAPI.getShieldThickness());
        planetType.setShieldTexture(planetSpecAPI.getShieldTexture());
        planetType.setShieldTexture2(planetSpecAPI.getShieldTexture2());
        planetType.setShieldThickness2(planetSpecAPI.getShieldThickness2());
        planetType.setDoNotShowInCombat(planetSpecAPI.isDoNotShowInCombat());
        planetType.setGasGiant(planetSpecAPI.isGasGiant());

        return planetType;
    }
}
