# asterisk-config-java
Java library for Asterisk configuration files

This library is used to parse the various types of configuration files used by Asterisk. The configuration files are similar to Windows INI files in that they have sections and use a key/value pair system. There are some key differences:
* including additional configuration files is supported
* directives are supported that use '=>' as a delimiter

A line in a configuration flie can be one of the following entries:
* Comment - A line that only contains a comment and no other data. An example is "; this is a comment"
* ConfigEntry - A key/value pair line delimited by an equal sign (=). An example is "host = 127.0.0.1"
* Directive - A directive contains a type, for example register or exten, as a key and a command as a value. An example is "exten => NoOp("Hello")".
* Include - Allows inclusion of another file. This library does not process the inclusion but simply handles the presence of the entry in the configuration file. An example is "#include somefile.conf"

Each of these entries are part of a configuration file section. For example:
```
[general]
setting = value
#include somefile.conf
```

A configuration file can contain multiple sections. For example:
```
[general]
setting = value
#include somefile.conf

[parking]
600 = x
```
