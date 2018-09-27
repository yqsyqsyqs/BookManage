package cn.gson.bookmanage.common;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class BaseDao {
	String driver="oracle.jdbc.driver.OracleDriver";//驱动
	String url="jdbc:oracle:thin:@127.0.0.1:1521:orcl";//服务器地址ַ
	String username="scott";//连接的用户名
	String pwd="yqs0214365987";//数据库连接密码

	/**
	 * 获得连接
	 */
	public  Connection getConnection(){
		//3、加载驱动
		try {
			Class.forName(driver);
			//4、获得连接
			return DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *关闭所有连接，释放资源
	 * @param con
	 * @param ps
	 * @param rs
	 */
	public void closeAll(Connection con,PreparedStatement ps,ResultSet rs){
		//第八步  关闭连接,先开启的后关闭
		try {
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void closeAll(Connection con, PreparedStatement ps) {
		// TODO 自动生成的方法存根
		try {
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

