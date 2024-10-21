package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.combat.HullModEffect;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.loading.HullModSpecAPI;
import exporter.model.ShipMod;
import org.apache.log4j.Logger;

public class ShipModConverter {
    private static final Logger logger = Global.getLogger(ShipModConverter.class);
    private final ShipAPI playerShip;

    public ShipModConverter() {
        this.playerShip = Global.getCombatEngine().getPlayerShip();
    }

    public ShipMod convert(HullModSpecAPI hullModSpecAPI) {
        HullModEffect effect = hullModSpecAPI.getEffect();
        MutableShipStatsAPI mutableShipStatsAPI = this.playerShip.getMutableStats();
        String id = hullModSpecAPI.getId();

        ShipMod shipMod = new ShipMod();
        shipMod.setId(id);
        shipMod.setJsonType("SHIP_MOD");
        shipMod.setName(hullModSpecAPI.getDisplayName());
        shipMod.setIcon(hullModSpecAPI.getSpriteName());

        shipMod.setHaveSModEffect(effect.isSModEffectAPenalty());
        shipMod.setAlwaysUnlocked(hullModSpecAPI.isAlwaysUnlocked());
        shipMod.setHidden(hullModSpecAPI.isHidden());//一般不可见
        shipMod.setHiddenEverywhere(hullModSpecAPI.isHiddenEverywhere());//所有地方都不可见

        shipMod.setFrigateCost(hullModSpecAPI.getFrigateCost());
        shipMod.setDestroyerCost(hullModSpecAPI.getDestroyerCost());
        shipMod.setCruiserCost(hullModSpecAPI.getCruiserCost());
        shipMod.setCapitalCost(hullModSpecAPI.getCapitalCost());

        for (ShipAPI.HullSize hullSize : ShipAPI.HullSize.values()) {
            if (!ShipAPI.HullSize.DEFAULT.equals(hullSize) && !ShipAPI.HullSize.FIGHTER.equals(hullSize)) {
                hullModSpecAPI.getEffect().applyEffectsBeforeShipCreation(hullSize, mutableShipStatsAPI, "export");
                hullModSpecAPI.getEffect().applyEffectsAfterShipCreation(playerShip, "export");
                switch (hullSize) {
                    case FRIGATE:
                        shipMod.setFrigateDescription(hullModSpecAPI.getDescription(hullSize));
                        if (shipMod.isHaveSModEffect()) {
                            shipMod.setFrigateSDescription(hullModSpecAPI.getSModDescription(hullSize));
                        }
                        break;
                    case DESTROYER:
                        shipMod.setDestroyerDescription(hullModSpecAPI.getDescription(hullSize));
                        if (shipMod.isHaveSModEffect()) {
                            shipMod.setDestroyerSDescription(hullModSpecAPI.getSModDescription(hullSize));
                        }
                        break;
                    case CRUISER:
                        shipMod.setCruiserDescription(hullModSpecAPI.getDescription(hullSize));
                        if (shipMod.isHaveSModEffect()) {
                            shipMod.setCruiserSDescription(hullModSpecAPI.getSModDescription(hullSize));
                        }
                        break;
                    case CAPITAL_SHIP:
                        shipMod.setCapitalDescription(hullModSpecAPI.getDescription(hullSize));
                        if (shipMod.isHaveSModEffect()) {
                            shipMod.setCapitalSDescription(hullModSpecAPI.getSModDescription(hullSize));
                        }
                        break;
                }
            }
        }
        shipMod.setDescription(shipMod.getCapitalDescription());

        shipMod.setTags(hullModSpecAPI.getTags());
        shipMod.setUiTags(hullModSpecAPI.getUITags());

        return shipMod;
    }
}
