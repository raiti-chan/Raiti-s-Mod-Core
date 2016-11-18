package raiti.RaitisMod.Core.Util.Annotations;

import raiti.RaitisMod.Core.Item.BlockItem.RItemBlock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * {@link raiti.RaitisMod.Core.Block.RBlock RBlock}の関連付ける{@link RItemBlock}クラスを指定します。
 * <br>Created by Raiti-chan on 2016/11/18.
 *
 * @author Raiti-chan
 * @version 1.0.0
 * @since 1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemBlockClass {
	
	/**
	 * 指定された{@link RItemBlock}クラスを取得します
	 * @return 指定されたクラス
	 */
	Class<? extends RItemBlock> value();
	
}
