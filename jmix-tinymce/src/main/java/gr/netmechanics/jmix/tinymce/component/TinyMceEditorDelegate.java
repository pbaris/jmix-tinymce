package gr.netmechanics.jmix.tinymce.component;

import com.vaadin.flow.component.AbstractField;
import io.jmix.flowui.component.delegate.AbstractFieldDelegate;
import io.jmix.flowui.data.ValueSource;
import io.jmix.flowui.data.binding.impl.AbstractValueBinding;
import io.jmix.flowui.data.binding.impl.FieldValueBinding;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @param <C> component type
 * @param <V> component value type
 *
 * @author Panos Bariamis (pbaris)
 */
@Component("flowui_TinyMceEditorDelegate")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class TinyMceEditorDelegate<C extends AbstractField<?, String>, V> extends AbstractFieldDelegate<C, V, String> {

    public TinyMceEditorDelegate(C component) {
        super(component);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected AbstractValueBinding<V> createValueBinding(ValueSource<V> valueSource) {
        return applicationContext.getBean(FieldValueBinding.class, valueSource, component);
    }
}