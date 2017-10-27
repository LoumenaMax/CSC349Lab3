import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BuildGraphs {
	public static final String input = "wordgame_20170721.csv";
	public static final String output1 = "undirectedGraph.txt";
	public static final String output2 = "directedGraph.txt";
	
	public static Graph parse(boolean directioned) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String line = reader.readLine();
		ArrayList<String> words = new ArrayList<String>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		while(line != null) {
			Scanner sc = new Scanner(line);
			sc.useDelimiter(",");
			sc.next();
			Edge edge = new Edge(sc.next(), sc.next(), 1, directioned);
			if(edge.word1.contains(" ") || edge.word2.contains(" ")) {
				sc.close();
				line = reader.readLine();
				continue;
			}
			int index;
			if((index = edges.indexOf(edge)) >= 0) {
				edges.get(index).addWeight();
			}
			else {
				edges.add(edge);
				if(!words.contains(edge.word1)) {
					words.add(edge.word1);
				}
				if(!words.contains(edge.word2)) {
					words.add(edge.word2);
				}
			}
			sc.close();
			line = reader.readLine();
		}
		reader.close();
		return new Graph(words, edges);
	}
	
	public static void main(String[] args) {
		try {
			Graph graph = parse(false);
			FileWriter bw = new FileWriter(output1);
			bw.write(graph.toString());
			bw.flush();
			bw.close();
			graph = parse(true);
			bw = new FileWriter(output2);
			bw.write(graph.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
