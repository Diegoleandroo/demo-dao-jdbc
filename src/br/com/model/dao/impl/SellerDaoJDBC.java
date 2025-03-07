package br.com.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.model.dao.SellerDao;
import br.com.model.entities.Department;
import br.com.model.entities.Seller;
import db.DB;
import db.DbException;

public class SellerDaoJDBC implements SellerDao{

	// Esses metodos são o que foram criados na interface SellerDao
	
	private Connection conn; //O objeto conn terá toda a disponibilidade
	                         //                         
	
	
	public SellerDaoJDBC(Connection conn) { // Connection esta dado como parametro
		
		this.conn = conn;
		
	}
	
	@Override
	public void insert(Seller obj) {

		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					 "SELECT seller.*, department.Name as DepName " +
					 "FROM seller INNER JOIN department " +
					 "ON seller.DepartmentId = department.Id " +
					 "WHERE seller.Id = ?");
					
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				
				Department dep = new Department(); // Instanciamos o Departamento e sentamo ele 
				
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				
				Seller obj = new Seller();
				
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep); // setDep esta sendo direcionado aou Instanciamento departamento 
				
				return obj;
				
			}

			return null;
			
		} catch (SQLException e ) {
			
			throw new DbException(e.getMessage()); 
			
		} finally {
			
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			
		}
		
		
		

	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
