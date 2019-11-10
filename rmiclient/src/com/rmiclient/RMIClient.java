package com.rmiclient;

import com.rmiregister.RMIInterface;

import javax.swing.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    private static RMIInterface lookUp;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(null);
        RMIInterface stub = (RMIInterface) registry.lookup("RMIInterface");

        String txt = JOptionPane.showInputDialog("What is your name?");

        boolean response = stub.isLeapYear(Integer.parseInt(txt));
        JOptionPane.showMessageDialog(null, response ? "This year is leap" : "This year is not leap");
    }
}
