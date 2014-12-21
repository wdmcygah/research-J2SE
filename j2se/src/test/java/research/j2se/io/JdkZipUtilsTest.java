package research.j2se.io;

import junit.framework.TestCase;
import research.j2se.io.ZipUtils;

/**
 * jdk压缩解压工具类测试
 */
public class JdkZipUtilsTest
    extends TestCase
{
   
	/**
	 * 测试压缩文件
	 */
    public void testZip()
    {
    	String targetFilePath = "src/main/resources/ziptarget/zip/压缩.zip";
    	String sourceFilePath1 = "src/main/resources/zipsource/unzip/测试1.xlsx";
    	String sourceFilePath2 = "src/main/resources/zipsource/unzip/测试2.xlsx";
    	String sourceFilePath3 = "src/main/resources/zipsource/unzip/测试3.xlsx";
        ZipUtils.zip(targetFilePath, sourceFilePath1,sourceFilePath2,sourceFilePath3);
    }
    
    /**
     * 测试解压文件（这里Excel文件解压无法打开，使用解压工具可以打开）
     */
    public void testUnzip(){
    	String targetDirPath = "src/main/resources/ziptarget/unzip";
    	String sourceFilePath1 = "src/main/resources/zipsource/zip/压缩.zip";
    	//String sourceFilePath2 = "src/main/resources/zipsource/zip/压缩2.zip";
    	//String sourceFilePath3 = "src/main/resources/zipsource/zip/压缩3.zip"; 
    	//ZipUtils.unzip(targetDirPath, sourceFilePath1,sourceFilePath2,sourceFilePath3);
    	ZipUtils.unzip(targetDirPath, sourceFilePath1);
    }
}
