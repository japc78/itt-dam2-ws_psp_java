package app;

import java.rmi.Remote;
import java.rmi.RemoteException;

import beans.Constelacion;

/**
 * ConstalacionInterface
 */
public interface AppInterface extends Remote {
	public String listarConstelaciones() throws RemoteException;
	public String buscarPorNombre(String name) throws RemoteException;
	public Constelacion buscarPorId(int i) throws RemoteException;
}