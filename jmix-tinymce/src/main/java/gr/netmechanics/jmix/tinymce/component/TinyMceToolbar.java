package gr.netmechanics.jmix.tinymce.component;

import org.vaadin.tinymce.Toolbar;

public enum TinyMceToolbar {
    SEPARATOR(Toolbar.SEPARATOR),
    UNDO(Toolbar.UNDO),
    REDO(Toolbar.REDO),
    FORMAT_SELECT(Toolbar.FORMAT_SELECT),
    BLOCKS(Toolbar.BLOCKS),
    BOLD(Toolbar.BOLD),
    ITALIC(Toolbar.ITALIC),
    UNDERLINE(Toolbar.UNDERLINE),
    STRIKETHROUGH(Toolbar.STRIKETHROUGH),
    FORECOLOR(Toolbar.FORECOLOR),
    BACKCOLOR(Toolbar.BACKCOLOR),
    ALIGN_LEFT(Toolbar.ALIGN_LEFT),
    ALIGN_CENTER(Toolbar.ALIGN_CENTER),
    ALIGN_RIGHT(Toolbar.ALIGN_RIGHT),
    ALIGN_JUSTIFY(Toolbar.ALIGN_JUSTIFY),
    FONTNAME(Toolbar.FONTNAME),
    FONTSIZE(Toolbar.FONTSIZE),
    BLOCKQUOTE(Toolbar.BLOCKQUOTE),
    NUMLIST(Toolbar.NUMLIST),
    BULLIST(Toolbar.BULLIST),
    OUTDENT(Toolbar.OUTDENT),
    INDENT(Toolbar.INDENT),
    REMOVE_FORMAT(Toolbar.REMOVE_FORMAT),
    HELP(Toolbar.HELP),
    TABLE(Toolbar.TABLE),
    TABLE_DELETE(Toolbar.TABLE_DELETE),
    TABLE_PROPS(Toolbar.TABLE_PROPS),
    TABLE_ROWPROPS(Toolbar.TABLE_ROWPROPS),
    TABLE_CELLPROPS(Toolbar.TABLE_CELLPROPS),
    TABLE_INSERT_ROW_BEFORE(Toolbar.TABLE_INSERT_ROW_BEFORE),
    TABLE_INSERT_ROW_AFTER(Toolbar.TABLE_INSERT_ROW_AFTER),
    TABLE_DELETE_ROW(Toolbar.TABLE_DELETE_ROW),
    TABLE_INSERT_COL_BEFORE(Toolbar.TABLE_INSERT_COL_BEFORE),
    TABLE_INSERT_COL_AFTER(Toolbar.TABLE_INSERT_COL_AFTER),
    FONTSELECT(Toolbar.FONTSELECT),
    FONTSIZESELECT(Toolbar.FONTSIZESELECT),
    EMOTICONS(Toolbar.EMOTICONS),
    LINK(Toolbar.LINK),
    IMAGE(Toolbar.IMAGE),
    MEDIA(Toolbar.MEDIA),
    PRINT(Toolbar.PRINT),
    INSERT_DATETIME(Toolbar.INSERT_DATETIME);

    public final Toolbar toolbar;

    TinyMceToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

}
