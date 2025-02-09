class Suit {
    private int id;
    private String type;
    private int durability;
    private SuitType suitType;

    public Suit(int id, String type, int durability) {
        this.id = id;
        this.type = type;
        this.durability = durability;
        switch (type.toLowerCase()) {
            case "power": this.suitType = new PowerSuit(); break;
            case "stealth": this.suitType = new StealthSuit(); break;
            case "identitymask": this.suitType = new IdentityMaskSuit(); break;
            default: throw new IllegalArgumentException("Unknown suit type: " + type);
        }
    }

    public String getInfo() { return "Suit ID : " + id + " Type : " + type + " Durability : " + durability ;}
    public int getId() { return id; }
    public String getType() { return type; }
    public int getDurability() { return durability; }
    public void setDurability(int durability) { this.durability = durability; }

    //เช็คความทนทาน
    public boolean isDurabilityValid() { return suitType.isDurabilityValid(durability); }
}
