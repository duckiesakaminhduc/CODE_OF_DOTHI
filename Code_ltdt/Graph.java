import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class Graph {

    private int numVertices;
    private int[][] matrix;

    public Graph() {
    }

    public void loadGraph(String pathFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line = reader.readLine();
            this.numVertices = Integer.parseInt(line.trim());
            this.matrix = new int[numVertices][numVertices];
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.trim().split("\\s+");
                for (int col = 0; col < values.length; col++) {
                    matrix[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (Exception e) {
            System.out.println("loi ko doc duoc file" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.loadGraph("graph.txt");
        int[][] matrix = graph.matrix;
        int numVertices = graph.numVertices;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}