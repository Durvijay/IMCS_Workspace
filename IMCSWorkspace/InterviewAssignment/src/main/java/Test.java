import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Test test=new Test();
		System.out.println(test.solution("abc.jpg 154b\naad.avi 89b"));
	}
	
	public String solution(String S) {
		// write your code in Java SE 8
		Set<String> music = new HashSet<>(Arrays.asList("mp3", "aac", "flac"));
		Set<String> image = new HashSet<>(Arrays.asList("jpg", "bmp", "gif"));
		Set<String> movie = new HashSet<>(Arrays.asList("mp4", "avi", "mkv"));

		Map<String, Integer> fileTypeAndSize = new HashMap<>();
		String[] filesInfo = S.split("\n");
		int recordIndex = 0;

		// for each use kiya kar
		while (recordIndex < filesInfo.length) {
			String[] input = filesInfo[recordIndex].split(" ");
			String fileExt = input[0].substring(input[0].lastIndexOf(".") + 1, input[0].length());
			int fileSize = Integer.valueOf(input[1].substring(0, input[1].length() - 1));
			recordIndex++;
			if (music.contains(fileExt))
				fileTypeAndSize.put("music", fileTypeAndSize.getOrDefault("music",0) + fileSize);
			else if (image.contains(fileExt))
				fileTypeAndSize.put("image", fileTypeAndSize.getOrDefault("image",0) + fileSize);
			else if (movie.contains(fileExt))
				fileTypeAndSize.put("movie", fileTypeAndSize.getOrDefault("movie",0) + fileSize);
			else
				fileTypeAndSize.put("other", fileTypeAndSize.getOrDefault("other",0) + fileSize);
		}
		return buildString(fileTypeAndSize);

	}

	private String buildString(Map<String, Integer> fileTypeAndSize) {
		StringBuilder output = new StringBuilder();
		for (Map.Entry<String,Integer> entry : fileTypeAndSize.entrySet()) {
			output.append( entry.getKey()+" "+ entry.getValue()+"b\n");
		}
		return output.toString();
	}
}
