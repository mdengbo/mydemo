using System;
using System.IO;
using System.Text;
using System.Configuration;

namespace SuperMarket.Utility
{
	/// <summary>
	/// Logger ��ժҪ˵����
	/// </summary>
	public class Logger
	{
		public struct ErrorInfo
		{ 
			//��������ʱ�� 
			public string ErrorTime;
			//��ǰ�û� 
			public string User;
			//Ӧ�ó�������
			public string AppName;
			//��������������
			public string ClassName; 
			//�������ķ�������
			public string FunctionName;
			//������Ϣ
			public string ErrorMessage; 

			public ErrorInfo(string user,
									string appName,
									string className,
									string functionName,
									string errorMessage)
			{
				this.ErrorTime = DateTime.Now.ToString();
				this.User = user;
				this.AppName = appName;
				this.ClassName = className;
				this.FunctionName = functionName;
				this.ErrorMessage = errorMessage;
			}

		} 
		
		public Logger()
		{
			//
			// TODO: �ڴ˴���ӹ��캯���߼�
			//
		}
		
		public void SetErrorLog(ErrorInfo errorInfo)
		{
			string path = ConfigurationSettings.AppSettings["logPath"];

			FileStream fs = new FileStream(path,FileMode.Append,FileAccess.Write,FileShare.None);

			StreamWriter sw = new StreamWriter(fs);
			
			StringBuilder sb = new StringBuilder();

			sb.Append(errorInfo.ErrorTime);
			sb.Append("     ");
			sb.Append(errorInfo.User);
			sb.Append("     ");
			sb.Append(errorInfo.AppName);
			sb.Append("     ");
			sb.Append(errorInfo.ClassName);
			sb.Append("     ");
			sb.Append(errorInfo.FunctionName);
			sb.Append("     ");
			sb.Append(errorInfo.ErrorMessage);


			sw.WriteLine(sb.ToString());
			sb = null;
			sw.Close();

			fs.Close();

		}
	}
}
