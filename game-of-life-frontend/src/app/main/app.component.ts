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

  }

  ngOnInit(): void{

    this.getNextGeneration();

  }

  getNextGeneration():void{
    this.gameOfLifeService.getNextGeneration().then(result => {
      this.generation = result;
    })
  }
}
