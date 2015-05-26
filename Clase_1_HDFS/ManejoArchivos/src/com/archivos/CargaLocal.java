package com.archivos;

import java.io.InputStream;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
// vv FileSystemCat

public class CargaLocal {
	public static void main(String[] args) throws Exception {
			String uri = "hdfs://localhost/user/training/shakespeare/Macbeth.txt";
			Configuration conf = new Configuration();
			FileSystem fs = FileSystem.get(URI.create(uri), conf);
			InputStream in = null;
			try {
				in = fs.open(new Path(uri));
				IOUtils.copyBytes(in, System.out, 4096, false);
			} finally {
				IOUtils.closeStream(in);
			}
			}
}
