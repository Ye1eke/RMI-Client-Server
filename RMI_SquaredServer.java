import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMI_SquaredServer extends UnicastRemoteObject implements RMI_SquaredInterface {

    public RMI_SquaredServer() throws RemoteException {
        super();
    }

    @Override
    public double getSquare(double input) throws RemoteException {
        return input * input;
    }

    @Override
    public double getSquareRoot(double input) throws RemoteException {
        return Math.sqrt(input);
    }

    public static void main(String[] args) throws RemoteException {
        try {
            Registry registry = LocateRegistry.createRegistry(7777);
            registry.bind("squared", new RMI_SquaredServer());
            System.out.println("The RMI_SquaredApp is running and ready....");

        } catch (Exception e) {
            System.out.println("ERROR: The RMI_SquaredApp is not running....");
        }
    }

}

