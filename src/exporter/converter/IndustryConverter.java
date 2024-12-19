package exporter.converter;

import com.fs.starfarer.api.loading.IndustrySpecAPI;
import exporter.model.Industry;

public class IndustryConverter {
    public Industry convert(IndustrySpecAPI industrySpecAPI) {
        Industry industry = new Industry();

        industry.setId(industrySpecAPI.getId());
        industry.setJsonType("INDUSTRY");
        industry.setPluginClass(industrySpecAPI.getPluginClass());
        industry.setTags(industrySpecAPI.getTags());
        industry.setName(industrySpecAPI.getName());
        industry.setDesc(industrySpecAPI.getDesc());
        industry.setCost(industrySpecAPI.getCost());
        industry.setBuildTime(industrySpecAPI.getBuildTime());
        industry.setUpkeep(industrySpecAPI.getUpkeep());
        industry.setIncome(industrySpecAPI.getIncome());
        industry.setImageName(industrySpecAPI.getImageName());
        industry.setUpgrade(industrySpecAPI.getUpgrade());
        industry.setDowngrade(industrySpecAPI.getDowngrade());
        industry.setOrder(industrySpecAPI.getOrder());
        industry.setData(industrySpecAPI.getData());
        industry.setDisruptDanger(industrySpecAPI.getDisruptDanger().name);

        return industry;
    }
}
