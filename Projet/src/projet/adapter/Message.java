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
public class Message implements INotification {

    NotificationAdapter notificationAdapter;

    @Override
    public void display(String format, Notification not) {
        if (format.equals("TEXT") || format.equals("XML") || format.equals("JSON")) {
            notificationAdapter = new NotificationAdapter(format);
            notificationAdapter.display(format, not);
        } else {
            System.out.println("Invalid Format. " + format + " format not supported");
        }
    }

}
