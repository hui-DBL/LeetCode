package at_2020.test;

import java.util.concurrent.TimeUnit;

/**
 * @author hui.zhong
 * @date 2020-07-17
 */
public class TestVolatile {

	private static volatile VolatileEntity volatileEntity = VolatileEntity.getInstance();

	public static void main(String[] args) {
		new Thread(() -> {
			int localVal = volatileEntity.dataModel.initVal;

			while ((localVal < VolatileEntity.max)) {
				if (volatileEntity.dataModel.initVal != localVal) {
					System.out.printf("The initVal is update to [%d]\n", volatileEntity.dataModel.initVal);
					localVal = volatileEntity.dataModel.initVal;
				}
//				try {
//					TimeUnit.SECONDS.sleep(2);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}, "reader").start();

		new Thread(() -> {
			int localValue = volatileEntity.dataModel.initVal;

			while (localValue < VolatileEntity.max) {
				//修改init_value
				System.out.printf("The init_value will be changed to [%d]\n", ++localValue);
				volatileEntity.dataModel.initVal = localValue;
				try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "updater").start();
	}
}
