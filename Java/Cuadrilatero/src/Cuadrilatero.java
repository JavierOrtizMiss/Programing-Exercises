public class Cuadrilatero {
    private int[][] vertices = new int[4][2];
    
    public Cuadrilatero(int[][]vertices){
        this.vertices = vertices;
    }

    public int[][] getVertice(){
        return vertices;
}
}