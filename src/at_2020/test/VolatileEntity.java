package at_2020.test;

/**
 * @author hui.zhong
 * @date 2020-07-17
 */
public class VolatileEntity {

	final static int max = 5;

	public static int getMax() {
		return max;
	}

	DataModel dataModel = new DataModel();

	private static class VolatileEntityHolder {
		private static VolatileEntity instance = new VolatileEntity();
	}

	public static VolatileEntity getInstance() {
		return VolatileEntityHolder.instance;
	}
}
