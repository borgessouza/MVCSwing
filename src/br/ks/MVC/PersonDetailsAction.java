package br.ks.MVC;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PersonDetailsAction extends AbstractAction {

    private static final long serialVersionUID = -8816163868526676625L;

    private ListSelectionModel personSelectionModel;
    private DefaultListModel personListModel;

    public PersonDetailsAction(ListSelectionModel personSelectionModel,
            DefaultListModel personListModel) {
        boolean unsupportedSelectionMode = personSelectionModel
                .getSelectionMode() != ListSelectionModel.SINGLE_SELECTION;
        if (unsupportedSelectionMode) {
            throw new IllegalArgumentException(
                    "PersonDetailAction can only handle single list selections. "
                            + "Please set the list selection mode to ListSelectionModel.SINGLE_SELECTION");
        }
        this.personSelectionModel = personSelectionModel;
        this.personListModel = personListModel;
        personSelectionModel
                .addListSelectionListener(new ListSelectionListener() {

                    public void valueChanged(ListSelectionEvent e) {
                        ListSelectionModel listSelectionModel = (ListSelectionModel) e
                                .getSource();
                        updateEnablement(listSelectionModel);
                    }
                });
        updateEnablement(personSelectionModel);
    }

    public void actionPerformed(ActionEvent e) {
        int selectionIndex = personSelectionModel.getMinSelectionIndex();
        PersonElementModel personElementModel = (PersonElementModel) personListModel
                .get(selectionIndex);

        Person person = personElementModel.getPerson();
        String personDetials = createPersonDetails(person);

        JOptionPane.showMessageDialog(null, personDetials);
    }

    private String createPersonDetails(Person person) {
        return person.getId() + ": " + person.getFirstName() + " "
                + person.getLastName();
    }

    private void updateEnablement(ListSelectionModel listSelectionModel) {
        boolean emptySelection = listSelectionModel.isSelectionEmpty();
        setEnabled(!emptySelection);
    }

}

