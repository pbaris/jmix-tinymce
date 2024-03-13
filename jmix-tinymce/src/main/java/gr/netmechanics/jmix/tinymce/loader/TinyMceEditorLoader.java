package gr.netmechanics.jmix.tinymce.loader;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Strings;
import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;
import io.jmix.flowui.xml.layout.support.DataLoaderSupport;
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

        boolean useBasicConfig = loadBoolean(element, "useBasicConfig").orElse(false);

        resultComponent.configurePlugin(useBasicConfig, loadConfig(Plugin.class, "plugins"));
        resultComponent.configureMenubar(useBasicConfig, loadConfig(Menubar.class, "menubar"));
        resultComponent.configureToolbar(useBasicConfig, loadConfig(Toolbar.class, "toolbar"));

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

    @SuppressWarnings("unchecked")
    private <E extends Enum<E>> E[] loadConfig(final Class<E> type, final String attributeName) {
        return loaderSupport.loadString(element, attributeName).map(valuesString -> {
            List<String> values = split(valuesString);
            return values.stream()
                .map(v -> Enum.valueOf(type, v))
                .toArray(v -> (E[]) Array.newInstance(type, values.size()));
        }).orElseGet(() -> (E[]) Array.newInstance(type, 0));
    }

    private List<String> split(String names) {
        return Arrays.stream(names.split("[\\s,]+"))
            .filter(split -> !Strings.isNullOrEmpty(split))
            .toList();
    }
}