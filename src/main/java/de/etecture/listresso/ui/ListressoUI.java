package de.etecture.listresso.ui;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import de.etecture.listresso.repository.MemberRepository;
import de.etecture.listresso.ui.service.Endpoint;
import de.etecture.listresso.ui.service.NavigationService;
import de.etecture.listresso.ui.view.MainView;
import de.etecture.listresso.ui.view.MemberView;
import de.etecture.listresso.ui.view.RoundView;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("mytheme")
@Widgetset("widgetset.MyAppWidgetset")
@SpringUI
public class ListressoUI extends UI {

    @Autowired
    private NavigationService navigationService;
    @Autowired
    private MemberRepository memberRepository;

//    @Autowired
//    private MainView mainView;
//    @Autowired
//    private MemberView memberView;
//    @Autowired
//    private RoundView roundView;

    @Override
    protected void init(VaadinRequest request) {
        this.getPage().setTitle("Listresso!");

        this.navigationService.root(this);

        this.navigationService.bind(new MainView(), null, Endpoint.OVERVIEW);
        this.navigationService.bind(new MemberView(), Endpoint.MEMBERS);
        this.navigationService.bind(new RoundView(), Endpoint.ROUNDS);

        Responsive.makeResponsive(this);
    }

    public static NavigationService getNavigationService(){
        return ((ListressoUI)getCurrent()).navigationService;
    }

    public static MemberRepository getMemberRepository(){
        return ((ListressoUI)getCurrent()).memberRepository;
    }

}
