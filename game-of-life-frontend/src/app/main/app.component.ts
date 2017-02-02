import {Component, OnInit} from '@angular/core';
import {GameOfLifeService} from "../service/game-of-life.service";
import {Generation} from "../class/generation";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [GameOfLifeService]
})
export class AppComponent implements OnInit{


  title: string;
  generation: Generation;


  constructor(private gameOfLifeService: GameOfLifeService){

    this.title = "Game of Life!";
    this.generation = new Generation(1, "First test", [[
      0,
      0,
      0,
      0,
      0
    ],
      [
        0,
        0,
        0,
        0,
        0
      ],
      [
        0,
        1,
        1,
        1,
        0
      ],
      [
        0,
        0,
        0,
        0,
        0
      ],
      [
        0,
        0,
        0,
        0,
        0
      ]],5,5 );

  }

  ngOnInit(): void{

   // this.getNextGeneration();

  }

  getNextGeneration():void{
    this.gameOfLifeService.getNextGeneration(this.generation).then(result => {
      console.log("COMPONENT");
      console.log(result);
      this.generation = result;
    })
  }

  toggleCell(row:number,col:number):void{
    this.generation.cells[row][col] = +!this.generation.cells[row][col];
  }

  addRow():void{
    var newRow :number[]= new Array();
    for(var i=0; i<this.generation.col; i++){
      newRow.push(0);
    }
    this.generation.row++;
    this.generation.cells.push(newRow);
  }

  removeRow():void{

    this.generation.row--;
    this.generation.cells.pop();
  }

  addColumn():void{
    for(var i=0; i<this.generation.cells.length; i++){
      this.generation.cells[i].push(0);
    }
    this.generation.col++;
  }

  removeColumn():void{
    for(var i=0; i<this.generation.cells.length; i++){
      this.generation.cells[i].pop();
    }
    this.generation.col--;

  }
}
