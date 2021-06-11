/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.plantuml.internal;

import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.configuration.internal.AbstractDocumentConfigurationSource;
import org.xwiki.model.reference.DocumentReference;
import org.xwiki.model.reference.LocalDocumentReference;

/**
 * Provides configuration from the {@code PlantUML.PlantUMLConfig} document in the current wiki, extracting the data
 * from the {@code PlantUML.PlantUMLConfigClass} xobjects.
 *
 * @version $Id$
 * @since 2.0
 */
@Component
@Named("plantuml")
@Singleton
public class PlantUMLConfigClassDocumentConfigurationSource extends AbstractDocumentConfigurationSource
{
    private static final String SPACE = "PlantUML";

    private static final LocalDocumentReference CLASS_REFERENCE =
        new LocalDocumentReference(SPACE, "PlantUMLConfigClass");

    /**
     * The local reference of the {@code PlantUML.PlantUMLConfig} document.
     */
    private static final LocalDocumentReference DOC_REFERENCE =
        new LocalDocumentReference(SPACE, "PlantUMLConfig");

    @Override
    protected String getCacheId()
    {
        return "configuration.document.plantuml";
    }

    @Override
    protected DocumentReference getDocumentReference()
    {
        return new DocumentReference(DOC_REFERENCE, getCurrentWikiReference());
    }

    @Override
    protected LocalDocumentReference getClassReference()
    {
        return CLASS_REFERENCE;
    }
}
