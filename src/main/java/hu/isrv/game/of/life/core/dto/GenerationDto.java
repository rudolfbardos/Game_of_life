package hu.isrv.game.of.life.core.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rudi on 2017. 02. 01..
 */
public class GenerationDto {

    private Long Id;
    private String Name;
    int cells[][];

    public GenerationDto() {
    }

    public GenerationDto(Long id, String name, int[][] cells) {
        Id = id;
        Name = name;
        this.cells = cells;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int[][] getCells() {
        return cells;
    }

    public void setCells(int[][] cells) {
        this.cells = cells;
    }
}
