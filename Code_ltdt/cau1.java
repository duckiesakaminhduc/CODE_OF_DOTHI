import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class cau1 {

    public class Graph {
        private int numVertices;
        private int[][] adjacencyMatrix;

        public Graph() {
        }

        public void loadGraph(String pathFile) {
            try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
                String line = reader.readLine();
                this.numVertices = Integer.parseInt(line.trim());
                this.adjacencyMatrix = new int[numVertices][numVertices];
                int row = 0;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.trim().split("\\s+");
                    for (int col = 0; col < values.length; col++) {
                        this.adjacencyMatrix[row][col] = Integer.parseInt(values[col]);
                    }
                    row++;
                }
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }

        // implement other methods here

    }

    public static void main(String[] args) {
        cau1 outerObject = new cau1();
        cau1.Graph graph = outerObject.new Graph();
        graph.loadGraph("test1.txt");
        int[][] adjacencyMatrix = graph.adjacencyMatrix;
        int numVertices = graph.numVertices;
        System.out.println("Number of vertices: " + numVertices);
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}