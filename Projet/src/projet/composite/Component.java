/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.composite;

import javafx.beans.Observable;
import projet.models.Notification;

/**
 *
 * @author user
 */
public interface Component {

    abstract void sendMessage(Notification not);
}
