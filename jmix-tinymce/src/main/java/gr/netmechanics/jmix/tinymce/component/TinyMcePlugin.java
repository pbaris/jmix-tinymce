package gr.netmechanics.jmix.tinymce.component;

import org.vaadin.tinymce.Plugin;

public enum TinyMcePlugin {
    ADVLIST(Plugin.ADVLIST),
    ANCHOR(Plugin.ANCHOR),
    AUTOLINK(Plugin.AUTOLINK),
    AUTORESIZE(Plugin.AUTORESIZE),
    AUTOSAVE(Plugin.AUTOSAVE),
    CHARMAP(Plugin.CHARMAP),
    CODE(Plugin.CODE),
    CODESAMPLE(Plugin.CODESAMPLE),
    COLORPICKER(Plugin.COLORPICKER),
    CONTEXTMENU(Plugin.CONTEXTMENU),
    DIRECTIONALITY(Plugin.DIRECTIONALITY),
    EMOTICONS(Plugin.EMOTICONS),
    FULLPAGE(Plugin.FULLPAGE),
    FULLSCREEN(Plugin.FULLSCREEN),
    HELP(Plugin.HELP),
    HR(Plugin.HR),
    IMAGE(Plugin.IMAGE),
    IMAGE_TOOLS(Plugin.IMAGE_TOOLS),
    IMPORT_CSS(Plugin.IMPORT_CSS),
    INSERT_DATETIME(Plugin.INSERT_DATETIME),
    LEGACYOUTPUT(Plugin.LEGACYOUTPUT),
    LINK(Plugin.LINK),
    LISTS(Plugin.LISTS),
    MEDIA(Plugin.MEDIA),
    NONBREAKING(Plugin.NONBREAKING),
    NONEDITABLE(Plugin.NONEDITABLE),
    PAGEBREAK(Plugin.PAGEBREAK),
    PASTE(Plugin.PASTE),
    PREVIEW(Plugin.PREVIEW),
    PRINT(Plugin.PRINT),
    QUICKBARS(Plugin.QUICKBARS),
    SAVE(Plugin.SAVE),
    SEARCH_REPLACE(Plugin.SEARCH_REPLACE),
    SPELLCHECKER(Plugin.SPELLCHECKER),
    TABFOCUS(Plugin.TABFOCUS),
    TABLE(Plugin.TABLE),
    TEMPLATE(Plugin.TEMPLATE),
    TEXT_COLOR(Plugin.TEXT_COLOR),
    TEXT_PATTERN(Plugin.TEXT_PATTERN),
    VISUAL_BLOCKS(Plugin.VISUAL_BLOCKS),
    VISUAL_CHARS(Plugin.VISUAL_CHARS),
    WORDCOUNT(Plugin.WORDCOUNT);

    public final Plugin plugin;

    TinyMcePlugin(Plugin plugin) {
        this.plugin = plugin;
    }

}
