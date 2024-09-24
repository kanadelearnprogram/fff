package entity;

public class Card {
    private String face;
    private String Suits;

    public Card(String face, String suits) {
        this.face = face;
        this.Suits = suits;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getSuits() {
        return Suits;
    }

    public void setSuits(String suits) {
        Suits = suits;
    }

    @Override
    public String toString() {
        return "Card{" +
                "face='" + face + '\'' +
                ", Suits='" + Suits + '\'' +
                '}';
    }
}
