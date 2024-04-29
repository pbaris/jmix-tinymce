package gr.netmechanics.jmix.tinymce.component;

/**
 * @author Panos Bariamis (pbaris)
 */
public enum TinyMceButton implements TinyMceEnum {
    SEPARATOR("|", null),
    NEW_TOOLBAR("+", null),

    ACCORDION("accordion", TinyMcePlugin.ACCORDION),
    ACCORDION_TOGGLE("accordiontoggle", TinyMcePlugin.ACCORDION),
    ACCORDION_REMOVE("accordionremove", TinyMcePlugin.ACCORDION),
    ALIGN_CENTER("aligncenter", null),
    ALIGN_JUSTIFY("alignjustify", null),
    ALIGN_LEFT("alignleft", null),
    ALIGN_NONE("alignnone", null),
    ALIGN_RIGHT("alignright", null),
    ANCHOR("anchor", TinyMcePlugin.ANCHOR),
    BACKCOLOR("backcolor", null),
    BLOCKQUOTE("blockquote", null),
    BLOCKS("blocks", null),
    BOLD("bold", null),
    BULLETS_LIST("bullist", TinyMcePlugin.LISTS),
    CANCEL("cancel", TinyMcePlugin.SAVE),
    CHARACTER_MAP("charmap", TinyMcePlugin.CHARACTER_MAP),
    COPY("copy", null),
    CODE("code", TinyMcePlugin.CODE),
    CODE_SAMPLE("codesample", TinyMcePlugin.CODE_SAMPLE),
    CUT("cut", null),
    EMOTICONS("emoticons", TinyMcePlugin.EMOTICONS),
    FONT_FAMILY("fontfamily", null),
    FONT_SIZE("fontsize", null),
    FONT_SIZE_INPUT("fontsizeinput", null),
    FORECOLOR("forecolor", null),
    FULLSCREEN("fullscreen", TinyMcePlugin.FULLSCREEN),
    H1("h1", null),
    H2("h2", null),
    H3("h3", null),
    H4("h4", null),
    H5("h5", null),
    H6("h6", null),
    HELP("help", TinyMcePlugin.HELP),
    HR("hr", null),
    IMAGE("image", TinyMcePlugin.IMAGE),
    INDENT("indent", null),
    INSERT_DATETIME("insertdatetime", TinyMcePlugin.INSERT_DATETIME),
    LINK("link", TinyMcePlugin.LINK),
    ITALIC("italic", null),
    LANGUAGE("language", null),
    LINE_HEIGHT("lineheight", null),
    LTR("ltr", TinyMcePlugin.DIRECTIONALITY),
    MEDIA("media", TinyMcePlugin.MEDIA),
    NEW_DOCUMENT("newdocument", null),
    NON_BREAKING("nonbreaking", TinyMcePlugin.NON_BREAKING),
    NUMBERS_LIST("numlist", TinyMcePlugin.LISTS),
    OPEN_LINK("openlink", TinyMcePlugin.LINK),
    OUTDENT("outdent", null),
    PAGE_BREAK("pagebreak", TinyMcePlugin.PAGE_BREAK),
    PASTE("paste", null),
    PASTE_TEXT("pastetext", null),
    PREVIEW("preview", TinyMcePlugin.PREVIEW),
    PRINT("print", null),
    QUICK_IMAGE("quickimage", TinyMcePlugin.QUICK_BARS),
    QUICK_LINK("quicklink", TinyMcePlugin.QUICK_BARS),
    QUICK_TABLE("quicktable", TinyMcePlugin.QUICK_BARS),
    REDO("redo", null),
    REMOVE("remove", null),
    REMOVE_FORMAT("removeformat", null),
    RESTORE_DRAFT("restoredraft", TinyMcePlugin.AUTOSAVE),
    SAVE("save", TinyMcePlugin.SAVE),
    SELECT_ALL("selectall", null),
    SEARCH_REPLACE("searchreplace", TinyMcePlugin.SEARCH_REPLACE),
    RTL("rtl", TinyMcePlugin.DIRECTIONALITY),
    STRIKETHROUGH("strikethrough", null),
    STYLES("styles", null),
    SUBSCRIPT("subscript", null),
    SUPERSCRIPT("superscript", null),
    TABLE("table", TinyMcePlugin.TABLE),
    TABLE_CELL_PROPERTIES("tablecellprops", TinyMcePlugin.TABLE),
    TABLE_COPY_ROW("tablecopyrow", TinyMcePlugin.TABLE),
    TABLE_CUT_ROW("tablecutrow", TinyMcePlugin.TABLE),
    TABLE_DELETE("tabledelete", TinyMcePlugin.TABLE),
    TABLE_DELETE_COL("tabledeletecol", TinyMcePlugin.TABLE),
    TABLE_DELETE_ROW("tabledeleterow", TinyMcePlugin.TABLE),
    TABLE_INSERT_DIALOG("tableinsertdialog", TinyMcePlugin.TABLE),
    TABLE_INSERT_COL_AFTER("tableinsertcolafter", TinyMcePlugin.TABLE),
    TABLE_INSERT_COL_BEFORE("tableinsertcolbefore", TinyMcePlugin.TABLE),
    TABLE_INSERT_ROW_AFTER("tableinsertrowafter", TinyMcePlugin.TABLE),
    TABLE_INSERT_ROW_BEFORE("tableinsertrowbefore", TinyMcePlugin.TABLE),
    TABLE_MERGE_CELLS("tablemergecells", TinyMcePlugin.TABLE),
    TABLE_PASTE_ROW_AFTER("tablepasterowafter", TinyMcePlugin.TABLE),
    TABLE_PASTE_ROW_BEFORE("tablepasterowbefore", TinyMcePlugin.TABLE),
    TABLE_PROPERTIES("tableprops", TinyMcePlugin.TABLE),
    TABLE_ROW_PROPERTIES("tablerowprops", TinyMcePlugin.TABLE),
    TABLE_SPLIT_CELLS("tablesplitcells", TinyMcePlugin.TABLE),
    TABLE_CLASS("tableclass", TinyMcePlugin.TABLE),
    TABLE_CELL_CLASS("tablecellclass", TinyMcePlugin.TABLE),
    TABLE_CELL_VALIGN("tablecellvalign", TinyMcePlugin.TABLE),
    TABLE_CELL_BORDER_WIDTH("tablecellborderwidth", TinyMcePlugin.TABLE),
    TABLE_CELL_BORDER_STYLE("tablecellborderstyle", TinyMcePlugin.TABLE),
    TABLE_CAPTION("tablecaption", TinyMcePlugin.TABLE),
    TABLE_CELL_BACKCOLOR("tablecellbackgroundcolor", TinyMcePlugin.TABLE),
    TABLE_CELL_BORDER_COLOR("tablecellbordercolor", TinyMcePlugin.TABLE),
    TABLE_ROW_HEADER("tablerowheader", TinyMcePlugin.TABLE),
    TABLE_COL_HEADER("tablecolheader", TinyMcePlugin.TABLE),
    TEMPLATE("template", TinyMcePlugin.TEMPLATE),
    UNDERLINE("underline", null),
    UNDO("undo", null),
    UNLINK("unlink", TinyMcePlugin.LINK),
    VISUAL_AID("visualaid", null),
    VISUAL_BLOCKS("visualblocks", TinyMcePlugin.VISUAL_BLOCKS),
    VISUAL_CHARACTERS("visualchars", TinyMcePlugin.VISUAL_CHARACTERS),
    WORD_COUNT("wordcount", TinyMcePlugin.WORD_COUNT);

    public final String jsName;
    public final TinyMcePlugin plugin;

    TinyMceButton(String jsName, TinyMcePlugin plugin) {
        this.jsName = jsName;
        this.plugin = plugin;
    }

    @Override
    public String getJsName() {
        return jsName;
    }

    public TinyMcePlugin getPlugin() {
        return plugin;
    }
}
