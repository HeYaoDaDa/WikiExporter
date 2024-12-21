package exporter.model;

public class PlanetType {
    private String id;
    private String name;
    private String jsonType;
    private String descriptionId;
    private String description;
    private float tilt;
    private float pitch;
    private float rotation;
    private float atmosphereThickness;
    private boolean star;
    private float atmosphereThicknessMin;
    private float cloudRotation;
    private float coronaSize;
    private String cloudTexture;
    private String texture;
    private String coronaTexture;
    private String glowTexture;
    private boolean useReverseLightForGlow;
    private String iconTexture;
    private boolean blackHole;
    private boolean nebulaCenter;
    private float scaleMultMapIcon;
    private float scaleMultStarscapeIcon;
    private String starscapeIcon;
    private boolean pulsar;
    private float shieldThickness;
    private String shieldTexture;
    private String shieldTexture2;
    private float shieldThickness2;
    private boolean doNotShowInCombat;
    private boolean gasGiant;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJsonType() {
        return jsonType;
    }

    public void setJsonType(String jsonType) {
        this.jsonType = jsonType;
    }

    public String getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(String descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getTilt() {
        return tilt;
    }

    public void setTilt(float tilt) {
        this.tilt = tilt;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getAtmosphereThickness() {
        return atmosphereThickness;
    }

    public void setAtmosphereThickness(float atmosphereThickness) {
        this.atmosphereThickness = atmosphereThickness;
    }

    public boolean isStar() {
        return star;
    }

    public void setStar(boolean star) {
        this.star = star;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getAtmosphereThicknessMin() {
        return atmosphereThicknessMin;
    }

    public void setAtmosphereThicknessMin(float atmosphereThicknessMin) {
        this.atmosphereThicknessMin = atmosphereThicknessMin;
    }

    public float getCloudRotation() {
        return cloudRotation;
    }

    public void setCloudRotation(float cloudRotation) {
        this.cloudRotation = cloudRotation;
    }

    public float getCoronaSize() {
        return coronaSize;
    }

    public void setCoronaSize(float coronaSize) {
        this.coronaSize = coronaSize;
    }

    public String getCloudTexture() {
        return cloudTexture;
    }

    public void setCloudTexture(String cloudTexture) {
        this.cloudTexture = cloudTexture;
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String getCoronaTexture() {
        return coronaTexture;
    }

    public void setCoronaTexture(String coronaTexture) {
        this.coronaTexture = coronaTexture;
    }

    public String getGlowTexture() {
        return glowTexture;
    }

    public void setGlowTexture(String glowTexture) {
        this.glowTexture = glowTexture;
    }

    public boolean isUseReverseLightForGlow() {
        return useReverseLightForGlow;
    }

    public void setUseReverseLightForGlow(boolean useReverseLightForGlow) {
        this.useReverseLightForGlow = useReverseLightForGlow;
    }

    public String getIconTexture() {
        return iconTexture;
    }

    public void setIconTexture(String iconTexture) {
        this.iconTexture = iconTexture;
    }

    public boolean isBlackHole() {
        return blackHole;
    }

    public void setBlackHole(boolean blackHole) {
        this.blackHole = blackHole;
    }

    public boolean isNebulaCenter() {
        return nebulaCenter;
    }

    public void setNebulaCenter(boolean nebulaCenter) {
        this.nebulaCenter = nebulaCenter;
    }

    public float getScaleMultMapIcon() {
        return scaleMultMapIcon;
    }

    public void setScaleMultMapIcon(float scaleMultMapIcon) {
        this.scaleMultMapIcon = scaleMultMapIcon;
    }

    public float getScaleMultStarscapeIcon() {
        return scaleMultStarscapeIcon;
    }

    public void setScaleMultStarscapeIcon(float scaleMultStarscapeIcon) {
        this.scaleMultStarscapeIcon = scaleMultStarscapeIcon;
    }

    public String getStarscapeIcon() {
        return starscapeIcon;
    }

    public void setStarscapeIcon(String starscapeIcon) {
        this.starscapeIcon = starscapeIcon;
    }

    public boolean isPulsar() {
        return pulsar;
    }

    public void setPulsar(boolean pulsar) {
        this.pulsar = pulsar;
    }

    public float getShieldThickness() {
        return shieldThickness;
    }

    public void setShieldThickness(float shieldThickness) {
        this.shieldThickness = shieldThickness;
    }

    public String getShieldTexture() {
        return shieldTexture;
    }

    public void setShieldTexture(String shieldTexture) {
        this.shieldTexture = shieldTexture;
    }

    public String getShieldTexture2() {
        return shieldTexture2;
    }

    public void setShieldTexture2(String shieldTexture2) {
        this.shieldTexture2 = shieldTexture2;
    }

    public float getShieldThickness2() {
        return shieldThickness2;
    }

    public void setShieldThickness2(float shieldThickness2) {
        this.shieldThickness2 = shieldThickness2;
    }

    public boolean isDoNotShowInCombat() {
        return doNotShowInCombat;
    }

    public void setDoNotShowInCombat(boolean doNotShowInCombat) {
        this.doNotShowInCombat = doNotShowInCombat;
    }

    public boolean isGasGiant() {
        return gasGiant;
    }

    public void setGasGiant(boolean gasGiant) {
        this.gasGiant = gasGiant;
    }
}
