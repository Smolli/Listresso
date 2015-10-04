package de.etecture.listresso.ui.view;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import de.etecture.listresso.domain.Member;
import de.etecture.listresso.ui.ListressoUI;
import de.etecture.listresso.ui.VaadinUI;
import de.etecture.listresso.ui.component.MemberDetail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//@SpringComponent
@DesignRoot
public class MemberView extends VerticalLayout implements View {

//    @Autowired
//    private transient NavigationService navigationService;
//    @Autowired
//    private transient MemberRepository memberRepository;

    @VaadinUI
    private Button btnBack;
    @VaadinUI
    private VerticalLayout listMembers;
    @VaadinUI
    @Size(message = "Please give a proper name.", min = 3, max = 20)
    @NotNull
    private TextField textMemberName;
    @VaadinUI
    private Button btnMemberAdd;

    public MemberView() {
        super();

        Design.read(this);

        this.btnBack.addClickListener(e -> ListressoUI.getNavigationService().back());
        this.btnMemberAdd.addClickListener(e -> this.addNewMember());
        this.textMemberName.setImmediate(false);
    }

    private void addNewMember() {
        this.textMemberName.validate();

        if (this.textMemberName.isValid()) {
            final Member member = new Member();
            final String memberName = this.textMemberName.getValue();

            member.setName(memberName);

            this.listMembers.addComponent(new MemberDetail(member));

            ListressoUI.getMemberRepository().save(member);
        }
    }

    @Override
    public void enter(final ViewChangeEvent event) {
        this.listMembers.removeAllComponents();

        final List<Member> members = ListressoUI.getMemberRepository().findAll();
        members.stream()
            .map(MemberDetail::new)
            .forEach(this.listMembers::addComponent);
    }

}
