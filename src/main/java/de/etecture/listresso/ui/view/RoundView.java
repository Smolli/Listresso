package de.etecture.listresso.ui.view;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import de.etecture.listresso.ui.ListressoUI;
import de.etecture.listresso.ui.VaadinUI;
import de.etecture.listresso.ui.component.MemberRound;

@DesignRoot
//@SpringComponent
public class RoundView extends VerticalLayout implements View {

//    @Autowired
//    private NavigationService navigationService;
//    @Autowired
//    private MemberRepository memberRepository;

    @VaadinUI
    private Button btnBack;
    @VaadinUI
    private Button btnSave;
    @VaadinUI
    private VerticalLayout listMembers;

    public RoundView() {
        super();

        Design.read(this);

        this.btnBack.addClickListener(e -> ListressoUI.getNavigationService().back());
    }

    @Override
    public void enter(ViewChangeEvent event) {
        this.listMembers.removeAllComponents();

        ListressoUI.getMemberRepository().findAll().stream()
            .map(MemberRound::new)
            .forEach(this.listMembers::addComponent);
    }

}
