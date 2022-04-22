public class FileDownloader extends Thread {

	private String url;
	public FileDownloader(String url) {
		this.url = url;
	}
	public void run() {
		Downloader dw = new Downloader(url);
		dw.download();
	}

	public static void main(String[] args) throws Exception {
		FileDownloader fd1 = new FileDownloader("file1");
		FileDownloader fd2 = new FileDownloader("file2");
		FileDownloader fd3 = new FileDownloader("file3");
		FileDownloader fd4 = new FileDownloader("file4");
		fd1.start();
		fd2.start();
		fd3.start();
		fd4.start();
	}
}