package custom_Exception;

import java.lang.Exception;

@SuppressWarnings("serial")
public class MyBankingException extends Exception {
	
	public MyBankingException(String msg)
	{
		super(msg);
	}

}
