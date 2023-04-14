
Read from the console the name of a file
 containing HTML.

Example:
Info about Leela <span xml:lang="en"lang="en"><b><span>Leela Turanga
</span></b></span><span>Super</span>
<span>girl</span>

The main method's first parameter is a
tag name. For example, "span".
Displaying all tags that match the specified
 tag.
The order match their order in the
 file, each tag on a new line.
The number of spaces, newline characters
(\n), or carriage returns (\r) does not
affect the result.
The file does not have a CDATA tag. Each
opening tag has a separate closing tag,
and there are no self-closing tags.
Tags may have nested tags.

Example output:
<span xml:lang="en" lang="en"><b><span>Leela
 Turanga</span></b></span>
<span>Leela Turanga</span>
<span>Super</span>
<span>girl</span>

Tag templates:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1 and text2 can be empty
