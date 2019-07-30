package enumTest;

public enum Danli {
    INSTANCE;
    private String content;
    Danli() {
         content="枚举";
    }

    public String getContent() {
        return content;
    }
}
