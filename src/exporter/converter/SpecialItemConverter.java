package exporter.converter;

import com.fs.starfarer.api.campaign.SpecialItemSpecAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.salvage.MarketCMD;
import exporter.model.SpecialItem;

import java.util.Set;

public class SpecialItemConverter {
    public SpecialItem convert(SpecialItemSpecAPI api){
        SpecialItem specialItem = new SpecialItem();

        specialItem.setId(api.getId());
        specialItem.setJsonType("SPECIAL_ITEM");
        specialItem.setName(api.getName());
        specialItem.setDesc(api.getDesc());
        specialItem.setDescFirstPara(api.getDescFirstPara());
        specialItem.setIconName(api.getIconName());

        specialItem.setTags(api.getTags());
        specialItem.setParams(api.getParams());
        specialItem.setBaseDanger(api.getBaseDanger().name);
        specialItem.setManufacturer(api.getManufacturer());

        specialItem.setStackSize(api.getStackSize());
        specialItem.setOrder(api.getOrder());
        specialItem.setCargoSpace(api.getCargoSpace());
        specialItem.setBasePrice(api.getBasePrice());
        specialItem.setRarity(api.getRarity());

        return specialItem;
    }
}
