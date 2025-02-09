class StealthSuit extends SuitType {
    public boolean isDurabilityValid(int durability) {
        return durability >= 50;
    }
}