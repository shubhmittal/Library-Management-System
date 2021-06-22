import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class DBinfo 
{
	public static Vector<String> colsName;
	public static Vector<Vector<String>> allRows;
	
	static
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println("driver loaded ");
	}
	public static Connection getConn(String dbname)
	{
		Connection con=null;
		try 
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname, "root","shubham");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
	
	//21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 21b 
	public static Vector<String> getValues(String tableName)
	{
		Vector<String> v= new Vector<>();
		v.add("Select");//on combo box by default select is written
		Connection con=DBinfo.getConn("library");
		
		String query="select Name from "+tableName+" order by Name";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			
			while(res.next())
			{
				String n=res.getString(1);
				v.add(n);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return v;
	
		
	}

	public static int setValues(String option, String value)
	{
		int i=0;
		Connection con=DBinfo.getConn("library");
		String query="insert into "+option+" values(?,?)";
		
		try
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, 0);
			ps.setString(2,value.toUpperCase());
			i=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return i;
	}
	public static void getBookTable()
	{
		//28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 28b 
		//declaration above
		colsName = new Vector<>();//it will store all the colsName fetched from db
		allRows = new Vector<>();//it will store vectors (containing single-single rows) i.e rows data
		
		Connection con=DBinfo.getConn("library");
		
		String query="select * from book";
		
		try 
		{
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			
			 //------------fetched all the cols names(metadata of the table)--------
			
			ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			
			for(int i=1; i<=count; i++)
			{
				colsName.add(rsmd.getColumnName(i));
			}
			
			 //-----------fetching all the records and will store it into vector of vector
			
			while(res.next())
			{
				Vector<String> singleRow= new Vector<>();
				for(int i=1; i<=count; i++)
				{
					singleRow.add(res.getString(i));
				}
				allRows.add(singleRow);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	public static void getBookTable(String option, String value)
	{
		colsName= new Vector<>();
		allRows= new Vector<>();
		
		Connection con= DBinfo.getConn("library");
		
		String query="select * from book where "+option+"=?";
		
		try 
		{
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,value);
			ResultSet res=ps.executeQuery();
			
			ResultSetMetaData rsmd= res.getMetaData();
			
			int count=rsmd.getColumnCount();
			for(int i=1; i<=count; i++)
			{
				colsName.add(rsmd.getColumnName(i));
			}
			while(res.next())
			{
				Vector<String> singleRow= new Vector<>();
				for(int i=1; i<=count; i++)
				{
					singleRow.add(res.getString(i));
				}
				allRows.add(singleRow);
 			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void getIssueBook()
	{
		// TODO Auto-generated method stub
		colsName =new Vector<>();
		allRows= new Vector<>();
		
		Connection con=DBinfo.getConn("library");
		String query="select * from issuebook";
		try 
		{
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			
			for(int i=1; i<=count; i++)
			{
				colsName.add(rsmd.getColumnName(i));
			}
			while(res.next())
			{
				Vector<String> singleRow= new Vector<>();
				
				for(int i=1; i<=count; i++)
				{
					singleRow.add(res.getString(i));
				}
				allRows.add(singleRow);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void getIssueBook1()
	{
		// TODO Auto-generated method stub
		colsName =new Vector<>();
		allRows= new Vector<>();
		
		Connection con=DBinfo.getConn("library");
		String query="select * from issuebook where ReturnDate is null";
		try 
		{
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			
			for(int i=1; i<=count; i++)
			{
				colsName.add(rsmd.getColumnName(i));
			}
			while(res.next())
			{
				Vector<String> singleRow= new Vector<>();
				
				for(int i=1; i<=count; i++)
				{
					singleRow.add(res.getString(i));
				}
				allRows.add(singleRow);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void getIssueBook(String uname)
	{
		// TODO Auto-generated method stub
		colsName =new Vector<>();
		allRows= new Vector<>();
		
		Connection con=DBinfo.getConn("library");
		String query="select * from issuebook where username=?";
		try 
		{
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,uname);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			
			for(int i=1; i<=count; i++)
			{
				colsName.add(rsmd.getColumnName(i));
			}
			while(res.next())
			{
				Vector<String> singleRow= new Vector<>();
				
				for(int i=1; i<=count; i++)
				{
					singleRow.add(res.getString(i));
				}
				allRows.add(singleRow);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void getPersonalDetail(String uname)
	{
		// TODO Auto-generated method stub
		colsName =new Vector<>();
		allRows= new Vector<>();
		
		Connection con=DBinfo.getConn("library");
		String query="select * from registration where username=?";
		try 
		{
			PreparedStatement ps= con.prepareStatement(query);
			ps.setString(1,uname);
			ResultSet res=ps.executeQuery();
			ResultSetMetaData rsmd=res.getMetaData();
			int count=rsmd.getColumnCount();
			
			for(int i=1; i<=count; i++)
			{
				colsName.add(rsmd.getColumnName(i));
			}
			while(res.next())
			{
				Vector<String> singleRow= new Vector<>();
				
				for(int i=1; i<=count; i++)
				{
					singleRow.add(res.getString(i));
				}
				allRows.add(singleRow);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
}

























