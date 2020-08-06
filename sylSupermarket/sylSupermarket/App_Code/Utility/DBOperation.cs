using System;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Collections;

namespace SuperMarket.Utility
{
	/// <summary>
	/// ���ݿ������
	/// </summary>
	public class DBOperation
	{
		#region private utility methods & constructors
		//���ݿ����ᴮ
		public static readonly string CONN_STRING_NON_DTC = ConfigurationSettings.AppSettings["ConnectionString"];

		// ��Hashtable����洢����
		private static Hashtable parmCache = Hashtable.Synchronized(new Hashtable());

		/// <summary>
		/// ִ��ǰ׼������(�������Ը�ֵ)
		/// </summary>
		/// <param name="cmd">SqlCommand����</param>
		/// <param name="conn">SqlConnection����</param>
		/// <param name="trans">SqlTransaction����</param>
		/// <param name="cmdType">��������(stored procedure, text)</param>
		/// <param name="cmdText">�洢��������T-SQL����</param>
		/// <param name="cmdParms">��������</param>
		private static void PrepareCommand(SqlCommand cmd, SqlConnection conn, SqlTransaction trans, CommandType cmdType, string cmdText, SqlParameter[] cmdParms) 
		{

			if (conn.State != ConnectionState.Open)
				conn.Open();

			cmd.Connection = conn;
			cmd.CommandText = cmdText;

			if (trans != null)
				cmd.Transaction = trans;

			cmd.CommandType = cmdType;

			if (cmdParms != null) 
			{
				foreach (SqlParameter parm in cmdParms)
					cmd.Parameters.Add(parm);
			}
		}

		/// <summary>
		/// ��Ӳ������ϵ������С�
		/// </summary>
		/// <param name="cacheKey">������ֵ</param>
		/// <param name="cmdParms">��������</param>
		public static void CacheParameters(string cacheKey, params SqlParameter[] cmdParms) 
		{
			parmCache[cacheKey] = cmdParms;
		}

		/// <summary>
		/// ȡ�û������
		/// </summary>
		/// <param name="cacheKey">������ֵ</param>
		/// <returns>��������</returns>
		public static SqlParameter[] GetCachedParameters(string cacheKey) 
		{
			SqlParameter[] cachedParms = (SqlParameter[])parmCache[cacheKey];
			
			if (cachedParms == null)
				return null;
			
			SqlParameter[] clonedParms = new SqlParameter[cachedParms.Length];

			for (int i = 0, j = cachedParms.Length; i < j; i++)
				clonedParms[i] = (SqlParameter)((ICloneable)cachedParms[i]).Clone();

			return clonedParms;
		}
		#endregion

