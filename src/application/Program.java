package application;

import java.util.Date;

import br.com.model.dao.DaoFactory;
import br.com.model.dao.SellerDao;
import br.com.model.entities.Department;
import br.com.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SellerDao sellerDao = DaoFactory.createSellerDao(); // A interface foi implantada
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		

		
	}

}
