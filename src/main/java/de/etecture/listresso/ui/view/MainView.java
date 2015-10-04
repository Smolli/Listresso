package de.etecture.listresso.ui.view;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Responsive;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import de.etecture.listresso.ui.ListressoUI;
import de.etecture.listresso.ui.VaadinUI;
import de.etecture.listresso.ui.service.Endpoint;

@DesignRoot
//@SpringComponent
public class MainView extends VerticalLayout implements View {

//    @Autowired
//    private NavigationService navigationService;

    @VaadinUI
    private Button btnMembers;
    @VaadinUI
    private Button btnRounds;

    public MainView() {
        super();

        Design.read(this);

        this.btnMembers.addClickListener(e -> ListressoUI.getNavigationService().to(Endpoint.MEMBERS));
        this.btnRounds.addClickListener(e -> ListressoUI.getNavigationService().to(Endpoint.ROUNDS));

        Responsive.makeResponsive(this);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
