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

        shipSystem.setFluxPerSecond(shipSystemSpecAPI.getFluxPerSecond());
        shipSystem.setFluxPerSecondBaseRate(shipSystemSpecAPI.getFluxPerSecondBaseRate());
        shipSystem.setFluxPerSecondBaseCap(shipSystemSpecAPI.getFluxPerSecondBaseCap());
        shipSystem.setFluxPerUse(shipSystemSpecAPI.getFluxPerUse());
        shipSystem.setFluxPerUseBaseRate(shipSystemSpecAPI.getFluxPerUseBaseRate());
        shipSystem.setFluxPerUseBaseCap(shipSystemSpecAPI.getFluxPerUseBaseCap());
        shipSystem.setCrPerUse(shipSystemSpecAPI.getCrPerUse());
        shipSystem.setMaxUses(shipSystemSpecAPI.getMaxUses(null));//混淆里面的代码可以直接送Null
        shipSystem.setRegen(shipSystemSpecAPI.getRegen(null));
        shipSystem.setChargeUp(shipSystemSpecAPI.getIn());//实际是in
        shipSystem.setActive(shipSystemSpecAPI.getActive());
        shipSystem.setDown(shipSystemSpecAPI.getOut());//和Out
        shipSystem.setCooldown(shipSystemSpecAPI.getCooldown(null));
        shipSystem.setToggle(shipSystemSpecAPI.isToggle());
        shipSystem.setNoDissipation(!shipSystemSpecAPI.isDissipationAllowed());//看是不是和文件是反的 用no更简单
        shipSystem.setNoHardDissipation(!shipSystemSpecAPI.isHardDissipationAllowed());
        shipSystem.setHardFlux(shipSystemSpecAPI.generatesHardFlux());
        shipSystem.setNoFiring(!shipSystemSpecAPI.isFiringAllowed());
        shipSystem.setNoTurning(!shipSystemSpecAPI.isTurningAllowed());
        shipSystem.setNoStrafing(!shipSystemSpecAPI.isStrafeAllowed());
        shipSystem.setNoAccel(!shipSystemSpecAPI.isAccelerateAllowed());
        shipSystem.setNoShield(!shipSystemSpecAPI.isShieldAllowed());
        shipSystem.setNoVent(!shipSystemSpecAPI.isVentingAllowed());
        shipSystem.setPhaseCloak(shipSystemSpecAPI.isPhaseCloak());
        shipSystem.setTags(shipSystemSpecAPI.getTags());


        return shipSystem;
    }
}
