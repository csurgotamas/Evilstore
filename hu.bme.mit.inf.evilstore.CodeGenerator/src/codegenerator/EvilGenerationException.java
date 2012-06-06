package codegenerator;

public class EvilGenerationException extends Exception {

	private static final long serialVersionUID = 5610890989570437619L;
	
	public EvilGenerationException(String reason)
	{
		super(reason);
	}
	
	public String getReason()
	{
		return this.getMessage();
	}
}
