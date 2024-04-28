package gr.netmechanics.jmix.tinymce.component;

import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_CENTER;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_JUSTIFY;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_LEFT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ALIGN_RIGHT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.BACKCOLOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.BOLD;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.BULLETS_LIST;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.CODE;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.FORECOLOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.FULLSCREEN;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.INDENT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.ITALIC;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.LINK;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.NEW_DOCUMENT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.NUMBERS_LIST;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.OUTDENT;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.SEPARATOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.TABLE;
import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.UNDERLINE;
import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;

import java.util.List;
import java.util.Set;

/**
 * @author Panos Bariamis (pbaris)
 */
public enum TinyMceConfigMode {
    BASIC(
        emptyList(),
        List.of(
            NEW_DOCUMENT, SEPARATOR,
            BOLD, ITALIC, UNDERLINE, SEPARATOR,
            FORECOLOR, BACKCOLOR, SEPARATOR, 
            ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, INDENT, OUTDENT, SEPARATOR,
            NUMBERS_LIST, BULLETS_LIST, LINK, TABLE, SEPARATOR,
            FULLSCREEN, CODE),
        Set.of(TinyMcePlugin.LINK, TinyMcePlugin.LISTS, TinyMcePlugin.CODE, TinyMcePlugin.FULLSCREEN, TinyMcePlugin.TABLE)),

    ADVANCED(emptyList(), emptyList(), emptySet());

    private final List<TinyMceMenu> menubar;
    private final List<TinyMceButton> toolbar;
    private final Set<TinyMcePlugin> plugins;

    TinyMceConfigMode(final List<TinyMceMenu> menubar, final List<TinyMceButton> toolbar, final Set<TinyMcePlugin> plugins) {
        this.menubar = menubar;
        this.toolbar = toolbar;
        this.plugins = plugins;
    }

    public List<TinyMceMenu> getMenubar() {
        return menubar;
    }

    public List<TinyMceButton> getToolbar() {
        return toolbar;
    }

    public Set<TinyMcePlugin> getPlugins() {
        return plugins;
    }
}
