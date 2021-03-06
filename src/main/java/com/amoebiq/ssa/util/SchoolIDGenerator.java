package com.amoebiq.ssa.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;




public class SchoolIDGenerator implements IdentifierGenerator{
	
	private static final String _NAME = "SCH";
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		
		Connection connection = session.connection();
		
		try {
            Statement statement= connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(id) as Id from school");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = _NAME + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
	

}
