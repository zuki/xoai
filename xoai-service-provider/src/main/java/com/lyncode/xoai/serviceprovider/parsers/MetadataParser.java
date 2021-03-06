/**
 * Copyright 2012 Lyncode
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     client://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lyncode.xoai.serviceprovider.parsers;

import com.lyncode.xml.XmlReader;
import com.lyncode.xml.exceptions.XmlReaderException;
import com.lyncode.xoai.model.xoai.Element;
import com.lyncode.xoai.model.xoai.Field;
import com.lyncode.xoai.model.xoai.XOAIMetadata;
import org.hamcrest.Matcher;

import javax.xml.namespace.QName;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

import static com.lyncode.xml.matchers.QNameMatchers.localPart;
import static com.lyncode.xml.matchers.XmlEventMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;

public class MetadataParser {
    public XOAIMetadata parse(InputStream input) throws XmlReaderException {
        XOAIMetadata metadata = new XOAIMetadata();
        XmlReader reader = new XmlReader(input);
        reader.next(elementName(localPart(equalTo("metadata"))));

        while (reader.next(endOfMetadata(), startElement()).current(startElement())) {
            metadata.withElement(parseElement(reader));
        }

        return metadata;
    }

    private Element parseElement(XmlReader reader) throws XmlReaderException {
        Element element = new Element(reader.getAttributeValue(name()));

        while (reader.next(startElement(), endElement()).current(startElement())) {
            element.withElement(parseElement(reader));
            reader.next(endElement());
        }

        while (reader.next(startField(), endElement()).current(startField())) {
            Field field = new Field()
                    .withName(reader.getAttributeValue(name()));

            if (reader.next(endElement(), text()).current(text()))
                field.withValue(reader.getText());

            element.withField(field);
        }

        return element;
    }

    private Matcher<XMLEvent> startField() {
        return allOf(aStartElement(), elementName(localPart(equalTo("field"))));
    }

    private Matcher<XMLEvent> endOfMetadata() {
        return allOf(anEndElement(), elementName(localPart(equalTo("metadata"))));
    }

    private Matcher<QName> name() {
        return localPart(equalTo("name"));
    }

    private Matcher<XMLEvent> startElement() {
        return allOf(aStartElement(), elementName(localPart(equalTo("element"))));
    }
    private Matcher<XMLEvent> endElement() {
        return allOf(anEndElement(), elementName(localPart(equalTo("element"))));
    }
}
