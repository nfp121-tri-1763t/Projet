/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Observer;

import java.util.Observable;
import java.util.Observer;
import projet.adapter.JSonNotification;
import projet.adapter.Message;
import projet.adapter.XmlNotification;
import projet.models.Notification;

/**
 *
 * @author user
 */
public class DoctorObserver implements Observer {

    String Format = "TEXT";
    int Severity_Degree;
    Notification not;
    Message msg;
    String newLine = System.getProperty("line.separator");

    public void update(Observable obj, Object arg) {
        System.out.println("Doctor =>" + newLine + "Format:" + Format + newLine + "Severity Degree:" + Severity_Degree);
        msg.display(Format, (Notification) arg);
        System.out.println();
    }

    public DoctorObserver(String Format, int Severity_Degree) {

        this.Format = Format;
        this.Severity_Degree = Severity_Degree;
        msg = new Message();
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String Format) {
        this.Format = Format;
    }

    public int getSeverity_Degree() {
        return Severity_Degree;
    }

    public void setSeverity_Degree(int Severity_Degree) {
        this.Severity_Degree = Severity_Degree;
    }

}
