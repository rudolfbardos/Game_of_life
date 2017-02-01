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
      ]] );

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
}
