package exporter.converter;

import com.fs.starfarer.api.campaign.PlanetAPI;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import exporter.model.StarSystem;

import java.util.ArrayList;

public class StarSystemConverter {
    public StarSystem convert(StarSystemAPI starSystemAPI) {
        StarSystem starSystem = new StarSystem();

        starSystem.setId(starSystemAPI.getId());
        starSystem.setJsonType("START_SYSTEM");
        starSystem.setName(starSystemAPI.getName());
        starSystem.setLocation(starSystemAPI.getLocation());
        starSystem.setType(starSystemAPI.getType().name());

        if (starSystemAPI.isInConstellation()) {
            starSystem.setConstellationId(starSystemAPI.getConstellation().getName());
        }
        ArrayList<String> planetIds = new ArrayList<>();
        for (PlanetAPI planet : starSystemAPI.getPlanets()) {
            planetIds.add(planet.getId());
        }
        starSystem.setPlanetIds(planetIds);

        starSystem.setStarId(starSystemAPI.getStar().getId());
        if (starSystemAPI.getSecondary() != null) {
            starSystem.setSecondaryId(starSystemAPI.getSecondary().getId());
        }
        if (starSystemAPI.getTertiary() != null) {
            starSystem.setTertiaryId(starSystemAPI.getTertiary().getId());
        }

        starSystem.setProcgen(starSystemAPI.isProcgen());

        return starSystem;
    }
}
