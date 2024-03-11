package gr.netmechanics.jmix.tinymce.component;

import com.google.common.base.Strings;
import com.vaadin.flow.component.HasAriaLabel;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasTheme;
import gr.netmechanics.jmix.tinymce.component.delegate.TinyMceEditorDelegate;
import io.jmix.flowui.data.SupportsValueSource;
import io.jmix.flowui.data.ValueSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;
import org.vaadin.tinymce.TinyMce;

/**
 * @author Panos Bariamis (pbaris)
 */
public class TinyMceEditor extends TinyMce implements SupportsValueSource<String>, ApplicationContextAware, InitializingBean,
    HasLabel, HasTheme, HasHelper, HasAriaLabel {

    private ApplicationContext applicationContext;

    private TinyMceEditorDelegate<TinyMceEditor, String> fieldDelegate;

    @Nullable
    @Override
    public ValueSource<String> getValueSource() {
        return fieldDelegate.getValueSource();
    }

    @Override
    public void setValueSource(@Nullable final ValueSource<String> valueSource) {
        fieldDelegate.setValueSource(valueSource);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        fieldDelegate = createFieldDelegate();
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected TinyMceEditorDelegate<TinyMceEditor, String> createFieldDelegate() {
        //noinspection unchecked
        return applicationContext.getBean(TinyMceEditorDelegate.class, this);
    }

    @Override
    public void setValue(String value) {
        super.setValue(Strings.nullToEmpty(value));
    }
}
