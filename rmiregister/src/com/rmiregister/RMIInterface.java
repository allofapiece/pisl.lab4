package com.rmiregister;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @version 1.0.0
 */
public interface RMIInterface extends Remote {
    public boolean isLeapYear(int year) throws RemoteException;
}
