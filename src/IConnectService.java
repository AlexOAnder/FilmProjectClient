import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Entities.CustomOrderView;
import Entities.Film;
import Entities.Order;

public interface IConnectService extends Remote{

	public List<Order> GetOrders() throws RemoteException;
			
	public List<Film> GetFilmsList() throws RemoteException;
		
	public boolean GetStatusConnect() throws RemoteException;
	
	public List<CustomOrderView> GetCustomOrderViewList() throws RemoteException;
	
	void AddNewCustomOrderView(CustomOrderView order) throws RemoteException;
	
	void UpdateOrderStatus(int orderId) throws RemoteException;
}
