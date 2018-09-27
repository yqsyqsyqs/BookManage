package cn.gson.bookmanage.common;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;
public class Procedure extends BaseDao{

		public  void callProcedureY(Object...objects){ 
			Connection con=super.getConnection();
			CallableStatement cs = null;
			//创建执行对象
			try {
				//指定调用的存储过程
				
			if(objects.length==3){
				//如果是两个参数
				cs = invoke(objects[0], objects[1],objects[2], con);
			}//执行存储过程调用 
				cs.execute(); 
				//System.out.println("返回值:");
				//System.out.println(cs.getInt(3));
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					cs.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private CallableStatement invoke(Object id, Object col1, Object functionName, Connection con) throws SQLException {
			CallableStatement cs = null;
			String name=functionName.toString();
			switch (name) {
			case "Updatebook":
				cs = con.prepareCall("{call "+name+"(?,?)}");
				cs.setLong(1, Long.valueOf(id.toString()));
				cs.setInt(2, Integer.valueOf(col1.toString()));
				break;
			default:
				break;
			}
			
			 // cs.registerOutParameter(3, OracleTypes.INTEGER);//接收返回值
			return cs;
		} 


	}

