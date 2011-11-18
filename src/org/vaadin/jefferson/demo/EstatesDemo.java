/*
 * Copyright 2011 Vaadin Ltd.
 * 
 * Licensed under the GNU Affero General Public License, Version 2 (the 
 * "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/agpl.html
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.vaadin.jefferson.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.vaadin.jefferson.content.View;
import org.vaadin.jefferson.demo.EstatesContent.PropertiesView;

import com.vaadin.Application;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.AbstractSelect;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class EstatesDemo extends Application {
    private final Map<String, String> propertyCaptions = new HashMap<String, String>();
    private final Map<String, String> propertyValues = new HashMap<String, String>();

    public EstatesDemo() {
        propertyCaptions.put(
                PropertiesView.MAX, "Greater value of assets and debit");
        propertyCaptions.put(
                PropertiesView.DATE, "Filed for bankruptcy");
        propertyCaptions.put(
                PropertiesView.STATE, "State");

        propertyValues.put(PropertiesView.MAX, "241 959,01 €");
        propertyValues.put(PropertiesView.DATE, "1.1.2010");
        propertyValues.put(PropertiesView.STATE, "Canceled");
    }

    @Override
    public void init() {
        setTheme("jefferson-demo");
        Window mainWindow = new Window("Estates Demo");
        setMainWindow(mainWindow);

        EstatesContent content = new EstatesContent();
        EstatesPresentation presentation = new EstatesPresentation();

        try {
            mainWindow.setContent(presentation.visit(content));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }

        for (View<Label> property : content.getPropertiesView().getProperties()) {
            Label rendition = property.getRendition();
            String name = property.getName();
            rendition.setCaption(propertyCaptions.get(name));
            rendition.setValue(propertyValues.get(name));
        }

        AbstractSelect estates = content.getEstatesView().getRendition();
        estates.setContainerDataSource(
                new IndexedContainer(Arrays.asList("A", "B", "C")));
    }
}
