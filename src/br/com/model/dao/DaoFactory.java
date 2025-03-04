package br.com.model.dao;

import br.com.model.dao.impl.SellerDaoJDBC;
import db.DB;

public class DaoFactory {

	// Operações staticas para instanciar os Daos
	
	public static SellerDao createSellerDao() { // interface SellerDao 
		
		return new SellerDaoJDBC(DB.getConnection()); // Ela irá instanciar uma implementação 
		
		
		
	}
	
}

