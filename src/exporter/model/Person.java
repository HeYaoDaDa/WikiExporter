package exporter.model;

import java.util.List;

public class Person {
    private String id;
    private String jsonType;

    private String firstName;
    private String lastName;
    private String gender;

    private String rankId;
    private String rank;
    private String rankArticle;

    private String postId;
    private String post;
    private String postArticle;

    private String portraitSprite;

    private String factionId;

    private double importance;
    private double contactWeight;
    private List<String> tags;
    private String marketId;
    private boolean aiCore;
    private boolean defaults;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonType() {
        return jsonType;
    }

    public void setJsonType(String jsonType) {
        this.jsonType = jsonType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRankArticle() {
        return rankArticle;
    }

    public void setRankArticle(String rankArticle) {
        this.rankArticle = rankArticle;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostArticle() {
        return postArticle;
    }

    public void setPostArticle(String postArticle) {
        this.postArticle = postArticle;
    }

    public String getPortraitSprite() {
        return portraitSprite;
    }

    public void setPortraitSprite(String portraitSprite) {
        this.portraitSprite = portraitSprite;
    }

    public String getFactionId() {
        return factionId;
    }

    public void setFactionId(String factionId) {
        this.factionId = factionId;
    }

    public double getImportance() {
        return importance;
    }

    public void setImportance(double importance) {
        this.importance = importance;
    }

    public double getContactWeight() {
        return contactWeight;
    }

    public void setContactWeight(double contactWeight) {
        this.contactWeight = contactWeight;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public boolean isAiCore() {
        return aiCore;
    }

    public void setAiCore(boolean aiCore) {
        this.aiCore = aiCore;
    }

    public boolean isDefaults() {
        return defaults;
    }

    public void setDefaults(boolean defaults) {
        this.defaults = defaults;
    }
}
