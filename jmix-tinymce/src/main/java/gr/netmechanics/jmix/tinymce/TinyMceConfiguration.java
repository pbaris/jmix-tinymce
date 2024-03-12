package gr.netmechanics.jmix.tinymce;

import gr.netmechanics.jmix.tinymce.component.TinyMceEditor;
import gr.netmechanics.jmix.tinymce.loader.TinyMceEditorLoader;
import io.jmix.core.annotation.JmixModule;
import io.jmix.flowui.FlowuiConfiguration;
import io.jmix.flowui.sys.registration.ComponentRegistration;
import io.jmix.flowui.sys.registration.ComponentRegistrationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@ConfigurationPropertiesScan
@JmixModule(dependsOn = {FlowuiConfiguration.class})
@PropertySource(name = "gr.netmechanics.jmix.tinymce", value = "classpath:/gr/netmechanics/jmix/tinymce/module.properties")
public class TinyMceConfiguration {

//    @Bean("tinymce_TinymceViewControllers")
//    public ViewControllersConfiguration screens(final ApplicationContext applicationContext,
//                                                final AnnotationScanMetadataReaderFactory metadataReaderFactory) {
//        final ViewControllersConfiguration viewControllers
//                = new ViewControllersConfiguration(applicationContext, metadataReaderFactory);
//        viewControllers.setBasePackages(Collections.singletonList("gr.netmechanics.jmix.tinymce"));
//        return viewControllers;
//    }
//
//    @Bean("tinymce_TinymceActions")
//    public ActionsConfiguration actions(final ApplicationContext applicationContext,
//                                        final AnnotationScanMetadataReaderFactory metadataReaderFactory) {
//        final ActionsConfiguration actions
//                = new ActionsConfiguration(applicationContext, metadataReaderFactory);
//        actions.setBasePackages(Collections.singletonList("gr.netmechanics.jmix.tinymce"));
//        return actions;
//    }

    @Bean
    public ComponentRegistration searchField() {
        return ComponentRegistrationBuilder.create(TinyMceEditor.class)
            .withComponentLoader("tinyMceEditor", TinyMceEditorLoader.class)
            .build();
    }
}
