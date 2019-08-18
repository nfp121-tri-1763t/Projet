/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.adapter;

import projet.models.Notification;

/**
 *
 * @author user
 */
public class NotificationAdapter implements INotification {

    IFormatNotification formatNotification;

    public NotificationAdapter(String format) {

        switch (format) {
            case "TEXT":
                this.formatNotification = new TextNotification();
                break;
            case "XML":
                this.formatNotification = new XmlNotification();
                break;
            case "JSON":
                this.formatNotification = new JSonNotification();
                break;

        }
    }

    @Override
    public void display(String format, Notification not) {

        switch (format) {
            case "TEXT":
                formatNotification.displayText(not);
                break;
            case "XML":
                formatNotification.displayXml(not);
                break;
            case "JSON":
                formatNotification.displayJson(not);
                break;

        }

    }

}
