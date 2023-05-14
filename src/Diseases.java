public enum Diseases {
    HEADACHE(1),
    BLEEDING(2),
    BROKENARM(3),
    UNCONSCIOUS(4);

    private int danger;

    Diseases(int danger) {
        this.danger = danger;
    }

    public int getDanger() {
        return danger;
    }

}
