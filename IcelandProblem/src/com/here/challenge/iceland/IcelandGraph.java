/**
 * 
 */
package com.here.challenge.iceland;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lali
 *
 */
public class IcelandGraph {
	private final int initIcelandsCount = 20;
	Iceland[] iceland;
	Map<String, Iceland> nameToIcelandMap = new HashMap<String, Iceland>();
	int adjMatrix[][];
	int vertexCount=0;
	
	/**
	 * 
	 */
	public IcelandGraph() {
		iceland = new Iceland[initIcelandsCount];
		adjMatrix = new int[initIcelandsCount][initIcelandsCount];
		// TODO Auto-generated constructor stub
	}

	/**
	 * Add ice land
	 * @param name
	 */
	public void addIceland(String name) {
		Iceland iceland = new Iceland();
		iceland.setName(name);
		iceland.setId(vertexCount);
		this.iceland[vertexCount] = iceland;
		this.nameToIcelandMap.put(name, iceland);
		vertexCount++;
	}
	public void addBridge(Iceland start, Iceland end) {
		this.adjMatrix[start.hashCode()][end.hashCode()] = 1;
		this.adjMatrix[end.hashCode()][start.hashCode()] = 1;
	}
	public void connectIceland(String startName, String endName){
		this.addBridge(this.nameToIcelandMap.get(startName), this.nameToIcelandMap.get(endName));
	}
	public void displayAdjacentMatrix(){
		System.out.print("  ");
		for (int i = 0 ; i < vertexCount ; i++){
			//System.out.println(i);
			System.out.print(iceland[i].getName()+ " ");
		}
		System.out.println("");
		for (int i = 0; i < vertexCount; i++) {
			System.out.print(iceland[i].getName()+" ");
			for (int j = 0; j < vertexCount;j++) {
				System.out.print(this.adjMatrix[i][j]+ " ");
			}
			System.out.println("");
		}
	}
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		IcelandGraph icelandGraph = new IcelandGraph();
//		icelandGraph.addIceland("A");
//		icelandGraph.addIceland("B");
//		icelandGraph.addIceland("C");
//		icelandGraph.addIceland("D");
//		icelandGraph.addIceland("E");
//		icelandGraph.addIceland("F");
//
//		icelandGraph.connectIceland("A", "C");
//		icelandGraph.connectIceland("C", "B");
//		icelandGraph.connectIceland("C", "E");
//		icelandGraph.connectIceland("B", "D");
//		icelandGraph.connectIceland("B", "E");
//		icelandGraph.connectIceland("E", "F");
//		icelandGraph.displayAdjacentMatrix();
//		icelandGraph.printCriticalEdge();
//	}
	
	public String printCriticalEdge(){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (int i =0; i < this.vertexCount; i++){
			int connectedIcelandCount =0;
			int endPoint = 0;
			for (int j =0; j < this.vertexCount; j++){
				if(adjMatrix[i][j] == 1){
					connectedIcelandCount++;
					endPoint = j;
				}
			}
			if (connectedIcelandCount == 1){
				builder.append("("+iceland[i].getName()+","+iceland[endPoint].getName()+")");
				builder.append(",");
			}
		}
		if(builder.lastIndexOf(",")!=-1){
			String criticalEdges = builder.substring(0, builder.lastIndexOf(","));
			builder = new StringBuilder(criticalEdges);
		}
		if(builder.length() ==1){
			builder.append("(NA)");
		}
		builder.append("}");
		System.out.println(builder.toString());
		return builder.toString();
	}
	

}
