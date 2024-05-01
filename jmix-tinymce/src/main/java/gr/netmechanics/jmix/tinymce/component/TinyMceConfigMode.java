package gr.netmechanics.jmix.tinymce.component;

import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_CENTER;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_JUSTIFY;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_LEFT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_RIGHT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.BACKCOLOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.BOLD;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.BULLETS_LIST;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.CHARACTER_MAP;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.CODE;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.COPY;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.CUT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.FORECOLOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.FULLSCREEN;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.HR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.INDENT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ITALIC;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.LINK;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.MEDIA;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.NUMBERS_LIST;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.OUTDENT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.PASTE;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.PASTE_TEXT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.REDO;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.REMOVE_FORMAT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.SEPARATOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.SUBSCRIPT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.SUPERSCRIPT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.TABLE;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.UNDERLINE;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.UNDO;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.UNLINK;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.VISUAL_BLOCKS;
import static java.util.Collections.emptyList;

import java.util.List;

/**
 * @author Panos Bariamis (pbaris)
 */

public enum TinyMceConfigMode {
    BASIC(emptyList(), List.of(
        UNDO, REDO, SEPARATOR,
        BOLD, ITALIC, UNDERLINE, SEPARATOR,
        ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, SEPARATOR,
        FORECOLOR, BACKCOLOR, SEPARATOR,
        NUMBERS_LIST, BULLETS_LIST, INDENT, OUTDENT, SEPARATOR,
        LINK, TABLE, FULLSCREEN, CODE)),

    ADVANCED(emptyList(), List.of(
        UNDO, REDO, CUT, COPY, PASTE, PASTE_TEXT, SEPARATOR,
        BOLD, ITALIC, UNDERLINE, SUBSCRIPT, SUPERSCRIPT, SEPARATOR,
        ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, SEPARATOR,
        FORECOLOR, BACKCOLOR, SEPARATOR,
        NUMBERS_LIST, BULLETS_LIST, INDENT, OUTDENT, SEPARATOR,
        LINK, UNLINK, TABLE, MEDIA, HR, CHARACTER_MAP, VISUAL_BLOCKS, REMOVE_FORMAT, FULLSCREEN, CODE));

    private final List<TinyMceMenu> menubar;
    private final List<TinyMceButton> toolbar;

    TinyMceConfigMode(final List<TinyMceMenu> menubar, final List<TinyMceButton> toolbar) {
        this.menubar = menubar;
        this.toolbar = toolbar;
    }

    public List<TinyMceMenu> getMenubar() {
        return menubar;
    }

    public List<TinyMceButton> getToolbar() {
        return toolbar;
    }
}
