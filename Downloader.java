import java.net.URL;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;

public class Downloader {

	private static final int MAX_BUFFER_SIZE = 1024;

	private URL url;
	private int size;
	private int count;

	public Downloader(URL url) {
		this.url = url;
		this.size = -1;
		this.count = 0;
	}

	public void download() {
		RandomAccessFile file = null;
		InputStream stream = null;
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("Range", "bytes="+count+"-");
			connection.connect();
			size = connection.getContentLength();
			if (size < 1) error();
			file = new RandomAccessFile(getFileName(), "rw");
			file.seek(count);
			stream = connection.getInputStream();
			while (true) {
				byte[] buffer;
				if (size - count > MAX_BUFFER_SIZE)
					buffer = new byte[MAX_BUFFER_SIZE];
				else buffer = new byte[size - count];
				int read = stream.read(buffer);
				if (read == -1) break;
				file.write(buffer, 0, read);
				count += read;
			}
		} catch (Exception e) {
			error();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (Exception e) {}
			}
			if (stream != null) {
				try {
					stream.close();
				} catch (Exception e) {}
			}
		}
	}

	private void error() {
		System.out.println("fatal error downloading file "+getFileName());
		System.exit(1);
	}
	
	public String getFileName() {
		String fileName = url.getFile(); 
		return fileName.substring(fileName.lastIndexOf('/')+1);
	}

	public int getSize() {return size;}
	public String getUrl() {return url.toString();}
	public double getProgress() {return ((double)count/size)*100;}

	public static void main(String[] args) throws Exception {
		String addr = "https://stackoverflow.com/questions/tagged/python";
		URL url = new URL(addr);
		Downloader downloader = new Downloader(url);
		downloader.download();
	}
}