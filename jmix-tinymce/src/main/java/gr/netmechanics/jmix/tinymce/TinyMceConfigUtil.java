package gr.netmechanics.jmix.tinymce;

import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.NEW_TOOLBAR;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import gr.netmechanics.jmix.tinymce.component.TinyMceButton;
import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import gr.netmechanics.jmix.tinymce.component.TinyMceEnum;
import gr.netmechanics.jmix.tinymce.component.TinyMceMenu;
import gr.netmechanics.jmix.tinymce.component.TinyMcePlugin;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Panos Bariamis (pbaris)
 */
public class TinyMceConfigUtil {
    private TinyMceConfigUtil() {}

    public static void applyToolbarConfig(final TinyMceEditor editor, final List<TinyMceButton> toolbar) {
        if (!toolbar.contains(NEW_TOOLBAR)) {
            applyConfig(editor, toolbar, "toolbar", true);
            return;
        }

        String[] toolbars = toolbar.stream()
            .map(TinyMceEnum::getJsName)
            .collect(Collectors.joining(" ")).split("\\++");

        editor.configure("toolbar", Arrays.stream(toolbars)
            .filter(tb -> !Strings.isNullOrEmpty(tb))
            .map(String::trim)
            .toArray(String[]::new));
    }

    public static void applyPluginsConfig(final TinyMceEditor editor, final List<TinyMceMenu> menubar, final List<TinyMceButton> toolbar) {
        Set<TinyMcePlugin> plugins = menubar.stream()
            .flatMap(m -> m.getPlugins().stream())
            .collect(Collectors.toSet());

        plugins.addAll(toolbar.stream()
            .map(TinyMceButton::getPlugin)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet()));

        applyConfig(editor, plugins, "plugins", false);
    }

    public static <E extends TinyMceEnum> void applyConfig(final TinyMceEditor editor, final Collection<E> configs,
                                                     final String attribute, final boolean supportsDisable) {
        final String config = configs.stream()
            .map(TinyMceEnum::getJsName)
            .collect(Collectors.joining(" "));

        if (StringUtils.isNotBlank(config)) {
            editor.configure(attribute, config);

        } else if (supportsDisable) {
            editor.configure(attribute, false);
        }
    }
}
