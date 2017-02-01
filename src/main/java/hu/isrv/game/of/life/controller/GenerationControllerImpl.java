package hu.isrv.game.of.life.controller;

import hu.isrv.game.of.life.core.dto.GenerationDto;

import hu.isrv.game.of.life.core.dto.PointDto;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

/**
 * Created by Rudi on 2017. 01. 19..
 */
@RestController
@RequestMapping("/api/gof")
public class GenerationControllerImpl {


    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> getTest() {

        GenerationDto generationDto = new GenerationDto();

        generationDto.setId(1L);
        generationDto.setName("First test");
        int cells[][] = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
        generationDto.setCells(cells);

        return new ResponseEntity<GenerationDto>(generationDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/getnextgeneration", method = RequestMethod.POST)
    public ResponseEntity<?> getNextGeneration(@RequestBody GenerationDto currentGenerationDto) {

        GenerationDto nextGenerationDto = new GenerationDto();
        nextGenerationDto.setName(currentGenerationDto.getName());
        nextGenerationDto.setId(currentGenerationDto.getId() + 1);

        int currentGen[][] = currentGenerationDto.getCells();
        int nextGen[][] = new int[currentGen.length][currentGen[0].length];


        //TODO: Business logic

        for (int row = 0; row < currentGen.length; row++) {
            for (int col = 0; col < currentGen[row].length; col++) {

                List<PointDto> pointDtos = getNeighbours(row, col, currentGen.length, currentGen[row].length);

                if (currentGen[row][col] == 0) {

                    int alive = 0;

                    for (PointDto pointDto : pointDtos) {

                        if (currentGen[pointDto.X][pointDto.Y] == 1) {
                            alive++;
                        }

                    }

                    if (alive == 3) {

                        nextGen[row][col] = 1;
                    }
                } else if (currentGen[row][col] == 1) {

                    int alive = 0;

                    for (PointDto pointDto : pointDtos) {
                        if (currentGen[pointDto.X][pointDto.Y] == 1) {
                            alive++;
                        }
                    }

                    if (alive < 2) {
                        nextGen[row][col] = 0;
                    } else if (alive == 2 || alive == 3) {
                        nextGen[row][col] = 1;
                    } else if (alive > 3) {
                        nextGen[row][col] = 0;
                    }


                }


            }
        }


        nextGenerationDto.setCells(nextGen);

        return new ResponseEntity<GenerationDto>(nextGenerationDto, HttpStatus.OK);
    }

    protected List<PointDto> getNeighbours(int row, int col, int rowLength, int colLength) {

        List<PointDto> pointDtos = new ArrayList<>();

        if ((col + 1) < colLength) {
            pointDtos.add(new PointDto(row, col + 1));
        }

        if ((col - 1) >= 0) {
            pointDtos.add(new PointDto(row, col - 1));
        }

        if ((row - 1) >= 0) {
            pointDtos.add(new PointDto(row - 1, col));
        }

        if ((row - 1 >= 0) && (col + 1 < colLength)) {
            pointDtos.add(new PointDto(row - 1, col + 1));
        }
        if ((row - 1 >= 0) && (col - 1 >= 0)) {
            pointDtos.add(new PointDto(row - 1, col - 1));
        }
        if (row + 1 < rowLength) {
            pointDtos.add(new PointDto(row + 1, col));
        }

        if ((row + 1 < rowLength) && (col + 1 < colLength)) {
            pointDtos.add(new PointDto(row + 1, col + 1));
        }

        if ((row + 1 < rowLength) && (col - 1 >= 0)) {
            pointDtos.add(new PointDto(row + 1, col - 1));
        }

        System.out.println("Row:" + row + "---Col:" + col);
        pointDtos.forEach(pointDto -> {
            System.out.println("X:" + pointDto.X + ",Y:" + pointDto.Y);

        });


        return pointDtos;
    }

}


