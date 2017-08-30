package utils;

/**
 * Holder for popular domains.
 *
 */
public enum Domains {
    COM(".com"),
    EU(".eu"),
    NET(".net"),
    ORG(".org"),
    BIZ(".biz"),
    INFO(".info"),
    US(".us"),
    NL(".nl");

    private String extension;

    Domains(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return this.extension;
    }
}
