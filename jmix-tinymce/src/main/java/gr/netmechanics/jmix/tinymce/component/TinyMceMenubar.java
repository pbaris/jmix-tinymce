package gr.netmechanics.jmix.tinymce.component;

import org.vaadin.tinymce.Menubar;

public enum TinyMceMenubar {
    FILE(Menubar.FILE),
    EDIT(Menubar.EDIT),
    VIEW(Menubar.VIEW),
    INSERT(Menubar.INSERT),
    FORMAT(Menubar.FORMAT),
    TOOLS(Menubar.TOOLS),
    TABLE(Menubar.TABLE),
    HELP(Menubar.HELP);

    public final Menubar menubar;

    TinyMceMenubar(Menubar menubar) {
        this.menubar = menubar;
    }

}
