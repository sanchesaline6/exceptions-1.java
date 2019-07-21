package secao10_problema_exemplo.exceptions;

public class DomainException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg)
	{
		super(msg);
	}
}
