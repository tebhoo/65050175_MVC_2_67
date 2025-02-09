class Suit {
    private int id;
    private String type;
    private int durability;

    public Suit(int id, String type, int durability) {
        this.id = id;
        this.type = type;
        this.durability = durability;
    }

    public String getInfo() { return "Suit ID : " + id + " Type : " + type + " Durability : " + durability ;}
    public int getId() { return id; }
    public String getType() { return type; }
    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }
}
