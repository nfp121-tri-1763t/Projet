/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import projet.view.PatientView;
import projet.models.Notification;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.util.Observer;
import javax.swing.JButton;
import projet.Observer.AmbulanceObserver;
import projet.Observer.DoctorObserver;
import projet.Observer.NurseObserver;
import projet.Observer.RelativesObserver;
import projet.composite.Component;
import projet.composite.Leaf;
import projet.composite.NotRoom;

/**
 *
 * @author user
 */
public class Projet implements ActionListener {

    /**
     * @param args the command line arguments
     */
    static PatientView view;
    static JButton btnSend;
    String msgDescription;
    String msgValue;
    int type;

    Notification not;

    static Leaf TresUrgentLeaf;
    static Leaf CritiqueLeaf;
    static Leaf NormaLeaf;

    static NotRoom notRoomCritique;
    static NotRoom notRoomNormale;
    static NotRoom notRoomTresUrgent;

    //default Constructeur
    public Projet() {

    }

    enum Format {
        TEXT, JSON, XML
    }

    public static void main(String[] args) {

        //Interface Graphique 
        Projet p = new Projet();

        view = new PatientView();
        view.show();

        btnSend = view.btnSendNot;

        //set action listeners 
        btnSend.addActionListener(p);

        //composite
        TresUrgentLeaf = new Leaf();
        CritiqueLeaf = new Leaf();
        NormaLeaf = new Leaf();

        notRoomCritique = new NotRoom();
        notRoomNormale = new NotRoom();
        notRoomTresUrgent = new NotRoom();

        //generate Observers
        AmbulanceObserver RedCrossAmbulance = new AmbulanceObserver(String.valueOf(Format.XML), 3);
        AmbulanceObserver Jam3iyeTebiyeAmbulance = new AmbulanceObserver(String.valueOf(Format.JSON), 3);

        DoctorObserver HeartDoctor = new DoctorObserver(String.valueOf(Format.XML), 2);
        DoctorObserver EyesDoctor = new DoctorObserver(String.valueOf(Format.JSON), 2);

        NurseObserver StaffNurse = new NurseObserver(String.valueOf(Format.XML), 1);
        NurseObserver ManagerNurse = new NurseObserver(String.valueOf(Format.TEXT), 1);

        RelativesObserver Parents = new RelativesObserver(String.valueOf(Format.JSON), 1);
        RelativesObserver Cousins = new RelativesObserver(String.valueOf(Format.TEXT), 1);

        addObverSuitableForObvable(RedCrossAmbulance, RedCrossAmbulance.getSeverity_Degree());
        addObverSuitableForObvable(Jam3iyeTebiyeAmbulance, Jam3iyeTebiyeAmbulance.getSeverity_Degree());
        addObverSuitableForObvable(HeartDoctor, HeartDoctor.getSeverity_Degree());
        addObverSuitableForObvable(EyesDoctor, EyesDoctor.getSeverity_Degree());
        addObverSuitableForObvable(StaffNurse, StaffNurse.getSeverity_Degree());
        addObverSuitableForObvable(ManagerNurse, ManagerNurse.getSeverity_Degree());
        addObverSuitableForObvable(Parents, Parents.getSeverity_Degree());
        addObverSuitableForObvable(Cousins, Cousins.getSeverity_Degree());

        //composite hierarchy
        notRoomCritique.add(CritiqueLeaf);
        notRoomCritique.add(NormaLeaf);

        notRoomTresUrgent.add(NormaLeaf);
        notRoomTresUrgent.add(CritiqueLeaf);
        notRoomTresUrgent.add(TresUrgentLeaf);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Send Notification")) {
            msgDescription = view.txtDescription.getText();
            msgValue = view.txtValue.getText();
            type = (int) view.jSpinnerType.getValue();

            not = new Notification(msgDescription, msgValue, type);

            switch (not.getType()) {
                case 1:
                    NormaLeaf.sendMessage(not);
                    break;
                case 2:
                    notRoomCritique.sendMessage(not);
                    break;
                case 3:
                    notRoomTresUrgent.sendMessage(not);
                    break;
            }

        }

    }

    public static void addObverSuitableForObvable(Observer obver, int degree) {

        switch (degree) {

            case 1:
                NormaLeaf.addObserver(obver);
                break;
            case 2:
                CritiqueLeaf.addObserver(obver);
                break;
            case 3:
                TresUrgentLeaf.addObserver(obver);
                break;

        }

    }

}
