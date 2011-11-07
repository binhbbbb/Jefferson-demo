package org.vaadin.jefferson.demo;

import org.vaadin.jefferson.Presentation;
import org.vaadin.jefferson.content.SelectionControl;
import org.vaadin.jefferson.content.UIElement;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalSplitPanel;

public class EstatesPresentation extends Presentation {
    public EstatesPresentation() {
        define(SelectionControl.class, Table.class);
        define("Tabs", NativeSelect.class);

        define("Main", VerticalSplitPanel.class);
        define("Main", method("main"));

        define("Properties", HorizontalLayout.class);

        define("Root", method("root"));
        define("Navigation", method("bar"));
        define("Estate info", method("bar"));
        define("Estates", method("fill"));
        define("Expense", method("fill"));
    }

    void bar(UIElement<?> content, Component component) {
        component.addStyleName("bar");
    }

    void fill(UIElement<?> content, Component component) {
        component.setSizeFull();
    }

    void main(UIElement<?> content, Component component) {
        component.setHeight(100, Sizeable.UNITS_PERCENTAGE);
    }

    void root(UIElement<?> content, Component component) {
        component.setHeight(100, Sizeable.UNITS_PERCENTAGE);
    }
}