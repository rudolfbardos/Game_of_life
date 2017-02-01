/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { GameOfLifeServiceService } from './game-of-life-service.service';

describe('GameOfLifeServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GameOfLifeServiceService]
    });
  });

  it('should ...', inject([GameOfLifeServiceService], (service: GameOfLifeServiceService) => {
    expect(service).toBeTruthy();
  }));
});
