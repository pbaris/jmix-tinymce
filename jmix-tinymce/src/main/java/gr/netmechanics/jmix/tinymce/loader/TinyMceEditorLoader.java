package gr.netmechanics.jmix.tinymce.loader;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;
import io.jmix.flowui.xml.layout.support.DataLoaderSupport;
import org.apache.commons.lang3.StringUtils;
import org.vaadin.tinymce.Menubar;
import org.vaadin.tinymce.Plugin;
import org.vaadin.tinymce.Toolbar;

/**
 * @author Panos Bariamis (pbaris)
 */
public class TinyMceEditorLoader extends AbstractComponentLoader<TinyMceEditor> {

    protected DataLoaderSupport dataLoaderSupport;

    @Override
    protected TinyMceEditor createComponent() {
        return factory.create(TinyMceEditor.class);
    }

    @Override
    public void loadComponent() {
        getDataLoaderSupport().loadData(resultComponent, element);

        resultComponent.configure("branding", false);

        loadConfig(Plugin.class, "plugins", false, it -> it.pluginLabel);
        loadConfig(Menubar.class, "menubar", true, it -> it.menubarLabel);
        loadConfig(Toolbar.class, "toolbar", true, it -> it.toolbarLabel);

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

    private <E extends Enum<E>> void loadConfig(final Class<E> type, final String attribute,
                                                final boolean supportsDisable, final Function<E, String> convert) {

        String config = loaderSupport.loadString(element, attribute)
            .map(valuesString -> split(valuesString).stream()
                .map(v -> convert.apply(Enum.valueOf(type, v)))
                .collect(Collectors.joining(" ")))
            .orElse(null);

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