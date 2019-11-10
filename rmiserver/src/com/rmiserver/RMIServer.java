package com.rmiserver;

import com.rmiregister.RMIInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static java.time.Year.isLeap;

public class RMIServer implements RMIInterface {
    protected RMIServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            RMIServer server = new RMIServer();
            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(server, 8080);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("RMIInterface", stub);
            /*System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Naming.rebind("//127.0.0.1", new RMIServer());*/
            System.out.println("Server ready");

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public boolean isLeapYear(int year) {
        return isLeap(year);
    }
}
