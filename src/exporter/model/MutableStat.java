package exporter.model;

import com.fs.starfarer.api.combat.StatBonus;

public class MutableStat {
    private double baseValue;
    private double modifiedValue;

    public MutableStat(com.fs.starfarer.api.combat.MutableStat mutableStat) {
        this.baseValue = mutableStat.getBaseValue();
        this.modifiedValue = mutableStat.getModifiedValue();
    }

    public MutableStat(double baseValue, StatBonus statBonus) {
        com.fs.starfarer.api.combat.MutableStat mutableStat = new com.fs.starfarer.api.combat.MutableStat((float) baseValue);
        mutableStat.applyMods(statBonus);
        this.baseValue = baseValue;
        this.modifiedValue = mutableStat.getModifiedValue();
    }

    public double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(double baseValue) {
        this.baseValue = baseValue;
    }

    public double getModifiedValue() {
        return modifiedValue;
    }

    public void setModifiedValue(double modifiedValue) {
        this.modifiedValue = modifiedValue;
    }
}
