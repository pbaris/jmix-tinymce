[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

# TinyMCE Editor for Jmix

This add-on provides support for [TinyMCE WYSIWYG Editor](https://www.tiny.cloud/) through the [TinyMCE wrapper for Vaadin Flow](https://vaadin.com/directory/component/tinymce-for-flow) addon.

![](./docs/preview.png)

> [!NOTE]  
> Only non-paid plugins are supported

## Installation

The following table shows which version of the add-on is compatible with which version of the platform:

| Jmix Version | Add-on Version | Implementation                                  |
|--------------|----------------|-------------------------------------------------|
| 2.2.x        | 1.0.0          | gr.netmechanics.jmix:jmix-tinymce-starter:1.0.0 |
| 2.3.2        | 1.1.0          | gr.netmechanics.jmix:jmix-tinymce-starter:1.1.0 |
| 2.3.4        | 1.3.0          | gr.netmechanics.jmix:jmix-tinymce-starter:1.3.0 |
| 2.4.1        | 1.4.1          | gr.netmechanics.jmix:jmix-tinymce-starter:1.4.1 |
| 2.4.2        | 1.4.4          | gr.netmechanics.jmix:jmix-tinymce-starter:1.4.4 |
| 2.5.x        | 1.5.0          | gr.netmechanics.jmix:jmix-tinymce-starter:1.5.0 |
| 2.6.x        | 1.6.0          | gr.netmechanics.jmix:jmix-tinymce-starter:1.6.0 |

For manual installation, add the following dependencies to your `build.gradle`:

```gradle
implementation 'gr.netmechanics.jmix:jmix-tinymce-starter:<addon-version>'
```

## How to use the add-on

In an edit screen you can add the field from studio `Component Palette` window

![](./docs/palette.png)

or through code

```xml
<view xmlns="http://jmix.io/schema/flowui/view"
        xmlns:nm="http://schemas.netmechanics.gr/jmix/ui"
        focusComponent="form">
    ...
    <layout>
        <formLayout id="form">
            <nm:tinyMceEditor id="summaryField" property="summary" />
        </formLayout>
        ...
    </layout>
</view>
```

## Configuration

We can configure the editor, based on predefined configuration modes, provide custom configuration or combine the two.

> [!TIP]  
> If no other configuration is specified, the _BASIC_ configuration mode is used.

### Configuration Modes
There are two configuration modes, BASIC and ADVANCED. Both modes have no menubar, but a single toolbar with buttons:

#### BASIC

```xml
<nm:tinyMceEditor id="summaryField" property="summary" 
                  configMode="BASIC" />
```

UNDO, REDO, BOLD, ITALIC, UNDERLINE, ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, FORECOLOR, BACKCOLOR, NUMBERS_LIST, BULLETS_LIST, INDENT, OUTDENT, LINK, TABLE, FULLSCREEN, CODE

![](./docs/preview_basic.png)

#### ADVANCED

```xml
<nm:tinyMceEditor id="summaryField" property="summary" 
                  configMode="ADVANCED" />
```

UNDO, REDO, CUT, COPY, PASTE, PASTE_TEXT, BOLD, ITALIC, UNDERLINE, SUBSCRIPT, SUPERSCRIPT, ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT, ALIGN_JUSTIFY, FORECOLOR, BACKCOLOR, NUMBERS_LIST, BULLETS_LIST, INDENT, OUTDENT, LINK, UNLINK, TABLE, MEDIA, HR, CHARACTER_MAP, VISUAL_BLOCKS, REMOVE_FORMAT, FULLSCREEN, CODE

![](./docs/preview_advanced.png)

### Custom Configuration

We can provide our own configuration per editor. We can config the menubar and the toolbar(s), using the appropriate enums. In  the toolbar, we can use the pipe (|) character to group buttons, and the plus (+) character to add a new toolbar.

```xml
<nm:tinyMceEditor id="summaryField" property="summary" 
                  menubar="FILE INSERT" 
                  toolbar="TABLE | UNDO REDO + ALIGN_LEFT ALIGN_CENTER ALIGN_RIGHT ALIGN_JUSTIFY"/>
```

![](./docs/preview_custom.png)

### Combined Configuration

We can combine any of the configuration modes with custom menubar and toolbar(s) configuration.

```xml
<nm:tinyMceEditor id="summaryField" property="summary" 
                  configMode="BASIC" 
                  toolbar="UNLINK MEDIA"/>
```

![](./docs/preview_combined.png)
