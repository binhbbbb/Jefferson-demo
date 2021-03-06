package org.vaadin.jefferson.demo.addressbook;

import org.vaadin.jefferson.demo.addressbook.content.AddressBookView;
import org.vaadin.jefferson.demo.addressbook.domain.PersonContainer;
import org.vaadin.jefferson.presentation.SmartPresentation;
import org.vaadin.jefferson.presentation.SmartPresentation.Orientation;

import com.vaadin.Application;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AddressBookDemo extends Application {
    private PersonContainer dataSource = PersonContainer.createWithTestData();

    @Override
    public void init() {
        setMainWindow(new Window("Address Book Demo application",
                new SmartPresentation(Orientation.VERTICAL).visit(
                        new AddressBookView(dataSource))));
    }
}
