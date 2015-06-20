/**
 * 
 */
package come.here.challenge;

import java.util.LinkedList;
import java.util.Queue;

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
		int inputCount = 3; 
		String input = "({A,B,C},{(A,B),(B,C)}),({A,B,C},{(A,B),(B,C),(C,A)}),({A,B,C,D,E},{(A,B),(B,C),(C,D),(D,E)})";
//		input = "({A,B,C},{(A,B),(B,C)(C,A)})";
//		input = "({A,B,C,D,E},{(A,B),(B,C),(C,D),(D,E)})";
		Stack<String>  tokStack = new Stack<String>();
		Queue<String> queue = new LinkedList<>();
		IcelandGraph[] icelandGraphs = new IcelandGraph[inputCount];
		IcelandGraph icelandGraph = null;
		int delimCount =0;
		int graphCount = 0;
		for (int i = 0; i < input.length(); i++) {
			String token =  input.substring(i, i+1);
//			System.out.println(delimCount);
			if (token.equalsIgnoreCase("{")){
				delimCount++;
				if (delimCount%2 !=0){
					icelandGraph = new IcelandGraph();
					icelandGraphs[graphCount] =icelandGraph;
					graphCount++;
				}
				
			}
			
			if(ESCAPE_TOKS.contains(token)){
				continue;
			}
//			System.out.println(input);
			if(token.equalsIgnoreCase("}")){
//				icelandGraph = new IcelandGraph();
				while (tokStack.getTop()!=-1) {
					String land = tokStack.pop();
					icelandGraph.addIceland(land);
				}
				continue;
				
			}
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
		}
		
		for (int i = 0; i < icelandGraphs.length; i++) {
			icelandGraphs[i].displayAdjacentMatrix();
			icelandGraphs[i].printCriticalEdge();
			System.out.println("");
		}
	}

}
