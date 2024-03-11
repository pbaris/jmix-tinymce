package gr.netmechanics.jmix.tinymce;

import io.jmix.core.annotation.JmixModule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(TinyMceConfiguration.class)
@PropertySource("classpath:/gr/netmechanics/jmix/tinymce/test-app.properties")
@JmixModule(id = "gr.netmechanics.jmix.tinymce.test", dependsOn = TinyMceConfiguration.class)
public class TinyMceTestConfiguration {

}
