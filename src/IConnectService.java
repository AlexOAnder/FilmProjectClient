
import java.rmi.RemoteException;
import java.util.List;

import Entities.Order;
public interface IConnectService{

	public List<Order> GetOrders() throws RemoteException;
			
	public String[] GetFilmsList()	throws RemoteException;
	
	public void AddNewOrder(Order order) throws RemoteException;
	
	public void UpdateOrderStatusById(int id,int status) throws RemoteException;
}
