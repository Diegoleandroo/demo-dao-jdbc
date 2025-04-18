package application;

import java.util.List;

import br.com.model.dao.DaoFactory;
import br.com.model.dao.SellerDao;
import br.com.model.entities.Department;
import br.com.model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SellerDao sellerDao = DaoFactory.createSellerDao(); // A interface foi implantada
		
		
		System.out.println("=== TEST  1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		
		System.out.println("\n=== TEST  2: seller findByDepartment ====");
		Department department = new Department(2, null); 
		List<Seller> list = sellerDao.findByDepartment(department); 
		for (Seller obj : list) {
			
			System.out.println(obj);
			
		}
		
		
		System.out.println("\n=== TEST  3: seller findALL ===="); 
		list = sellerDao.findByDepartment(department); 
		
		for (Seller obj : list) {
			
			System.out.println(obj);
			
		}
		
	}

}
