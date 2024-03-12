package gr.netmechanics.jmix.tinymce.kit;

import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import io.jmix.flowui.kit.meta.StudioComponent;
import io.jmix.flowui.kit.meta.StudioProperty;
import io.jmix.flowui.kit.meta.StudioPropertyType;
import io.jmix.flowui.kit.meta.StudioUiKit;

/**
 * @author Panos Bariamis (pbaris)
 */
@StudioUiKit
public interface StudioComponents {

    @StudioComponent(
        name = "TinyMceEditor",
        classFqn = "gr.netmechanics.jmix.tinymce.component.TinyMceEditor",
        category = "Components",
        xmlElement = "tinyMceEditor",
        xmlns = "http://schemas.netmechanics.gr/jmix/ui",
        xmlnsAlias = "nm",
        icon = "gr/netmechanics/jmix/tinymce/kit/meta/icon/component/tinymce.svg",
        properties = {
            @StudioProperty(xmlAttribute = "id", type = StudioPropertyType.COMPONENT_ID),
            @StudioProperty(xmlAttribute = "visible", type = StudioPropertyType.BOOLEAN, defaultValue = "true"),
            @StudioProperty(xmlAttribute = "colspan", type = StudioPropertyType.INTEGER),
            @StudioProperty(xmlAttribute = "alignSelf", type = StudioPropertyType.ENUMERATION,
                classFqn = "com.vaadin.flow.component.orderedlayout.FlexComponent$Alignment",
                defaultValue = "AUTO",
                options = {"START", "END", "CENTER", "STRETCH", "BASELINE", "AUTO"}),
            @StudioProperty(xmlAttribute = "css", type = StudioPropertyType.STRING),
            @StudioProperty(xmlAttribute = "enabled", type = StudioPropertyType.BOOLEAN, defaultValue = "true"),
            @StudioProperty(xmlAttribute = "readOnly", type = StudioPropertyType.BOOLEAN, defaultValue = "false"),
            @StudioProperty(xmlAttribute = "width", type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "height", type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "maxHeight", type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "maxWidth", type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "minHeight", type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "minWidth", type = StudioPropertyType.SIZE),
            @StudioProperty(xmlAttribute = "ariaLabel", type = StudioPropertyType.LOCALIZED_STRING),
            @StudioProperty(xmlAttribute = "ariaLabelledBy", type = StudioPropertyType.LOCALIZED_STRING),
            @StudioProperty(xmlAttribute = "classNames", type = StudioPropertyType.VALUES_LIST),
            @StudioProperty(xmlAttribute = "label", type = StudioPropertyType.LOCALIZED_STRING),
            @StudioProperty(xmlAttribute = "helperText", type = StudioPropertyType.LOCALIZED_STRING),
            @StudioProperty(xmlAttribute = "dataContainer", type = StudioPropertyType.DATA_CONTAINER_REF),
            @StudioProperty(xmlAttribute = "property", type = StudioPropertyType.PROPERTY_REF)
        }
    )
    TinyMceEditor tinyMceEditor();
}
