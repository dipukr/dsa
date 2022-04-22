import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Command {
	public static void main(String[] args) throws Exception {
		try {
			Process process = Runtime.getRuntime().exec("cmd /c dir");
			var out = new StringBuilder();
			var rd = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line; 
			while ((line = rd.readLine()) != null)
				out.append(line+"\n");
			int val = process.waitFor();
			if (val == 0)
				System.out.println(out);
		} catch (IOException e) {e.printStackTrace();}
		catch(InterruptedException e) {e.printStackTrace();}
	}
}