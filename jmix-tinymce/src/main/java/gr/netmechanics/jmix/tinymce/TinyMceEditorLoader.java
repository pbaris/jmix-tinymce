package gr.netmechanics.jmix.tinymce;

import static gr.netmechanics.jmix.tinymce.component.TinyMceButton.NEW_TOOLBAR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import gr.netmechanics.jmix.tinymce.component.TinyMceButton;
import gr.netmechanics.jmix.tinymce.component.TinyMceConfigMode;
import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import gr.netmechanics.jmix.tinymce.component.TinyMceEnum;
import gr.netmechanics.jmix.tinymce.component.TinyMceMenu;
import gr.netmechanics.jmix.tinymce.component.TinyMcePlugin;
import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;
import io.jmix.flowui.xml.layout.support.DataLoaderSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.NonNull;

/**
 * @author Panos Bariamis (pbaris)
 */
public class TinyMceEditorLoader extends AbstractComponentLoader<TinyMceEditor> {

    protected DataLoaderSupport dataLoaderSupport;

    @Override
    @NonNull
    protected TinyMceEditor createComponent() {
        return factory.create(TinyMceEditor.class);
    }

    @Override
    public void loadComponent() {
        getDataLoaderSupport().loadData(resultComponent, element);

        resultComponent.configure("branding", false)
            .configure("entity_encoding", "raw");

        loadTinyMceBars();

        componentLoader().loadLabel(resultComponent, element);
        componentLoader().loadEnabled(resultComponent, element);
        componentLoader().loadClassNames(resultComponent, element);
        componentLoader().loadSizeAttributes(resultComponent, element);
        componentLoader().loadHelperText(resultComponent, element);
        componentLoader().loadValueAndElementAttributes(resultComponent, element);
        componentLoader().loadAriaLabel(resultComponent, element);
    }

    protected DataLoaderSupport getDataLoaderSupport() {
        if (dataLoaderSupport == null) {
            dataLoaderSupport = applicationContext.getBean(DataLoaderSupport.class, context);
        }
        return dataLoaderSupport;
    }

    private void loadTinyMceBars() {
        TinyMceConfigMode configMode = loaderSupport.loadString(element, "configMode")
            .map(TinyMceConfigMode::valueOf)
            .orElse(null);

        List<TinyMceMenu> viewMenubar = loadConfig(TinyMceMenu.class, "menubar");
        List<TinyMceButton> viewToolbar = loadConfig(TinyMceButton.class, "toolbar");

        if (configMode == null && viewMenubar.isEmpty() && viewToolbar.isEmpty()) {
            configMode = TinyMceConfigMode.BASIC;
        }

        if (configMode != null) {
            var menubar = new ArrayList<>(configMode.getMenubar());
            viewMenubar.stream().filter(it -> !menubar.contains(it)).forEach(menubar::add);
            applyConfig(menubar, "menubar", true);

            var toolbar = new ArrayList<>(configMode.getToolbar());
            viewToolbar.stream().filter(it -> !toolbar.contains(it)).forEach(toolbar::add);
            applyToolbarConfig(toolbar);
            applyPluginsConfig(menubar, toolbar);

        } else {
            applyConfig(viewMenubar, "menubar", true);
            applyToolbarConfig(viewToolbar);
            applyPluginsConfig(viewMenubar, viewToolbar);
        }
    }

    private <E extends Enum<E> & TinyMceEnum> List<E> loadConfig(final Class<E> type, final String attribute) {
        return loaderSupport.loadString(element, attribute)
            .map(valuesString -> split(valuesString).stream()
                .map(v -> {
                    boolean isBtn = TinyMceButton.class.isAssignableFrom(type);
                    String enumValue;
                    if (isBtn && "|".equals(v)) {
                        enumValue = "SEPARATOR";

                    } else if (isBtn && "+".equals(v)) {
                        enumValue = "NEW_TOOLBAR";

                    } else {
                        enumValue = v;
                    }
                    return Enum.valueOf(type, enumValue);
                })
                .toList())
            .orElse(Collections.emptyList());
    }

    private void applyToolbarConfig(final List<TinyMceButton> toolbar) {
        if (!toolbar.contains(NEW_TOOLBAR)) {
            applyConfig(toolbar, "toolbar", true);
            return;
        }

        String[] toolbars = toolbar.stream()
            .map(TinyMceEnum::getJsName)
            .collect(Collectors.joining(" ")).split("\\++");

        resultComponent.configure("toolbar", Arrays.stream(toolbars)
            .filter(tb -> !Strings.isNullOrEmpty(tb))
            .map(String::trim)
            .toArray(String[]::new));
    }

    private void applyPluginsConfig(final List<TinyMceMenu> menubar, final List<TinyMceButton> toolbar) {
        Set<TinyMcePlugin> plugins = menubar.stream()
            .flatMap(m -> m.getPlugins().stream())
            .collect(Collectors.toSet());

        plugins.addAll(toolbar.stream()
            .map(TinyMceButton::getPlugin)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet()));

        applyConfig(plugins, "plugins", false);
    }

    private <E extends TinyMceEnum> void applyConfig(final Collection<E> configs, final String attribute, final boolean supportsDisable) {
        final String config = configs.stream()
            .map(TinyMceEnum::getJsName)
            .collect(Collectors.joining(" "));

        if (StringUtils.isNotBlank(config)) {
            resultComponent.configure(attribute, config);

        } else if (supportsDisable) {
            resultComponent.configure(attribute, false);
        }
    }

    private List<String> split(String names) {
        return Arrays.stream(names.split("[\\s,]+"))
            .filter(split -> !Strings.isNullOrEmpty(split))
            .toList();
    }
}