public class BankingTest {

	public BankingTest() {
		new BankingThread().start();
	}
	
	private BankingThread bankingThread;
	
	public static void main(String[] args) {
		BankingTest bankingTest = new BankingTest();
	}

}
