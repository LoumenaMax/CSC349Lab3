import java.util.List;


public class Graph {
	public List<String> words;
	public List<Edge> edges;

	public Graph(List<String> words, List<Edge> edges) {
		this.words = words;
		this.edges = edges;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(Edge e : edges) {
			str.append("(");
			str.append(e.word1);
			str.append(",");
			str.append(e.word2);
			str.append(") ");
			str.append(e.weight);
			str.append("\n");
		}
		return str.toString();
	}
}
