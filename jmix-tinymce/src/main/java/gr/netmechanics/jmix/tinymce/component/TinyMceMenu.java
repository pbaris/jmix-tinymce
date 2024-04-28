package gr.netmechanics.jmix.tinymce.component;

/**
 * @author Panos Bariamis (pbaris)
 */
public enum TinyMceMenu implements TinyMceEnum {
    FILE("file"),
    EDIT("edit"),
    VIEW("view"),
    INSERT("insert"),
    FORMAT("format"),
    TOOLS("tools"),
    TABLE("table"),
    HELP("help");

    public final String jsName;

    TinyMceMenu(String jsName) {
        this.jsName = jsName;
    }

    @Override
    public String getJsName() {
        return jsName;
    }
}
