package wooteco.subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.List;

public class ShortestPath {

    private final List<Station> vertexes;
    private final int distance;

    public ShortestPath(final GraphPath<Station, DefaultWeightedEdge> path) {
        validatePathExist(path);
        this.vertexes = path.getVertexList();
        this.distance = (int) path.getWeight();
    }

    private void validatePathExist(final GraphPath<Station, DefaultWeightedEdge> path) {
        if (path == null) {
            throw new IllegalStateException("해당 경로가 존재하지 않습니다.");
        }
    }

    public List<Station> getVertexes() {
        return vertexes;
    }

    public int getDistance() {
        return distance;
    }
}
