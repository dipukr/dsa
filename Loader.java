public class Loader {

	public static void main(final String[] args) throws Exception {
		if (args.length != 1) return;
		try {
			BufferedInputStream in = new 
				BufferedInputStream(new URL(args[0]).openStream());
			FileOutputStream out = new FileOutputStream("C:\\Users\\D2epu\\Desktop\\test\\kak.pdf");
			byte[] buffer = new byte[1024];
			while (true) {
				int readSize = in.read(buffer, 0, 1024);
				if (readSize == -1) break;
				out.write(buffer, 0, readSize);
			}
		} catch (IOException e) {
			System.out.println("File IO Error");
		}
	}
}