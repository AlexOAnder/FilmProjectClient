import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Entities.Film;
import Entities.Order;

public interface IConnectService extends Remote{

	public List<Order> GetOrders() throws RemoteException;
			
	public List<Film> GetFilmsList() throws RemoteException;
	
	public void AddNewOrder(Order order) throws RemoteException;
	
	public void UpdateOrderStatusById(int id,int status) throws RemoteException;
	
	public boolean GetStatusConnect() throws RemoteException;
}
