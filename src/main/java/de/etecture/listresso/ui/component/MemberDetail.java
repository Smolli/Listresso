package de.etecture.listresso.ui.component;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;
import de.etecture.listresso.domain.Member;
import de.etecture.listresso.ui.VaadinUI;

@DesignRoot
public class MemberDetail extends VerticalLayout {

    @VaadinUI
    private Label lblName;
    @VaadinUI
    private Label lblBalance;
    @VaadinUI
    private ComboBox selBeverage;

    public MemberDetail(final Member member) {
        super();

        Design.read(this);

        this.lblName.setValue(member.getName());
    }

}
