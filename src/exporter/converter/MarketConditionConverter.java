package exporter.converter;

import com.fs.starfarer.api.characters.MarketConditionSpecAPI;
import exporter.model.MarketCondition;

public class MarketConditionConverter {
    public MarketCondition convert(MarketConditionSpecAPI marketConditionSpecAPI) {
        MarketCondition marketCondition = new MarketCondition();

        marketCondition.setId(marketConditionSpecAPI.getId());
        marketCondition.setJsonType("MARKET_CONDITION");
        marketCondition.setName(marketConditionSpecAPI.getName());
        marketCondition.setDesc(marketConditionSpecAPI.getDesc());
        marketCondition.setIcon(marketConditionSpecAPI.getIcon());
        marketCondition.setScriptClass(marketConditionSpecAPI.getScriptClass());
        marketCondition.setOrder(marketConditionSpecAPI.getOrder());
        marketCondition.setPlanetary(marketConditionSpecAPI.isPlanetary());
        marketCondition.setDecivRemove(marketConditionSpecAPI.isDecivRemove());

        return marketCondition;
    }
}
