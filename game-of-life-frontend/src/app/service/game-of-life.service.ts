import {Injectable} from '@angular/core';
import {Generation} from "../class/generation";
import {GENERATION} from "../mock/mock-generation";

@Injectable()
export class GameOfLifeService {

  constructor() {
  }

  getNextGeneration(): Promise<Generation> {
    return Promise.resolve(GENERATION);
  }

}
