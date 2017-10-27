
public class Edge {
	public String word1;
	public String word2;
	public int weight;
	public boolean direction;
	
	public Edge(String word1, String word2, int weight) {
		this.word1 = word1;
		this.word2 = word2;
		this.weight = weight;
		this.direction = false;
	}
	
	public Edge(String word1, String word2, int weight, boolean direction) {
		this.word1 = word1;
		this.word2 = word2;
		this.weight = weight;
		this.direction = direction;
	}
	
	public void addWeight() {
		weight++;
	}
	
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(!o.getClass().equals(this.getClass()))
			return false;
		Edge otherEdge = (Edge)o;
		if(direction == true) {
			if(!otherEdge.direction == direction) {
				return false;
			}
			if(!otherEdge.word1.equals(word1) || !otherEdge.word2.equals(word2)) {
				return false;
			}
			return true;
		}
		if(!otherEdge.word1.equals(word1)) {
			if(!otherEdge.word1.equals(word2))
				return false;
			else {
				if(!otherEdge.word2.equals(word1))
					return false;
				else
					return true;
			}
		}
		if(!otherEdge.word2.equals(word2)) {
			return false;
		}
		return true;
	}
}
