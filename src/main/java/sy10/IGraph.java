package sy10;

public interface IGraph {
    void createGraph();

    int getVexNum();  //点数

    int getArcNum();  //边数

    Object getVex(int v);

    int locateVex(Object vex);

    int firstAdjVex(int v);

    int nextAdjVex(int v, int w);
}
