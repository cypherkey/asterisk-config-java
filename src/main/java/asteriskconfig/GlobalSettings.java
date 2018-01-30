package asteriskconfig;

public class GlobalSettings {
    private static GlobalSettings settings = new GlobalSettings();
    private String eol = "\n";
    private String inlineCommentPrefix = "\t\t";
    private String commentChar = ";";

    private GlobalSettings() {

    }

    public static GlobalSettings getInstance() {
        if (settings == null) {
            settings = new GlobalSettings();
        }
        return settings;
    }

    public String getEol() {
        return eol;
    }

    public void setEol(String eol) {
        this.eol = eol;
    }

    public String getInlineCommentPrefix() {
        return inlineCommentPrefix;
    }

    public void setInlineCommentPrefix(String commentPrefix) {
        this.inlineCommentPrefix = commentPrefix;
    }

    public String getCommentChar() {
        return commentChar;
    }
}
