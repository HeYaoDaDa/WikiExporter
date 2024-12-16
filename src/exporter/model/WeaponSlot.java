package exporter.model;

import com.fs.starfarer.api.loading.WeaponSlotAPI;
import org.lwjgl.util.vector.Vector2f;

public class WeaponSlot {
    private String id;
    private String slotSize;
    private String weaponType;
    private Vector2f location;
    private double angle;

    private boolean weaponSlot;
    private boolean decorative;
    private boolean hidden;
    private boolean builtIn;
    private boolean turret;
    private boolean hardPoint;

    public WeaponSlot(WeaponSlotAPI api) {
        this.id = api.getId();
        this.slotSize = api.getSlotSize().name();
        this.weaponType = api.getWeaponType().name();
        this.location = new Vector2f(-1 * api.getLocation().y, 1 * api.getLocation().x);
        this.angle = api.getAngle();

        this.weaponSlot = api.isWeaponSlot();
        this.decorative = api.isDecorative();
        this.hidden = api.isHidden();
        this.builtIn = api.isBuiltIn();
        this.turret = api.isTurret();
        this.hardPoint = api.isHardpoint();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(String slotSize) {
        this.slotSize = slotSize;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public Vector2f getLocation() {
        return location;
    }

    public void setLocation(Vector2f location) {
        this.location = location;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean isWeaponSlot() {
        return weaponSlot;
    }

    public void setWeaponSlot(boolean weaponSlot) {
        this.weaponSlot = weaponSlot;
    }

    public boolean isDecorative() {
        return decorative;
    }

    public void setDecorative(boolean decorative) {
        this.decorative = decorative;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isBuiltIn() {
        return builtIn;
    }

    public void setBuiltIn(boolean builtIn) {
        this.builtIn = builtIn;
    }

    public boolean isTurret() {
        return turret;
    }

    public void setTurret(boolean turret) {
        this.turret = turret;
    }

    public boolean isHardPoint() {
        return hardPoint;
    }

    public void setHardPoint(boolean hardPoint) {
        this.hardPoint = hardPoint;
    }
}
