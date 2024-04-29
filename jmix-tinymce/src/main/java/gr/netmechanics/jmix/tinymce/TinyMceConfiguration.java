package gr.netmechanics.jmix.tinymce;

import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import io.jmix.core.annotation.JmixModule;
import io.jmix.flowui.FlowuiConfiguration;
import io.jmix.flowui.sys.registration.ComponentRegistration;
import io.jmix.flowui.sys.registration.ComponentRegistrationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Panos Bariamis (pbaris)
 */
@Configuration
@ComponentScan
@ConfigurationPropertiesScan
@JmixModule(dependsOn = {FlowuiConfiguration.class})
@PropertySource(name = "gr.netmechanics.jmix.tinymce", value = "classpath:/gr/netmechanics/jmix/tinymce/module.properties")
public class TinyMceConfiguration {

    @Bean
    public ComponentRegistration tinyMceEditor() {
        return ComponentRegistrationBuilder.create(TinyMceEditor.class)
            .withComponentLoader("tinyMceEditor", TinyMceEditorLoader.class)
            .build();
    }
}
