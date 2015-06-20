/**
 * 
 */
package come.here.challenge;

import com.here.challenge.iceland.IcelandGraph;
import com.here.challenge.iceland.Stack;

/**
 * @author Lali
 *
 */
public class Main {
	public static String ESCAPE_TOKS = "(,{";
	/**
	 * 
	 */
	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//({A,B,C},{(A,B),(B,C)(C,A)})
		//({A,B,C,D,E},{(A,B),(B,C),(C,D),(D,E)})
		
//		String delimitter = "})";
		String input = "({A,B,C},{(A,B),(B,C)(C,A)}),({A,B,C,D,E},{(A,B),(B,C),(C,D),(D,E)})";
		input = "({A,B,C},{(A,B),(B,C)(C,A)})";
		input = "({A,B,C,D,E},{(A,B),(B,C),(C,D),(D,E)})";
		Stack<String>  tokStack = new Stack<String>();
		IcelandGraph icelandGraph = new IcelandGraph();;
		for (int i = 0; i < input.length(); i++) {
			String token =  input.substring(i, i+1);
			if(ESCAPE_TOKS.contains(token)){
				continue;
			}
			System.out.println(input);
			if(token.equalsIgnoreCase("}")){
//				icelandGraph = new IcelandGraph();
				while (tokStack.getTop()!=-1) {
					String land = tokStack.pop();
					icelandGraph.addIceland(land);
				}
				continue;
				
			}
			System.out.println("+++++++++++");
			if(token.equalsIgnoreCase(")")){
				if(tokStack.getTop()== -1){
					continue;
				}
				String start = tokStack.pop();
				String end = tokStack.pop();
				icelandGraph.connectIceland(start, end);
				continue;
			}
			tokStack.push(token);
//			System.out.println(input.substring(i, i+1));
//			System.out.println(tokStack.getTop());
		}
		icelandGraph.displayAdjacentMatrix();
		icelandGraph.printCriticalEdge();
	}

}
