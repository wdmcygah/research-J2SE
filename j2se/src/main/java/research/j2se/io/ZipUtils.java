package research.j2se.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 使用JDK自带的Zip处理类进行文件的压缩与解压
 *
 */
public class ZipUtils {
	
	/**
	 * 压缩文件（一个或多个）到指定压缩包
	 */
	public static void zip( String targetFilePath, String ... sourceFilePaths){
		if( sourceFilePaths == null || sourceFilePaths.length == 0 ){
			return;
		}
		try {
			File targetFile = new File(targetFilePath);
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(targetFile));
			BufferedInputStream bis = null;
			byte [] buffer = new byte[512];
			for( int i = 0; i < sourceFilePaths.length; i++ ){
				File sourceFile = new File(sourceFilePaths[i]);
				if( sourceFile.exists() ){
					//目标文件不存在则创建文件
					if( ! targetFile.exists() ){
						targetFile.createNewFile();
					}
					String sourceFileName = sourceFile.getName();
					ZipEntry entry = new ZipEntry(sourceFileName);
					//设置压缩包的入口
					zos.putNextEntry(entry);
					bis = new BufferedInputStream(new FileInputStream(sourceFile));
					while( bis.read(buffer) != -1){
						zos.write(buffer);
					}
				}
			}
			bis.close();
			zos.flush();
			zos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解压文件到指定目录
	 */
	public static void unzip(String targetDirPath, String ... sourceFilePaths){
		if( sourceFilePaths == null || sourceFilePaths.length == 0 ){
			return;
		}
		//解压目录不存在则创建
		File targetDir = new File(targetDirPath);
		if( ! targetDir.exists() ){
			targetDir.mkdirs();
		}
		try {
			byte [] buffer = new byte[512];
			for( int i = 0; i < sourceFilePaths.length; i++ ){
				File sourceFile = new File(sourceFilePaths[i]);
				ZipInputStream zis = new ZipInputStream(new FileInputStream(sourceFile));
				ZipEntry entry = null;
				//遍历压缩文件的各个入口
				while( (entry=zis.getNextEntry()) != null ){
					String fileName = entry.getName();
					//创建对应的文件
					File file = new File(targetDirPath+File.separator + fileName);
					if( ! file.exists() ){
						file.createNewFile();
					}
					//进行文件的写入
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file,true));
					while( zis.read(buffer) != -1 ){
						bos.write(buffer);
					}
					zis.closeEntry();
					bos.flush();
					bos.close();
				}
				zis.close();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch( Exception e ){
			e.printStackTrace();
		}
	}
	
}
