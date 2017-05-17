package research.j2se.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {
		// 这里用到的i18n下面的文件名都以下划线分隔，RBControl_语言编码_区域编码的形式
		String baseName = "i18n/RBControl";

		// 演示Locale常量解析RBControl_zh_cn.properties数据
		Locale l = Locale.CHINA;
		ResourceBundle rs = ResourceBundle.getBundle(baseName, l);
		String result = rs.getString("region");
		System.out.println("示例1结果：" + result);

		// 演示Locale.Builder解析RBControl_zh_hk.properties数据
		l = new Locale.Builder().setLanguage("zh").setRegion("hk").build();
		rs = ResourceBundle.getBundle(baseName, l);
		result = rs.getString("region");
		System.out.println("示例2结果：" + result);

		// 演示Locale构造函数解析RBControl_zh_tw.properties数据
		l = new Locale("zh", "tw");
		rs = ResourceBundle.getBundle(baseName, l);
		result = rs.getString("region");
		System.out.println("示例3结果：" + result);

		// 演示Locale构造函数解析RBControl_en_US.properties数据
		l = Locale.forLanguageTag("en-US");
		rs = ResourceBundle.getBundle(baseName, l);
		result = rs.getString("region");
		System.out.println("示例4结果：" + result);

		// 演示Locale解析RBControl_zh.properties数据,但是对应数据不存在时，会取默认RBControl.properties
		l = new Locale("zh");
		rs = ResourceBundle.getBundle(baseName, l);
		result = rs.getString("region");
		System.out.println("示例5结果：" + result);
	}

}
