package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.combat.ShipAPI;
import com.fs.starfarer.api.combat.WeaponAPI;
import com.fs.starfarer.api.loading.Description;
import com.fs.starfarer.api.loading.ProjectileSpecAPI;
import com.fs.starfarer.api.loading.WeaponSpecAPI;
import exporter.model.Weapon;
import exporter.utils.JsonUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WeaponConverter {
    private static final Logger logger = Global.getLogger(ShipModConverter.class);
    private final ShipAPI playerShip;
    private final Map<String, JSONObject> csvObjectMap = new HashMap<>();

    public WeaponConverter() throws JSONException, IOException {
        this.playerShip = Global.getCombatEngine().getPlayerShip();

        JSONArray csvArray = Global.getSettings().loadCSV("data/weapons/weapon_data.csv", true);
        for (int i = 0; i < csvArray.length(); i++) {
            JSONObject csvObject = csvArray.getJSONObject(i);
            String id = csvObject.getString("id");
            if (id != null && !id.isEmpty()) {
                this.csvObjectMap.put(id, csvObject);
            }
        }
    }

    public Weapon convert(WeaponSpecAPI weaponSpecAPI) throws JSONException {
        SettingsAPI settings = Global.getSettings();
        WeaponAPI.DerivedWeaponStatsAPI derivedStats = weaponSpecAPI.getDerivedStats();
        String id = weaponSpecAPI.getWeaponId();
        JSONObject csvObject = csvObjectMap.get(id);
        Description description = settings.getDescription(id, Description.Type.WEAPON);

        Weapon weapon = new Weapon();
        weapon.setId(id);
        weapon.setName(weaponSpecAPI.getWeaponName());
        weapon.setDescription("");
        if (description.hasText1()) {
            weapon.setDescription(description.getText1());
        }
        if (description.hasText2()) {
            weapon.setDescription(weapon.getDescription() + "\n" + description.getText2());
        }
        weapon.setCustomPrimary(weaponSpecAPI.getCustomPrimary());
        weapon.setTurretSprite(weaponSpecAPI.getTurretSpriteName());
        weapon.setHardPointSprite(weaponSpecAPI.getHardpointSpriteName());

        weapon.setPrimaryRoleStr(weaponSpecAPI.getPrimaryRoleStr());
        weapon.setSize(weaponSpecAPI.getSize().getDisplayName());
        weapon.setMountType(weaponSpecAPI.getMountType().getDisplayName());
        weapon.setOrdnancePoint(JsonUtils.getDouble(csvObject, "OPs", 0));

        weapon.setMaxRange(weaponSpecAPI.getMaxRange());
        weapon.setDamagePerShot(derivedStats.getDamagePerShot());
        weapon.setDamagePerSecond(derivedStats.getDamageOver30Sec());
        weapon.setEmpPerShot(derivedStats.getEmpPerShot());
        weapon.setEmpPerSecond(derivedStats.getEmpPerSecond());

        weapon.setFluxPerSecond(derivedStats.getFluxPerSecond());
        weapon.setSustainedFluxPerSecond(derivedStats.getSustainedFluxPerSecond());
        weapon.setDps(derivedStats.getDps());
        weapon.setSustainedDps(derivedStats.getSustainedDps());
        weapon.setFluxPerDamage(derivedStats.getFluxPerDam());

        weapon.setCustomAncillary(weaponSpecAPI.getCustomAncillary());
        weapon.setDamageType(weaponSpecAPI.getDamageType());
        if (weaponSpecAPI.getProjectileSpec() instanceof ProjectileSpecAPI) {
            weapon.setSoftFlux(((ProjectileSpecAPI) weaponSpecAPI.getProjectileSpec()).getDamage().isSoftFlux());
        } else {
            weapon.setSoftFlux(true);
        }
        weapon.setAccuracyStr(weaponSpecAPI.getAccuracyStr());
        weapon.setTurnRate(weaponSpecAPI.getTurnRate());
        WeaponAPI fakeWeapon = Global.getCombatEngine().createFakeWeapon(playerShip, id);
        weapon.setReFireDelay(fakeWeapon.getRefireDelay());

        return weapon;
    }
}
