package gr.netmechanics.jmix.tinymce.loader;

import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import io.jmix.flowui.xml.layout.loader.AbstractComponentLoader;
import io.jmix.flowui.xml.layout.support.DataLoaderSupport;

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
}