package raiti.RaitisMod.Factory.Energy;

/**
 * Created by Raiti on 2016/10/10.
 */
public interface EnergyBuffer {
	
	/**
	 * 蓄電量を取得します
	 * @return 蓄電量
	 */
	public long getBufferEnergy();
	
	/**
	 * 最大蓄電量を取得します
	 * @return 蓄電最大値
	 */
	public long getMaxBuffer();
	
	/**
	 * エネルギーをバッファーに追加します
	 * @param addEnelgy 追加するエネルギー
	 * @return 余ったエネルギー
	 */
	public long addBufferEnergy(long addEnergy);
	
	/**
	 * エネルギーを送電できるか
	 * @return できるならtrue
	 */
	public boolean canSendEnergy();
	
	/**
	 * エネルギーを受信できるか
	 * @return できるならtrue
	 */
	public boolean canReceiveEnergy();
	
}
