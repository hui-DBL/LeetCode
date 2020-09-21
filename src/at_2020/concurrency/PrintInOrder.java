package at_2020.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hui.zhong
 * @date 2020-09-21
 */
public class PrintInOrder {

	public static void main(String[] args) throws InterruptedException {

		Runnable first = new Runnable() {
			@Override
			public void run() {
				System.out.println("first");
			}
		};
		Runnable second = new Runnable() {
			@Override
			public void run() {
				System.out.println("second");
			}
		};
		Runnable third = new Runnable() {
			@Override
			public void run() {
				System.out.println("third");
			}
		};

		Thread f = new Thread(first);
		Thread s = new Thread(second);
		Thread t = new Thread(third);

		f.start();
		s.start();
		t.start();
	}
}

class Foo {

	Semaphore secondSem = new Semaphore(0);
	Semaphore thirdSem = new Semaphore(0);

	public Foo() {
	}

	public void first(Runnable printFirst) throws InterruptedException {
		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		secondSem.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		secondSem.acquire();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		thirdSem.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		thirdSem.acquire();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}
