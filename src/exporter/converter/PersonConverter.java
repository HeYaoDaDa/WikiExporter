package exporter.converter;

import com.fs.starfarer.api.characters.PersonAPI;
import exporter.model.Person;

import java.util.ArrayList;

public class PersonConverter {
    public Person convert(PersonAPI personAPI) {
        Person person = new Person();

        person.setId(personAPI.getId());
        person.setJsonType("PERSON");

        person.setFirstName(personAPI.getName().getFirst());
        person.setLastName(personAPI.getName().getLast());
        person.setGender(personAPI.getGender().name());

        person.setRankId(personAPI.getRankId());
        person.setRank(personAPI.getRank());
        person.setRankArticle(personAPI.getRankArticle());

        person.setPostId(personAPI.getPostId());
        person.setPost(personAPI.getPost());
        person.setPostArticle(personAPI.getPostArticle());

        person.setPortraitSprite(personAPI.getPortraitSprite());

        person.setFactionId(personAPI.getFaction().getId());

        person.setImportance(personAPI.getImportance().getValue());
        person.setContactWeight(personAPI.getContactWeight());
        person.setTags(new ArrayList<>(personAPI.getTags()));

        person.setMarketId(personAPI.getMarket().getId());
        person.setAiCore(personAPI.isAICore());
        person.setDefaults(personAPI.isDefault());

        return person;
    }
}
