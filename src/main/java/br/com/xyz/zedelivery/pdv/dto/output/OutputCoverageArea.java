package br.com.xyz.zedelivery.pdv.dto.output;

import br.com.xyz.zedelivery.pdv.PDV;
import lombok.*;
import org.locationtech.jts.geom.Coordinate;

import java.util.List;
import java.util.stream.*;

@AllArgsConstructor
@Getter
class OutputCoverageArea {

    private final String type;
    private final List<List<Double>> coordinates;

    public OutputCoverageArea(PDV pdv){
        this.type = pdv.getCoverageAreaType();
        this.coordinates = Stream.of(pdv.getCoordinates()).map(this::createListCoordinate).collect(Collectors.toList());
    }

    List<Double> createListCoordinate(Coordinate coordinate){
        return List.of(coordinate.getX(),coordinate.getY());
    }
}
