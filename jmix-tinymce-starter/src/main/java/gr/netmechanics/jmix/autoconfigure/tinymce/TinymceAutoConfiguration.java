package gr.netmechanics.jmix.autoconfigure.tinymce;

import gr.netmechanics.jmix.tinymce.TinyMceConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({TinyMceConfiguration.class})
public class TinymceAutoConfiguration {
}

