package exporter.converter;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.SettingsAPI;
import com.fs.starfarer.api.campaign.econ.CommoditySpecAPI;
import com.fs.starfarer.api.loading.Description;
import exporter.model.Commodity;

public class CommodityConverter {
    public Commodity convert(CommoditySpecAPI commoditySpecAPI) {
        SettingsAPI settings = Global.getSettings();
        String id = commoditySpecAPI.getId();
        Description description = settings.getDescription(id, Description.Type.RESOURCE);

        Commodity commodity = new Commodity();

        commodity.setId(id);
        commodity.setJsonType("COMMODITY");
        commodity.setName(commoditySpecAPI.getName());
        commodity.setDescription("");
        if (description.hasText1()) {
            commodity.setDescription(description.getText1());
        }
        commodity.setIconName(commoditySpecAPI.getIconName());

        commodity.setStackSize(commoditySpecAPI.getStackSize());
        commodity.setOrder(commoditySpecAPI.getOrder());
        commodity.setCargoSpace(commoditySpecAPI.getCargoSpace());
        commodity.setBasePrice(commoditySpecAPI.getBasePrice());
        commodity.setUtility(commoditySpecAPI.getUtility());

        commodity.setDemandClass(commoditySpecAPI.getDemandClass());

        commodity.setEconomyTier(commoditySpecAPI.getEconomyTier());
        commodity.setEconUnit(commoditySpecAPI.getEconUnit());
        commodity.setIconWidthMult(commoditySpecAPI.getIconWidthMult());
        commodity.setExportValue(commoditySpecAPI.getExportValue());

        commodity.setPrimary(commoditySpecAPI.isPrimary());
        commodity.setExotic(commoditySpecAPI.isExotic());
        commodity.setMeta(commoditySpecAPI.isMeta());
        commodity.setNonEcon(commoditySpecAPI.isNonEcon());
        commodity.setPersonnel(commoditySpecAPI.isPersonnel());
        commodity.setFuel(commoditySpecAPI.isFuel());
        commodity.setSupplies(commoditySpecAPI.isSupplies());
        commodity.setPriceVariability(commoditySpecAPI.getPriceVariability().v);
        commodity.setBaseDanger(commoditySpecAPI.getBaseDanger().name);

        return commodity;
    }
}
