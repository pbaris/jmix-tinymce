package gr.netmechanics.jmix.tinymce.component;

import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.ANCHOR;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.AUTOSAVE;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.CHARACTER_MAP;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.CODE;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.CODE_SAMPLE;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.EMOTICONS;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.FULLSCREEN;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.IMAGE;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.INSERT_DATETIME;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.LINK;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.MEDIA;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.NON_BREAKING;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.PAGE_BREAK;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.PREVIEW;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.SEARCH_REPLACE;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.TEMPLATE;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.VISUAL_BLOCKS;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.VISUAL_CHARACTERS;
import static gr.netmechanics.jmix.tinymce.component.TinyMcePlugin.WORD_COUNT;

import java.util.Set;

/**
 * @author Panos Bariamis (pbaris)
 */
public enum TinyMceMenu implements TinyMceEnum {
    FILE("file", Set.of(AUTOSAVE, PREVIEW)),
    EDIT("edit", Set.of(SEARCH_REPLACE)),
    VIEW("view", Set.of(CODE, VISUAL_BLOCKS, VISUAL_CHARACTERS, PREVIEW, FULLSCREEN)),
    INSERT("insert", Set.of(IMAGE, LINK, MEDIA, TEMPLATE, CODE_SAMPLE, TinyMcePlugin.TABLE,
        CHARACTER_MAP, EMOTICONS, PAGE_BREAK, NON_BREAKING, ANCHOR, INSERT_DATETIME)),
    FORMAT("format", Set.of(VISUAL_BLOCKS)),
    TOOLS("tools", Set.of(CODE, WORD_COUNT)),
    TABLE("table", Set.of(TinyMcePlugin.TABLE)),
    HELP("help", Set.of(TinyMcePlugin.HELP));

    public final String jsName;
    public final Set<TinyMcePlugin> plugins;

    TinyMceMenu(final String jsName, final Set<TinyMcePlugin> plugins) {
        this.jsName = jsName;
        this.plugins = plugins;
    }

    @Override
    public String getJsName() {
        return jsName;
    }

    public Set<TinyMcePlugin> getPlugins() {
        return plugins;
    }
}
