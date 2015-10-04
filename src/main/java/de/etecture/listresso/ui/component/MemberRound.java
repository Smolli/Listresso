package de.etecture.listresso.ui.component;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.declarative.Design;
import de.etecture.listresso.domain.Member;
import de.etecture.listresso.ui.VaadinUI;

@DesignRoot
public class MemberRound extends HorizontalLayout {

    @VaadinUI
    private Label lblName;
    @VaadinUI
    private Label lblPrice;
//    @VaadinUI
//    private Button btnMember;

    private boolean active = true;

    public MemberRound(final Member member) {
        super();

        Design.read(this);

        this.lblName.setValue(member.getName());

        this.setStyleName("active");
        this.addLayoutClickListener(this::toggleEvent);
    }

    private void toggleEvent(LayoutClickEvent event) {
        this.active = !this.active;

        this.setStyleName(this.active ? "active" : "inactive");
    }
}
