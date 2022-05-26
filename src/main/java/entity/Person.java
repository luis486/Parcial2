package entity;

public class Person {

    private int id;
    private String president;
    private String vicepresident;
    private String presidentImage;
    private String vicepresidentImage;
    private String groupImage;
    private int amountVotes;

    public Person(int id, String president, String vicepresident, String presidentImage, String vicepresidentImage, String groupImage, int amountVotes) {
        this.id = id;
        this.president = president;
        this.vicepresident = vicepresident;
        this.presidentImage = presidentImage;
        this.vicepresidentImage = vicepresidentImage;
        this.groupImage = groupImage;
        this.amountVotes=amountVotes;
    }
    public Person() { }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPresident() {
        return president;
    }
    public void setPresident(String president) {
        this.president = president;
    }
    public String getVicepresident() {
        return vicepresident;
    }
    public void setVicepresident(String vicepresident) {
        this.vicepresident = vicepresident;
    }
    public String getPresidentImage() {
        return presidentImage;
    }
    public void setPresidentImage(String presidentImage) {
        this.presidentImage = presidentImage;
    }
    public String getVicepresidentImage() {
        return vicepresidentImage;
    }
    public void setVicepresidentImage(String vicepresidentImage) {
        this.vicepresidentImage = vicepresidentImage;
    }
    public String getGroupImage() {
        return groupImage;
    }
    public void setGroupImage(String groupImage) {
        this.groupImage = groupImage;
    }
    public int getAmountVotes() {
        return amountVotes;
    }
    public void setAmountVotes(int amountVotes) {this.amountVotes = amountVotes;}
}
