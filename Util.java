import java.io.File;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Util {

	public static void main(String[] args) throws Exception {
		listDir(args);
		listFiles(new File("E:\\"));
		System.out.println(all.size());
		BufferedWriter w = new BufferedWriter(new FileWriter("log"));
		for (String e: all) w.write(e+"\n");
	}

	private static void replaceAll(String filename) throws Exception {
		List<String> lines = 
			Files.lines(Paths.get(filename))
				.map(s -> s.replaceAll("    ", "\t"))
				.collect(Collectors.toList());
		StringBuffer data = new StringBuffer();
		lines.forEach(s -> data.append(s).append('\n'));
		Files.write(Paths.get(filename), data.toString().getBytes());
	}

	private static void listFiles(final String[] args) throws Exception {
		if (!dir.isDirectory()) {
			all.add(dir.getName());
			return;
		}
		File[] files = dir.listFiles();
		for (File file: files) {
			if (file.getName().equals("$RECYCLE.BIN") ||
				file.getName().equals("System Volume Information")) continue;
			listFiles(file);
		}
	} 

	private static void listDir(final String[] args) throws Exception {
		String root = ".";
		if (args.length > 0) root = args[0];
		System.out.println("Walking path..."+Paths.get(root));
		long[] size = {0};
		long[] count = {0};
		try (Stream<Path> paths = Files.walk(Paths.get(root))) {
			paths.filter(Files::isRegularFile)
				.forEach((Path p) -> {
					File f = p.toFile();
					size[0] += f.length();
					count[0] += 1;
				});
		}
		System.out.println("Files: "+fileCount);
		System.out.println("Folders: "+dirCount);
	}
}