package gr.netmechanics.jmix.tinymce.component;

/**
 * @author Panos Bariamis (pbaris)
 */
public enum TinyMcePlugin implements TinyMceEnum {
    ACCORDION("accordion"),
    ADVANCED_LIST("advlist"),
    ANCHOR("anchor"),
    AUTOLINK("autolink"),
    AUTORESIZE("autoresize"),
    AUTOSAVE("autosave"),
    CHARACTER_MAP("charmap"),
    CODE("code"),
    CODE_SAMPLE("codesample"),
    DIRECTIONALITY("directionality"),
    EMOTICONS("emoticons"),
    FULLSCREEN("fullscreen"),
    HELP("help"),
    IMAGE("image"),
    IMPORT_CSS("importcss"),
    INSERT_DATETIME("insertdatetime"),
    LINK("link"),
    LISTS("lists"),
    MEDIA("media"),
    NON_BREAKING("nonbreaking"),
    PAGE_BREAK("pagebreak"),
    PREVIEW("preview"),
    QUICK_BARS("quickbars"),
    SAVE("save"),
    SEARCH_REPLACE("searchreplace"),
    TABLE("table"),
    TEMPLATE("template"),
    VISUAL_BLOCKS("visualblocks"),
    VISUAL_CHARACTERS("visualchars"),
    WORD_COUNT("wordcount");

    public final String jsName;

    TinyMcePlugin(String jsName) {
        this.jsName = jsName;
    }

    @Override
    public String getJsName() {
        return jsName;
    }
}
