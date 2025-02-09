class IdentityMaskSuit extends SuitType {
    public boolean isDurabilityValid(int durability) {
        return !(durability % 10 == 3 || durability % 10 == 7);
    }
}