		#region ExecuteNonQuery 
		/// <summary>
		/// ͨ�����������ݿ����ᴮִ������
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  int result = ExecuteNonQuery(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">���ݿ����ᴮ</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>Ӱ�������</returns>
		public static int ExecuteNonQuery(string connString, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{

			SqlCommand cmd = new SqlCommand();

			using (SqlConnection conn = new SqlConnection(connString)) 
			{
				PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);
				int val = cmd.ExecuteNonQuery();
				cmd.Parameters.Clear();
				return val;
			}
		}

		/// <summary>
		/// ͨ��������SqlConnection���ݿ��������ִ������
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  int result = ExecuteNonQuery(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">SqlConnection����</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>Ӱ�������</returns>
		public static int ExecuteNonQuery(SqlConnection conn, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{

			SqlCommand cmd = new SqlCommand();

			PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);
			int val = cmd.ExecuteNonQuery();
			cmd.Parameters.Clear();
			return val;
		}

		/// <summary>
		/// ͨ��������SqlTransaction�������ִ������
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  int result = ExecuteNonQuery(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">SqlConnection����</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>Ӱ�������</returns>
		public static int ExecuteNonQuery(SqlTransaction trans, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{
			SqlCommand cmd = new SqlCommand();
			PrepareCommand(cmd, trans.Connection, trans, cmdType, cmdText, cmdParms);
			int val = cmd.ExecuteNonQuery();
			cmd.Parameters.Clear();
			return val;
		}

        //ִ��һЩ������ϵ��Ҫһ�γɹ���sql��䣬ʹ���������
        public static bool ExecuteStoreProcedure(string connString,String[] SqlStrings,SqlParameter[][] cmdParms)
        {
            bool success = true;
            SqlCommand cmd = new SqlCommand();
            int i = 0;
			using (SqlConnection conn = new SqlConnection(connString)) 
			{
                conn.Open();
                SqlTransaction trans = conn.BeginTransaction(); /*��ʼ����*/
                cmd.Connection = conn;
                cmd.Transaction = trans;
                try
                {
                    foreach (String sqlstr in SqlStrings)
                    {
                        cmd.CommandText = sqlstr;
                        if (cmdParms != null)
                        {
                            foreach (SqlParameter parm in cmdParms[i])
                                cmd.Parameters.Add(parm);    
                        }
                        cmd.ExecuteNonQuery();
                        i++;
                    }
                    cmd.Parameters.Clear();
                    trans.Commit();
                }
                catch
                {
                    success = false;
                    trans.Rollback();
                }
                finally
                {
                    conn.Close();
                }
			}
            return success;
        }
  
		#endregion

		#region ExecuteDataTable
		/// <summary>
		/// ͨ�����������ݿ����ᴮִ������
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  int result = ExecuteDataTable(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">���ݿ����ᴮ</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>�������ݼ�</returns>
		public static DataTable ExecuteDataTable(string connString, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{
			SqlCommand cmd = new SqlCommand();

			using (SqlConnection conn = new SqlConnection(connString)) 
			{
				PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);

				SqlDataAdapter da = new SqlDataAdapter(cmd);
				DataTable dt = new DataTable();

				da.Fill(dt);
					
				cmd.Parameters.Clear();

				return dt;		
			}
		}

        /*����sql��ѯ���õ��ڴ����ݼ�*/
        public static DataSet GetDataSet(string connString, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms)
        {
            SqlCommand cmd = new SqlCommand();

            using (SqlConnection conn = new SqlConnection(connString))
            {
                PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                cmd.Parameters.Clear();
                return ds;
            }
        }


		/// <summary>
		/// ͨ��������SqlConnection���ݿ��������ִ������
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  int result = ExecuteDataTable(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">SqlConnection����</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>�������ݼ�</returns>
		public static DataTable ExecuteDataTable(SqlConnection conn, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{

			SqlCommand cmd = new SqlCommand();

			PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);

			SqlDataAdapter da = new SqlDataAdapter(cmd);
			DataTable dt = new DataTable();

			da.Fill(dt);
					
			cmd.Parameters.Clear();

			return dt;		
		}

		/// <summary>
		/// ͨ��������SqlTransaction�������ִ������
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  int result = ExecuteDataTable(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">SqlConnection����</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>�������ݼ�</returns>
		public static DataTable ExecuteDataTable(SqlTransaction trans, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{
			SqlCommand cmd = new SqlCommand();
			PrepareCommand(cmd, trans.Connection, trans, cmdType, cmdText, cmdParms);

			SqlDataAdapter da = new SqlDataAdapter(cmd);

			DataTable dt = new DataTable();

			da.Fill(dt);
					
			cmd.Parameters.Clear();

			return dt;		
		}
		#endregion

		#region ExecuteReader
		/// <summary>
		/// ͨ�����������ݿ����ᴮִ���������һ��SqlDataReader����
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  SqlDataReader r = ExecuteReader(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">���ݿ����ᴮ</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>SqlDataReader����</returns>
		public static SqlDataReader ExecuteReader(string connString, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{
			SqlCommand cmd = new SqlCommand();
			SqlConnection conn = new SqlConnection(connString);

			try 
			{
				PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);
				SqlDataReader rdr = cmd.ExecuteReader(CommandBehavior.CloseConnection);
				cmd.Parameters.Clear();
				return rdr;
			}
			catch 
			{
				conn.Close();
				throw;
			}
		}
		#endregion

		#region ExecuteScalar
		/// <summary>
		/// ͨ�����������ݿ����ᴮִ��������ؼ�¼����һ����Ϣ�ĵ�һ�С�
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  Object obj = ExecuteScalar(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">���ݿ����ᴮ</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>ʹ��Convert.To{Type}������Ҫ������</returns>
		public static object ExecuteScalar(string connString, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{
			SqlCommand cmd = new SqlCommand();

			using (SqlConnection conn = new SqlConnection(connString)) 
			{
				PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);
				object val = cmd.ExecuteScalar();
				cmd.Parameters.Clear();
				return val;
			}
		}

		/// <summary>
		/// ͨ��������SqlConnection���ݿ��������ִ��������ؼ�¼����һ����Ϣ�ĵ�һ�С�
		/// </summary>
		/// <remarks>
		/// e.g.:  
		///  Object obj = ExecuteScalar(connString, CommandType.StoredProcedure, "PublishOrders", new SqlParameter("@prodid", 24));
		/// </remarks>
		/// <param name="connectionString">���ݿ����ᴮ</param>
		/// <param name="commandType">��������(stored procedure, text, etc.)</param>
		/// <param name="commandText">�洢��������T-SQL����</param>
		/// <param name="commandParameters">��������</param>
		/// <returns>ʹ��Convert.To{Type}������Ҫ������</returns>
		public static object ExecuteScalar(SqlConnection conn, CommandType cmdType, string cmdText, params SqlParameter[] cmdParms) 
		{
			
			SqlCommand cmd = new SqlCommand();

			PrepareCommand(cmd, conn, null, cmdType, cmdText, cmdParms);
			object val = cmd.ExecuteScalar();
			cmd.Parameters.Clear();
			return val;
		}
		#endregion


	}
}