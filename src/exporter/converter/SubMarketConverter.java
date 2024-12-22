package exporter.converter;

import com.fs.starfarer.api.campaign.econ.SubmarketSpecAPI;
import exporter.model.SubMarket;

public class SubMarketConverter {
    public SubMarket convert(SubmarketSpecAPI submarketSpecAPI) {
        SubMarket subMarket = new SubMarket();

        subMarket.setId(submarketSpecAPI.getId());
        subMarket.setJsonType("SUB_MARKET");
        subMarket.setName(submarketSpecAPI.getName());
        subMarket.setDesc(submarketSpecAPI.getName());
        subMarket.setIcon(submarketSpecAPI.getIcon());
        subMarket.setFactionId(subMarket.getFactionId());

        return subMarket;
    }
}
