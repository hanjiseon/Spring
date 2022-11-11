// Thread : Runable인터페이스를 구현하거나, Runable 인터페이스를 구현한  Thread를 상속
// run() : Thread가 수행할 로직 (일반적으로 while(true)를 사용하고 조건에 따아 빠져나가도록 설계)
public class BankingThread extends Thread {
	int CSaccount = 100000;
	int YHaccount = 50000;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000); // 1000밀리세컨드 동안 해당스레드가 작업을 중지

				// sleep을 해야하는데 다른 쓰레드가 sleep을 방해하면 발생
			} catch (InterruptedException ie) {
			}
			// 1000~10000까지 1000단위로 임의 숫자 생성
			int money = ((int) (Math.random() * 10) + 1) * 1000;
			this.CSaccount = this.CSaccount - money;
			this.YHaccount = this.YHaccount + money;
			System.out.println("입출액 금액: " + money);
			System.out.println("철수의 계좌: " + CSaccount);
			System.out.println("영희의 계좌: " + YHaccount);
		}

	}

}
