package gr.netmechanics.jmix.tinymce.component;

import java.util.Optional;

import com.google.common.base.Strings;
import com.vaadin.flow.component.HasAriaLabel;
import com.vaadin.flow.component.HasHelper;
import com.vaadin.flow.component.HasLabel;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.customfield.CustomField;
import io.jmix.flowui.component.UiComponentUtils;
import io.jmix.flowui.data.SupportsValueSource;
import io.jmix.flowui.data.ValueSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.vaadin.tinymce.TinyMce;

/**
 * @author Panos Bariamis (pbaris)
 */
public class TinyMceEditor extends CustomField<String> implements SupportsValueSource<String>, ApplicationContextAware, InitializingBean,
    HasLabel, HasHelper, HasAriaLabel, HasSize {

    private ApplicationContext applicationContext;

    private final TinyMce tinyMce = new TinyMce();

    public TinyMceEditor() {
        tinyMce.addValueChangeListener(e -> this.updateValue());
        add(tinyMce);
    }

    private TinyMceEditorDelegate<TinyMceEditor, String> fieldDelegate;

    public TinyMce configure(final String configurationKey, final String value) {
        return tinyMce.configure(configurationKey, value);
    }

    public TinyMce configure(final String configurationKey, final String... value) {
        return tinyMce.configure(configurationKey, value);
    }

    public TinyMce configure(final String configurationKey, final boolean value) {
        return tinyMce.configure(configurationKey, value);
    }

    public TinyMce configure(final String configurationKey, final double value) {
        return tinyMce.configure(configurationKey, value);
    }

    @Override
    public void setReadOnly(final boolean readOnly) {
        tinyMce.setReadOnly(readOnly);
    }

    @Override
    public void setEnabled(final boolean enabled) {
        tinyMce.setEnabled(enabled);
    }

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
    public void setApplicationContext(@NonNull final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    protected TinyMceEditorDelegate<TinyMceEditor, String> createFieldDelegate() {
        //noinspection unchecked
        return applicationContext.getBean(TinyMceEditorDelegate.class, this);
    }

    @Override
    public String getValue() {
        return tinyMce.getValue();
    }

    @Override
    public void setValue(String value) {
        tinyMce.setValue(Strings.nullToEmpty(value));
    }

    @Override
    protected String generateModelValue() {
        return UiComponentUtils.getValue(tinyMce);
    }

    @Override
    protected void setPresentationValue(final String newPresentationValue) {
        UiComponentUtils.setValue(tinyMce, newPresentationValue);
    }

    //region HasSize
    @Override
    public void setWidth(final String width) {
        tinyMce.setWidth(width);
    }

    @Override
    public void setWidth(final float width, final Unit unit) {
        tinyMce.setWidth(width, unit);
    }

    @Override
    public void setMinWidth(final String minWidth) {
        tinyMce.setMinWidth(minWidth);
    }

    @Override
    public void setMinWidth(final float minWidth, final Unit unit) {
        tinyMce.setMinWidth(minWidth, unit);
    }

    @Override
    public void setMaxWidth(final String maxWidth) {
        tinyMce.setMaxWidth(maxWidth);
    }

    @Override
    public void setMaxWidth(final float maxWidth, final Unit unit) {
        tinyMce.setMaxWidth(maxWidth, unit);
    }

    @Override
    public String getWidth() {
        return tinyMce.getWidth();
    }

    @Override
    public String getMinWidth() {
        return tinyMce.getMinWidth();
    }

    @Override
    public String getMaxWidth() {
        return tinyMce.getMaxWidth();
    }

    @Override
    public Optional<Unit> getWidthUnit() {
        return tinyMce.getWidthUnit();
    }

    @Override
    public void setHeight(final String height) {
        tinyMce.setHeight(height);
    }

    @Override
    public void setHeight(final float height, final Unit unit) {
        tinyMce.setHeight(height, unit);
    }

    @Override
    public void setMinHeight(final String minHeight) {
        tinyMce.setMinHeight(minHeight);
    }

    @Override
    public void setMinHeight(final float minHeight, final Unit unit) {
        tinyMce.setMinHeight(minHeight, unit);
    }

    @Override
    public void setMaxHeight(final String maxHeight) {
        tinyMce.setMaxHeight(maxHeight);
    }

    @Override
    public void setMaxHeight(final float maxHeight, final Unit unit) {
        tinyMce.setMaxHeight(maxHeight, unit);
    }

    @Override
    public String getHeight() {
        return tinyMce.getHeight();
    }

    @Override
    public String getMinHeight() {
        return tinyMce.getMinHeight();
    }

    @Override
    public String getMaxHeight() {
        return tinyMce.getMaxHeight();
    }

    @Override
    public Optional<Unit> getHeightUnit() {
        return tinyMce.getHeightUnit();
    }

    @Override
    public void setSizeFull() {
        tinyMce.setSizeFull();
    }

    @Override
    public void setWidthFull() {
        tinyMce.setWidthFull();
    }

    @Override
    public void setHeightFull() {
        tinyMce.setHeightFull();
    }

    @Override
    public void setSizeUndefined() {
        tinyMce.setSizeUndefined();
    }

    public static String getCssSize(final float size, final Unit unit) {
        return HasSize.getCssSize(size, unit);
    }
    //endregion
}
